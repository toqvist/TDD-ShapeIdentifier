package shapes;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        
        ShapeIdentifier si = new ShapeIdentifier();
        ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
    
        coordinates.add(new Coordinate(0, 0, 0));
        coordinates.add(new Coordinate(2, 0, 0));
        coordinates.add(new Coordinate(3, 1, 0));
        coordinates.add(new Coordinate(1, 1, 0));

        si.identify(coordinates);
    }
}
