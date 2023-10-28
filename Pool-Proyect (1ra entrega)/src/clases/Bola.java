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

    public double x, y, x2, y2;
    public double sgx, sgy, sgx2, sgy2;
    public final int ancho = 20, alto = 20;

    public static boolean finJuego = false;

    public Bola(int x, int y) {

        this.x = x;
        this.y = y;

        this.x2 = x;
        this.y2 = y;
    }

    public RoundRectangle2D getBola() {

        return new RoundRectangle2D.Double(x, y, ancho, alto, 50, 50);
    }

    public RoundRectangle2D.Double getBola2() {

        return new RoundRectangle2D.Double(x2, y2, ancho, alto, 50, 50);
    }

    public void pararBola() {

        // Bola blanca
        if ((Math.round(sgx) == 0) && (Math.round(sgy) == 0)) {

            sgx = 0;
            sgy = 0;
        }
    }

    // Función que detiene el juego junto con la trayectoria de la bola negra
    public void frenarJuegoYBola2() {

        if (((Math.round(sgx) == 0) && (Math.round(sgy) == 0)) && ((Math.round(Tablero.bola2.sgx2) == 0) && (Math.round(Tablero.bola2.sgy2) == 0))) {

            EventoTeclado.space = false;

            Tablero.bola2.sgx2 = 0;
            Tablero.bola2.sgy2 = 0;
        }
    }

    public void mover(Rectangle limites, boolean colision) {

        if (colision == true) {

            sgy = -sgy;
            sgx = -sgx;
        }

        if (!EventoTeclado.space) {

            // Direccionamiento de bola blanca y ubicación de la mira
            if (EventoTeclado.up && sgy > -5.00) {

                Tablero.mira.y -= 95;

                sgy -= 1.00;
                EventoTeclado.up = false;
            }
            if (EventoTeclado.down && sgy < 5.00) {

                Tablero.mira.y += 95;

                sgy += 1.00;
                EventoTeclado.down = false;
            }
            if (EventoTeclado.left && sgx > -5.00) {

                Tablero.mira.x -= 95;

                sgx -= 1.00;
                EventoTeclado.left = false;
            }
            if (EventoTeclado.right && sgx < 5.00) {

                Tablero.mira.x += 95;

                sgx += 1.00;
                EventoTeclado.right = false;
            }
        }

        if (EventoTeclado.space) {

            x += sgx;
            y += sgy;

            // Restablecer ubicacion de la mira
            Tablero.mira.x = Tablero.bola.x + Tablero.bola.ancho / 2 - Tablero.mira.ancho / 2;
            Tablero.mira.y = Tablero.bola.y + Tablero.bola.alto / 2 - Tablero.mira.ancho / 2;

            // Rozamiento blanca
            if (sgx < 0) {

                sgx += 0.004;
            }
            if (sgx > 0) {

                sgx -= 0.004;
            }
            if (sgy < 0) {

                sgy += 0.004;
            }
            if (sgy > 0) {

                sgy -= 0.004;
            }

            pararBola();
            frenarJuegoYBola2();
        }

        // Choque con paredes - Blanca
        if (x > limites.getMaxX() - ancho) {
            sgx = -(sgx);
        }
        if (y > limites.getMaxY() - alto) {
            sgy = -(sgy);
        }
        if (x < 0) {
            sgx = -(sgx);
        }
        if (y < 0) {
            sgy = -(sgy);
        }

    }

    public void mover_aux(Rectangle limites, boolean colision) {

        if (colision == true) {

            // Los condicionales son usados para darle más velocidad a la bola negra
            sgy2 = -(Tablero.bola.sgy);
            if (sgy2 < 0){
                sgy2 -= 1;
            }
            if (sgy2 > 0){
                sgy2 += 1;
            }

            sgx2 = -(Tablero.bola.sgx);
            if (sgx2 > 0){
                sgx2 += 1;
            }
            if (sgx2 < 0){
                sgx2 -= 1;
            }
        }

        if (EventoTeclado.space) {

            x2 += sgx2;
            y2 += sgy2;

            // Rozamiento negra
            if (sgx2 < 0) {

                sgx2 += 0.004;
            }
            if (sgx2 > 0) {

                sgx2 -= 0.004;
            }
            if (sgy2 < 0) {

                sgy2 += 0.004;
            }
            if (sgy2 > 0) {

                sgy2 -= 0.004;
            }
        }

        // Choque con paredes - Negra
        if (x2 > limites.getMaxX() - ancho) {
            sgx2 = -(sgx2);
        }
        if (y2 > limites.getMaxY() - alto) {
            sgy2 = -(sgy2);
        }
        if (x2 < 0) {
            sgx2 = -(sgx2);
        }
        if (y2 < 0) {
            sgy2 = -(sgy2);
        }
    }

    // Medición de los valores de sgx y sgy
    public double getPotenciaY() {

        return sgy;
    }

    public double getPotenciaX() {

        return sgx;
    }
}
