/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Modelo.LibroFisico;
import Modelo.LibroDigital;
import Modelo.ListaLibrosFisicos;
import Modelo.ListaLibrosDigitales;
import Modelo.Carrito;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;

/**
 *
 * @author laura
 */
public class Controladora {
    
    JFrame ventana;
    String[] generos = {"Seleccione un genero","Misterio", "Fantasia", "Ficcion", "Romance","Terror","Drama","Fabula"};
    String[] formatos = {"Seleccione un formato","PDF","EPUB","MOBI","IBOOK"};
    String[] medidas = {"mb","gb"};
    private static Carrito car = new Carrito();
    private static ListaLibrosFisicos librosF = new ListaLibrosFisicos();
    private static ListaLibrosDigitales librosD = new ListaLibrosDigitales();
    double totalF = 0;
    double totalD = 0;
    double costoEnvio = 0;
    int dest, env;
    
    
    public Controladora(JFrame ventana){
       this.ventana = ventana;
    }
    
    public void iniciaVentana(JFrame ventana){
       //librosF.agregarLibroFisico();
       //librosD.agregarLibroDigital();
       ventana.setLocationRelativeTo(null); 
       ventana.setIconImage(new ImageIcon("src/Imagenes/icono.png").getImage()); 
       ventana.setResizable(false);
    }
    
    public void activaVentana(JFrame ventana,JFrame ventana2) {
       ventana.setLocationRelativeTo(null);
       ventana.setVisible(true);
       ventana2.dispose(); 
    }
    
    public void llenarTablaLibrosF(JTable tablaLibrosF,ArrayList<LibroFisico> librosF) {
       
       String[] columna = {"Codigo","Titulo","Autor","Genero","Precio ($)"};
        DefaultTableModel dtm = new DefaultTableModel(null,columna);
        for (LibroFisico libro : librosF) {
            if (libro.getCant() >= 1 && libro.getEstado() == 1) {
            String[] row = {libro.getCodigo(),libro.getTitulo(),libro.getAutor(),libro.getGenero(),Double.toString(libro.getPrecio())};
            dtm.addRow(row);
            totalF += libro.getPrecio();
            }
        }
        tablaLibrosF.setModel(dtm);
    }
    
    public void llenarTablaLibrosD(JTable tablaLibrosD,ArrayList<LibroDigital> librosD) {
       
       String[] columna = {"Codigo","Titulo","Autor","Genero","Precio ($)","Formato"};
        DefaultTableModel dtm = new DefaultTableModel(null,columna);
        for (LibroDigital libro : librosD) {
            if (libro.getCant() >= 1 && libro.getEstado() == 1) {
            String[] row = {libro.getCodigo(),libro.getTitulo(),libro.getAutor(),libro.getGenero(),Double.toString(libro.getPrecio()),libro.getFormato()};
            dtm.addRow(row);
            totalD += libro.getPrecio();
            }
        }
        tablaLibrosD.setModel(dtm);
    }
    
    public void llenarTablaLibrosFV(JTable tablaLibrosF,ArrayList<LibroFisico> librosF) {
       
       String[] columna = {"Codigo","Titulo","Autor","Genero","Precio ($)","Año de Publicación","Peso (kg)","Estado","Cant. Disponible"};
        DefaultTableModel dtm = new DefaultTableModel(null,columna);
        for (LibroFisico libro : librosF) {
            String[] row = {libro.getCodigo(),libro.getTitulo(),libro.getAutor(),libro.getGenero(),Double.toString(libro.getPrecio()),Integer.toString(libro.getAno()),Double.toString(libro.getPeso()),Integer.toString(libro.getEstado()),Integer.toString(libro.getCant())};
            dtm.addRow(row);
        }
        tablaLibrosF.setModel(dtm);
    }
    
    public void llenarTablaLibrosDV(JTable tablaLibrosD,ArrayList<LibroDigital> librosD) {
       
       String[] columna = {"Codigo","Titulo","Autor","Genero","Precio ($)","Formato","Tamaño","Medida","Año de Publicación","Estado","Cant. Disponible"};
        DefaultTableModel dtm = new DefaultTableModel(null,columna);
        for (LibroDigital libro : librosD) {
            String[] row = {libro.getCodigo(),libro.getTitulo(),libro.getAutor(),libro.getGenero(),Double.toString(libro.getPrecio()),libro.getFormato(),Double.toString(libro.getTamano()),libro.getMedida(),Integer.toString(libro.getAno()),Integer.toString(libro.getEstado()),Integer.toString(libro.getCant())};
            dtm.addRow(row);
        }
        tablaLibrosD.setModel(dtm);
    }
    
    public void calcularCostoEnvio(JRadioButton nacional, JRadioButton internacional, JRadioButton normal, JRadioButton urgente) {
        if (nacional.isSelected() == true)
            dest = 20;
        if (internacional.isSelected() == true)
            dest = 45;
        if (normal.isSelected() == true) 
            env = 15;
        if (urgente.isSelected() == true) 
            env = 30;
        costoEnvio = dest + env;
    }
    
    public void llenarCombo(JComboBox comboGeneros) {
        for (String g : generos) 
            comboGeneros.addItem(g);
    }
    public void llenarComboF(JComboBox comboFormatos) {
        for (String f : formatos) 
            comboFormatos.addItem(f);
    }
    public void llenarComboM(JComboBox comboMedidas) {
        for (String m : medidas) 
            comboMedidas.addItem(m);
    }

    public double getTotalF() {
        return totalF;
    }

    public void setTotalF(double totalF) {
        this.totalF = totalF;
    }

    public double getTotalD() {
        return totalD;
    }

    public void setTotalD(double totalD) {
        this.totalD = totalD;
    }

    public static Carrito getCar() {
        return car;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public static ListaLibrosFisicos getLibrosF() {
        return librosF;
    }

    public static ListaLibrosDigitales getLibrosD() {
        return librosD;
    }

    public String[] getGeneros() {
        return generos;
    }

    public String[] getFormatos() {
        return formatos;
    }

    public String[] getMedidas() {
        return medidas;
    }
    
    
    
    
    
    
    
    
    
}
