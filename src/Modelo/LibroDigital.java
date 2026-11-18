/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author laura
 */
public class LibroDigital extends Libro { 
    
    private String formato,medida;
    private double tamano;
    
    String[] tamanos = {"mb","gb"};
    String[] formatos = {"PDF","EPUB","MOBI","IBOOK"};
    
    public LibroDigital(String formato, double tamano,String medida, String codigo, String titulo, String autor, String genero, int cant, int ano, int estado, double precio, double costo) {
        super(codigo, titulo, autor, genero, cant, ano, estado, precio, costo);
        this.formato = formato;
        this.tamano = tamano;
        this.medida = medida;
    }

    public LibroDigital() {
        super();
        formato = "";
        tamano = 0;
        medida = "";
    }
    
    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public double getTamano() {
        return tamano;
    }

    public void setTamano(double tamano) {
        this.tamano = tamano;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }
    
    @Override
    public void calcularPrecioLibro(double ganancia, double costo) {
       super.setPrecio((costo+ ((costo*ganancia)/100))*0.10); 
    } 
    
    
}
