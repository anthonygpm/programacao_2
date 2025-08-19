import model.entities.Reservation;
import model.exceptions.DateException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Room number: ");
        int roomNumber = sc.nextInt();
        sc.nextLine();
        System.out.print("Check-In date (dd/MM/yyyy): ");
        LocalDate checkIn = LocalDate.parse(sc.nextLine(), fmt);
        System.out.print("Check-Out date (dd/MM/yyyy): ");
        LocalDate checkOut = LocalDate.parse(sc.nextLine(), fmt);

        try {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);
            System.out.println();

            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-In date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(sc.nextLine(), fmt);
            System.out.print("Check-Out date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(sc.nextLine(), fmt);
            reservation.updateDates(checkIn, checkOut);
            System.out.println(reservation);
        }
        catch (DateException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }
    }
}
