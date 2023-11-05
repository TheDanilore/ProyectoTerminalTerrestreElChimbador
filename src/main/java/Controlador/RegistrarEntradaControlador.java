/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.RegistrarEntrada;

/**
 *
 * @author ASUS
 */
public class RegistrarEntradaControlador {
    private RegistrarEntrada vista;

    public RegistrarEntradaControlador(RegistrarEntrada vista) {
        this.vista = vista;
    }

    public void consultarVehiculo(String placa) {
        
        /*Vehiculo vehiculo = buscarVehiculoEnLaBaseDeDatos(placa);
        if (vehiculo != null) {
            vista.actualizarVehiculo(vehiculo);
        } else {
            vista.mostrarMensajeError("El vehículo no existe");
        }*/
    }

    public void consultarConductor(String dni) {
        /*Conductor conductor = buscarConductorEnLaBaseDeDatos(dni);
        if (conductor != null) {
            vista.actualizarConductor(conductor);
        } else {
            vista.mostrarMensajeError("El conductor no existe");
        }*/
    }


}
