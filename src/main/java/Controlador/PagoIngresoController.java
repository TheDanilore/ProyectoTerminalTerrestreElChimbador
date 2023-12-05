/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.DAOException;
import DAO.DAOManager;
import DAO.MetodoPagoDAO;
import DAO.PagoDAO;
import DAO.RegistroEntradaDAO;
import Modelo.MetodoPago;
import Modelo.Pago;
import Modelo.RegistroEntrada;
import Vista.ConsultarPago;
import Vista.PagoIngreso;
import Vista.RegistroEntradaVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danilore
 */
public class PagoIngresoController implements ActionListener {

    private DAOManager manager;
    PagoIngreso vista = new PagoIngreso();
    ConsultarPago consultarPago = new ConsultarPago();
    Pago modelo = new Pago();
    RegistroEntrada modeloEntrada = new RegistroEntrada();
    DefaultTableModel clase = new DefaultTableModel();

    double totalpagar = 0.00;

    public PagoIngresoController(PagoIngreso v, ConsultarPago pv, DAOManager manager) throws DAOException {
        this.vista = v;
        this.consultarPago = pv;
        this.manager = manager;
        this.vista.btnPago.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
        
        llenarMetodoPago();
        llenarMetodoPagoConsultar();
        listar(consultarPago.tableVehiculo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnPago) {
            try {
                guardar();
                guardarRegistroEntrada();
                PDF();
                this.vista.setVisible(false);
            } catch (DAOException ex) {
                Logger.getLogger(MetodoPagoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnCancelar) {
            try {
                cancelar();
            } catch (DAOException ex) {
                Logger.getLogger(PagoIngresoController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void setTextosEnTextFieldB(String texto1, String texto2, String texto3, String texto4, String texto5, String texto6) throws DAOException {
        vista.txtDni.setText(texto1);
        vista.txtConductor.setText(texto2);
        vista.txtPlaca.setText(texto3);
        vista.txtTipoVehiculo.setText(texto4);
        vista.txtDestino.setText(texto5);
        vista.txtMontoPago.setText(texto6);
    }

    public void guardarRegistroEntrada() throws DAOException {
        if (camposValidos()) {

            modeloEntrada.setDni(Long.parseLong(vista.txtDni.getText()));
            modeloEntrada.setConductor(vista.txtConductor.getText());
            modeloEntrada.setVehiculo(vista.txtPlaca.getText());
            modeloEntrada.setTipo_vehiculo(vista.txtTipoVehiculo.getText());
            modeloEntrada.setDestino(vista.txtDestino.getText());
            modeloEntrada.setPago(Double.parseDouble(vista.txtMontoPago.getText()));

            //Conexion, consulta con la base de datos
            RegistroEntradaDAO dao = manager.getRegistroEntradaDAO();
            dao.add(modeloEntrada);

            JOptionPane.showMessageDialog(null, "Ingreso Registrado con Exito");

        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }
    }

    public void guardar() throws DAOException {
        if (camposValidos()) {

            modelo.setDni_conductor(Long.parseLong(vista.txtDni.getText()));
            modelo.setConductor(vista.txtConductor.getText());
            modelo.setPlaca(vista.txtPlaca.getText());
            modelo.setTipo_vehiculo(vista.txtTipoVehiculo.getText());
            modelo.setDestino(vista.txtDestino.getText());
            modelo.setMonto(Double.parseDouble(vista.txtMontoPago.getText()));

            String metodo = vista.cbxMetodoPago.getSelectedItem().toString();
            if ("Pago Efectivo".equalsIgnoreCase(metodo)) {
                modelo.setId_metodo_pago(1);
            }

            //Conexion, consulta con la base de datos
            PagoDAO dao = manager.getPagoDAO();
            dao.add(modelo);

            JOptionPane.showMessageDialog(null, "Pago Registrado");

        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }
    }

    public void actualizar() throws DAOException {
        if ("".equals(consultarPago.txtIdPago.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            if (camposValidosConsultar()) {
                modelo.setDni_conductor(Long.parseLong(vista.txtDni.getText()));
                modelo.setConductor(vista.txtConductor.getText());
                modelo.setPlaca(vista.txtPlaca.getText());
                modelo.setTipo_vehiculo(vista.txtTipoVehiculo.getText());
                modelo.setDestino(vista.txtDestino.getText());
                modelo.setMonto(Double.parseDouble(vista.txtMontoPago.getText()));

                String metodo = vista.cbxMetodoPago.getSelectedItem().toString();
                if ("Pago Efectivo".equalsIgnoreCase(metodo)) {
                    modelo.setId_metodo_pago(1);
                }

                //Conexion, consulta con la base de datos
                PagoDAO dao = manager.getPagoDAO();
                dao.update(modelo);

                JOptionPane.showMessageDialog(null, "Pago Actualizado con Exito");
                LimpiarTable();
                listar(consultarPago.tableVehiculo);
                Limpiar();

            } else {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            }
        }
    }

    public void listar(JTable tabla) throws DAOException {
        clase = (DefaultTableModel) tabla.getModel();
        PagoDAO dao = manager.getPagoDAO();
        List<Pago> lista = dao.listAll();
        Object[] ob = new Object[9];

        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId_pago();
            ob[1] = lista.get(i).getDni_conductor();
            ob[2] = lista.get(i).getConductor();
            ob[3] = lista.get(i).getPlaca();
            ob[4] = lista.get(i).getTipo_vehiculo();
            ob[5] = lista.get(i).getDestino();
            ob[6] = lista.get(i).getFecha_pago();
            ob[7] = lista.get(i).getMonto();
            ob[8] = lista.get(i).getId_metodo_pago();

            if (lista.get(i).getId_metodo_pago() == 1) {
                ob[8] = "Pago Efectivo";
            }

            clase.addRow(ob);
        }
        consultarPago.tableVehiculo.setModel(clase);
    }

    public void cancelar() throws DAOException {

        vista.setVisible(false);

    }
    
    public void nuevo(){
        Limpiar();
        
    }

    public boolean camposValidos() {
        return !vista.txtConductor.getText().isEmpty()
                && !vista.txtDni.getText().isEmpty()
                && !vista.txtPlaca.getText().isEmpty()
                && !vista.txtMontoPago.getText().isEmpty()
                && !vista.txtConductor.getText().isEmpty();
    }
    
    public boolean camposValidosConsultar() {
        return !consultarPago.txtIdPago.getText().isEmpty()
                && !consultarPago.txtDni.getText().isEmpty()
                && !consultarPago.txtConductor.getText().isEmpty()
                && !consultarPago.txtPlaca.getText().isEmpty()
                && !consultarPago.txtTipoVehiculo.getText().isEmpty()
                && !consultarPago.txtDestino.getText().isEmpty()
                && !consultarPago.txtMontoPago.getText().isEmpty()
                && consultarPago.cbxMetodoPago.getSelectedItem()!=null;
    }
    
    public void Limpiar() {
        consultarPago.txtIdPago.setText("");
        consultarPago.txtDni.setText("");
        consultarPago.txtConductor.setText("");
        consultarPago.txtPlaca.setText("");
        consultarPago.txtTipoVehiculo.setText("");
        consultarPago.txtDestino.setText("");
        consultarPago.txtMontoPago.setText("");
        consultarPago.cbxMetodoPago.setSelectedItem(null);
        
    }

    public void LimpiarTable() {
        for (int i = 0; i < clase.getRowCount(); i++) {
            clase.removeRow(i);
            i = i - 1;
        }
    }


    private void llenarMetodoPago() throws DAOException {

        MetodoPagoDAO dao = manager.getMetodoPagoDAO();

        List<MetodoPago> lista = (ArrayList<MetodoPago>) dao.listAll();

        //int idselect = 1;
        vista.cbxMetodoPago.removeAllItems();

        for (int i = 0; i < lista.size(); i++) {
            vista.cbxMetodoPago.addItem(lista.get(i).getDescripcion());
        }

    }
    private void llenarMetodoPagoConsultar() throws DAOException {

        MetodoPagoDAO dao = manager.getMetodoPagoDAO();

        List<MetodoPago> lista = (ArrayList<MetodoPago>) dao.listAll();

        //int idselect = 1;
        consultarPago.cbxMetodoPago.removeAllItems();

        for (int i = 0; i < lista.size(); i++) {
            consultarPago.cbxMetodoPago.addItem(lista.get(i).getDescripcion());
        }

    }

    private void PDF() {
        try {
            //Conexion, consulta con la base de datos
            PagoDAO dao = manager.getPagoDAO();

            int id = dao.IDPago();

            FileOutputStream archivo;
            File file = new File("src\\main\\java\\Reportes\\Pago" + id + ".pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Image img = Image.getInstance("src\\main\\java\\Imagenes\\utp.png");

            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.GREEN);
            fecha.add(Chunk.NEWLINE);
            Date date = new Date();
            fecha.add("Boleta: " + id + "\n" + "Fecha: " + new SimpleDateFormat("dd-MM-yyyy").format(date) + "\n\n");

            PdfPTable encabezado = new PdfPTable(4);
            encabezado.setWidthPercentage(100);
            encabezado.getDefaultCell().setBorder(0);
            float[] columnaencabezado = new float[]{20f, 30f, 70f, 40f};
            encabezado.setWidths(columnaencabezado);
            encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);

            encabezado.addCell(img);

            String ruc = "78954654";
            String nombre = "Municipalidad Provincial del Santa";
            String telefono = "936081881";
            String direccion = "Chimbote";
            String razon = "Municipalidad Provincial del Santa";

            encabezado.addCell("");
            encabezado.addCell("RUC: " + ruc + "\nNombre: " + nombre + "\nTelefono: " + telefono + "\nDireccion: " + direccion + "\nRazon: " + razon);
            encabezado.addCell(fecha);
            doc.add(encabezado);

            Paragraph clientes = new Paragraph();
            clientes.add(Chunk.NEWLINE);
            clientes.add("""
                         Datos del Cliente
                         
                         """);
            doc.add(clientes);

            PdfPTable tablacliente = new PdfPTable(4);
            tablacliente.setWidthPercentage(100);
            tablacliente.getDefaultCell().setBorder(0);
            float[] columnacliente = new float[]{20f, 50f, 30f, 40f};
            tablacliente.setWidths(columnacliente);
            tablacliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell clientes1 = new PdfPCell(new Phrase("DNI/Ruc", negrita));
            PdfPCell clientes2 = new PdfPCell(new Phrase("Nombre", negrita));
            PdfPCell clientes3 = new PdfPCell(new Phrase("Placa", negrita));
            PdfPCell clientes4 = new PdfPCell(new Phrase("Destino", negrita));
            clientes1.setBorder(0);
            clientes2.setBorder(0);
            clientes3.setBorder(0);
            clientes4.setBorder(0);
            tablacliente.addCell(clientes1);
            tablacliente.addCell(clientes2);
            tablacliente.addCell(clientes3);
            tablacliente.addCell(clientes4);
            tablacliente.addCell(vista.txtDni.getText());
            tablacliente.addCell(vista.txtConductor.getText());
            tablacliente.addCell(vista.txtPlaca.getText());
            tablacliente.addCell(vista.txtDestino.getText());

            doc.add(tablacliente);

            //productos
            PdfPTable tablaproductos = new PdfPTable(3);
            tablaproductos.setWidthPercentage(100);
            tablaproductos.getDefaultCell().setBorder(0);
            float[] columnaproductos = new float[]{10f, 50f, 15f};
            tablaproductos.setWidths(columnaproductos);
            tablaproductos.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell productos1 = new PdfPCell(new Phrase("CANTIDAD", negrita));
            PdfPCell productos2 = new PdfPCell(new Phrase("DESCRIPCION", negrita));
            PdfPCell productos3 = new PdfPCell(new Phrase("MONTO", negrita));
            productos1.setBorder(0);
            productos2.setBorder(0);
            productos3.setBorder(0);
            productos1.setBackgroundColor(BaseColor.DARK_GRAY);
            productos2.setBackgroundColor(BaseColor.DARK_GRAY);
            productos3.setBackgroundColor(BaseColor.DARK_GRAY);
            tablaproductos.addCell(productos1);
            tablaproductos.addCell(productos2);
            tablaproductos.addCell(productos3);

            for (int i = 0; i < 1; i++) {
                String descripcion = vista.txtDestino.getText();
                String cantidad = "1";
                String total = vista.txtMontoPago.getText();
                tablaproductos.addCell(cantidad);
                tablaproductos.addCell(descripcion);
                tablaproductos.addCell(total);
            }
            doc.add(tablaproductos);

            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);

            totalpagar = Double.parseDouble(vista.txtMontoPago.getText());
            info.add("Total a Pagar: " + totalpagar);
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);

            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Cancelacion y Firma\n\n");
            firma.add("--------------------");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);

            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("Gracias por su preferencia");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);

            doc.close();
            archivo.close();
            Desktop.getDesktop().open(file);
        } catch (DocumentException | IOException e) {
            System.out.println(e.toString());

        }
    }

}
