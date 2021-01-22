import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Board {

    public HashMap<ArrayList<Integer>, Character> locations;
    public char userPreference;
    public char botPreference;

    public Board() {
        this.locations = new HashMap<>();
    }

    public void userPlacement(ArrayList<Integer> list) {
        if (this.locations.get(list) == null) {
            this.locations.put(list, userPreference);
        }
    }

//    public boolean checkAvailability(int x, int y) {
//        if (this.locations.get(x) == y) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return this.locations.get(new ArrayList<>(Arrays.asList(1, 1))) + " | " + this.locations.get(new ArrayList<>(Arrays.asList(1, 2))) + " | " + this.locations.get(new ArrayList<>(Arrays.asList(1, 3))) + "\n"
                + this.locations.get(new ArrayList<>(Arrays.asList(2, 1))) + " | " + this.locations.get(new ArrayList<>(Arrays.asList(2, 2))) + " | " + this.locations.get(new ArrayList<>(Arrays.asList(2, 3))) + "\n"
                + this.locations.get(new ArrayList<>(Arrays.asList(3, 1))) + " | " + this.locations.get(new ArrayList<>(Arrays.asList(3, 2))) + " | " + this.locations.get(new ArrayList<>(Arrays.asList(3, 3)));
    }

}