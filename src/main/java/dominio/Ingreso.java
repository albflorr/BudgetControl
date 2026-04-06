/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.time.LocalDate;


public class Ingreso extends Transaccion {
    public Ingreso(String desc, Double monto, LocalDate fecha) { super(desc, monto, fecha); }
    @Override
    public Double calcularImpacto() { return monto; }
}
