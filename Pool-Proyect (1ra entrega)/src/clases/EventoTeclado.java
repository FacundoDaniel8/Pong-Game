/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.event.*;

/**
 *
 * @author Alumno
 */
public class EventoTeclado extends KeyAdapter{
    
    static boolean right, left, up, down, restart;
    static boolean space, esc;
    
    @Override
    public void keyPressed(KeyEvent e){
        
        int id = e.getKeyCode();
        
        if (id == KeyEvent.VK_RIGHT){
            right = true;
        }
        if (id == KeyEvent.VK_LEFT){
            left = true;
        }
        if (id == KeyEvent.VK_UP){
            up = true;
        }
        if (id == KeyEvent.VK_DOWN){
            down = true;
        }
        if (id == KeyEvent.VK_SPACE){
            space = true;
        }
        if (id == KeyEvent.VK_ESCAPE){
            esc = true;
        }
        if (id == KeyEvent.VK_R){
            restart = true;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        
        int id = e.getKeyCode();
        
        if (id == KeyEvent.VK_RIGHT){
            right = false;
        }
        if (id == KeyEvent.VK_LEFT){
            left = false;
        }
        if (id == KeyEvent.VK_UP){
            up = false;
        }
        if (id == KeyEvent.VK_DOWN){
            down = false;
        }
        if (id == KeyEvent.VK_ESCAPE){
            esc = false;
        }
        if (id == KeyEvent.VK_R){
            restart = false;
        }
    }
}
