package org.example.controller;

import org.example.dtos.FuncionarioDTO;
import org.example.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> obterDetalhesFuncionario(@PathVariable int id) {
        FuncionarioDTO funcionario = funcionarioService.obterDetalhesFuncionario(id);
        return ResponseEntity.ok(funcionario);
    }

    @PostMapping
    public ResponseEntity<String> adicionarFuncionario(@RequestBody FuncionarioDTO funcionario) {
        funcionarioService.adicionarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Funcionário adicionado com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarFuncionario(@PathVariable int id, @RequestBody FuncionarioDTO funcionario) {
        funcionarioService.atualizarFuncionario(id, funcionario);
        return ResponseEntity.ok("Funcionário atualizado com sucesso.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirFuncionario(@PathVariable int id) {
        funcionarioService.excluirFuncionario(id);
        return ResponseEntity.ok("Funcionário excluído com sucesso.");
    }
}
