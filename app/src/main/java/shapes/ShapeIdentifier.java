package shapes;

import java.util.ArrayList;

public class ShapeIdentifier {

    public String identify(ArrayList<Coordinate> coordinates) {
        if (coordinates.isEmpty()) {
            return "None";
        }

        if (coordinates.size() == 1) {
            return "Dot";
        }

        if (coordinates.size() == 2) {

            Coordinate firstCoordinate = coordinates.get(0);
            Coordinate secondCoordinate = coordinates.get(1);
            
            boolean areNotTheSame = 
                    firstCoordinate.x() != secondCoordinate.x() ||
                    firstCoordinate.y() != secondCoordinate.y() ||
                    firstCoordinate.z() != secondCoordinate.z();

            if (areNotTheSame) {
                return "Line";
            } else {
                return "Dot";
            }
        }

        return "None";
    }

}
