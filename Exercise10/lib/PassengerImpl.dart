import 'package:Testes/Car.dart';
import 'package:Testes/Passenger.dart';

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
class PassengerImpl extends Passenger {

  Car car;

  PassengerImpl(this.car);

  run() {

    getInTheCar();
    waitRideAway();
    getOutTheCar();
    rideInThePark();

  }

  getInTheCar() {

    car.addPassenger(this);
    print("entrei no carro");
  }

  waitRideAway() {

    print("esperando o passeio terminar");
  }

  getOutTheCar() {

    print("saindo do carro");
    car.removePassenger(this);

  }

  rideInThePark() {

    print("passeando pelo parque");

  }

  setCar(Car car) {
    this.car = car;
}

  execute() {

    this.run();
  }

}
