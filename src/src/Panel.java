/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author alexi
 */
public class Panel extends JPanel implements ActionListener, MouseListener {

    private final Toolkit screen;
    private final JButton aceptar;
    private final JButton denegar;
    private final JLabel mensaje;
    private final Dimension FRAME_DIMENSIONS;
    private final JTextField aniversario;
    private final JButton enviar;
    public Panel(Dimension d) {
        screen = Toolkit.getDefaultToolkit();
        mensaje = new JLabel("<html><div style= 'text-align: center;'>¿Quisieras, en algun futuro,<br> Casarte conmigo y ser mucho más felices juntos?</div></html>", SwingConstants.CENTER);
        aceptar = new JButton("Aceptar");
        denegar = new JButton("Negar :c");
        enviar = new JButton("Enviar fecha");
        aniversario= new JTextField("Aniversario",5);
        System.out.println("Panel iniciado");
        FRAME_DIMENSIONS= d;
    }

    protected void iniciarComponentes() {
        enviar.addActionListener(this);
        aceptar.addActionListener(this);
        denegar.addActionListener(this);
        denegar.addMouseListener(this);
        try {
            GraphicsEnvironment ge
                    = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("AmoreMIO.ttf")));
        } catch (IOException | FontFormatException e) {
            System.out.println("Exploté");
        }
        aniversario.setFont(new Font("Arial", Font.PLAIN,12));
        enviar.setFont(new Font("Arial", Font.BOLD, 14));
        aceptar.setFont(new Font("AmoreMIO", Font.BOLD, 24));
        denegar.setFont(new Font("Arial Black", Font.PLAIN, 18));
        mensaje.setFont(new Font("Baskerville Old Face", Font.BOLD, 25));
        enviar.setBackground(new Color(231,51,255));
        aceptar.setBackground(new Color(133, 254, 69));
        denegar.setBackground(new Color(254, 78, 69));
        enviar.setLayout(null);
        aniversario.setLayout(null);
        mensaje.setLayout(null);
        denegar.setLayout(null);
        aceptar.setLayout(null);
        aniversario.setBounds(3*FRAME_DIMENSIONS.width/10, 3*FRAME_DIMENSIONS.height/5,100,30);
        enviar.setBounds(3*FRAME_DIMENSIONS.width/10, 7*FRAME_DIMENSIONS.height/10, 125, 30);
        aceptar.setBounds(FRAME_DIMENSIONS.width/10, 2*FRAME_DIMENSIONS.height/5, 125, 30);
        denegar.setBounds(5*FRAME_DIMENSIONS.width/10, 2*FRAME_DIMENSIONS.height/5, 125, 30);
        mensaje.setBounds(FRAME_DIMENSIONS.width/20, FRAME_DIMENSIONS.height/40, 350, 100);
        System.out.println("Botones iniciados");
        this.add(aniversario);
        this.add(enviar);
        this.add(aceptar);
        this.add(denegar);
        this.add(mensaje);
        System.out.println("Botones agregados");

        Dimension dimensiones = screen.getScreenSize();
        this.setSize(dimensiones);
        this.setBackground(new Color(254, 190, 69));
        setVisible(true);
        System.out.println("Panel construido y visible");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aceptar) {
            aceptar.setVisible(false);
            denegar.setVisible(false);
            URL url = Panel.class
                    .getResource("aceptar.gif");
            Icon icono = new ImageIcon(url);
            JLabel gif = new JLabel(icono);
            gif.setLayout(null);
            gif.setFocusable(true);
            this.add(gif);
            gif.setBounds(FRAME_DIMENSIONS.width/20, FRAME_DIMENSIONS.height/10, 350, 350);

            this.setBackground(new Color(254, 69, 114));
            mensaje.setText("<html><div style= 'text-align: center;'> Te amooooo <br> mi amorcitoooooooooooooo" + new String(Character.toChars(0x2764)) + new String(Character.toChars(0x1F48F)) + "</div> </html>");
            mensaje.setSize(360, 200);
        } else if (e.getSource() == denegar) {
            JOptionPane.showConfirmDialog(null, "Chale ¿Por qué? " + new String(Character.toChars(0x1F62D)) + new String(Character.toChars(0x1F494)), "Has roto mi corazoncito... ", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getSource()==enviar){
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void mousePressed(MouseEvent e) {
        //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Random newy = new Random();
        Random newx = new Random();
        int x, y;
        x = newx.nextInt(this.getWidth() - 124);
        y = newy.nextInt(this.getHeight() - 29);
        denegar.setLocation(x, y);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //To change body of generated methods, choose Tools | Templates.

    }

}
