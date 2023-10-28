/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author w10
 */
public class Mira {
    
    public double x, y;
    int ancho = 10, alto = 10;
    
    public Mira(Bola bola){
        
        this.x = bola.x + bola.ancho / 2 - ancho / 2;
        this.y = bola.y + bola.alto/2 - ancho / 2;
    }
    
    public RoundRectangle2D.Double getMira(){
        
        return new RoundRectangle2D.Double(x,y,ancho,alto, 50, 50);
    }
}
