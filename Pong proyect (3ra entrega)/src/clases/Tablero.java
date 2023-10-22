/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

// import static clases.Bola.puntaje;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;

/**
 *
 * @author ALUMNOS
 */
public class Tablero extends JPanel {

    int n = 0;
    int m = 1;
    int j = 0;
    
    int cont = 0;

    Bola bola = new Bola(000, 100);
    Paleta paleta = new Paleta(340, 520);

    Ladrillo[][] ladrillo = new Ladrillo[1][8];
    Ladrillo[][] ladrillo2 = new Ladrillo[2][8];
    Ladrillo[][] ladrillo3 = new Ladrillo[3][8];

    public static Panel panelJuego;

    @Override
    public void paintComponent(Graphics g) {

        Dimension tamanio = getSize();

        ImageIcon fondo = new ImageIcon(getClass().getResource("/imagenFondo/luces-neon-degradadas-abstractas.jpg"));
        g.drawImage(fondo.getImage(), 0, 0,
                tamanio.width, tamanio.height, null);
        setOpaque(false);

        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor(Color.yellow);
        dibujar(g2);
        
        g2.setColor(Color.white);
        dibujarItems(g2);
        
        g2.setColor(Color.cyan);
        
        if (bola.nivel == 1){
            
            crearLadrillos(ladrillo);
            dibujarLadrillos(g2, ladrillo);
            efectoLadrillo(ladrillo);
        }

        if (bola.nivel == 2) {

            crearLadrillos(ladrillo2);
            dibujarLadrillos(g2, ladrillo2);
            efectoLadrillo(ladrillo2);

        }
        if (bola.nivel == 3) {

            crearLadrillos(ladrillo3);
            dibujarLadrillos(g2, ladrillo3);
            efectoLadrillo(ladrillo3);

        }
        
        actualizar();

        super.paintComponent(g);

    }

    public void dibujar(Graphics2D g) {

        g.fill(bola.getBola());
        g.fill(paleta.getPaleta());
    }

    public void actualizar() {

        bola.mover(getBounds(), colision(paleta.getPaleta()));
        paleta.mover(getBounds());

    }

    private boolean colision(Rectangle2D f) {

        return bola.getBola().intersects(f);
    }

    boolean colisionBrick(Ladrillo bloque) {
        if (bola.y >= bloque.y
                && bola.y < bloque.y + bloque.alto
                && bola.x > bloque.x
                && bola.x < bloque.x + bloque.ancho) {

            j++;
            return true;
        }
        return false;
    }

    private void crearLadrillos(Ladrillo bloque[][]) {

        for (int i = 1; i < bola.nivel+1; i++) {
            for (int k = 1; k < 8; k++) {

                // Relleno del primer bloque de la matriz 1
                if (bloque == ladrillo){
                    
                    if (bloque[0][0] == null) {

                        bloque[0][0] = new Ladrillo();
                        bloque[0][0].x = 1;
                        bloque[0][0].y = 40;
                    }
                }
                
                // Relleno de los primeros bloques de la matriz 2
                if (bloque == ladrillo2){
                    
                    if (bloque[0][0] == null
                        && bloque[1][0] == null) {

                        bloque[0][0] = new Ladrillo();
                        bloque[0][0].x = 1;
                        bloque[0][0].y = 40;
                        
                        bloque[1][0] = new Ladrillo();
                        bloque[1][0].x = 1;
                        bloque[1][0].y = 80;
                    }
                }
                
                // Relleno de los primeros bloques de la matriz 3
                if (bloque == ladrillo3){
                    
                    if (bloque[0][0] == null
                        && bloque[1][0] == null
                        && bloque[2][0] == null) {

                        bloque[0][0] = new Ladrillo();
                        bloque[0][0].x = 1;
                        bloque[0][0].y = 40;
                        
                        bloque[1][0] = new Ladrillo();
                        bloque[1][0].x = 1;
                        bloque[1][0].y = 80;
                        
                        bloque[2][0] = new Ladrillo();
                        bloque[2][0].x = 1;
                        bloque[2][0].y = 120;
                    }
                }

                // Completando la matriz
                if (bloque[n][m] == null) {

                    bloque[n][m] = new Ladrillo();
                    bloque[n][m].x = k * 100;
                    bloque[n][m].y = i * 40;
                }

                m++;

                if (k == 7) {

                    m = 1;
                    n++;

                    if (n == bola.nivel) {

                        n = 0;
                    }
                }
                //System.out.println(n);
            }
        }
    }

    private void dibujarLadrillos(Graphics2D g, Ladrillo bloque[][]) {

        for (int i = 0; i < bola.nivel; i++) {
            for (int k = 0; k < 8; k++) {

                g.fill(bloque[i][k].getLadrillo());
            }

        }
    }


    public void efectoLadrillo(Ladrillo bloque[][]) {

        for (int i = 0; i < bola.nivel; i++) {
            for (int k = 0; k < 8; k++) {

                if (colisionBrick(bloque[i][k])) {

                    //bola.sgy = bola.sgy*-1; 
                    // Choque inferior
                    if (bola.y <= bloque[i][k].y - bloque[i][k].alto) {

                        bola.sgy = -(bola.sgy);
                    }

                    // Choque superior
                    if (bola.y >= bloque[i][k].y - bola.alto) {

                        bola.sgy = -(bola.sgy);
                    }

                    // Choque lateral izquierdo
                    if (bola.x <= bloque[i][k].x) {

                        bola.sgy = -(bola.sgy);
                        bola.sgx = -(bola.sgx);
                    }

                    // Choque lateral derecho
                    if (bola.x >= bloque[i][k].x + bloque[i][k].ancho) {

                        bola.sgy = -(bola.sgy);
                        bola.sgx = -(bola.sgx);
                    }

                    bloque[i][k].x = -1000;
                    cont++;
                    
                    if (bola.nivel == 1 && cont == 8){
                        
                        bola.nivel = 2;
                        bola.x = paleta.x;
                        bola.y = paleta.y;
                        cont = 0;
                        Bola.finJuego = false;
                    }
                    if (bola.nivel == 2 && cont == 16){
                        
                        bola.nivel = 3;
                        bola.x = paleta.x;
                        bola.y = paleta.y;
                        cont = 0;
                    }
                    if (bola.nivel == 3 && cont == 24){
                        
                        bola.nivel = 4;
                        bola.x = paleta.x + paleta.ancho/2 - bola.ancho;
                        bola.y = paleta.y - bola.alto;
                        cont = 0;
                    }
                    
                }
            }
        }
    }

    private void dibujarItems(Graphics2D g) {

        Font fuentes = new Font("Arial", Font.BOLD, 30);
        g.setFont(fuentes);

        g.drawString("NIVEL: ", (float) getBounds().getMaxX() - 150, 30);
        g.drawString(Integer.toString(bola.getNivel()), (float) getBounds().getMaxX() - 30, 30);

        g.drawString("Pulse ESC para salir ", (float) getBounds().getMinX() + 10, 30);

        salirJuego();

        if (bola.getNivel() == 4 || bola.getVidas() == 0) {

            g.drawString("JUEGO FINALIZADO", (float) getBounds().getCenterX() - 155, (float) getBounds().getCenterY() - 20);
            g.drawString("Pulse 'S' para volver a jugar", (float) getBounds().getCenterX() - 210, (float) getBounds().getCenterY() + 30);
            Bola.finJuego = true;

            if (EventoTeclado.s) {

                panelJuego.dispose();

                panelJuego = new Panel();
                panelJuego.setVisible(true);
                panelJuego.add(Panel.lamina_juego);

                Bola.finJuego = false;
                EventoTeclado.s = false;
                EventoTeclado.esc = false;
                bola.vidas = 1;
            }

        }
    }

    public void salirJuego() {

        if (EventoTeclado.esc) {

            Tablero.panelJuego.dispose();

            TableroInicio.panel = new Panel();
            TableroInicio.panel.setVisible(true);

            TableroInicio.panel.add(Panel.lamina_inicio);

            Bola.finJuego = false;
            EventoTeclado.s = false;
            EventoTeclado.esc = false;
            bola.vidas = 1;
            bola.nivel = 1;
        }
    }
}
