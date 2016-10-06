import 'package:Testes/Car.dart';
import 'package:Testes/CarImpl.dart';
import 'package:Testes/Passenger.dart';
import 'package:Testes/PassengerImpl.dart';

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
main() {

  Passenger passenger;
  Car car = new CarImpl();
  car.execute();

  for (int i = 0; i < 5; i++) {

    passenger = new PassengerImpl(car);
    passenger.execute();
  }

}

