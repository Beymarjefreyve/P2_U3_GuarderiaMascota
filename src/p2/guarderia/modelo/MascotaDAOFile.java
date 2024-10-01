/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.guarderia.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author yefre
 */
public class MascotaDAOFile implements IDAO{

    @Override
    public void agregar(IObjetoDTO dto) throws Exception {
        String ruta = "mascotas.csv";
        MascotaDTO m = (MascotaDTO) dto;
        
        // Crear la línea con los datos de la mascota
        String linea = m.getId()+";"+m.getNombre()+";"+m.getRaza()+";"+m.getEdad()+";";
        
        if(m.getPropietario()!=null)
            linea += m.getPropietario();
        else
            linea += "null";
              
        try(BufferedWriter file = new BufferedWriter(new FileWriter(ruta))){
            file.write(linea);
            file.newLine();
        }catch(IOException e){
            System.out.println("Error al agregar la mascota: "+e.getMessage());
        }
       
    }

    @Override
    public void eliminar(String id) throws Exception {

        String ruta = "mascotas.csv", separador = ";", linea;
        ArrayList<String> lineas = new ArrayList<>();

        // Leer el archivo línea por línea y almacenar las que no coincidan con el id a eliminar
        try (BufferedReader file = new BufferedReader(new FileReader(ruta))) {
            while ((linea = file.readLine()) != null) { // <-- Mientras halla lineas para leer
                
                String[] datos = linea.split(separador); // <-- Guardar los datos de la linea en un arreglo String
                String idLinea = datos[0]; // <-- Obtener el ID de la mascota

                if (!(idLinea.equals(idLinea))) {
                    lineas.add(linea); // <-- Agregar linea si el Id a eliminar no es el mismo
                 }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        // Reescribir el archivo 
        try (BufferedWriter fileNew = new BufferedWriter(new FileWriter(ruta))) {
            for (String lineaActual : lineas) {
                fileNew.write(lineaActual);
                fileNew.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    @Override
    public void actualizar(String id, IObjetoDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public IObjetoDTO buscar(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }

    @Override
    public ArrayList<IObjetoDTO> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
