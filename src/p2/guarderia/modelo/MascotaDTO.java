/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.guarderia.modelo;

/**
 *
 * @author yefre
 */
public class MascotaDTO implements IObjetoDTO{
    
    private String id;
    
    private String nombre;
    
    private String edad;
    
    private String raza;
    
    private PersonaDTO propietario;
    
    public MascotaDTO(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public PersonaDTO getPropietario() {
        return propietario;
    }

    public void setPropietario(PersonaDTO propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return " Nombre: " + this.nombre + " id: " + this.id;
    }
    
}
