import 'dart:io';

main() async {

  var x =0, y =0;

  void sum(){

    x = y + 1;
    y = x + 1;
  }

  for(int i=0; i<10; i++){

    await sum();
    await sum();

    print(x);
  }

}
