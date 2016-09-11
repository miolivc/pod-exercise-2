import 'dart:convert';
import 'package:Node1/util/Serializable.dart';

class Person extends Serializable {

  int     id;
  String  name;
  String  email;

  Person(this.id, this.name, this.email);

  @override
  String toString() {
    return 'Person{_id: $id, _name: $name, _email: $email}';
  }

  Person.fromJson(String json){

    Map map = JSON.decode(json);

    id = map[id];
    name = map[name];
    email = map[email];

  }

}