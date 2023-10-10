/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import javax.swing.JFrame;
/**
 *
 * @author ALUMNOS
 */
public class Panel extends JFrame{
    
    private final int ancho=800, alto=600;
    private final Tablero lamina;
    private Hilo hilo;
    
    public Panel(){
        
        setTitle("Pong");
        setSize(ancho, alto);
        setLocationRelativeTo(null);
        setResizable(false);
        
        lamina = new Tablero();
        add(lamina);
        addKeyListener(new EventoTeclado());
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        hilo = new Hilo(lamina);
        hilo.start();
       
    }
    
}
