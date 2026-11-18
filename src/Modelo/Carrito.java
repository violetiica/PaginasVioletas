/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.ArrayList;
/**
 *
 * @author laura
 */
public class Carrito {
    
    private ArrayList<LibroFisico> librosF = new ArrayList<>();
    private ArrayList<LibroDigital> librosD = new ArrayList<>();
    
    public Carrito(){};
    
    public void agregarLibroF(LibroFisico libroF) {
        librosF.add(libroF);
    }
    
    public void agregarLibroD(LibroDigital libroD) {
        librosD.add(libroD);
    }

    public ArrayList<LibroFisico> getLibrosF() {
        return librosF;
    }

    public void setLibrosF(ArrayList<LibroFisico> librosF) {
        this.librosF = librosF;
    }

    public ArrayList<LibroDigital> getLibrosD() {
        return librosD;
    }

    public void setLibrosD(ArrayList<LibroDigital> librosD) {
        this.librosD = librosD;
    }
    
    
}
