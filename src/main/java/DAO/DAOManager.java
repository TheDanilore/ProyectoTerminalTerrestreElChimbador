/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Danilore
 */
public interface DAOManager {
    CargoDAO getCargoDAO();
    ConductorDAO getConductorDAO();
    EmpresasDAO getEmpresasDAO();
    EstadoConductorDAO getEstadoConductorDAO();
    EstadoEmpresaDAO getEstadoEmpresaDAO();
    EstadoUsuarioDAO getEstadoUsuarioDAO();
    EstadoVehiculoDAO getEstadoVehiculoDAO();
    MetodoPagoDAO getMetodoPagoDAO();
    PagoCocheraDAO getPagoCocheraDAO();
    PagoEscalaDAO getPagoEscalaDAO();
    PagoNormalDAO getPagoNormalDAO();
    TipoDocumentoIdentidadDAO getTipoDocumentoIdentidadDAO();
    TipoVehiculoPagoDAO getTipoVehiculoPagoDAO();
    UsuarioDAO getUsuarioDAO();
    VehiculoDAO getVehiculoDAO();
    RegistroEntradaDAO getRegistroEntradaDAO();
    DepartamentoDAO getDepartamentoDAO();
    ProvinciaDAO getProvinciaDAO();
    DistritoDAO getDistritoDAO();
    
    PagoDAO getPagoDAO();

}
