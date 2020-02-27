/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicantion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;

/**
 *
 * @author ti-unirb
 */
public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println("Room number: ");
        int number = sc.nextInt();
        System.out.println("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.println("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());
        
        if (!checkOut.after(checkIn)){
            System.out.println("Erro in reservation");
        }else{
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: "+reservation);
            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.println("Check-in dae (dd/MM/yyyy)");
            checkIn = sdf.parse(sc.next());
            System.out.println("Check-out date (dd/MM/yyyy)");
            checkOut = sdf.parse(sc.next());
            
            Date now = new Date();
            if(checkIn.before(now) || checkOut.before(now)){
                System.out.println("Erro in reservation");
            }else if(!checkOut.after(checkIn)){
                System.out.println("Erro in reservation");
            }else{
                reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: "+reservation);  
            }
        }
    }
}
