/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;



public abstract class Libro {
    
    private String codigo, titulo, autor, genero;
    private int cant, ano, estado;
    private double precio, costo;
    
    String[] generos = {"Misterio", "Fantasia", "Ficcion", "Romance","Terror","Drama","Fábula"};

    public Libro(String codigo, String titulo, String autor, String genero, int cant, int ano, int estado, double precio, double costo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.cant = cant;
        this.ano = ano;
        this.estado = estado;
        this.precio = precio;
        this.costo = costo;
    }

    public Libro() {
        codigo = "";
        titulo = "";
        genero = "";
        cant = 0;
        ano = 0;
        estado = 0;
        precio = 0;
        costo = 0;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String[] getGeneros() {
        return generos;
    }
    
    public abstract void calcularPrecioLibro(double ganancia, double costo);
    
}
