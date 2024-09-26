/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.guarderia.modelo;

import java.util.ArrayList;

/**
 *
 * @author Beymar Villamizar
 */
public class GuarderiaFachada {
 
    private IDAO idao;
    
    public void agregarMascota(String id, String nombre, String edad, String raza) throws Exception{
       idao = new MascotaDAOFile();
       MascotaDTO m = new MascotaDTO();
       m.setId(id);
       m.setNombre(nombre);
       m.setEdad(edad);
       m.setRaza(raza);
       idao.agregar(m); // agrego a el csv
    }
    
    public void eliminarMascota(String idMascota) throws Exception{
        idao = new MascotaDAOFile();
        idao.eliminar(idMascota);
    }
    
    public void actualizarMascota(String id, String nombre, String edad, String raza) throws Exception{
       idao = new MascotaDAOFile();
       MascotaDTO m = (MascotaDTO) idao.buscar(id); //Casteo el object que me retorna idao
       m.setId(id);
       m.setNombre(nombre);
       m.setEdad(edad);
       m.setRaza(raza);
    }
    
    public String[] buscarMascota(String id) throws Exception{
        idao = new MascotaDAOFile();
        MascotaDTO m = (MascotaDTO) idao.buscar(id);
        String [] info = new String[4];
        if(m!=null){
            info[0] = m.getId();
            info[1] = m.getNombre();
            info[2] = m.getEdad();
            info[3] = m.getRaza();
        }
        return info;
    }
    
    public void asignarPropietarioMascota(String idMascota, String idPersona) throws Exception{
        idao = new MascotaDAOFile();
        MascotaDTO m = (MascotaDTO) idao.buscar(idMascota);
        idao = new PersonaDAOFile();
        PersonaDTO p = (PersonaDTO) idao.buscar(idPersona);
        if(m!=null & p!=null){
            m.setPropietario(p);
        }
    }
    
    public void retirarPropietarioMascota(String idMascota, String idPersona) throws Exception{
        idao = new MascotaDAOFile();
        MascotaDTO m = (MascotaDTO) idao.buscar(idMascota);
        idao = new PersonaDAOFile();
        PersonaDTO p = (PersonaDTO) idao.buscar(idPersona);
        if(m!=null & p!=null){
            m.setPropietario(null);
        }
    }
    
    public String[] listarPersonas() throws Exception{
        idao = new PersonaDAOFile();
        ArrayList<IObjetoDTO> personas = idao.listar();
        String [] lista = new String[personas.size()];
        for(int i=0; i<personas.size(); i++){
            lista[i] = personas.get(i).toString();
        }
        return lista;
    }
    
    public String[] listarMascotas() throws Exception{
        idao = new MascotaDAOFile();
        ArrayList<IObjetoDTO> mascotas = idao.listar();
        String [] lista = new String[mascotas.size()];
        for(int i=0; i<mascotas.size(); i++){
            lista[i] = mascotas.get(i).toString();
        }
        return lista;
    }
}
