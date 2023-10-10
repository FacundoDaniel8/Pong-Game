/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.Rectangle;
import java.awt.geom.RoundRectangle2D;
/**
 *
 * @author Alumno
 */
public class Bola {
    private int x;
    private int y;
    private int sgx=1, sgy=1;
    private final int ancho=20, alto=20;
    
     // vidas y fin del juego
    public int vidas = 3;
    public static boolean finJuego = false;
    
    public Bola(int x, int y){
        
        this.x=x;
        this.y=y;
    }
    
    public RoundRectangle2D.Double getBola(){
        
        return new RoundRectangle2D.Double(x, y, ancho,alto,100,100);
    }
    
    public void mover(Rectangle limites, boolean colision){
        
        if (!(Bola.finJuego)){
            
            x+=sgx;
            y+=sgy;

            if (colision == true){

                sgy = -sgy;
                y = 500;
            }

            if (x>limites.getMaxX()-ancho){
                sgx = -sgx;
            }
            if (y>limites.getMaxY()){
                x = 400;
                y = 0;

                vidas = vidas - 1;
            }
            if (x<0){   
                sgx= -sgx;
            }
            if (y<0){   
                sgy= -sgy;
            }
        }
    }
    
    public int getVidas(){
        
        return vidas;
    }
}
