/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.controller;

import lps.sistemalocacaoimpressora.model.Cliente;
import lps.sistemalocacaoimpressora.model.dao.ClienteDAO;

public class ClienteController {

    private ClienteDAO repositorio;

    public ClienteController() {
        repositorio = new ClienteDAO();
    }

    public void cadastrarCliente(String nome, String idade, String sexo, String cpf, String email, String senha) throws Exception {
        int i = Integer.parseInt(idade);
        Cliente novoCliente = new Cliente(nome, i, sexo.charAt(0), cpf, email, senha);
        if (repositorio.findByCpf(cpf) == null) {
            repositorio.save(novoCliente);
        } else {
            throw new Exception("Error - Já existe um cliente com este 'CPF'.");
        }
    }
}
