/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloPrincipal;
import Vista.VistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author AlumnadoTarde
 */
public class ControladorPrincipal implements ActionListener {

    //El controlador tiene acceso a la vista y al modelo.
    public static VistaPrincipal vista;
    public static ModeloPrincipal modelo;

    public ControladorPrincipal(VistaPrincipal vista, ModeloPrincipal modelo) {
        ControladorPrincipal.vista = vista;
        ControladorPrincipal.modelo = modelo;

        //Llama a la función de ModeloPricipal que devuelve un ResultSet
        vista.FillTableModel(modelo.ejecutar_consulta());

        //Los botones que ejecutaran un acción en el pograma
        vista.getBtnBajas().addActionListener(this);
        vista.getBtnSalir().addActionListener(this);
        vista.getBtnModificaciones().addActionListener(this);

        ShowDataOnTextField();
    }

    public ControladorPrincipal() {
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == vista.getBtnSalir()) {
            System.exit(0);
        } else if (event.getSource() == vista.getBtnBajas()) {
            modelo.deleteData(vista.getTxtRegistro().getText());

        } else if (event.getSource() == vista.getBtnModificaciones()) {
            modelo.UpdateData(vista.getTxtRegistro().getText(), vista.getTxtDni().getText(), vista.getTxtNombre().getText(), vista.getTxtApellido1().getText(), vista.getTxtApellido2().getText());
        } else if(event.getSource()== vista.getBtnAltas()){
            //Código de altas
        }
    }

    private void ShowDataOnTextField() {
        vista.getTablaAlumnos().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent event) {
                int row = vista.getTablaAlumnos().getSelectedRow();

                vista.getTxtDni().setText(String.valueOf(vista.getTablaAlumnos().getValueAt(row, 1)));
                vista.getTxtRegistro().setText(String.valueOf(vista.getTablaAlumnos().getValueAt(row, 0)));
                vista.getTxtNombre().setText(String.valueOf(vista.getTablaAlumnos().getValueAt(row, 2)));
                vista.getTxtApellido1().setText(String.valueOf(vista.getTablaAlumnos().getValueAt(row, 3)));
                vista.getTxtApellido2().setText(String.valueOf(vista.getTablaAlumnos().getValueAt(row, 4)));
            }
        });
    }
}
