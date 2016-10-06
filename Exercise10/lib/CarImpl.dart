import 'package:Testes/Car.dart';
import 'package:Testes/Passenger.dart';
import 'dart:core';

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
class CarImpl extends Car {

  List<Passenger> passengers;

  CarImpl() {

    passengers = new List<Passenger>();
  }

  run() {

    waitFill();
    takeAWalk();
    waitGetOutAll();

  }

  addPassenger(Passenger passenger) {

    passengers.add(passenger);

    passenger.setCar(this);

    return true;
  }

  removePassenger(Passenger passenger) {

    if (passengers.remove(passenger)) {

      passenger.setCar(null);

      return true;
    }

    return false;
  }

  waitFill() {

    print("CARRO : aguardando preencher as vagas mínimas do carrinho.");

    while (passengers.length < 5) {

    }

    print("CARRO : Passeio iniciado");

  }

  takeAWalk() {

    print("CARRO : terminamos de dar uma volta.");

  }

  waitGetOutAll() {

    print("CARRO : aguardando todos sairem do carrinho.");

    while (passengers.length > 0) {

    }

    print("CARRO : Carrinho livre");

  }

  void execute() {

    this.run();
  }

}
