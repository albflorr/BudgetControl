/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.time.LocalDate;

public abstract class Transaccion {
    protected Long id;
    protected String descripcion;
    protected Double monto;
    protected LocalDate fecha;

    public Transaccion(String descripcion, Double monto, LocalDate fecha) {
        this.descripcion = descripcion;
        this.monto = monto;
        this.fecha = fecha;
    }

    public abstract Double calcularImpacto(); // Método Polimórfico

    // Getters
    public String getDescripcion() { return descripcion; }
    public Double getMonto() { return monto; }
    public LocalDate getFecha() { return fecha; }
    @Override
    public String toString(){
        return this.getDescripcion()+" - "+this.getMonto()+" - "+this.getFecha();
    }
}
