/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holaMundo;
import jade.core.behaviours.Behaviour;

/**
 *
 * @author Octavio Bautista
 */
public class Comportamiento extends Behaviour{

    @Override
    public void action() {
        System.out.println("Hola Mundo");
    }

    @Override
    public boolean done() {
       return true; 
    }
    
}
