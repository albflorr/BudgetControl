/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package aplicacion;

import dominio.Transaccion;
import java.util.List;

public interface IBudgetRepository {
    void guardar(Transaccion t);
    List<Transaccion> obtenerTodas(); 
}
