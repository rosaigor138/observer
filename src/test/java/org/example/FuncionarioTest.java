package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    @Test
    void deveNotificarUmFuncionario() {
        Projeto projeto = new Projeto("Novo Sistema", "Desenvolvimento de um novo sistema interno");
        Funcionario funcionario = new Funcionario("Funcionario 1");
        funcionario.inscreverNoProjeto(projeto);
        projeto.atualizarStatus("Em Progresso");
        assertEquals("Funcionario 1, atualização realizada no Projeto{nomeProjeto='Novo Sistema', descricao='Desenvolvimento de um novo sistema interno', status='Em Progresso'}", funcionario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarFuncionarios() {
        Projeto projeto = new Projeto("Novo Sistema", "Desenvolvimento de um novo sistema interno");
        Funcionario funcionario1 = new Funcionario("Funcionario 1");
        Funcionario funcionario2 = new Funcionario("Funcionario 2");
        funcionario1.inscreverNoProjeto(projeto);
        funcionario2.inscreverNoProjeto(projeto);
        projeto.atualizarStatus("Em Progresso");
        assertEquals("Funcionario 1, atualização realizada no Projeto{nomeProjeto='Novo Sistema', descricao='Desenvolvimento de um novo sistema interno', status='Em Progresso'}", funcionario1.getUltimaNotificacao());
        assertEquals("Funcionario 2, atualização realizada no Projeto{nomeProjeto='Novo Sistema', descricao='Desenvolvimento de um novo sistema interno', status='Em Progresso'}", funcionario2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarFuncionario() {
        Projeto projeto = new Projeto("Novo Sistema", "Desenvolvimento de um novo sistema interno");
        Funcionario funcionario = new Funcionario("Funcionario 1");
        projeto.atualizarStatus("Em Progresso");
        assertEquals(null, funcionario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarFuncionarioProjetoA() {
        Projeto projetoA = new Projeto("Sistema A", "Desenvolvimento do Sistema A");
        Projeto projetoB = new Projeto("Sistema B", "Desenvolvimento do Sistema B");
        Funcionario funcionario1 = new Funcionario("Funcionario 1");
        Funcionario funcionario2 = new Funcionario("Funcionario 2");
        funcionario1.inscreverNoProjeto(projetoA);
        funcionario2.inscreverNoProjeto(projetoB);
        projetoA.atualizarStatus("Em Progresso");
        assertEquals("Funcionario 1, atualização realizada no Projeto{nomeProjeto='Sistema A', descricao='Desenvolvimento do Sistema A', status='Em Progresso'}", funcionario1.getUltimaNotificacao());
        assertEquals(null, funcionario2.getUltimaNotificacao());
    }
}
