/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Presupuesto {
    // Atributo que almacena la colección de transacciones (Ingresos y Egresos)
    private final List<Transaccion> transacciones;

    public Presupuesto() {
        this.transacciones = new ArrayList<>();
    }

    /**
     * Agrega una transacción al presupuesto. 
     * Gracias al polimorfismo, puede recibir tanto un Ingreso como un Egreso.
     * @param t
     */
    public void agregarTransaccion(Transaccion t) {
        if (t != null) {
            this.transacciones.add(t);
        }
    }

    /**
     * Calcula el saldo neto acumulado.
     * Aplica el patrón Strategy/Polimorfismo: cada transacción sabe si debe 
     * sumar o restar su monto mediante el método calcularImpacto().
     * @return 
     */
    public Double calcularSaldo() {
        Double saldo = 0.0;
        for (Transaccion t : transacciones) {
            saldo += t.calcularImpacto();
        }
        return saldo;
    }

    /**
     * Retorna una lista no modificable de las transacciones para proteger 
     * la integridad de los datos (Encapsulamiento avanzado).
     * @return 
     */
    public List<Transaccion> getTransacciones() {
        return Collections.unmodifiableList(transacciones);
    }
    
    /**
     * Método de utilidad para obtener solo ingresos o solo egresos si fuera necesario
     * @return 
     */
    public int totalMovimientos() {
        return this.transacciones.size();
    }
}