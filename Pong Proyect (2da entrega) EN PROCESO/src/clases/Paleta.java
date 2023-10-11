/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Alumno
 */
public class Paleta {
    
    private int x, y;
    static final int ancho=115, alto=10;
    
    public Paleta(int x, int y){
        
        this.x=x;
        this.y=y;
    }
    
    public Rectangle2D getPaleta(){
        
        return new Rectangle2D.Double(x,y,ancho,alto);
    }
    
    public void mover(Rectangle limites){
        
        if (!(Bola.finJuego)){
            
            if ((EventoTeclado.a == true || EventoTeclado.left == true) && x > limites.getMinX()){
            
                x--;
            }
            if ((EventoTeclado.d == true || EventoTeclado.right == true) && x < limites.getMaxX()-ancho){
            
                x++;
            }
        }
        
    }
}
