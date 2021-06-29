/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalgalvez;

import javax.persistence.*;

/**
 *
 * @author macarena
 */
@Entity
public class EstanciaTemporada {
    private long id;
    private double valor;
    private Temporada temporada;
    private Estancia estancia;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @ManyToOne
    @JoinColumn(name = "temporadaId")
    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }

    @ManyToOne
    @JoinColumn(name = "estanciaId")
    public Estancia getEstancia() {
        return estancia;
    }

    public void setEstancia(Estancia estancia) {
        this.estancia = estancia;
    }
        
    
}
