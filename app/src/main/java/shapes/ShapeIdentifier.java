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
            
            if(isSquare(coordinates)) {
                return "Square";
            } 

            if(isRectangle(coordinates)) {
                return "Rectangle";
            }
            
            return "2D Shape";
        }

        return "None";
    }

    private boolean isSquare (ArrayList<Coordinate> coordinates) {

        if (coordinates.size() != 4) {
            return false;
        }

        float side1 = coordinates.get(0).x() - coordinates.get(1).x();
        float side2 = coordinates.get(1).y() - coordinates.get(2).y();
        boolean hasEqualSides = side1 == side2 || (side1* -1) == side2;
        
        if (hasEqualSides) {
            return true;
        }
        return false;
    }

    private boolean isRectangle (ArrayList<Coordinate> coordinates) {

        if (coordinates.size() != 4) {
            return false;
        }

        float horisontal1 = coordinates.get(0).x() - coordinates.get(1).x();
        float horisontal2 = coordinates.get(2).x() - coordinates.get(3).x();
        
        float vertical1 = coordinates.get(1).y() - coordinates.get(2).y();
        float vertical2 = coordinates.get(3).y() - coordinates.get(0).y();
        
        if (sidesAreEqualLength(vertical1, vertical2) && !sidesAreEqualLength(horisontal1, vertical1)) {
            return true;
        }
        //&& anglesAre90(side1

        //if coordinate changes in both x and y it is a parallelogram

        return false;
    }

   


    private boolean sidesAreEqualLength (float distance1, float distance2) {

        if (distance1 == distance2 || (distance1* -1) == distance2) {
            return true;
        }
        return false;
        
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
