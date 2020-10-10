/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenteContador100;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
/**
 *
 * @author Octavio Bautista
 */
public class Comportamiento extends Behaviour {
    
    int n=0;
    @Override
    public void action() {
        System.out.println(n);
    }

    @Override
    public boolean done() {
        if(n==100)
            return true;
        n++;
        return false;
    }
}
