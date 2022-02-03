package com.proyecto.estancias.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Comentario {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid",strategy = "uuid2")
    private String id;
    private String descripcion;
    private int voto;   //voto para enumerar del 1 al 5 y validarlo
    
/**
 * Falta encapsular el voto
 */   

// private Voto voto;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the voto
     */
    public int getVoto() {
        return voto;
    }

    /**
     * @param voto the voto to set
     */
    public void setVoto(int voto) {
        this.voto = voto;
    }

    
    
}
