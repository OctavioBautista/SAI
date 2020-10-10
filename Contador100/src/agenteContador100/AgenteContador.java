/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenteContador100;

import jade.core.Agent;

/**
 *
 * @author Octavio Bautista
 */
public class AgenteContador extends Agent{
    Comportamiento comp = new Comportamiento();
    public void setup(){
        this.addBehaviour(comp);
    }
}
