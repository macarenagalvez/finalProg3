/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalgalvez;

import java.util.*;
import javax.persistence.*;

/**
 *
 * @author macarena
 */
@Entity
public class Temporada {
    private int id;
    private String denominacion;
    private Date fechaInicio;
    private Date fechaFin;
    private ArrayList<EstanciaTemporada> estancias;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    @Column
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Column
    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @OneToMany(mappedBy = "temporada")
    public ArrayList<EstanciaTemporada> getEstancias() {
        return estancias;
    }

    public void setEstancias(ArrayList<EstanciaTemporada> estancias) {
        this.estancias = estancias;
    }
    
    
}
