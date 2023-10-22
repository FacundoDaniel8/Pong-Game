/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.awt.Color;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Alumno
 */
public class Ladrillo {
    
    public int x, y;
    public int ancho=90, alto=30;
    
    
    public Rectangle2D getLadrillo(){
        
        return new Rectangle2D.Double(x,y,ancho,alto);
    }
}
