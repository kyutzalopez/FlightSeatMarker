import java.util.Scanner;

public class FlightSeats {
    //this method prints seating chart, changes as seats are marked
    public void printSeating(String[][] x) {
        for (int row = 0; row < x.length; row++) {
            for (int col = 0; col < x[row].length; col++) {
                System.out.print(x[row][col] + " ");
            }
            System.out.println();
        }
    }
    //this method marks the seat after it is  verified, otherwise not used
    public void markSeat(String[][] x, int i, int j) {
        x[i][j] = "X";
        printSeating(x);
    }
    //this method verifies seats, when seat is taken it will repeat until not taken
    public boolean verifySeat(String[][] x, String row, String col){
        int i = Integer.parseInt(row) - 1; //remember to subtract 1
        int j = 0;
        if ("A".equals(col)) {
            j = 1;}
        if ("B".equals(col)) {
            j = 2;}
        if ("C".equals(col)) {
            j = 3;}
        if ("D".equals(col)) {
            j = 4;}

        if (x[i][j] == "X") {
            return true;
        }
        else {
            markSeat(x, i, j);
            return false;
        }
    }
}
