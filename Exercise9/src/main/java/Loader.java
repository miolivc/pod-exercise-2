
import io.github.pod.entities.CarImpl;
import io.github.pod.entities.PassengerImpl;
import io.github.pod.interfaces.Car;
import io.github.pod.interfaces.Passenger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class Loader {

    public static void main(String[] args) throws InterruptedException {

        Passenger passenger;
        Car car = new CarImpl();
        car.execute();

        for (int i = 0; i < 5; i++) {

            passenger = new PassengerImpl(car);
            passenger.execute();
        }

    }

}
