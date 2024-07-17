package com.mycompany.perruqueriacanina;

import com.mycompany.perruqueriacanina.igu.Principal;

public class PerruqueriaCanina {

    public static void main(String[] args) {
    
    //Agregamos la instancia de la pantalla principal
    Principal princ = new Principal();   
    
    //Agregamos que sea visible
    princ.setVisible(true);
    
    //Agregamos que lo muestre en medio
    princ.setLocationRelativeTo(null);
   
    }
}
