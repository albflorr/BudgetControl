/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructura.ui;

import aplicacion.BudgetService;
import dominio.Egreso;
import dominio.Ingreso;
import dominio.Transaccion;
import java.time.LocalDate;
import java.util.List;

public class BudgetController {
    private final BudgetService budgetService;

    // Inyección de Dependencias: El controlador recibe el servicio ya configurado
    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    /**
     * Procesa la solicitud de registro desde la UI.
     * @param descripcion
     * @param monto
     * @param fecha
     * @param tipo "INGRESO" o "EGRESO"
     * @return 
     */
    public String ejecutarRegistro(String descripcion, Double monto, LocalDate fecha, String tipo) {
        try {
            Transaccion transaccion;
            if (tipo.equalsIgnoreCase("INGRESO")) {
                transaccion = new Ingreso(descripcion, monto, fecha);
            } else if (tipo.equalsIgnoreCase("EGRESO")) {
                transaccion = new Egreso(descripcion, monto, fecha);
            } else {
                return "Error: Tipo de transacción no válido.";
            }

            budgetService.registrarMovimiento(transaccion);
            return "Transacción registrada exitosamente.";
        } catch (Exception e) {
            return "Error al registrar: " + e.getMessage();
        }
    }

    public Double obtenerSaldoActual() {
        return budgetService.calcularSaldoTotal();
    }
    
    public List<Transaccion> obtenerHistorial() {
        return budgetService.obtenerHistorialCompleto();
    }
}