import java.util.Vector;

class Reservation {
    private String reservationID;
    private String reservationType;
    private String details;

    public Reservation(String reservationID, String reservationType, String details) {
        this.reservationID = reservationID;
        this.reservationType = reservationType;
        this.details = details;
    }

    public String getReservationID() {
        return reservationID;
    }

    public String getReservationType() {
        return reservationType;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationID + ", Type: " + reservationType + ", Details: " + details;
    }
}

class TravelAgency {
    private Vector<Reservation> reservations;

    public TravelAgency() {
        reservations = new Vector<>();
    }

    public void searchFlights(String criteria) {
        // Implement flight search logic here
        System.out.println("Searching for flights with criteria: " + criteria);
        // Add code to search and display flight results
    }

    public void searchHotels(String criteria) {
        // Implement hotel search logic here
        System.out.println("Searching for hotels with criteria: " + criteria);
        // Add code to search and display hotel results
    }

    public void bookReservation(String reservationID, String reservationType, String details) {
        Reservation reservation = new Reservation(reservationID, reservationType, details);
        reservations.add(reservation);
        System.out.println("Reservation booked: " + reservation);
    }

    public void cancelReservation(String reservationID) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationID().equals(reservationID)) {
                reservations.remove(reservation);
                System.out.println("Reservation canceled: " + reservation);
                return;
            }
        }
        System.out.println("Reservation not found with ID: " + reservationID);
    }

    public void displayReservations() {
        System.out.println("All Reservations:");
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }
}

public class TravelAgencyProgram {
    public static void main(String[] args) {
        TravelAgency travelAgency = new TravelAgency();

        travelAgency.searchFlights("New York to Los Angeles");
        travelAgency.searchHotels("Los Angeles");

        travelAgency.bookReservation("R101", "Flight", "New York to Los Angeles, Date: 2023-11-01");
        travelAgency.bookReservation("H201", "Hotel", "Hotel ABC, Los Angeles, Check-in: 2023-11-01, Check-out: 2023-11-05");

        travelAgency.displayReservations();

        travelAgency.cancelReservation("R101");

        travelAgency.displayReservations();
    }
}
