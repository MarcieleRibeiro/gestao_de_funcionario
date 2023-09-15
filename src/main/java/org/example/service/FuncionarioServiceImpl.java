package org.example.service;

import org.example.dtos.FuncionarioDTO;
import org.example.exception.FuncionarioJaExistenteException;
import org.example.exception.FuncionarioNaoEncontradoException;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
    private Map<Integer, FuncionarioDTO> funcionarios;

    public FuncionarioServiceImpl(Map<Integer, FuncionarioDTO> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public FuncionarioDTO obterDetalhesFuncionario(int id) {
        FuncionarioDTO funcionario = funcionarios.get(id);
        if (funcionario == null) {
            throw new FuncionarioNaoEncontradoException("Funcionário com ID " + id + " não encontrado.");
        }
        return funcionario;
    }

    @Override
    public void adicionarFuncionario(FuncionarioDTO funcionario) {
        int id = funcionario.getId();

        if (funcionarios.containsKey(id)) {
            throw new FuncionarioJaExistenteException("Funcionário com ID " + id + " já existe.");
        }

        funcionarios.put(id, funcionario);
    }

    @Override
    public void atualizarFuncionario(int id, FuncionarioDTO funcionario) {
        if (!funcionarios.containsKey(id)) {
            throw new FuncionarioNaoEncontradoException("Funcionário com ID " + id + " não encontrado.");
        }

        funcionarios.put(id, funcionario);
    }

    @Override
    public void excluirFuncionario(int id) {
        if (!funcionarios.containsKey(id)) {
            throw new FuncionarioNaoEncontradoException("Funcionário com ID " + id + " não encontrado.");
        }

        funcionarios.remove(id);
    }
}
