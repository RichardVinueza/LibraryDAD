/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecamodificacion;
import Controlador.ControladorPrincipal;
import Modelo.ModeloPrincipal;
import Vista.VistaPrincipal;

/**
 *
 * @author AlumnadoTarde
 */
public class BibliotecaModificacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Creamos los objetos de la vista y el modelo.
        VistaPrincipal vista = new VistaPrincipal();
        ModeloPrincipal modelo = new ModeloPrincipal();
        
        //El objeto controlador nos servirá como intermediario entre vists y modelo.
        ControladorPrincipal controlador = new ControladorPrincipal(vista, modelo);
        
        //Al ejecutar el programa la vista se hace visible.
        vista.setVisible(true);

    }

}
