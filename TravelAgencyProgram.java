import java.util.Scanner;
import java.util.Vector;

class Reservation {
    private String name;
    private String destination;

    public Reservation(String name, String destination) {
        this.name = name;
        this.destination = destination;
    }

    public String getName() {
        return name;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "Reservation: " + name + " to " + destination;
    }
}

class ReservationSystem {
    private Vector<Reservation> reservations;
    private String[] availableDestinations = {"New York", "Paris", "London", "Los Angeles"};
    private String[] availableHotels = {"Hotel A", "Hotel B", "Hotel C", "Hotel D"};
    private boolean[] flightAvailability = {true, false, true, true}; // Available flights for each destination
    private boolean[] hotelAvailability = {true, false, true, true}; // Available hotels for each destination

    public ReservationSystem() {
        reservations = new Vector<>();
    }

    public void searchFlight(String name, String destination) {
        int index = findDestinationIndex(destination);
        if (index != -1 && flightAvailability[index]) {
            System.out.println("Flights available to " + destination + " for " + name);
        } else {
            System.out.println("No flights available to " + destination + " for " + name);
        }
    }

    public void searchHotel(String name, String destination) {
        int index = findDestinationIndex(destination);
        if (index != -1 && hotelAvailability[index]) {
            System.out.println("Hotels available in " + destination + " for " + name);
        } else {
            System.out.println("No hotels available in " + destination + " for " + name);
        }
    }

    public void bookReservation(String name, String destination, boolean isHotel) {
        int index = findDestinationIndex(destination);
        if (index != -1) {
            if (isHotel) {
                if (hotelAvailability[index]) {
                    System.out.println("Booking a hotel reservation in " + destination + " for " + name);
                    Reservation reservation = new Reservation(name, destination);
                    reservations.add(reservation);
                    hotelAvailability[index] = false; // Mark the hotel as booked
                } else {
                    System.out.println("No hotels available in " + destination + " for " + name);
                }
            } else {
                if (flightAvailability[index]) {
                    System.out.println("Booking a flight reservation to " + destination + " for " + name);
                    Reservation reservation = new Reservation(name, destination);
                    reservations.add(reservation);
                    flightAvailability[index] = false; // Mark the flight as booked
                } else {
                    System.out.println("No flights available to " + destination + " for " + name);
                }
            }
        } else {
            System.out.println("Invalid destination. Available destinations are: " + String.join(", ", availableDestinations));
        }
    }

    public void cancelReservation(String name, String destination) {
        Reservation toRemove = null;
        for (Reservation reservation : reservations) {
            if (reservation.getName().equals(name) && reservation.getDestination().equals(destination)) {
                toRemove = reservation;
                break;
            }
        }

        if (toRemove != null) {
            reservations.remove(toRemove);
            int index = findDestinationIndex(destination);
            if (index != -1) {
                flightAvailability[index] = true; // Mark the flight as available
                hotelAvailability[index] = true;  // Mark the hotel as available
            }
            System.out.println("Reservation canceled: " + toRemove);
        } else {
            System.out.println("Reservation not found for " + name + " to " + destination);
        }
    }

    private int findDestinationIndex(String destination) {
        for (int i = 0; i < availableDestinations.length; i++) {
            if (availableDestinations[i].equalsIgnoreCase(destination)) {
                return i;
            }
        }
        return -1; // Destination not found
    }
}

public class TravelAgencyProgram {
    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Search for Flights");
            System.out.println("2. Search for Hotels");
            System.out.println("3. Book a Flight Reservation");
            System.out.println("4. Book a Hotel Reservation");
            System.out.println("5. Cancel a Reservation");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter destination: ");
                    String destination = scanner.nextLine();
                    reservationSystem.searchFlight(name, destination);
                    break;

                case 2:
                    System.out.print("Enter your name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter destination: ");
                    destination = scanner.nextLine();
                    reservationSystem.searchHotel(name, destination);
                    break;

                case 3:
                    System.out.print("Enter your name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter destination: ");
                    destination = scanner.nextLine();
                    reservationSystem.bookReservation(name, destination, false); // Book a flight
                    break;

                case 4:
                    System.out.print("Enter your name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter destination: ");
                    destination = scanner.nextLine();
                    reservationSystem.bookReservation(name, destination, true); // Book a hotel
                    break;

                case 5:
                    System.out.print("Enter your name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter destination: ");
                    destination = scanner.nextLine();
                    reservationSystem.cancelReservation(name, destination);
                    break;

                case 6:
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
