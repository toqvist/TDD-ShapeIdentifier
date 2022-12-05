package shapes;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.lang.model.util.Elements.Origin;

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
            
            if (isSquare(coordinates)) {
                return "Square";
            } 

            if (isRectangle(coordinates)) {
                return "Rectangle";
            }

            if (isParallelogram(coordinates)) {
                return "Parallelogram";
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

        Face horizontal1 = new Face (coordinates.get(0),coordinates.get(1));
        Face horizontal2 = new Face (coordinates.get(2), coordinates.get(3));

        Face vertical1 = new Face (coordinates.get(1), coordinates.get(2));
        Face vertical2 = new Face (coordinates.get(3), coordinates.get(0));

        boolean sidesAreNotEqual = false;
        boolean anglesAre90 = false;

        if (vertical1.getHeight() == vertical2.getHeight() && vertical1.getHeight() != horizontal1.getLength()) {
            sidesAreNotEqual = true;
        }

        if (sidesAreNotEqual) {
            return true;
        }

        
        return false;
    }

    private boolean isParallelogram (ArrayList<Coordinate> coordinates) {

       return true;
    }

    private boolean anglesAre90 () {
        // System.out.println(cord1.x() + " " + cord2.x());
        // System.out.println(cord1.y() + " " + cord2.y());

        // if(cord1.x() != cord2.x() && cord1.y() != cord2.y()) {
        //     return false;
        // }

        //if horizontal1 and horizontal2 have different origins/exits then it is a parallelogram
        

        return true;
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
