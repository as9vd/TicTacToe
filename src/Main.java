import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();

        System.out.println("Welcome to this game of Tic-Tac-Toe. You'll be facing a solid bot.");
        System.out.print("Do you want to be 'X' or 'O'? ");
        while (true) {
            int preference = xOrO(scanner.nextLine());

            if (preference == 1) {
                System.out.println("Nice mate. You're X. Good stuff.");
                board.userPreference = 'X';
                board.botPreference = 'O';
                break;
            } else if (preference == 2) {
                System.out.println("Nice mate. You're O. Good stuff.");
                board.userPreference = 'O';
                board.botPreference = 'X';
                break;
            } else {
                System.out.print("Not a legitimate answer mate, try again: ");
            }
        }

        while (true) {
            System.out.println("Current state of the board: ");
            System.out.println(board.toString());
            System.out.println("Where will you place your next piece? ");

            System.out.print("X coordinate: ");
            int x = Integer.valueOf(scanner.nextLine());
            System.out.print("Y coordinate: ");
            int y = Integer.valueOf(scanner.nextLine());

            ArrayList<Integer> coordinateList = new ArrayList<>();
            coordinateList.add(x);
            coordinateList.add(y);

            board.userPlacement(coordinateList);
        }
    }

    public static int xOrO(String answer) {
        if (answer.toLowerCase().contains("x")) {
            return 1;
        } else if (answer.toLowerCase().contains("x")) {
            return 2;
        } else {
            return 0;
        }
    }

}