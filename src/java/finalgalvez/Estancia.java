/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalgalvez;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author macarena
 */
@Entity
public class Estancia {

    private int codigoEstancia;
    private double nombre;
    private int categoria;
    private String descripcion;
    private String domicilio;
    private boolean destacada;
    private ArrayList<Caracteristica> caracteristicas;
    private ArrayList<EstanciaTemporada> estanciasTemporada;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCodigoEstancia() {
        return codigoEstancia;
    }

    public void setCodigoEstancia(int codigoEstancia) {
        this.codigoEstancia = codigoEstancia;
    }

    @Column
    public double getNombre() {
        return nombre;
    }

    public void setNombre(double nombre) {
        this.nombre = nombre;
    }

    @Column
    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @Column
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column
    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    @Column
    public boolean isDestacada() {
        return destacada;
    }

    public void setDestacada(boolean destacada) {
        this.destacada = destacada;
    }

    @ManyToMany()
    @JoinTable
    public ArrayList<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(ArrayList<Caracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    @OneToMany(mappedBy = "estancia")
    public ArrayList<EstanciaTemporada> getEstanciasTemporada() {
        return estanciasTemporada;
    }

    public void setEstanciasTemporada(ArrayList<EstanciaTemporada> estanciasTemporada) {
        this.estanciasTemporada = estanciasTemporada;
    }

    public String verCaracteristicasXTipo(String tipo) {
        String result = "";

        for (Caracteristica c : this.caracteristicas) {
            result += "<li>" + c.getTipo() + "</li>";
        }

        return result;
    }

    public double getValorEstanciaXFechaReserva(Date fechaReserva) {
        double result = 0;

        for (EstanciaTemporada et : this.estanciasTemporada) {
            if (et.getTemporada().getFechaInicio().after(fechaReserva) && et.getTemporada().getFechaInicio().before(fechaReserva)) {
                result = et.getValor();
            }
        }

        return result;
    }

    public Temporada getTemporadaMasEconomicaXAnio(int anio) {
        Temporada result = new Temporada();
        double menorPrecio = 0;

        for (EstanciaTemporada et : this.estanciasTemporada) {
            menorPrecio = et.getValor();
            if (menorPrecio > et.getValor()) {
                menorPrecio = et.getValor();
                result = et.getTemporada();
            }
        }

        return result;
    }
}
