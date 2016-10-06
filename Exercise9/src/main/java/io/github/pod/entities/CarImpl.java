/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pod.entities;

import io.github.pod.interfaces.Car;
import io.github.pod.interfaces.Passenger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class CarImpl extends Thread implements Car {

    public List<Passenger> passengers;

    public CarImpl() {

        passengers = new ArrayList<>();
    }

    @Override
    public void run() {

        waitFill();
        takeAWalk();
        waitGetOutAll();

    }

    @Override
    public boolean addPassenger(Passenger passenger) {

        if (passengers.add(passenger)) {

            passenger.setCar(this);

            return true;
        }

        return false;
    }

    @Override
    public boolean removePassenger(Passenger passenger) {

        if (passengers.remove(passenger)) {

            passenger.setCar(null);

            return true;
        }

        return false;
    }

    @Override
    public void waitFill() {

        System.out.println("CARRO : aguardando preencher as vagas mínimas do carrinho.");

        while (passengers.size() < 5) {

            try {
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(CarImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("CARRO : Passeio iniciado");

    }

    @Override
    public void takeAWalk() {

        synchronized (this) {

            System.out.println("CARRO : terminamos de dar uma volta.");
            notifyAll();
        }

    }

    @Override
    public void waitGetOutAll() {
        
        System.out.println("CARRO : aguardando todos sairem do carrinho.");

        while (passengers.size() > 0) {

            try {
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(CarImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("CARRO : Carrinho livre");
        
    }
    
    @Override
    public void execute() {
        
        this.start();
    }

}
