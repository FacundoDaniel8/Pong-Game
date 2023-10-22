/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alumno
 */
public class TableroInicio extends JPanel{
    
     public static Panel panel = new Panel();
     
     public TableroInicio(){
         
         setBackground(Color.BLACK);
         
     }
     
     public void paintComponent(Graphics g){
         
        super.paintComponent(g);
         
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.yellow);
        
        dibujarMenu(g2);
     }
     
     
     
    public void dibujarMenu(Graphics2D g){
         
        Font fuentes = new Font("Arial", Font.BOLD, 60);
        g.setFont(fuentes);
         
        g.drawString("PONG GAME", (float) getBounds().getCenterX()-190, 80);
         
        boton_jugar();
        boton_config();
        boton_instrucciones();
        boton_salir();
     }
    
    
    
    public void boton_jugar(){
        
        JLabel btnJugar = new JLabel("JUGAR");
        
	
	btnJugar.setBounds(330, 160, 110, 60);
        btnJugar.setForeground(new Color(255, 255, 255));
		
	btnJugar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
		
                TableroInicio.panel.dispose();
                
                Tablero.panelJuego = new Panel();
                Tablero.panelJuego.setVisible(true);
                
                Tablero.panelJuego.add(Panel.lamina_juego);
            }
            @Override
            // Hover
            public void mouseEntered(MouseEvent e) {
                btnJugar.setForeground(Color.CYAN);
            }
            @Override
            public void mouseExited(MouseEvent e) {
		btnJugar.setForeground(Color.WHITE);
            }
        });
        
        btnJugar.setBackground(Color.WHITE);
        btnJugar.setFont(new Font("Arial", Font.BOLD, 30));
        btnJugar.setVisible(true);
        
        add(btnJugar);
    }
    
    public void boton_salir(){
        
        JLabel btnSalir = new JLabel("SALIR");
        
        btnSalir.setBounds(330, 310, 110, 60);
        btnSalir.setForeground(new Color(255, 255, 255));
		
	btnSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
		
                System.exit(0);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnSalir.setForeground(Color.CYAN);
            }
            @Override
            public void mouseExited(MouseEvent e) {
		btnSalir.setForeground(Color.WHITE);
            }
        });
        
        btnSalir.setBackground(Color.WHITE);
        btnSalir.setFont(new Font("Arial", Font.BOLD, 30));
        btnSalir.setVisible(true);
        
        add(btnSalir);
    }
    
    public void boton_config(){
        
        JLabel btnConfig = new JLabel("CONFIGURACIONES");
        
        btnConfig.setBounds(240, 210, 300, 60);
        btnConfig.setForeground(new Color(255, 255, 255));
		
	btnConfig.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
		
                //
            }
            public void mouseEntered(MouseEvent e) {
                btnConfig.setForeground(Color.CYAN);
            }
            @Override
            public void mouseExited(MouseEvent e) {
		btnConfig.setForeground(Color.WHITE);
            }
        });
        
        btnConfig.setBackground(Color.WHITE);
        btnConfig.setFont(new Font("Arial", Font.BOLD, 30));
        btnConfig.setVisible(true);
        
        add(btnConfig);
    }
    
    public void boton_instrucciones(){
        
        JLabel btnIns = new JLabel("INSTRUCCIONES");
        
        btnIns.setBounds(270, 260, 280, 60);
        btnIns.setForeground(new Color(255, 255, 255));
		
	btnIns.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
		
                //
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnIns.setForeground(Color.CYAN);
            }
            @Override
            public void mouseExited(MouseEvent e) {
		btnIns.setForeground(Color.WHITE);
            }
        });
        
        btnIns.setBackground(Color.WHITE);
        btnIns.setFont(new Font("Arial", Font.BOLD, 30));
        btnIns.setVisible(true);
        
        add(btnIns);
    }
}