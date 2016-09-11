import 'package:Node1/entities/Person.dart';
import 'package:postgresql/postgresql.dart';
import 'dart:async';
import 'dart:convert';


class PersonDao{

  static String _username = "postgres";
  static String _password = "123456";
  static String _DBname = "POD";
  static String _uri = 'postgres://$_username:$_password@localhost:5432/$_DBname';

  persist(Person person){

    var id = person.id;
    var name = person.name;
    var email = person.email;

    final String sql = "INSERT INTO Person (id, name, email) VALUES ('$id', '$name', '$email')";
    connect(_uri).then((Connection connection) {

      connection.execute(sql);
      connection.close();
    });

  }

  Future<List<Person>> executeQuery(String query){

    List<Person> result = new List();

    Completer<List<Person>> completer = new Completer();

    connect(_uri).then((Connection connection) {

      connection.query(query).toList().then((rows) {

        Person p;

        for (var row in rows) {

          p = new Person(row.id, row.name, row.email);

          result.add(p);

        }

        completer.complete(result);
        connection.close;

      });
    });

    return completer.future;
  }

}