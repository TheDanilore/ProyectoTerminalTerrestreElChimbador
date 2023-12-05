/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
        
import DAO.Conexion;
import DAO.DAOManager;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Danilore
 */
public class Excel {
    private final DAOManager manager;

    public Excel(DAOManager manager) {
        this.manager=manager;
    }
    
    public static void reporteCargo(){
        //Crear un nuevo libro de trabajo en formato XLSX (XSSFWorkbook) 2007 hasta la actualidad
        // (Se guarda en memoria)
        Workbook libro = new XSSFWorkbook();

        
        //Crear un nuevo libro de trabajo en formato XLS (HSSFWorkbook) 2003 para atras
        //Workbook libro = new HSSFWorkbook();
        
        
        // Crear una hoja en el libro
        Sheet hoja = libro.createSheet("Cargo");

        // Crear una fila en la hoja
        /*Row cabecera = hoja.createRow(2);

        // Crear las columnnas, una celda en la fila
        Cell departamento = cabecera.createCell(1);
        Cell poblacion = cabecera.createCell(2);
        Cell codigo = cabecera.createCell(3);
        
        departamento.setCellValue("Departamentos");
        poblacion.setCellValue("Poblacion Estimada");
        codigo.setCellValue("Codigo");

        */

        // Escribir el libro en un archivo (Exportar al equipo)
        try (FileOutputStream archivo = new FileOutputStream("src\\main\\java\\Reportes\\reporte-cargo.xlsx")) {
            
            //Agregando la imagen a Excel
            InputStream is = new FileInputStream("src\\main\\java\\Imagenes\\utp.png");
            byte[] bytes = IOUtils.toByteArray(is);
            int imgIndex = libro.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            is.close();
            
            CreationHelper help = libro.getCreationHelper();
            Drawing draw = hoja.createDrawingPatriarch();
 
            ClientAnchor anchor = help.createClientAnchor();
            anchor.setCol1(0);
            anchor.setRow1(1);
            Picture pict = draw.createPicture(anchor, imgIndex);
            pict.resize(1, 3);
            
            CellStyle tituloEstilo = libro.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTitulo = libro.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 14);
            tituloEstilo.setFont(fuenteTitulo);
            
            Row filaTitulo = hoja.createRow(1);
            Cell celdaTitulo = filaTitulo.createCell(1);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("Sistema de Registro de Ingreso Y Salidas del Terminal Terrestre El Chimbador");
            
            Row filaSubTitulo = hoja.createRow(3);
            Cell celdaSubTitulo = filaSubTitulo.createCell(1);
            celdaSubTitulo.setCellStyle(tituloEstilo);
            celdaSubTitulo.setCellValue("Reporte de Cargos");
            
            hoja.addMergedRegion(new CellRangeAddress(1, 2, 1, 10));
 
            String[] cabecera = new String[]{"Código", "Cargo"};
            
            CellStyle headerStyle = libro.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);
 
            Font font = libro.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 12);
            headerStyle.setFont(font);
            
            Row filaEncabezados = hoja.createRow(6);
 
            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }
            
            //Conexion con la base de datos
            Conexion con = new Conexion();
            PreparedStatement ps;
            ResultSet rs;
            Connection conn = con.getConnection();
 
            int numFilaDatos = 7;
            
            CellStyle datosEstilo = libro.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);
 
            ps = conn.prepareStatement("SELECT id_cargo, descripcion FROM cargo");
            rs = ps.executeQuery();
 
            int numCol = rs.getMetaData().getColumnCount();
 
            while (rs.next()) {
                Row filaDatos = hoja.createRow(numFilaDatos);
 
                for (int a = 0; a < numCol; a++) {
 
                    Cell CeldaDatos = filaDatos.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);
                    CeldaDatos.setCellValue(rs.getString(a + 1));
                }
 
 
                numFilaDatos++;
            }
            hoja.autoSizeColumn(0);
            hoja.autoSizeColumn(1);
            hoja.autoSizeColumn(2);
            hoja.autoSizeColumn(3);
            hoja.autoSizeColumn(4);
            
            hoja.setZoom(110);
            String fileName = "Cargo";
            String home = System.getProperty("user.home");
            File file = new File("src\\main\\java\\Reportes\\" + fileName + ".xlsx");
            FileOutputStream fileOut = new FileOutputStream(file);
            libro.write(fileOut);
            fileOut.close();
            Desktop.getDesktop().open(file);
            JOptionPane.showMessageDialog(null, "Reporte Generado");
            
            //libro.write(archivo);
        }  catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void reporteConductor(){
        //Crear un nuevo libro de trabajo en formato XLSX (XSSFWorkbook) 2007 hasta la actualidad
        // (Se guarda en memoria)
        Workbook libro = new XSSFWorkbook();

        
        //Crear un nuevo libro de trabajo en formato XLS (HSSFWorkbook) 2003 para atras
        //Workbook libro = new HSSFWorkbook();
        
        
        // Crear una hoja en el libro
        Sheet hoja = libro.createSheet("Conductor");

        // Crear una fila en la hoja
        /*Row cabecera = hoja.createRow(2);

        // Crear las columnnas, una celda en la fila
        Cell departamento = cabecera.createCell(1);
        Cell poblacion = cabecera.createCell(2);
        Cell codigo = cabecera.createCell(3);
        
        departamento.setCellValue("Departamentos");
        poblacion.setCellValue("Poblacion Estimada");
        codigo.setCellValue("Codigo");

        */

        // Escribir el libro en un archivo (Exportar al equipo)
        try (FileOutputStream archivo = new FileOutputStream("src\\main\\java\\Reportes\\reporte-conductor.xlsx")) {
            
            //Agregando la imagen a Excel
            InputStream is = new FileInputStream("src\\main\\java\\Imagenes\\utp.png");
            byte[] bytes = IOUtils.toByteArray(is);
            int imgIndex = libro.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            is.close();
            
            CreationHelper help = libro.getCreationHelper();
            Drawing draw = hoja.createDrawingPatriarch();
 
            ClientAnchor anchor = help.createClientAnchor();
            anchor.setCol1(0);
            anchor.setRow1(1);
            Picture pict = draw.createPicture(anchor, imgIndex);
            pict.resize(1, 3);
            
            CellStyle tituloEstilo = libro.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTitulo = libro.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 14);
            tituloEstilo.setFont(fuenteTitulo);
            
            Row filaTitulo = hoja.createRow(1);
            Cell celdaTitulo = filaTitulo.createCell(1);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("Sistema de Registro de Ingreso Y Salidas del Terminal Terrestre El Chimbador");
            
            Row filaSubTitulo = hoja.createRow(3);
            Cell celdaSubTitulo = filaSubTitulo.createCell(1);
            celdaSubTitulo.setCellStyle(tituloEstilo);
            celdaSubTitulo.setCellValue("Reporte de Conductores");
            
            hoja.addMergedRegion(new CellRangeAddress(1, 2, 1, 10));
 
            String[] cabecera = new String[]{"Código", "Primer Nombre","Segundo Nombre","Apellido Paterno","Apellido Materno","Codigo de Tipo de Identidad","Número de Documento","N° Telefono","Dirección","Codigo de Empresa","estado"};
            
            CellStyle headerStyle = libro.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);
 
            Font font = libro.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 12);
            headerStyle.setFont(font);
            
            Row filaEncabezados = hoja.createRow(6);
 
            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }
            
            //Conexion con la base de datos
            Conexion con = new Conexion();
            PreparedStatement ps;
            ResultSet rs;
            Connection conn = con.getConnection();
 
            int numFilaDatos = 7;
            
            CellStyle datosEstilo = libro.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);
 
            ps = conn.prepareStatement("SELECT id_conductor, primer_nombre,segundo_nombre,apellido_paterno,apellido_materno,id_tipo_documento_identidad,numero_documento,telefono,direccion,ruc_empresa,id_estado FROM conductor");
            rs = ps.executeQuery();
 
            int numCol = rs.getMetaData().getColumnCount();
 
            while (rs.next()) {
                Row filaDatos = hoja.createRow(numFilaDatos);
 
                for (int a = 0; a < numCol; a++) {
 
                    Cell CeldaDatos = filaDatos.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);
                    CeldaDatos.setCellValue(rs.getString(a + 1));
                }
 
 
                numFilaDatos++;
            }
            hoja.autoSizeColumn(0);
            hoja.autoSizeColumn(1);
            hoja.autoSizeColumn(2);
            hoja.autoSizeColumn(3);
            hoja.autoSizeColumn(4);
            
            hoja.setZoom(110);
            String fileName = "Conductor";
            String home = System.getProperty("user.home");
            File file = new File("src\\main\\java\\Reportes\\" + fileName + ".xlsx");
            FileOutputStream fileOut = new FileOutputStream(file);
            libro.write(fileOut);
            fileOut.close();
            Desktop.getDesktop().open(file);
            JOptionPane.showMessageDialog(null, "Reporte Generado");
            
            //libro.write(archivo);
        }  catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        public static void reporteEmpresa(){
        //Crear un nuevo libro de trabajo en formato XLSX (XSSFWorkbook) 2007 hasta la actualidad
        // (Se guarda en memoria)
        Workbook libro = new XSSFWorkbook();

        
        //Crear un nuevo libro de trabajo en formato XLS (HSSFWorkbook) 2003 para atras
        //Workbook libro = new HSSFWorkbook();
        
        
        // Crear una hoja en el libro
        Sheet hoja = libro.createSheet("Empresa");

        // Crear una fila en la hoja
        /*Row cabecera = hoja.createRow(2);

        // Crear las columnnas, una celda en la fila
        Cell departamento = cabecera.createCell(1);
        Cell poblacion = cabecera.createCell(2);
        Cell codigo = cabecera.createCell(3);
        
        departamento.setCellValue("Departamentos");
        poblacion.setCellValue("Poblacion Estimada");
        codigo.setCellValue("Codigo");

        */

        // Escribir el libro en un archivo (Exportar al equipo)
        try (FileOutputStream archivo = new FileOutputStream("src\\main\\java\\Reportes\\reporte-empresa.xlsx")) {
            
            //Agregando la imagen a Excel
            InputStream is = new FileInputStream("src\\main\\java\\Imagenes\\utp.png");
            byte[] bytes = IOUtils.toByteArray(is);
            int imgIndex = libro.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            is.close();
            
            CreationHelper help = libro.getCreationHelper();
            Drawing draw = hoja.createDrawingPatriarch();
 
            ClientAnchor anchor = help.createClientAnchor();
            anchor.setCol1(0);
            anchor.setRow1(1);
            Picture pict = draw.createPicture(anchor, imgIndex);
            pict.resize(1, 3);
            
            CellStyle tituloEstilo = libro.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTitulo = libro.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 14);
            tituloEstilo.setFont(fuenteTitulo);
            
            Row filaTitulo = hoja.createRow(1);
            Cell celdaTitulo = filaTitulo.createCell(1);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("Sistema de Registro de Ingreso Y Salidas del Terminal Terrestre El Chimbador");
            
            Row filaSubTitulo = hoja.createRow(3);
            Cell celdaSubTitulo = filaSubTitulo.createCell(1);
            celdaSubTitulo.setCellStyle(tituloEstilo);
            celdaSubTitulo.setCellValue("Reporte de Empresa");
            
            hoja.addMergedRegion(new CellRangeAddress(1, 2, 1, 10));
 
            String[] cabecera = new String[]{"Código", "ruc","Razon Social","Nombre","estado"};
            
            CellStyle headerStyle = libro.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);
 
            Font font = libro.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 12);
            headerStyle.setFont(font);
            
            Row filaEncabezados = hoja.createRow(6);
 
            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }
            
            //Conexion con la base de datos
            Conexion con = new Conexion();
            PreparedStatement ps;
            ResultSet rs;
            Connection conn = con.getConnection();
 
            int numFilaDatos = 7;
            
            CellStyle datosEstilo = libro.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);
 
            ps = conn.prepareStatement("SELECT id_empresa, ruc,razon_social,nombre_comercial,id_estado FROM empresa");
            rs = ps.executeQuery();
 
            int numCol = rs.getMetaData().getColumnCount();
 
            while (rs.next()) {
                Row filaDatos = hoja.createRow(numFilaDatos);
 
                for (int a = 0; a < numCol; a++) {
 
                    Cell CeldaDatos = filaDatos.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);
                    CeldaDatos.setCellValue(rs.getString(a + 1));
                }
 
 
                numFilaDatos++;
            }
            hoja.autoSizeColumn(0);
            hoja.autoSizeColumn(1);
            hoja.autoSizeColumn(2);
            hoja.autoSizeColumn(3);
            hoja.autoSizeColumn(4);
            
            hoja.setZoom(110);
            String fileName = "Empresa";
            String home = System.getProperty("user.home");
            File file = new File("src\\main\\java\\Reportes\\" + fileName + ".xlsx");
            FileOutputStream fileOut = new FileOutputStream(file);
            libro.write(fileOut);
            fileOut.close();
            Desktop.getDesktop().open(file);
            JOptionPane.showMessageDialog(null, "Reporte Generado");
            
            //libro.write(archivo);
        }  catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public static void reporteUsuario(){
          //Crear un nuevo libro de trabajo en formato XLSX (XSSFWorkbook) 2007 hasta la actualidad
        // (Se guarda en memoria)
        Workbook libro = new XSSFWorkbook();

        
        //Crear un nuevo libro de trabajo en formato XLS (HSSFWorkbook) 2003 para atras
        //Workbook libro = new HSSFWorkbook();
        
        
        // Crear una hoja en el libro
        Sheet hoja = libro.createSheet("Usuario");

        // Crear una fila en la hoja
        /*Row cabecera = hoja.createRow(2);

        // Crear las columnnas, una celda en la fila
        Cell departamento = cabecera.createCell(1);
        Cell poblacion = cabecera.createCell(2);
        Cell codigo = cabecera.createCell(3);
        
        departamento.setCellValue("Departamentos");
        poblacion.setCellValue("Poblacion Estimada");
        codigo.setCellValue("Codigo");

        */

        // Escribir el libro en un archivo (Exportar al equipo)
        try (FileOutputStream archivo = new FileOutputStream("src\\main\\java\\Reportes\\reporte-usuario.xlsx")) {
            
            //Agregando la imagen a Excel
            InputStream is = new FileInputStream("src\\main\\java\\Imagenes\\utp.png");
            byte[] bytes = IOUtils.toByteArray(is);
            int imgIndex = libro.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            is.close();
            
            CreationHelper help = libro.getCreationHelper();
            Drawing draw = hoja.createDrawingPatriarch();
 
            ClientAnchor anchor = help.createClientAnchor();
            anchor.setCol1(0);
            anchor.setRow1(1);
            Picture pict = draw.createPicture(anchor, imgIndex);
            pict.resize(1, 3);
            
            CellStyle tituloEstilo = libro.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTitulo = libro.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 14);
            tituloEstilo.setFont(fuenteTitulo);
            
            Row filaTitulo = hoja.createRow(1);
            Cell celdaTitulo = filaTitulo.createCell(1);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("Sistema de Registro de Ingreso Y Salidas del Terminal Terrestre El Chimbador");
            
            Row filaSubTitulo = hoja.createRow(3);
            Cell celdaSubTitulo = filaSubTitulo.createCell(1);
            celdaSubTitulo.setCellStyle(tituloEstilo);
            celdaSubTitulo.setCellValue("Reporte de Usuario");
            
            hoja.addMergedRegion(new CellRangeAddress(1, 2, 1, 10));
 
            String[] cabecera = new String[]{"Código", "Nombre", "usuario", "contraseña","cargo","estado"};
            
            CellStyle headerStyle = libro.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);
 
            Font font = libro.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 12);
            headerStyle.setFont(font);
            
            Row filaEncabezados = hoja.createRow(6);
 
            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }
            
            //Conexion con la base de datos
            Conexion con = new Conexion();
            PreparedStatement ps;
            ResultSet rs;
            Connection conn = con.getConnection();
 
            int numFilaDatos = 7;
            
            CellStyle datosEstilo = libro.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);
 
            ps = conn.prepareStatement("SELECT id_usuarios, nombres, usuario, contra_usuarios, id_cargo, id_estado FROM usuarios");
            rs = ps.executeQuery();
 
            int numCol = rs.getMetaData().getColumnCount();
 
            while (rs.next()) {
                Row filaDatos = hoja.createRow(numFilaDatos);
 
                for (int a = 0; a < numCol; a++) {
 
                    Cell CeldaDatos = filaDatos.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);
                    CeldaDatos.setCellValue(rs.getString(a + 1));
                }
 
 
                numFilaDatos++;
            }
            hoja.autoSizeColumn(0);
            hoja.autoSizeColumn(1);
            hoja.autoSizeColumn(2);
            hoja.autoSizeColumn(3);
            hoja.autoSizeColumn(4);
            
            hoja.setZoom(110);
            String fileName = "Usuarios";
            String home = System.getProperty("user.home");
            File file = new File("src\\main\\java\\Reportes\\" + fileName + ".xlsx");
            FileOutputStream fileOut = new FileOutputStream(file);
            libro.write(fileOut);
            fileOut.close();
            Desktop.getDesktop().open(file);
            JOptionPane.showMessageDialog(null, "Reporte Generado");
            
            //libro.write(archivo);
        }  catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void reporteVehiculo(){
        //Crear un nuevo libro de trabajo en formato XLSX (XSSFWorkbook) 2007 hasta la actualidad
        // (Se guarda en memoria)
        Workbook libro = new XSSFWorkbook();

        
        //Crear un nuevo libro de trabajo en formato XLS (HSSFWorkbook) 2003 para atras
        //Workbook libro = new HSSFWorkbook();
        
        
        // Crear una hoja en el libro
        Sheet hoja = libro.createSheet("Vehiculo");

        // Crear una fila en la hoja
        /*Row cabecera = hoja.createRow(2);

        // Crear las columnnas, una celda en la fila
        Cell departamento = cabecera.createCell(1);
        Cell poblacion = cabecera.createCell(2);
        Cell codigo = cabecera.createCell(3);
        
        departamento.setCellValue("Departamentos");
        poblacion.setCellValue("Poblacion Estimada");
        codigo.setCellValue("Codigo");

        */

        // Escribir el libro en un archivo (Exportar al equipo)
        try (FileOutputStream archivo = new FileOutputStream("src\\main\\java\\Reportes\\reporte-vehiculo.xlsx")) {
            
            //Agregando la imagen a Excel
            InputStream is = new FileInputStream("src\\main\\java\\Imagenes\\utp.png");
            byte[] bytes = IOUtils.toByteArray(is);
            int imgIndex = libro.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            is.close();
            
            CreationHelper help = libro.getCreationHelper();
            Drawing draw = hoja.createDrawingPatriarch();
 
            ClientAnchor anchor = help.createClientAnchor();
            anchor.setCol1(0);
            anchor.setRow1(1);
            Picture pict = draw.createPicture(anchor, imgIndex);
            pict.resize(1, 3);
            
            CellStyle tituloEstilo = libro.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTitulo = libro.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 14);
            tituloEstilo.setFont(fuenteTitulo);
            
            Row filaTitulo = hoja.createRow(1);
            Cell celdaTitulo = filaTitulo.createCell(1);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("Sistema de Registro de Ingreso Y Salidas del Terminal Terrestre El Chimbador");
            
            Row filaSubTitulo = hoja.createRow(3);
            Cell celdaSubTitulo = filaSubTitulo.createCell(1);
            celdaSubTitulo.setCellStyle(tituloEstilo);
            celdaSubTitulo.setCellValue("Reporte de Vehiculo");
            
            hoja.addMergedRegion(new CellRangeAddress(1, 2, 1, 10));
 
            String[] cabecera = new String[]{"Código", "Placa","Tipo de Vehiculo","Estado"};
            
            CellStyle headerStyle = libro.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);
 
            Font font = libro.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 12);
            headerStyle.setFont(font);
            
            Row filaEncabezados = hoja.createRow(6);
 
            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }
            
            //Conexion con la base de datos
            Conexion con = new Conexion();
            PreparedStatement ps;
            ResultSet rs;
            Connection conn = con.getConnection();
 
            int numFilaDatos = 7;
            
            CellStyle datosEstilo = libro.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);
 
            ps = conn.prepareStatement("SELECT id_vehiculo, placa_vehiculo,id_tipo_vehiculo, id_estado FROM vehiculo");
            rs = ps.executeQuery();
 
            int numCol = rs.getMetaData().getColumnCount();
 
            while (rs.next()) {
                Row filaDatos = hoja.createRow(numFilaDatos);
 
                for (int a = 0; a < numCol; a++) {
 
                    Cell CeldaDatos = filaDatos.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);
                    CeldaDatos.setCellValue(rs.getString(a + 1));
                }
 
 
                numFilaDatos++;
            }
            hoja.autoSizeColumn(0);
            hoja.autoSizeColumn(1);
            hoja.autoSizeColumn(2);
            hoja.autoSizeColumn(3);
            hoja.autoSizeColumn(4);
            
            hoja.setZoom(110);
            String fileName = "Vehiculo";
            String home = System.getProperty("user.home");
            File file = new File("src\\main\\java\\Reportes\\" + fileName + ".xlsx");
            FileOutputStream fileOut = new FileOutputStream(file);
            libro.write(fileOut);
            fileOut.close();
            Desktop.getDesktop().open(file);
            JOptionPane.showMessageDialog(null, "Reporte Generado");
            
            //libro.write(archivo);
        }  catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void reporteTipoVehiculo(){
        //Crear un nuevo libro de trabajo en formato XLSX (XSSFWorkbook) 2007 hasta la actualidad
        // (Se guarda en memoria)
        Workbook libro = new XSSFWorkbook();

        
        //Crear un nuevo libro de trabajo en formato XLS (HSSFWorkbook) 2003 para atras
        //Workbook libro = new HSSFWorkbook();
        
        
        // Crear una hoja en el libro
        Sheet hoja = libro.createSheet("Tipo Vehiculo");

        // Crear una fila en la hoja
        /*Row cabecera = hoja.createRow(2);

        // Crear las columnnas, una celda en la fila
        Cell departamento = cabecera.createCell(1);
        Cell poblacion = cabecera.createCell(2);
        Cell codigo = cabecera.createCell(3);
        
        departamento.setCellValue("Departamentos");
        poblacion.setCellValue("Poblacion Estimada");
        codigo.setCellValue("Codigo");

        */

        // Escribir el libro en un archivo (Exportar al equipo)
        try (FileOutputStream archivo = new FileOutputStream("src\\main\\java\\Reportes\\reporte-tipo-vehiculo.xlsx")) {
            
            //Agregando la imagen a Excel
            InputStream is = new FileInputStream("src\\main\\java\\Imagenes\\utp.png");
            byte[] bytes = IOUtils.toByteArray(is);
            int imgIndex = libro.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            is.close();
            
            CreationHelper help = libro.getCreationHelper();
            Drawing draw = hoja.createDrawingPatriarch();
 
            ClientAnchor anchor = help.createClientAnchor();
            anchor.setCol1(0);
            anchor.setRow1(1);
            Picture pict = draw.createPicture(anchor, imgIndex);
            pict.resize(1, 3);
            
            CellStyle tituloEstilo = libro.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTitulo = libro.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 14);
            tituloEstilo.setFont(fuenteTitulo);
            
            Row filaTitulo = hoja.createRow(1);
            Cell celdaTitulo = filaTitulo.createCell(1);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("Sistema de Registro de Ingreso Y Salidas del Terminal Terrestre El Chimbador");
            
            Row filaSubTitulo = hoja.createRow(3);
            Cell celdaSubTitulo = filaSubTitulo.createCell(1);
            celdaSubTitulo.setCellStyle(tituloEstilo);
            celdaSubTitulo.setCellValue("Reporte de Tipo Vehiculo");
            
            hoja.addMergedRegion(new CellRangeAddress(1, 2, 1, 10));
 
            String[] cabecera = new String[]{"Código","Tipo de Vehiculo"};
            
            CellStyle headerStyle = libro.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);
 
            Font font = libro.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 12);
            headerStyle.setFont(font);
            
            Row filaEncabezados = hoja.createRow(6);
 
            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }
            
            //Conexion con la base de datos
            Conexion con = new Conexion();
            PreparedStatement ps;
            ResultSet rs;
            Connection conn = con.getConnection();
 
            int numFilaDatos = 7;
            
            CellStyle datosEstilo = libro.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);
 
            ps = conn.prepareStatement("SELECT id_tipo_vehiculo, descripcion FROM tipo_vehiculo");
            rs = ps.executeQuery();
 
            int numCol = rs.getMetaData().getColumnCount();
 
            while (rs.next()) {
                Row filaDatos = hoja.createRow(numFilaDatos);
 
                for (int a = 0; a < numCol; a++) {
 
                    Cell CeldaDatos = filaDatos.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);
                    CeldaDatos.setCellValue(rs.getString(a + 1));
                }
 
 
                numFilaDatos++;
            }
            hoja.autoSizeColumn(0);
            hoja.autoSizeColumn(1);
            hoja.autoSizeColumn(2);
            hoja.autoSizeColumn(3);
            hoja.autoSizeColumn(4);
            
            hoja.setZoom(110);
            String fileName = "Tipo de Vehiculo";
            String home = System.getProperty("user.home");
            File file = new File("src\\main\\java\\Reportes\\" + fileName + ".xlsx");
            FileOutputStream fileOut = new FileOutputStream(file);
            libro.write(fileOut);
            fileOut.close();
            Desktop.getDesktop().open(file);
            JOptionPane.showMessageDialog(null, "Reporte Generado");
            
            //libro.write(archivo);
        }  catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void reporteRegistroEntrada(){
        //Crear un nuevo libro de trabajo en formato XLSX (XSSFWorkbook) 2007 hasta la actualidad
        // (Se guarda en memoria)
        Workbook libro = new XSSFWorkbook();

        
        //Crear un nuevo libro de trabajo en formato XLS (HSSFWorkbook) 2003 para atras
        //Workbook libro = new HSSFWorkbook();
        
        
        // Crear una hoja en el libro
        Sheet hoja = libro.createSheet("Registro Entrada");

        // Crear una fila en la hoja
        /*Row cabecera = hoja.createRow(2);

        // Crear las columnnas, una celda en la fila
        Cell departamento = cabecera.createCell(1);
        Cell poblacion = cabecera.createCell(2);
        Cell codigo = cabecera.createCell(3);
        
        departamento.setCellValue("Departamentos");
        poblacion.setCellValue("Poblacion Estimada");
        codigo.setCellValue("Codigo");

        */

        // Escribir el libro en un archivo (Exportar al equipo)
        try (FileOutputStream archivo = new FileOutputStream("src\\main\\java\\Reportes\\reporte-registro-entrada.xlsx")) {
            
            //Agregando la imagen a Excel
            InputStream is = new FileInputStream("src\\main\\java\\Imagenes\\utp.png");
            byte[] bytes = IOUtils.toByteArray(is);
            int imgIndex = libro.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            is.close();
            
            CreationHelper help = libro.getCreationHelper();
            Drawing draw = hoja.createDrawingPatriarch();
 
            ClientAnchor anchor = help.createClientAnchor();
            anchor.setCol1(0);
            anchor.setRow1(1);
            Picture pict = draw.createPicture(anchor, imgIndex);
            pict.resize(1, 3);
            
            CellStyle tituloEstilo = libro.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTitulo = libro.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 14);
            tituloEstilo.setFont(fuenteTitulo);
            
            Row filaTitulo = hoja.createRow(1);
            Cell celdaTitulo = filaTitulo.createCell(1);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("Sistema de Registro de Ingreso Y Salidas del Terminal Terrestre El Chimbador");
            
            Row filaSubTitulo = hoja.createRow(3);
            Cell celdaSubTitulo = filaSubTitulo.createCell(1);
            celdaSubTitulo.setCellStyle(tituloEstilo);
            celdaSubTitulo.setCellValue("Reporte de Entradas");
            
            hoja.addMergedRegion(new CellRangeAddress(1, 2, 1, 10));
 
            String[] cabecera = new String[]{"Código","DNI","Conductor","Placa","Tipo Vehiculo","Destino","Fecha","Usuario","Pago","Estado"};
            
            CellStyle headerStyle = libro.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);
 
            Font font = libro.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 12);
            headerStyle.setFont(font);
            
            Row filaEncabezados = hoja.createRow(6);
 
            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }
            
            //Conexion con la base de datos
            Conexion con = new Conexion();
            PreparedStatement ps;
            ResultSet rs;
            Connection conn = con.getConnection();
 
            int numFilaDatos = 7;
            
            CellStyle datosEstilo = libro.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);
 
            ps = conn.prepareStatement("SELECT id_registro_entrada, dni_conductor, conductor,placa,tipo_vehiculo,destino,fecha_hora_entrada,usuario,pago,id_estado_terminal FROM registro_entrada");
            rs = ps.executeQuery();
 
            int numCol = rs.getMetaData().getColumnCount();
 
            while (rs.next()) {
                Row filaDatos = hoja.createRow(numFilaDatos);
 
                for (int a = 0; a < numCol; a++) {
 
                    Cell CeldaDatos = filaDatos.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);
                    CeldaDatos.setCellValue(rs.getString(a + 1));
                }
 
 
                numFilaDatos++;
            }
            hoja.autoSizeColumn(0);
            hoja.autoSizeColumn(1);
            hoja.autoSizeColumn(2);
            hoja.autoSizeColumn(3);
            hoja.autoSizeColumn(4);
            
            hoja.setZoom(110);
            String fileName = "registroEntrada";
            String home = System.getProperty("user.home");
            File file = new File("src\\main\\java\\Reportes\\" + fileName + ".xlsx");
            FileOutputStream fileOut = new FileOutputStream(file);
            libro.write(fileOut);
            fileOut.close();
            Desktop.getDesktop().open(file);
            JOptionPane.showMessageDialog(null, "Reporte Generado");
            
            //libro.write(archivo);
        }  catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void reporteSistema(){
        //Crear un nuevo libro de trabajo en formato XLSX (XSSFWorkbook) 2007 hasta la actualidad
        // (Se guarda en memoria)
        Workbook libro = new XSSFWorkbook();

        
        //Crear un nuevo libro de trabajo en formato XLS (HSSFWorkbook) 2003 para atras
        //Workbook libro = new HSSFWorkbook();
        
        
        // Crear una hoja en el libro
        Sheet provincia = libro.createSheet("Provincia");
        Sheet distrito = libro.createSheet("Distrito");
        Sheet departamento = libro.createSheet("Departamento");
        // Crear una fila en la hoja
        /*Row cabecera = hoja.createRow(2);

        // Crear las columnnas, una celda en la fila
        Cell departamento = cabecera.createCell(1);
        Cell poblacion = cabecera.createCell(2);
        Cell codigo = cabecera.createCell(3);
        
        departamento.setCellValue("Departamentos");
        poblacion.setCellValue("Poblacion Estimada");
        codigo.setCellValue("Codigo");

        */

        // Escribir el libro en un archivo (Exportar al equipo)
        try (FileOutputStream archivo = new FileOutputStream("src\\main\\java\\reportes\\reporte-peru.xlsx")) {
            
            //Agregando la imagen a Excel
            InputStream is = new FileInputStream("src\\main\\java\\Imagenes\\utp.png");
            byte[] bytes = IOUtils.toByteArray(is);
            int imgIndex = libro.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            is.close();
            
            CreationHelper help = libro.getCreationHelper();
            Drawing draw = provincia.createDrawingPatriarch();
 
            ClientAnchor anchor = help.createClientAnchor();
            anchor.setCol1(0);
            anchor.setRow1(1);
            Picture pict = draw.createPicture(anchor, imgIndex);
            pict.resize(1, 3);
            
            CellStyle tituloEstilo = libro.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTitulo = libro.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 14);
            tituloEstilo.setFont(fuenteTitulo);
            
            Row filaTitulo = provincia.createRow(1);
            Cell celdaTitulo = filaTitulo.createCell(1);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("Reporte de Provincias del Perú");
            
            //Distritos
            //Creamos filas
            Row filaTituloDistritos = distrito.createRow(1);
            //creamos columnas, celdas en la fila
            Cell celdaTituloDistritos = filaTituloDistritos.createCell(1);
            celdaTituloDistritos.setCellStyle(tituloEstilo);
            celdaTituloDistritos.setCellValue("Reporte de Distritos del Perú");
            
            //Departamentos
            Row filaTituloDepartamentos = departamento.createRow(1);
            Cell celdaTituloDepartamentos = filaTituloDepartamentos.createCell(1);
            celdaTituloDepartamentos.setCellStyle(tituloEstilo);
            celdaTituloDepartamentos.setCellValue("Reporte de Departamentos del Perú");
            
 
            provincia.addMergedRegion(new CellRangeAddress(1, 2, 1, 3));
 
            String[] cabecera = new String[]{"Código", "Provincia", "Codigo de Departamento"};
            
            //distritos
            String[] cabeceraDistritos = new String[]{"Código", "Distrito","Codigo de Provincia" ,"Codigo de Departamnto"};
            
            //Departamentos
            String[] cabeceraDepartamentos = new String[]{"Código", "Departamento", "Número de Habitantes"};
            
            CellStyle headerStyle = libro.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);
 
            Font font = libro.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 12);
            headerStyle.setFont(font);
            
            Row filaEncabezados = provincia.createRow(4);
            Row filaEncabezadosDist = distrito.createRow(4);
            Row filaEncabezadosDepart = departamento.createRow(4);
 
            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }
            
            //distritos
            
            for (int i = 0; i < cabeceraDistritos.length; i++) {
                Cell celdaEnzabezado = filaEncabezadosDist.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabeceraDistritos[i]);
            }
            
            //departamentos
            
            for (int i = 0; i < cabeceraDepartamentos.length; i++) {
                Cell celdaEnzabezado = filaEncabezadosDepart.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabeceraDepartamentos[i]);
            }
            
            //Conexion con la base de datos
            Conexion con = new Conexion();
            PreparedStatement ps;
            ResultSet rs;
            Connection conn = con.getConnection();
 
            //distritos
            PreparedStatement psDis;
            ResultSet rsDis;
            Connection connDis = con.getConnection();
            
            //departamentis
            //distritos
            PreparedStatement psDepa;
            ResultSet rsDepar;
            Connection connDepa = con.getConnection();
            
            int numFilaDatos = 5;
            
            //distritos
            int numFilaDatosDistritos = 5;
            
            //departamentos
            int numFilaDatosDepartamento = 5;
            
            CellStyle datosEstilo = libro.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);
 
            ps = conn.prepareStatement("SELECT id, nombre,departamento_id FROM provincias");
            rs = ps.executeQuery();
 
            //distritos
            psDis = connDis.prepareStatement("SELECT id, nombre,provincia_id,departamento_id FROM distritos");
            rsDis = psDis.executeQuery();
            
            //departamentos
            psDepa = connDepa.prepareStatement("SELECT id, nombre, poblacion_estimada FROM departamentos");
            rsDepar = psDepa.executeQuery();
            
            int numCol = rs.getMetaData().getColumnCount();
            
            //distritos
            int numColDis = rsDis.getMetaData().getColumnCount();
            
            //departamentos
            int numColDep = rsDepar.getMetaData().getColumnCount();
            
            while (rs.next()) {
                Row filaDatos = provincia.createRow(numFilaDatos);
 
                for (int a = 0; a < numCol; a++) {
 
                    Cell CeldaDatos = filaDatos.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);
                    CeldaDatos.setCellValue(rs.getString(a + 1));
                }
 
 
                numFilaDatos++;
            }
            
            //Distritos
            while (rsDis.next()) {
                Row filaDatosDis = distrito.createRow(numFilaDatosDistritos);
 
                for (int a = 0; a < numColDis; a++) {
 
                    Cell CeldaDatosDis = filaDatosDis.createCell(a);
                    CeldaDatosDis.setCellStyle(datosEstilo);
                    CeldaDatosDis.setCellValue(rsDis.getString(a + 1));
                }
 
 
                numFilaDatosDistritos++;
            }
            
            //Departamentos
            while (rsDepar.next()) {
                Row filaDatosDep = departamento.createRow(numFilaDatosDepartamento);
 
                for (int a = 0; a < numColDep; a++) {
 
                    Cell CeldaDatosDep = filaDatosDep.createCell(a);
                    CeldaDatosDep.setCellStyle(datosEstilo);
                    CeldaDatosDep.setCellValue(rsDepar.getString(a + 1));
                }
 
 
                numFilaDatosDepartamento++;
            }
            
            
            provincia.autoSizeColumn(0);
            provincia.autoSizeColumn(1);
            provincia.autoSizeColumn(2);
            provincia.autoSizeColumn(3);
            provincia.autoSizeColumn(4);
            
            //distritos
            distrito.autoSizeColumn(0);
            distrito.autoSizeColumn(1);
            distrito.autoSizeColumn(2);
            distrito.autoSizeColumn(3);
            distrito.autoSizeColumn(4);
            
            //departamentos
            departamento.autoSizeColumn(0);
            departamento.autoSizeColumn(1);
            departamento.autoSizeColumn(2);
            departamento.autoSizeColumn(3);
            departamento.autoSizeColumn(4);
            
            provincia.setZoom(110);
            String fileName = "Peru";
            String home = System.getProperty("user.home");
            File file = new File(home + "/Downloads/" + fileName + ".xlsx");
            FileOutputStream fileOut = new FileOutputStream(file);
            libro.write(fileOut);
            fileOut.close();
            Desktop.getDesktop().open(file);
            JOptionPane.showMessageDialog(null, "Reporte Generado");
            
            //libro.write(archivo);
        }  catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
