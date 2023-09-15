package exception;

import org.example.exception.FuncionarioJaExistenteException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioJaExistenteExceptionTest {

    @Test
    public void testExceptionMessage() {
        String errorMessage = "Funcionário já existe!";
        FuncionarioJaExistenteException exception = new FuncionarioJaExistenteException(errorMessage);

        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    public void testException() {
        FuncionarioJaExistenteException exception = new FuncionarioJaExistenteException("Teste de exceção");

        assertNotNull(exception);
        assertEquals("Teste de exceção", exception.getMessage());
    }
}
