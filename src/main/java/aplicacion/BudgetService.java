/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import dominio.Transaccion;

public class BudgetService {
    private final IBudgetRepository repository;

    // Inyección de Dependencia (DIP)
    public BudgetService(IBudgetRepository repository) {
        this.repository = repository;
    }

    public void registrarMovimiento(Transaccion t) {
        // Regla de negocio: No permitir montos negativos
        if(t.getMonto() > 0) {
            repository.guardar(t);
        }
    }

    public Double calcularSaldoTotal() {
        return repository.obtenerTodas().stream()
                .mapToDouble(Transaccion::calcularImpacto)
                .sum();
    }
}
