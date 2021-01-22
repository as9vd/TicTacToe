import java.util.ArrayList;
import java.util.HashMap;

public class Board {

    public HashMap<Integer, Integer> locations;

    public Board() {
        this.locations = new HashMap<>();
    }

    public void place(int x, int y) {

    }

    public boolean checkAvailability(int x, int y) {
        if (this.locations.get(x) == y) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return null;
    }

}