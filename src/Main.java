import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();

        intro(board, scanner);

        while (true) {
            System.out.println("Current state of the board: ");
            System.out.println(board.toString());
            System.out.println("Where will you place your next piece? ");

            System.out.print("X coordinate: ");
            int x = Integer.parseInt(scanner.nextLine());

            while (true) {
                if (!(coordinateValidity(x))) {
                    System.out.println("Mate, that's not a valid X coordinate. Try again.");
                    System.out.print("X coordinate: ");
                    x = Integer.parseInt(scanner.nextLine());
                } else {
                    break;
                }
            }

            System.out.print("Y coordinate: ");
            int y = Integer.parseInt(scanner.nextLine());

            while (true) {
                if (!(coordinateValidity(y))) {
                    System.out.println("Mate, that's not a valid Y coordinate. Try again.");
                    System.out.print("Y coordinate: ");
                    y = Integer.parseInt(scanner.nextLine());
                } else {
                    break;
                }
            }

            board.userPlacement(new ArrayList<>(Arrays.asList(x, y)));

            if (board.checkVictory() == 1 || board.checkVictory() == 2) {
                System.out.println(board.toString());
                break;
            }

            if (board.markCount <= 8 && board.checkVictory() == 0) {
                board.botPlacement();
            }

            if (board.markCount == 9) {
                if (board.checkVictory() == 1 || board.checkVictory() == 2 ) {
                    System.out.println(board.toString());
                    break;
                }
                System.out.println(board.toString());
                System.out.println("Stalemate!");
                break;
            }
        }
    }

    public static int xOrO(String answer) {
        if (answer.toLowerCase().contains("x")) {
            return 1;
        } else if (answer.toLowerCase().contains("o")) {
            return 2;
        } else {
            return 0;
        }
    }

    public static void intro(Board board, Scanner scanner) {
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

        System.out.println();
        System.out.println("Here's a quick map of the coordinates for reference.");
        System.out.println("The first value in the parentheses is the X value, the second is the Y value.");
        System.out.println("(1,1) | (1,2) | (1,3)");
        System.out.println("(2,1) | (2,2) | (2,3)");
        System.out.println("(3,1) | (3,2) | (3,3)");
        System.out.println();
    }

    public static boolean coordinateValidity(int coordinate) {
        return coordinate <= 3 && coordinate >= 1;
    }

}