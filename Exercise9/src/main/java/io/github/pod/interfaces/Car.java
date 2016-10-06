/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pod.interfaces;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public interface Car {
    
    void waitFill();
    void takeAWalk();
    void waitGetOutAll();
    boolean addPassenger(Passenger passenger);
    boolean removePassenger(Passenger passenger);
    void execute();
    
}
