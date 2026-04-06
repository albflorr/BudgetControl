/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructura.persistence;

import dominio.Egreso;
import dominio.Ingreso;
import dominio.Transaccion;

class TransactionFactory {
    public static Transaccion create(String tipo, String desc, Double monto, java.time.LocalDate fecha) {
        if (tipo.equals("INGRESO")) return new Ingreso(desc, monto, fecha);
        if (tipo.equals("EGRESO")) return new Egreso(desc, monto, fecha);
        throw new IllegalArgumentException("Tipo desconocido");
    }
}
