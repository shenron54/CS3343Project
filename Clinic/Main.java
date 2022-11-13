import java.util.ArrayList;
import java.util.Scanner;

import Logistics.Doctor;
import Logistics.Hospital;
import Logistics.Location;
import Logistics.Time;
import Logistics.User;
import Reservations.Reservation;
import ServicesFactory.Service;
import ServicesFactory.ServicesFactory;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner sc = new Scanner(System.in);

        Hospital hos = Hospital.getinstance();
        ServicesFactory app = new ServicesFactory();

        // // Creating services
        Service s1 = app.createService("Vaccination");
        Service s2 = app.createService("Checkup");
        Service s3 = app.createService("Physical Test");


        // Creating locations
        Location l1 = new Location("Traetment Solutions Kowloon Tong", 10,
                new Doctor("Dr Asrani", new Time(9, 0), new Time(18, 0)));
        Location l2 = new Location("Traetment Solutions Central", 10,
                new Doctor("Dr Kumar", new Time(9, 0), new Time(18, 0)));
        Location l3 = new Location("Traetment Solutions Keneddy Town", 10,
                new Doctor("Dr Navale", new Time(9, 0), new Time(18, 0)));

        // Adding locations
        hos.addLocation(l1);
        hos.addLocation(l2);
        hos.addLocation(l3);

        //Adding Services
        hos.addService(s1);
        hos.addService(s2);
        hos.addService(s3);

        String userChoice = "run";

        while (!userChoice.equals("exit")) {

            System.out.println("Welcome to the Online Clinic Reservation Reservation Services");

            System.out.println("Are you an existing user? Press y/n");
            String exsistingUser = sc.next();
            User u;
            String HKID;

            if (exsistingUser.equals("y")) {
                System.out.println("Enter your HKID:");
                HKID = sc.next();
                u = hos.findUserByHKID(HKID);
            }

            else {
                System.out.println("Please enter your name: ");
                String name = sc.next();
                System.out.println("Enter your HKID:");
                HKID = sc.next();
                u = new User(HKID, name);
                hos.addUser(u);
            }

            System.out.println("Please select one of the options below: ");
            System.out.println("Type 'new' to make a new reservation.");
            System.out.println("Type 'cancel' to cancel an existing reservation.");
            System.out.println("Type 'enquire' to enquire about your existing reservation.");
            String serviceRequested = sc.next();

            if (serviceRequested.equals("new")) {
                System.out.println("Please select the location");
                hos.printLocations();
                int locationIndex = sc.nextInt();
                Location selectedLoc = Hospital.getLocByIndex(locationIndex);

                System.out.println("Please select the services");
                // Print out the services
                hos.printServices();
                int serviceIndex = sc.nextInt();
                Service s = Hospital.getServiceByIndex(serviceIndex);
                System.out.println("Please select the available time slots");
                // Will print the available time slots and ask the user to select from it (will
                // be different for differnt locations)
                if (s.getName().equals("CheckUp")) {
                    System.out.println(selectedLoc);
                    selectedLoc.getDocAvailability();
                }

                else {
                    selectedLoc.getAvailableIntervals();
                }
                String time = sc.next();

                Time selectedTime = new Time(Integer.parseInt(time.substring(0, 2)),
                        Integer.parseInt(time.substring(3)));

                System.out.println("Here are the details for your reservation:");
                System.out.println("Location: " + selectedLoc);
                System.out.println("Service selected: " + s);
                System.out.println("Time slot: " + selectedTime);
                System.out.println("Press y/n:");
                String answer = sc.next();
                if (answer.equals("y")) {
                    Reservation res = new Reservation(u, selectedLoc, s, selectedTime);
                    u.addReservation(res);
                    selectedLoc.addReservationLoc(res);
                    System.out.println("Reservation successful");

                }

                // // Will print out the reservation details
                System.out.println("Select one of the given options:");
                System.out.println("Type 'run' to use the reservation portal again.");
                System.out.println("Type 'exit' to end the application.");
                userChoice = sc.next();
            }

            else if (serviceRequested.equals("cancel")) {
                ArrayList<Reservation> r;
                r = u.getReservations();
                if (r != null) {
                    System.out.println("These are your existing reservation");
                    int count = 1;
                    for (Reservation reservation : r) {
                        System.out.println(count + ". " + reservation);
                    }

                    System.out.println("Enter the Reservation id to be deleted. ");
                    int id = sc.nextInt();
                    
                    Reservation rn = u.getReservationById(id);
                    Location selectedLoc = rn.getLocation();
                    selectedLoc.deleteReservationById(id);
                    u.deleteReservationById(id);
                    System.out.println("Deletion successful");
                }

                // // Will print out the reservation details
                System.out.println("Select one of the given options:");
                System.out.println("Type 'run' to use the reservation portal again.");
                System.out.println("Type 'exit' to end the application.");
                userChoice = sc.next();

            }

            else if (serviceRequested.equals("enquire")) {
                ArrayList<Reservation> r;
                r = u.getReservations();
                if (r != null) {
                    System.out.println("These are your existing reservation");
                    int count = 1;
                    for (Reservation reservation : r) {
                        System.out.println(count + ". " + reservation);
                    }
                }

                // // Will print out the reservation details
                System.out.println("Select one of the given options:");
                System.out.println("Type 'run' to use the reservation portal again.");
                System.out.println("Type 'exit' to end the application.");
                userChoice = sc.next();
            }
        }
    }
}
