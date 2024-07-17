package com.mycompany.perruqueriacanina.logica;

import com.mycompany.perruqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
   
 //En la controladora de la lógica que llama a la persistencia agregamos la siguiente instancia:
    
  ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
 
  

    public void guardar(String nombreMasco, String raza, String color, String numCliente, String nombreDuenio, String tlfDuenio, String observaciones, String alergico, String atenEspecial) {
        
    //Creamos el dueño asignamos sus valores:

    Duenio duenio = new Duenio();
    duenio.setNombre(nombreDuenio);
    duenio.setTlfDuenio(tlfDuenio);
    
    //Creamos la mascota asignamos sus valores:
    
    Mascota mascota = new Mascota();
    mascota.setNombre(nombreMasco);
    mascota.setRaza(raza);
    mascota.setColor(color);
    mascota.setAlergico(alergico);
    mascota.setAtencionEspecial(atenEspecial);
    mascota.setObservaciones(observaciones);
    mascota.setUnDuenio(duenio);
    
    //Se tiene que encargar de crearlo en la base de datos y asociar:
    controlPersis.guardar(duenio,mascota);
    
    
    }

    public List<Mascota> traerMascotas() {
      return controlPersis.traerMascotas();
    }  

    public void borrarMascota(int num_cliente) {
      controlPersis.borrarMascota(num_cliente);  
    }

    public Mascota traerMascota(int num_cliente) {
       return controlPersis.traerMascota(num_cliente);
       
    }

 
    public void modificarMascota(Mascota mascota, String nombreMasco, String raza, String color, String numCliente, String nombreDuenio, String tlfDuenio, String observaciones, String alergico, String atenEspecial) {
      
     mascota.setNombre(nombreMasco);
     mascota.setRaza(raza);
     mascota.setColor(color);
     mascota.setObservaciones(observaciones);
     mascota.setAtencionEspecial(atenEspecial);
     mascota.setAlergico(alergico);
     
     //En primer lugar modifico la mascota
     controlPersis.modificarMascota(mascota);
         
     //En segundo lugar identificar al dueño
     
     Duenio dueno = this.buscarDuenio(mascota.getUnDuenio().getId_duenio());
     //Seteo nuevos valores del dueño
     dueno.setTlfDuenio(tlfDuenio);
     dueno.setNombre(nombreDuenio);
     
     //Llamar al modificar Dueño
     
     this.modificarDuenio(dueno);
     
    }

    private Duenio buscarDuenio(int id_duenio) {
        
     return controlPersis.traerDuenio(id_duenio);
        
        
    }

    private void modificarDuenio(Duenio dueno) {
        
        controlPersis.modificarDuenio(dueno);
    }
    }

    
    
    
  
    
    
    
    
    
