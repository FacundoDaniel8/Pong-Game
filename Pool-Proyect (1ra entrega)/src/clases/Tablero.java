/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

// import static clases.Bola.puntaje;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author ALUMNOS
 */
public class Tablero extends JPanel {

    static Bola bola = new Bola(200, 250);
    static Bola bola2 = new Bola(610, 250);
    
    static Mira mira = new Mira(bola);

    public static Panel panelJuego;

    public Tablero(){
        
        setBackground(new Color(26,132,57));
    }
    
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor(Color.white);
        dibujarBola(g2);
        
        g2.setColor(Color.BLACK);
        dibujarBola2(g2);
        
        g2.setColor(Color.yellow);
        dibujarItems(g2);
        
        g2.setColor(Color.red);
        dibujarMira(g2);
        
        actualizar();
    }

    public void dibujarBola(Graphics2D g) {

        g.fill(bola.getBola());
        g.fill(mira.getMira());
    }
    public void dibujarBola2(Graphics2D g) {

        g.fill(bola2.getBola2());
    }
    public void dibujarMira(Graphics2D g) {

        g.fill(mira.getMira());
    }

    public void actualizar() {

        bola.mover(getBounds(), colision());
        bola2.mover_aux(getBounds(), colision2());
    }

    private boolean colision() {
        
        return bola.getBola().intersects(bola2.x2,bola2.y2,bola2.ancho,bola2.alto);
    }
    private boolean colision2() {
        
        return bola2.getBola2().intersects(bola.x,bola.y,bola.ancho,bola.alto);
    }

    private void dibujarItems(Graphics2D g) {

        Font fuentes = new Font("Arial", Font.BOLD, 30);
        Font fuentes2 = new Font("Arial", Font.BOLD, 20);
        g.setFont(fuentes);

        g.drawString("Pulse ESC para salir ", (float) getBounds().getMinX() + 10, 30);
        
        g.setFont(fuentes2);
        
        g.drawString("Potencia de X:  ", (float) getBounds().getMaxX() - 190, 25);
        g.drawString(Double.toString(bola.getPotenciaX()), (float) getBounds().getMaxX() - 45, 25);
        g.drawString("Potencia de Y:  ", (float) getBounds().getMaxX() - 190, 50);
        g.drawString(Double.toString(bola.getPotenciaY()), (float) getBounds().getMaxX() - 45, 50);
        
        g.drawString("Pulse R para reiniciar en caso de bugs", (float) getBounds().getMinX() + 10, (float) getBounds().getMaxY() - 10);
        
        salir_resetearJuego();
    }

    public void salir_resetearJuego() {
        
        
        if (EventoTeclado.esc || EventoTeclado.restart) {

            bola.x = 200;
            bola.y = 250;
            bola2.x2 = 610;
            bola2.y2 = 250;
            
            bola2.sgx2 = 0;
            bola.sgx = 0;
            bola2.sgy2 = 0;
            bola.sgy = 0;
            
            mira.x = bola.x + bola.ancho / 2 - mira.ancho / 2;
            mira.y = bola.y + bola.alto/2 - mira.ancho / 2;
        }
        
        if (EventoTeclado.esc){
            
            Tablero.panelJuego.dispose();

            TableroInicio.panel = new Panel();
            TableroInicio.panel.setVisible(true);

            TableroInicio.panel.add(Panel.lamina_inicio);
        }
    }
}
