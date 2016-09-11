import 'dart:io';
import 'package:Node1/dao/PersonDao.dart';
import 'dart:convert';

main() async {

  PersonDao personDao = new PersonDao();

  final server = await ServerSocket.bind('127.0.0.1', 4041);

  server.listen((Socket socket) {

    socket.listen((data) {

      String sql = new String.fromCharCodes(data).trim();

      personDao.executeQuery(sql).then((result){

        socket.write(JSON.encode(result));

      });

    });

  });

}