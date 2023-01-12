/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class LocacaoPJ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @OneToOne(targetEntity = PessoaJuridica.class, fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private PessoaJuridica cliente;
    
    @OneToOne(targetEntity = Impressora.class, fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Impressora impressora;
    
    private int tempo;
    private float valor;
    
    public void devolver(){
        this.impressora.setDisponivel(true);
    }
}
