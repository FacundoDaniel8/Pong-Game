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
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALUMNOS
 */
public class Tablero extends JPanel{
    
    Bola bola = new Bola(0, 0);
    Paleta paleta = new Paleta(380, 520);
    
    public Tablero(){
        
        setBackground(Color.BLACK);
    }
    
    @Override
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.WHITE);
        dibujar(g2);
        dibujarItems(g2);
        actualizar();
    }
    
    public void dibujar(Graphics2D g){
        
        g.fill(bola.getBola());
        g.fill(paleta.getPaleta());
    }
    public void actualizar(){
        
        bola.mover(getBounds(), colision(paleta.getPaleta()));
        paleta.mover(getBounds());
    }
    
    private boolean colision(Rectangle2D r){
        
        return bola.getBola().intersects(r);
    }
    
    
    private void dibujarItems(Graphics2D g){
        
        Graphics2D g1 = g;
        
        Font fuentes = new Font("Arial", Font.BOLD, 30);
        g.setFont(fuentes);
        
        g.drawString("VIDAS: ", (float) getBounds().getMaxX()-150, 30);
        g1.drawString(Integer.toString(bola.getVidas()), (float) getBounds().getMaxX()-30, 30);
        
        g.drawString("PUNTAJE: ", (float) getBounds().getMinX()+ 10, 30);
        g1.drawString(Integer.toString(bola.getPuntaje()), (float) getBounds().getMinX()+ 180, 30);
        
        g.drawString("RECORD: ", (float) getBounds().getMinX()+ 10, 70);
        g1.drawString(Integer.toString(bola.getRecord()), (float) getBounds().getMinX()+ 180, 70);
        
        if (bola.getVidas() == 0){
            
            g.drawString("JUEGO FINALIZADO", (float) getBounds().getCenterX() - 155, (float) getBounds().getCenterY() - 100);
            g.drawString("¿Volver a intentar?", (float) getBounds().getCenterX() - 140, (float) getBounds().getCenterY() - 50);
            g.drawString("S / N", (float) getBounds().getCenterX() - 50, (float) getBounds().getCenterY() - 0);
            Bola.finJuego = true;
            
            
            if (EventoTeclado.n == true){
                
                Panel panel = new Panel();
                panel.setVisible(true);
                Bola.finJuego = false;
                Bola.puntaje = 0;
                Bola.puntaje_aux = 0;
                
                setVisible(false);
            }
            
            if (EventoTeclado.s == true){
                
                Panel panel = new Panel();
                panel.setVisible(true);
                Bola.finJuego = false;
                Bola.puntaje = 0;
                Bola.puntaje_aux = 0;
                
                setVisible(false);
                
                panel.remove(Panel.lamina_inicio);
                panel.add(Panel.lamina_juego);
            }
            
        }
    }
    
}
