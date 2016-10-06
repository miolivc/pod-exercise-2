import 'package:Testes/Passenger.dart';

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
abstract class Car {

  void waitFill();
  void takeAWalk();
  void waitGetOutAll();
  bool addPassenger(Passenger passenger);
  bool removePassenger(Passenger passenger);
  void execute();
  void run();

}
