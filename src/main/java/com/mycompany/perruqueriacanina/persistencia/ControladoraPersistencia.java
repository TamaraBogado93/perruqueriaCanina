package com.mycompany.perruqueriacanina.persistencia;

import com.mycompany.perruqueriacanina.logica.Duenio;
import com.mycompany.perruqueriacanina.logica.Mascota;
import com.mycompany.perruqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    //Creamos en la controladora de Persistencia, dos instancias de las dos clases   
    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotaJpaController mascotaJpa = new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota mascota) {

        //Creamos en la BD (base de datos) el Dueño:
        duenioJpa.create(duenio);

        //Creamos en la BD (base de datos) la Mascota:   
        mascotaJpa.create(mascota);

    }

    public List<Mascota> traerMascotas() {
        
     /*Lo que encuentres de esta lista de Mascotas, le va a retornar a la controladora de la Lógica, lo recibe y lo devuelve
        a quien esté llamando a este método (verDatos) y este lo guarda en listaMascotas
        */   
        
       return mascotaJpa.findMascotaEntities();
       
    }

    public void borrarMascota(int num_cliente) {
        try {
            mascotaJpa.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mascota traerMascota(int num_cliente) {
        return mascotaJpa.findMascota(num_cliente);
    }

    public void modificarMascota(Mascota mascota) {
        try {
            mascotaJpa.edit(mascota);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Duenio traerDuenio(int id_duenio) {
        return duenioJpa.findDuenio(id_duenio);
    }

    public void modificarDuenio(Duenio dueno) {
      
        try {
            duenioJpa.edit(dueno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}
