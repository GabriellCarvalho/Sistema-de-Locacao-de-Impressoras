/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.model.valid;

public class ValidatePessoaFisica {

    public ValidatePessoaFisica() {
    }

    public boolean validaCPF(String cpf) {
        //vamos verificar o tamanho primeiro        
        if (cpf.length() != 11 && cpf.length() != 14) {
            return false;
            //throw new RuntimeException("CPF inválido -  Tamanho inválido.");
        }

        //Retira os caracteres deixando apenas digitos
        if (cpf.length() == 14) {
            cpf = cpf.replaceAll("\\.", "");
            cpf = cpf.replaceAll("-", "");
        }

        //se tem tamanho 11 e so possui digitos
        if (cpf.length() == 11 && cpf.matches("[0-9]*")) {
            String[] vet = cpf.split("");

            int digito1 = Integer.parseInt(vet[9]);
            int digito2 = Integer.parseInt(vet[10]);

            //vamos calcular o primeiro verificador
            int soma1 = 0;
            int fator1 = 10;
            for (int i = 0; i <= 8; i++) {
                int val = Integer.parseInt(vet[i]);
                soma1 = soma1 + (fator1 * val);
                fator1--;
            }

            int resultado1 = (soma1 * 10) % 11;
            if (resultado1 == 10) {
                resultado1 = 0;
            }

            if (resultado1 != digito1) {
                return false;
            }

            //vamos calcular o segundo verificador
            int soma2 = 0;
            int fator2 = 11;
            for (int i = 0; i <= 9; i++) {
                int val = Integer.parseInt(vet[i]);
                soma2 = soma2 + (fator2 * val);
                fator2--;
            }

            int resultado2 = (soma2 * 10) % 11;
            if (resultado2 == 10) {
                resultado2 = 0;
            }

            if (resultado2 != digito2) {
                return false;
            }

            //agora so basta verificar se todos são iguais
            for (int i = 0; i <= 9; i++) {
                int val = Integer.parseInt(vet[i]);
                int valProx = Integer.parseInt(vet[i + 1]);
                if (val != valProx) {
                    return true;
                }
            }
        }
        return false;
    }
}
