/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Movimiento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ConsultarRegistroControlador {
    private List<Movimiento> movimientos; // Lista de movimientos (debes llenarla con datos reales)

    public ConsultarRegistroControlador(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public List<Movimiento> consultarMovimientos(String placa, String fecha) {
        List<Movimiento> movimientosFiltrados = new ArrayList<>();

        for (Movimiento movimiento : movimientos) {
            boolean cumplePlaca = placa.isEmpty() || movimiento.getPlaca().equalsIgnoreCase(placa);
            boolean cumpleFecha = fecha.isEmpty() || movimiento.getFecha().equalsIgnoreCase(fecha);

            if (cumplePlaca && cumpleFecha) {
                movimientosFiltrados.add(movimiento);
            }
        }

        return movimientosFiltrados;
        
    }
}
