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
    private int sgx = 1, sgy = 1;
    private final int ancho = 20, alto = 20;

    // vidas y fin del juego
    public int vidas = 3;
    public static boolean finJuego = false;

    // puntaje auxiliar, utilizado para medir los segundos entre punto y punto
    public static double puntaje_aux = 0.00;
    // puntaje total
    public static int puntaje = 0;
   
    // record
    public static int record = 0;

    public Bola(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public RoundRectangle2D.Double getBola() {

        return new RoundRectangle2D.Double(x, y, ancho, alto, 100, 100);
    }

    public void mover(Rectangle limites, boolean colision) {

        if (!(Bola.finJuego)) {

            x += sgx;
            y += sgy;
            
            puntaje_aux += 0.005;
            
            // por cada 3 segundos, suma 5 puntos.
            if (puntaje_aux > 3){
                
                puntaje_aux = 0.00;
                puntaje += 5;
            }

            if (colision == true) {

                sgy = -sgy;
                y = 500;
                puntaje += 20;
            }

            if (x > limites.getMaxX() - ancho) {
                sgx = -sgx;
                puntaje += 10;
            }
            if (y > limites.getMaxY()) {
                x = 400;
                y = 0;

                vidas = vidas - 1;
                puntaje -= 50;
            }
            if (x < 0) {
                sgx = -sgx;
                puntaje += 10;
            }
            if (y < 0) {
                sgy = -sgy;
                puntaje += 10;
            }
            
            // Puntaje que calcula el record
            if (record <= puntaje){
                
                record = puntaje;
            }
        }
    }

    public int getVidas() {

        return vidas;
    }

    public int getPuntaje() {

        return (int) puntaje;
    }
    
    public int getRecord() {

        return (int) record;
    }
}
