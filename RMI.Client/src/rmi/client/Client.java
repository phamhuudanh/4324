/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.libs.ThuatToan;

/**
 *
 * @author jacky
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        // TODO code application logic here
        new Client().run();
        
    }
  
    private void run(){
       int port= 6394;
         // nhập dãy số random. 
           
             int n, sum = 0, tempSort;
                Scanner scanner = new Scanner(System.in);

                do {
                    System.out.println("Nhập vào số phần tử của mảng: ");
                    n = scanner.nextInt();
                } while (n < 0);
                int array[] = new int[n];           
                System.out.println("Nhập các phần tử cho mảng: ");
                for (int i = 0; i < n; i++) {
                    System.out.print("Nhập phần tử thứ " + i + ": ");
                    array[i] = scanner.nextInt();
                }
                // Hiển thị mảng vừa nhập
                System.out.println("\nMảng ban đầu: ");
                for (int i = 0; i < n; i++) {
                    System.out.print(array[i] + "\t");
                  
                }
                try {                
                ThuatToan nguyenTo = (ThuatToan) Naming.lookup("rmi://localhost:"+port+"/ThuatToan");
                //
                System.out.println(); 
                String result=nguyenTo.snt(array);
                System.out.println("======Dãy Số Nguyên Tố Là =======");                 
                System.out.println(result);
                System.out.println();              
                } catch (NotBoundException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RemoteException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
           
        } 
    
    
}
