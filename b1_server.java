/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lap_trinh_mang;
import java.util.*;
import java.net.*;
import java.io.*;
/**
 *
 * @author admin
 */
public class b1_server {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket server = new DatagramSocket(9999);
        System.out.println("Server đang chạy, chờ kết nối...");

       
        byte[] nhann = new byte[1000];
        DatagramPacket nhanson = new DatagramPacket(nhann, nhann.length);
        server.receive(nhanson);
        int n = Integer.parseInt(new String(nhanson.getData(), 0, nhanson.getLength()));

      
        StringBuilder result = new StringBuilder();
        for (int i = 5; i < n; i += 5) {
            if (isPrime(i)) {
                result.append(i).append(" ");
            }
        }

        
        byte[] guisodulieu = result.toString().getBytes();
        DatagramPacket guisodem = new DatagramPacket(guisodulieu, guisodulieu.length, nhanson.getAddress(), nhanson.getPort());
        server.send(guisodem);

        server.close();
    }

   
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
