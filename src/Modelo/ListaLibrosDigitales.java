/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author laura
 */
public class ListaLibrosDigitales {
    
    private ArrayList<LibroDigital> librosDigitales = new ArrayList<>();
    
    public ListaLibrosDigitales(){
        agregarLibroDigital();
    };
    
    public void agregarLibroDigital() {
        JSONParser parser = new JSONParser();
        try {
            String dirarch = System.getProperty("user.dir") + File.separator + "librosDigitales.json";
            JSONArray librosDigitalesjs = (JSONArray)parser.parse(new FileReader(dirarch));
            for (Object lib00 : librosDigitalesjs){
                JSONObject libro = (JSONObject) lib00;
                String codigo = libro.get("codigo").toString();
                String titulo = libro.get("titulo").toString();
                String autor = libro.get("autor").toString();
                String genero = libro.get("genero").toString();
                int cant = Integer.parseInt(libro.get("cantidad").toString());
                int ano = Integer.parseInt(libro.get("ano").toString());
                int est = Integer.parseInt(libro.get("estado").toString());
                double tamano = Double.parseDouble(libro.get("tamano").toString());
                String medida = libro.get("medida").toString();
                String formato = libro.get("formato").toString();
                double precio = Double.parseDouble(libro.get("precio").toString());
                double costo = Double.parseDouble(libro.get("costo").toString());
                LibroDigital libroD = new LibroDigital(formato,tamano,medida,codigo,titulo,autor,genero,cant,ano,est,precio,costo);
                librosDigitales.add(libroD);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();    
        } catch (IOException ex) {
            Logger.getLogger(ListaLibrosFisicos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ListaLibrosFisicos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void escribirarch(){
        StringBuilder jsonbuilder = new StringBuilder();
        jsonbuilder.append("[");
        for (int i=0;i<librosDigitales.size();i++){
            LibroDigital auxlib = (LibroDigital)librosDigitales.get(i);
            jsonbuilder.append("{\n" 
                        + "\"codigo\":\"" + auxlib.getCodigo() + "\",\n" 
                        + "\"titulo\":\""+ auxlib.getTitulo() + "\",\n" 
                        + "\"autor\":\"" + auxlib.getAutor() + "\",\n" 
                        + "\"genero\":\"" + auxlib.getGenero() + "\",\n" 
                        + "\"cantidad\":" + auxlib.getCant() + ",\n" 
                        + "\"ano\":\"" + auxlib.getAno() + "\",\n" 
                        + "\"estado\":\"" + auxlib.getEstado() + "\",\n" 
                        + "\"tamano\":\"" + auxlib.getTamano() + "\",\n" 
                        + "\"medida\":\"" + auxlib.getMedida() + "\",\n" 
                        + "\"formato\":\"" + auxlib.getFormato() + "\",\n" 
                        + "\"precio\":\"" + auxlib.getPrecio() + "\",\n" 
                        + "\"costo\":\"" + auxlib.getCosto() + "\"\n" 
                        + "}");
                    if(i < librosDigitales.size() - 1) { 
                        jsonbuilder.append(", \n");
                    }
        }
        jsonbuilder.append("]");
        try (FileWriter writer = new FileWriter("librosDigitales.json")) { 
            writer.write(jsonbuilder.toString()); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        }
    }
    
    public void agregarLibroDigital(LibroDigital lib) {
        librosDigitales.add(lib);
        escribirarch();
    }
    
    public void eliminarLibroDigital(LibroDigital lib) {
        librosDigitales.remove(lib);
        escribirarch();
    }

    public ArrayList<LibroDigital> getLibrosDigitales() {
        return librosDigitales;
    }

    public void setLibrosDigitales(ArrayList<LibroDigital> librosDigitales) {
        this.librosDigitales = librosDigitales;
    }
    
    
    
}
