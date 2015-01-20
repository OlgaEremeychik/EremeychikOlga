/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.bsuir.oop.courseProject.ServerEremeychikON;

/**
 *
 * @author HP
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class NetServerThreadEremeychikON {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8180);
            System.out.println("initialized");
            while (true) {
                Socket socket = server.accept();
                System.out.println(socket.getInetAddress().getHostName() + "connected");
                ServerThreadEremeychikON thread = new ServerThreadEremeychikON(socket);
                thread.start();   
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    
}
