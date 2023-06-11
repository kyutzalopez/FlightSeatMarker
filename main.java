import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FlightSeats fs = new FlightSeats();

        String[][] seatingChart = {
                {"1", "A", "B", "C", "D"},
                {"2", "A", "B", "C", "D"},
                {"3", "A", "B", "C", "D"},
                {"4", "A", "B", "C", "D"},
                {"5", "A", "B", "C", "D"},
                {"6", "A", "B", "C", "D"},
                {"7", "A", "B", "C", "D"}};

        fs.printSeating(seatingChart);

        //scans user's input and either verifies or quits depending on input
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a seat number or Q to quit: ");
        String selectedSeat = input.nextLine();

        //boolean variable meant to keep loop running until user decides to quit or all seats taken
        boolean quitter = true;
        //counter meant to keep track of all 28 seats being marked each time
        int counter = 0;

        while (quitter) {
            if (selectedSeat.equals("Q") || counter == 28) {
                break;
            }

            String[] seatReader = selectedSeat.split("");
            String i = seatReader[0], j = seatReader[1];

            //boolean variable meant to keep either while loops running based on seat verification
            boolean c = fs.verifySeat(seatingChart, i, j);

            //if seat is taken this will repeatedly run until seat is valid to mark
            while (c) {
                System.out.println("Seat is taken, please select a different one.");
                input = new Scanner(System.in);
                selectedSeat = input.nextLine();
                seatReader = selectedSeat.split("");
                String correctedRow = seatReader[0], correctedCol = seatReader[1];

                c = fs.verifySeat(seatingChart, correctedRow, correctedCol);

            }

            //if seat is valid to mark, it will be marked within FlightSeats class and run this repeatedly
            while (!c) {
                    //counter marks every seat being marked b/c this loop only runs when a seat is valid
                    counter++;
                    if (counter == 28) {
                        System.out.println("All seats are now taken...Goodbye.");
                        break;}

                    System.out.println("Please enter a seat number or Q to quit: ");
                    selectedSeat = input.nextLine();

                    if (selectedSeat.equals("Q")) {
                        break;}

                    seatReader = selectedSeat.split("");
                    i = seatReader[0];
                    j = seatReader[1];
                    c = fs.verifySeat(seatingChart, i, j);
            }
        }
    }
}
