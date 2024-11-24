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
public class b1_client {
   public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket client = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        int n = 0;
        boolean checksn = false;

    
        while (checksn == false) {
          
                System.out.print("nhap n:");
                n = sc.nextInt();
                checksn = true;
           
        }

    
        byte[] guin = String.valueOf(n).getBytes();
        InetAddress diachi = InetAddress.getByName("localhost");
        int port = 9999;
        DatagramPacket guison = new DatagramPacket(guin, guin.length, diachi, port);
        client.send(guison);

      
        byte[] nhandata = new byte[1000];
        DatagramPacket guisodulieu = new DatagramPacket(nhandata, nhandata.length);
        client.receive(guisodulieu);

       
        String result = new String(guisodulieu.getData(), 0, guisodulieu.getLength());
        System.out.println(result);
        client.close();
    }
}
