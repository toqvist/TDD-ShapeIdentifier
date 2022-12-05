package shapes;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ShapeIdentifier {

    public String identify(ArrayList<Coordinate> coordinates) {

        removeDuplicatePoints(coordinates);

        if (coordinates.isEmpty()) {
            return "None";
        }

        if (coordinates.size() == 1) {
            return "Dot";
        }

        if (coordinates.size() == 2) {
            return "Line";
        }

        if (coordinates.size() == 3) {
            return "Triangle";
        }

        if (coordinates.size() == 4) {
            
            if(isSquare()) {
                return "Square";
            } 

            if(isRectangle()) {
                return "Rectangle";
            }
            return "2D Shape";
        }

        return "None";
    }

    private boolean isSquare () {
        
        
        return true;
    }

    private boolean isRectangle () {
        return true;
    }

    private void removeDuplicatePoints(ArrayList<Coordinate> coordinates) {
        for (int i = 0; i < coordinates.size(); i++) {
            for (int j = 0; j < coordinates.size(); j++) {

                Coordinate cord1 = coordinates.get(i);
                Coordinate cord2 = coordinates.get(j);

                if (areTheSame(cord1, cord2) && i != j) {
                    coordinates.remove(cord2);
                }

            }
        }
    }

    private boolean areNotTheSame(Coordinate first, Coordinate second) {
        boolean areNotTheSame = first.x() != second.x() ||
                first.y() != second.y() ||
                first.z() != second.z();

        return areNotTheSame;
    }

    private boolean areTheSame(Coordinate first, Coordinate second) {
        boolean areNotTheSame = first.x() == second.x() &&
                first.y() == second.y() &&
                first.z() == second.z();

        return areNotTheSame;
    }

}
