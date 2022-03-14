/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.estancias.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Familia {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String nombre;
    private Integer edadMin;
    private Integer edadMax;
    private Integer numHijos;
    private String email;
    
    @OneToMany(cascade = CascadeType.ALL)
    private Casa casa;
    
   

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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the edadMin
     */
    public int getEdadMin() {
        return edadMin;
    }

    /**
     * @param edadMin the edadMin to set
     */
    public void setEdadMin(int edadMin) {
        this.setEdadMin((Integer) edadMin);
    }

    /**
     * @return the edadMax
     */
    public int getEdadMax() {
        return edadMax;
    }

    /**
     * @param edadMax the edadMax to set
     */
    public void setEdadMax(int edadMax) {
        this.setEdadMax((Integer) edadMax);
    }

    /**
     * @return the numHijos
     */
    public int getNumHijos() {
        return numHijos;
    }

    /**
     * @param numHijos the numHijos to set
     */
    public void setNumHijos(int numHijos) {
        this.setNumHijos((Integer) numHijos);
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param edadMin the edadMin to set
     */
    public void setEdadMin(Integer edadMin) {
        this.edadMin = edadMin;
    }

    /**
     * @param edadMax the edadMax to set
     */
    public void setEdadMax(Integer edadMax) {
        this.edadMax = edadMax;
    }

    /**
     * @param numHijos the numHijos to set
     */
    public void setNumHijos(Integer numHijos) {
        this.numHijos = numHijos;
    }

    /**
     * @return the casa
     */
    public Casa getCasa() {
        return casa;
    }

    /**
     * @param casa the casa to set
     */
    public void setCasa(Casa casa) {
        this.casa = casa;
    }

 
    
    
}
