package org.example.service;

import org.example.dtos.FuncionarioDTO;

public interface FuncionarioService {
    FuncionarioDTO obterDetalhesFuncionario(int id);

    void adicionarFuncionario(FuncionarioDTO funcionario);

    void atualizarFuncionario(int id, FuncionarioDTO funcionario);

    void excluirFuncionario(int id);
}


