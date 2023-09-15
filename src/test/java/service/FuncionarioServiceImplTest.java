package service;

import org.example.dtos.FuncionarioDTO;
import org.example.exception.FuncionarioJaExistenteException;
import org.example.exception.FuncionarioNaoEncontradoException;
import org.example.service.FuncionarioService;
import org.example.service.FuncionarioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioServiceImplTest {

    private FuncionarioService funcionarioService;
    private Map<Integer, FuncionarioDTO> funcionarios;

    @BeforeEach
    public void setUp() {
        funcionarios = new HashMap<>();
        funcionarioService = new FuncionarioServiceImpl(funcionarios);
    }

    @Test
    public void testObterDetalhesFuncionarioCasoDeSucesso() {
        FuncionarioDTO funcionario = new FuncionarioDTO(1, "João", "Analista", 5000.0, "123456789", "Rua A");
        funcionarios.put(1, funcionario);

        FuncionarioDTO resultado = funcionarioService.obterDetalhesFuncionario(1);

        assertNotNull(resultado);
        assertEquals(funcionario, resultado);
    }

    @Test
    public void testObterDetalhesFuncionarioFuncionarioNaoEncontrado() {
        assertThrows(FuncionarioNaoEncontradoException.class, () -> funcionarioService.obterDetalhesFuncionario(1));
    }

    @Test
    public void testAdicionarFuncionarioCasoDeSucesso() {
        FuncionarioDTO novoFuncionario = new FuncionarioDTO(1, "Maria", "Desenvolvedor", 6000.0, "987654321", "Rua B");

        funcionarioService.adicionarFuncionario(novoFuncionario);

        assertTrue(funcionarios.containsKey(1));
        assertEquals(novoFuncionario, funcionarios.get(1));
    }

    @Test
    public void testAdicionarFuncionarioFuncionarioJaExistente() {
        // Preparação
        FuncionarioDTO funcionarioExistente = new FuncionarioDTO(1, "João", "Analista", 5000.0, "123456789", "Rua A");
        funcionarios.put(1, funcionarioExistente);

        assertThrows(FuncionarioJaExistenteException.class, () -> funcionarioService.adicionarFuncionario(funcionarioExistente));
    }

    @Test
    public void testAtualizarFuncionarioCasoDeSucesso() {
        FuncionarioDTO funcionarioExistente = new FuncionarioDTO(1, "João", "Analista", 5000.0, "123456789", "Rua A");
        funcionarios.put(1, funcionarioExistente);
        FuncionarioDTO funcionarioAtualizado = new FuncionarioDTO(1, "João Silva", "Engenheiro", 6000.0, "987654321", "Rua B");

        funcionarioService.atualizarFuncionario(1, funcionarioAtualizado);

        assertEquals(funcionarioAtualizado, funcionarios.get(1));
    }

    @Test
    public void testAtualizarFuncionarioFuncionarioNaoEncontrado() {
        assertThrows(FuncionarioNaoEncontradoException.class, () -> funcionarioService.atualizarFuncionario(1, new FuncionarioDTO()));
    }

    @Test
    public void testExcluirFuncionarioCasoDeSucesso() {
        FuncionarioDTO funcionarioExistente = new FuncionarioDTO(1, "João", "Analista", 5000.0, "123456789", "Rua A");
        funcionarios.put(1, funcionarioExistente);

        funcionarioService.excluirFuncionario(1);

        assertFalse(funcionarios.containsKey(1));
    }

    @Test
    public void testExcluirFuncionarioFuncionarioNaoEncontrado() {
        assertThrows(FuncionarioNaoEncontradoException.class, () -> funcionarioService.excluirFuncionario(1));
    }
}

