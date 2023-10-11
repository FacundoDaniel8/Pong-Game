/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 *
 * @author Alumno
 */
public class TableroInicio extends JPanel {

    public TableroInicio() {

        setBackground(Color.BLACK);
    }

    private JButton jugar = new JButton("JUGAR");

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        dibujarMenu(g2);

    }

    private void dibujarMenu(Graphics2D g) {

        Font fuentes = new Font("Arial", Font.BOLD, 50);
        g.setFont(fuentes);

        g.drawString("PONG GAME", (float) getBounds().getCenterX() - 160, 70);

        jugar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {


                Panel panel = new Panel();
                panel.setVisible(true);
                
                panel.remove(Panel.lamina_inicio);
                panel.add(Panel.lamina_juego);
                
                setVisible(false);
            }
        });
        jugar.setBackground(new Color(255, 255, 255));
        jugar.setBounds(320, 200, 150, 60);
        jugar.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));

        add(jugar);
    }

}
