package com.mycompany.perruqueriacanina.logica;
//Mapeamos

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Duenio implements Serializable {
   
   //Añadimos los atributos correspondientes
   @Id
   //Se genera la ID automaticamente
   @GeneratedValue(strategy=GenerationType.SEQUENCE)
   private int id_duenio;
   private String nombre;
   private String tlfDuenio;
   
   //Añadimos los constructores
    public Duenio() {
    }

    public Duenio(int id_duenio, String nombre, String tlfDuenio) {
        this.id_duenio = id_duenio;
        this.nombre = nombre;
        this.tlfDuenio = tlfDuenio;
    }

    public int getId_duenio() {
        return id_duenio;
    }

    public void setId_duenio(int id_duenio) {
        this.id_duenio = id_duenio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTlfDuenio() {
        return tlfDuenio;
    }

    public void setTlfDuenio(String tlfDuenio) {
        this.tlfDuenio = tlfDuenio;
    }
}
