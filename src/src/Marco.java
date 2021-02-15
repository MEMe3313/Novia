/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JFrame;

/**
 *
 * @author alexi
 */
public class Marco extends JFrame {

    private final Toolkit screen;
    private final Image icono;

    public Marco() {
        screen = Toolkit.getDefaultToolkit();
        File aux = new File("icono.png");
        System.out.println(aux.getAbsolutePath());
        icono = screen.getImage(aux.getAbsolutePath());
    }

    public void iniciarVentana() {
        Dimension dimensiones = screen.getScreenSize();
        this.setBounds(dimensiones.width / 4, dimensiones.height / 4, (dimensiones.width / 4)+10, dimensiones.height / 2);
        this.setResizable(false);
        this.setIconImage(icono);
        this.setTitle("Hola mi amorcito...");
        Panel p = new Panel(this.getSize());
        System.out.println("Generando panel\n");
        p.iniciarComponentes();
        System.out.println("Componentes iniciados");
        p.setLayout(null);
        this.add(p);
        this.setVisible(true);
        System.out.println("Frame visible");
    }
}
