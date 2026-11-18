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
public class ListaLibrosFisicos {
    
    private ArrayList<LibroFisico> librosFisicos = new ArrayList<>();
    
    //public ListaLibrosFisicos(){};
    
    public ListaLibrosFisicos() {
        agregarLibroFisico();
    };
     
    public void agregarLibroFisico() {
        JSONParser parser = new JSONParser();
        try {
            String dirarch = System.getProperty("user.dir") + File.separator + "librosFisicos.json";
            JSONArray librosFisicosjs = (JSONArray)parser.parse(new FileReader(dirarch));
            for (Object lib00 : librosFisicosjs){
                JSONObject libro = (JSONObject) lib00;
                String codigo = libro.get("codigo").toString();
                String titulo = libro.get("titulo").toString();
                String autor = libro.get("autor").toString();
                String genero = libro.get("genero").toString();
                int cant = Integer.parseInt(libro.get("cantidad").toString());
                int ano = Integer.parseInt(libro.get("ano").toString());
                int est = Integer.parseInt(libro.get("estado").toString());
                double peso = Double.parseDouble(libro.get("peso").toString());
                double precio = Double.parseDouble(libro.get("precio").toString());
                double costo = Double.parseDouble(libro.get("costo").toString());
                LibroFisico libroF = new LibroFisico(peso,codigo,titulo,autor,genero,cant,ano,est,precio,costo);
                librosFisicos.add(libroF);
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
        for (int i=0;i<librosFisicos.size();i++){
            LibroFisico auxlib = (LibroFisico)librosFisicos.get(i);
                    jsonbuilder.append("{\n" 
                        + "\"codigo\":\"" + auxlib.getCodigo() + "\",\n" 
                        + "\"titulo\":\""+ auxlib.getTitulo() + "\",\n" 
                        + "\"autor\":\"" + auxlib.getAutor() + "\",\n" 
                        + "\"genero\":\"" + auxlib.getGenero() + "\",\n" 
                        + "\"cantidad\":" + auxlib.getCant() + ",\n" 
                        + "\"ano\":\"" + auxlib.getAno() + "\",\n" 
                        + "\"estado\":\"" + auxlib.getEstado() + "\",\n" 
                        + "\"peso\":\"" + auxlib.getPeso() + "\",\n" 
                        + "\"precio\":\"" + auxlib.getPrecio() + "\",\n" 
                        + "\"costo\":\"" + auxlib.getCosto() + "\"\n" 
                        + "}");
                    if(i < librosFisicos.size() - 1) { 
                        jsonbuilder.append(", \n");
                    }
        }
        jsonbuilder.append("]");
        try (FileWriter writer = new FileWriter("librosFisicos.json")) { 
            writer.write(jsonbuilder.toString()); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        }
    }
    
    public void agregarLibroFisico(LibroFisico lib) {
        librosFisicos.add(lib);
        escribirarch();
    }
    
    public void eliminarLibroFisico(LibroFisico lib) {
        librosFisicos.remove(lib);
        escribirarch();
    }

    public ArrayList<LibroFisico> getLibrosFisicos() {
        return librosFisicos;
    }

    public void setLibrosFisicos(ArrayList<LibroFisico> librosFisicos) {
        this.librosFisicos = librosFisicos;
    }
       
}
