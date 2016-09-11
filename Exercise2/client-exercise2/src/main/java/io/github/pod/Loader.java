/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pod;

import com.google.gson.Gson;
import io.github.pod.entities.Person;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.Arrays;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class Loader implements Serializable {

    public static void main(String[] args) throws IOException, InterruptedException {

        Socket clientSocket = new Socket("127.0.0.1", 4041);
        System.out.println("Connected " + clientSocket.toString());

        clientSocket.getOutputStream().write("Select * from Person".getBytes());
        System.out.println("Sending query...");
        
        Thread.sleep(2000);

        InputStream inputStream = clientSocket.getInputStream();

        byte[] bytes;

        bytes = new byte[inputStream.available()];

        inputStream.read(bytes);

        String msg = new String(bytes);

        System.out.println("Response reiceved, deserialization started...");

        Gson gson = new Gson();

        Person[] fromJson = gson.fromJson(msg, Person[].class);
        
        System.out.println("Deserialization completed, the Person array is: ");

        System.out.println(Arrays.toString(fromJson));

    }

}
