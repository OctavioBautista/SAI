/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holaMundo;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;

/**
 *
 * @author Octavio Bautista
 */
public class Agente extends Agent{
    Comportamiento comp = new Comportamiento();
    public void setup(){
        this.addBehaviour(comp);
    }
}
