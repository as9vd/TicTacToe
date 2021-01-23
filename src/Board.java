import java.util.*;

public class Board {

    public HashMap<ArrayList<Integer>, Character> locations;
    public char userPreference;
    public char botPreference;

    public int markCount = 0;

    public Board() {
        this.locations = new HashMap<>();
    }

    public void userPlacement(ArrayList<Integer> list) {
        while (true) {
            if (this.locations.get(list) == null) {
                this.locations.put(list, this.userPreference);
                this.markCount++;
                break;
            } else {
                System.out.println("There's no space there, try again.");
                System.out.print("X coordinate: ");
                int x = Integer.parseInt(new Scanner(System.in).nextLine());

                while (true) {
                    if (!(Main.coordinateValidity(x))) {
                        System.out.println("Mate, that's not a valid X coordinate. Try again.");
                        System.out.print("X coordinate: ");
                        x = Integer.parseInt(new Scanner(System.in).nextLine());
                    } else {
                        break;
                    }
                }

                System.out.print("Y coordinate: ");
                int y = Integer.parseInt(new Scanner(System.in).nextLine());

                while (true) {
                    if (!(Main.coordinateValidity(y))) {
                        System.out.println("Mate, that's not a valid Y coordinate. Try again.");
                        System.out.print("Y coordinate: ");
                        y = Integer.parseInt(new Scanner(System.in).nextLine());
                    } else {
                        break;
                    }
                }

                ArrayList<Integer> coordinateList = new ArrayList<>(Arrays.asList(x, y));
                if (this.locations.get(coordinateList) == null) {
                    this.locations.put(coordinateList, this.userPreference);
                    this.markCount++;
                    break;
                }
            }
        }
    }

    public void botPlacement() {
        int x = new Random().nextInt(3) + 1;
        int y = new Random().nextInt(3) + 1;
        ArrayList<Integer> botCoordinates = new ArrayList<>(Arrays.asList(x, y));

        while (true) {
            if (this.locations.get(botCoordinates) == null) {
                this.locations.put(botCoordinates, this.botPreference);
                this.markCount++;
                break;
            } else {
                x = new Random().nextInt(3) + 1;
                y = new Random().nextInt(3) + 1;
                botCoordinates = new ArrayList<>(Arrays.asList(x, y));
                if (this.locations.get(botCoordinates) == null) {
                    this.locations.put(botCoordinates, this.botPreference);
                    this.markCount++;
                    break;
                }
            }
        }
    }

    public int checkVictory() {
        if (this.locations.get(new ArrayList<>(Arrays.asList(1, 1))) == this.locations.get(new ArrayList<>(Arrays.asList(1, 2))) && this.locations.get(new ArrayList<>(Arrays.asList(1, 2))) == this.locations.get(new ArrayList<>(Arrays.asList(1, 3)))) { // Top row.
            if (!(this.locations.get(new ArrayList<>(Arrays.asList(1, 1))) == null)) {
                if (this.locations.get(new ArrayList<>(Arrays.asList(1, 1))) == this.userPreference) {
                    System.out.println("You won! Congratulations!");
                    return 1;
                } else if (this.locations.get(new ArrayList<>(Arrays.asList(1, 1))) == this.botPreference) {
                    System.out.println("You lost to the robot. Damn.");
                    return 2;
                }
            }
        } else if (this.locations.get(new ArrayList<>(Arrays.asList(2, 1))) == this.locations.get(new ArrayList<>(Arrays.asList(2, 2))) && this.locations.get(new ArrayList<>(Arrays.asList(2, 2))) == this.locations.get(new ArrayList<>(Arrays.asList(2, 3)))) { // Middle row.
            if (!(this.locations.get(new ArrayList<>(Arrays.asList(2, 1))) == null)) {
                if (this.locations.get(new ArrayList<>(Arrays.asList(2, 1))) == this.userPreference) {
                    System.out.println("You won! Congratulations!");
                    return 1;
                } else if (this.locations.get(new ArrayList<>(Arrays.asList(2, 1))) == this.botPreference) {
                    System.out.println("You lost to the robot. Damn.");
                    return 2;
                }
            }
        } else if (this.locations.get(new ArrayList<>(Arrays.asList(3, 1))) == this.locations.get(new ArrayList<>(Arrays.asList(3, 2))) && this.locations.get(new ArrayList<>(Arrays.asList(3, 2))) == this.locations.get(new ArrayList<>(Arrays.asList(3, 3)))) { // Bottom row.
            if (!(this.locations.get(new ArrayList<>(Arrays.asList(3, 1))) == null)) {
                if (this.locations.get(new ArrayList<>(Arrays.asList(3, 1))) == this.userPreference) {
                    System.out.println("You won! Congratulations!");
                    return 1;
                } else if (this.locations.get(new ArrayList<>(Arrays.asList(3, 1))) == this.botPreference) {
                    System.out.println("You lost to the robot. Damn.");
                    return 2;
                }
            }
        } else if (this.locations.get(new ArrayList<>(Arrays.asList(1, 1))) == this.locations.get(new ArrayList<>(Arrays.asList(2, 1))) && this.locations.get(new ArrayList<>(Arrays.asList(2, 1))) == this.locations.get(new ArrayList<>(Arrays.asList(3, 1)))) { // Left column.
            if (!(this.locations.get(new ArrayList<>(Arrays.asList(1, 1))) == null)) {
                if (this.locations.get(new ArrayList<>(Arrays.asList(1, 1))) == this.userPreference) {
                    System.out.println("You won! Congratulations!");
                    return 1;
                } else if (this.locations.get(new ArrayList<>(Arrays.asList(1, 1))) == this.botPreference) {
                    System.out.println("You lost to the robot. Damn.");
                    return 2;
                }
            }
        } else if (this.locations.get(new ArrayList<>(Arrays.asList(1, 2))) == this.locations.get(new ArrayList<>(Arrays.asList(2, 2))) && this.locations.get(new ArrayList<>(Arrays.asList(2, 2))) == this.locations.get(new ArrayList<>(Arrays.asList(3, 2)))) { // Middle column.
            if (!(this.locations.get(new ArrayList<>(Arrays.asList(1, 2))) == null)) {
                if (this.locations.get(new ArrayList<>(Arrays.asList(1, 2))) == this.userPreference) {
                    System.out.println("You won! Congratulations!");
                    return 1;
                } else if (this.locations.get(new ArrayList<>(Arrays.asList(1, 2))) == this.botPreference) {
                    System.out.println("You lost to the robot. Damn.");
                    return 2;
                }
            }
        } else if (this.locations.get(new ArrayList<>(Arrays.asList(1, 3))) == this.locations.get(new ArrayList<>(Arrays.asList(2, 3))) && this.locations.get(new ArrayList<>(Arrays.asList(2, 3))) == this.locations.get(new ArrayList<>(Arrays.asList(3, 3)))) { // Right column.
            if (!(this.locations.get(new ArrayList<>(Arrays.asList(1, 3))) == null)) {
                if (this.locations.get(new ArrayList<>(Arrays.asList(1, 3))) == this.userPreference) {
                    System.out.println("You won! Congratulations!");
                    return 1;
                } else if (this.locations.get(new ArrayList<>(Arrays.asList(1, 3))) == this.botPreference) {
                    System.out.println("You lost to the robot. Damn.");
                    return 2;
                }
            }
        } else if (this.locations.get(new ArrayList<>(Arrays.asList(1, 1))) == this.locations.get(new ArrayList<>(Arrays.asList(2, 2))) && this.locations.get(new ArrayList<>(Arrays.asList(2, 2))) == this.locations.get(new ArrayList<>(Arrays.asList(3, 3)))) { // Top left to bottom right.
            if (!(this.locations.get(new ArrayList<>(Arrays.asList(1, 1))) == null)) {
                if (this.locations.get(new ArrayList<>(Arrays.asList(1, 1))) == this.userPreference) {
                    System.out.println("You won! Congratulations!");
                    return 1;
                } else if (this.locations.get(new ArrayList<>(Arrays.asList(1, 1))) == this.botPreference) {
                    System.out.println("You lost to the robot. Damn.");
                    return 2;
                }
            }
        } else if (this.locations.get(new ArrayList<>(Arrays.asList(1, 3))) == this.locations.get(new ArrayList<>(Arrays.asList(2, 2))) && this.locations.get(new ArrayList<>(Arrays.asList(2, 2))) == this.locations.get(new ArrayList<>(Arrays.asList(3, 1)))) { // Top right to bottom left.
            if (!(this.locations.get(new ArrayList<>(Arrays.asList(1, 3))) == null)) {
                if (this.locations.get(new ArrayList<>(Arrays.asList(1, 3))) == this.userPreference) {
                    System.out.println("You won! Congratulations!");
                    return 1;
                } else if (this.locations.get(new ArrayList<>(Arrays.asList(1, 3))) == this.botPreference) {
                    System.out.println("You lost to the robot. Damn.");
                    return 2;
                }
            }
        }

        return 0;
    }

    @Override
    public String toString() {
        return this.locations.getOrDefault(new ArrayList<>(Arrays.asList(1, 1)), ' ') + " | " + this.locations.getOrDefault(new ArrayList<>(Arrays.asList(1, 2)), ' ') + " | " + this.locations.getOrDefault(new ArrayList<>(Arrays.asList(1, 3)), ' ') + "\n"
                + this.locations.getOrDefault(new ArrayList<>(Arrays.asList(2, 1)), ' ') + " | " + this.locations.getOrDefault(new ArrayList<>(Arrays.asList(2, 2)), ' ') + " | " + this.locations.getOrDefault(new ArrayList<>(Arrays.asList(2, 3)), ' ') + "\n"
                + this.locations.getOrDefault(new ArrayList<>(Arrays.asList(3, 1)), ' ') + " | " + this.locations.getOrDefault(new ArrayList<>(Arrays.asList(3, 2)), ' ') + " | " + this.locations.getOrDefault(new ArrayList<>(Arrays.asList(3, 3)), ' ');
    }

}