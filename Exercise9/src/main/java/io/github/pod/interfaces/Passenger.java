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
public interface Passenger {
    
    void getInTheCar();
    void waitRideAway();
    void getOutTheCar();
    void rideInThePark();
    void setCar(Car car);
    void execute();
    
}
