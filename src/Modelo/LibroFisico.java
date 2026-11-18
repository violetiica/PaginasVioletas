/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


/**
 *
 * @author laura
 */
public class LibroFisico extends Libro {
    
    private double peso, costoEnvio;
    LibroFisico libro;

    public LibroFisico(double peso, String codigo, String titulo, String autor, String genero, int cant, int ano, int estado, double precio, double costo) {
        super(codigo, titulo, autor, genero, cant, ano, estado, precio, costo);
        this.peso = peso;
    }
    
    
    public LibroFisico() {
        super();
        peso = 0;
        costoEnvio = 0;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    @Override
    public void calcularPrecioLibro(double ganancia, double costo) {
       super.setPrecio(costo+ ((costo*ganancia)/100)); 
    }
    
}
