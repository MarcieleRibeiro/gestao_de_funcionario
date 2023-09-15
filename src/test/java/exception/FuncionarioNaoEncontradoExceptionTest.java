package exception;

import org.example.exception.FuncionarioNaoEncontradoException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioNaoEncontradoExceptionTest {

    @Test
    public void testExceptionMessage() {
        String errorMessage = "Funcionário não encontrado!";
        FuncionarioNaoEncontradoException exception = new FuncionarioNaoEncontradoException(errorMessage);

        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    public void testException() {
        FuncionarioNaoEncontradoException exception = new FuncionarioNaoEncontradoException("Teste de exceção");

        assertNotNull(exception);
        assertEquals("Teste de exceção", exception.getMessage());
    }
}

