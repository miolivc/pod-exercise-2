/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pod.entities;

import io.github.pod.interfaces.Car;
import io.github.pod.interfaces.Passenger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class PassengerImpl extends Thread implements Passenger {

    private Car car;

    public PassengerImpl(Car car) {
        this.car = car;
    }

    public PassengerImpl() {
    }

    @Override
    public void run() {

        getInTheCar();
        waitRideAway();
        getOutTheCar();
        rideInThePark();

    }

    @Override
    public void getInTheCar() {

        car.addPassenger(this);
        System.out.println("entrei no carro");
    }

    @Override
    public void waitRideAway() {

        synchronized (car) {

            try {
                System.out.println("esperando o passeio terminar");
                car.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(PassengerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @Override
    public void getOutTheCar() {

        System.out.println("saindo do carro");
        car.removePassenger(this);

    }

    @Override
    public void rideInThePark() {

        System.out.println("passeando pelo parque");

    }

    @Override
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public void execute() {
        
        this.start();
    }
    
}
