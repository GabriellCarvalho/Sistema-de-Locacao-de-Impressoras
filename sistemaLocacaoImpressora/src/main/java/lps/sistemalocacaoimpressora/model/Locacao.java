/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @OneToOne(targetEntity = Impressora.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Cliente cliente;
    
    @OneToMany(targetEntity = Impressora.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Impressora> impressoras;
    
    private String tempo;
    private String valor;
    
    
    public void addImpressora(Impressora impressora) {
        this.impressoras.add(impressora);
    }
    
}
