/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.RegistroEntrada;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ConsultarRegistroControlador {
    private List<RegistroEntrada> movimientos; // Lista de movimientos (debes llenarla con datos reales)

    public ConsultarRegistroControlador(List<RegistroEntrada> movimientos) {
        this.movimientos = movimientos;
    }

    public List<RegistroEntrada> consultarMovimientos(String placa, String fecha) {
        List<RegistroEntrada> movimientosFiltrados = new ArrayList<>();

        /*for (RegistroEntrada movimiento : movimientos) {
            boolean cumplePlaca = placa.isEmpty() || movimiento.getVehiculo();
            boolean cumpleFecha = fecha.isEmpty() || movimiento.getFecha_hora_entrada().equalsIgnoreCase(fecha);

            if (cumplePlaca && cumpleFecha) {
                movimientosFiltrados.add(movimiento);
            }
        }*/

        return movimientosFiltrados;
        
    }
}
