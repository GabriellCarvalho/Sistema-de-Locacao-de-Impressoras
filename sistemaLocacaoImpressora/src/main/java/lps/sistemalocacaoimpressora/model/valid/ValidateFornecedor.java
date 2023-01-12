/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.model.valid;

import lps.sistemalocacaoimpressora.model.Fornecedor;
import lps.sistemalocacaoimpressora.model.exceptions.FuncionarioException;

public class ValidateFornecedor {

    public Fornecedor validacao(String nome, String cnpj, String pecas, String cartucho) {
        Fornecedor f = new Fornecedor();

        if (nome.isEmpty()) {
            throw new FuncionarioException("Error - Campo vazio: 'nome'.");
        }
        f.setNome(nome);

        if (cnpj.isEmpty()) {
            throw new FuncionarioException("Error - Campo vazio: 'cnpj'.");
        }
        ValidateCNPJ validCNPJ = new ValidateCNPJ();
        if (!validCNPJ.validaCNPJ(cnpj)) {
            throw new FuncionarioException("Error - CNPJ invalido");
        }
        f.setCnpj(cnpj);

        if (pecas.isEmpty()) {
            throw new FuncionarioException("Error - Campo vazio: 'pecas'.");
        }
        f.setPecas(pecas);

        if (cartucho.isEmpty()) {
            throw new FuncionarioException("Error - Campo vazio: 'cartucho'.");
        }
        f.setCartucho(cartucho);

        return (Fornecedor) f;
    }
}
