package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.controller.FuncionarioController;
import org.example.dtos.FuncionarioDTO;
import org.example.service.FuncionarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.Mockito.when;

public class FuncionarioControllerTest {

    @InjectMocks
    private FuncionarioController funcionarioController;

    @Mock
    private FuncionarioService funcionarioService;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(funcionarioController).build();
    }

    @Test
    public void testObterDetalhesFuncionario() throws Exception {
        int funcionarioId = 1;
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO(funcionarioId, "João", "Cargo", 1000.0, "12345", "Endereço");

        when(funcionarioService.obterDetalhesFuncionario(funcionarioId)).thenReturn(funcionarioDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/funcionarios/{id}", funcionarioId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(funcionarioId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("João"));
    }

    @Test
    public void testAdicionarFuncionario() throws Exception {
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO(1, "João", "Cargo", 1000.0, "12345", "Endereço");

        mockMvc.perform(MockMvcRequestBuilders.post("/funcionarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(funcionarioDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string("Funcionário adicionado com sucesso."));
    }

    @Test
    public void testAtualizarFuncionario() throws Exception {
        int funcionarioId = 1;
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO(funcionarioId, "João", "Cargo", 1000.0, "12345", "Endereço");

        mockMvc.perform(MockMvcRequestBuilders.put("/funcionarios/{id}", funcionarioId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(funcionarioDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Funcionário atualizado com sucesso."));
    }

    @Test
    public void testExcluirFuncionario() throws Exception {
        int funcionarioId = 1;

        mockMvc.perform(MockMvcRequestBuilders.delete("/funcionarios/{id}", funcionarioId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Funcionário excluído com sucesso."));
    }
}
