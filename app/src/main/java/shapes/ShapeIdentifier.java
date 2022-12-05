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

        boolean hasCordsInX = false;
        boolean hasCordsInY = false;
        boolean hasCordsInZ = false;

        for (Coordinate coordinate : coordinates) {

            if (coordinate.x() != 0) {
                hasCordsInX = true;
            }
            if (coordinate.y() != 0) {
                hasCordsInY = true;
            }
            if (coordinate.z() != 0) {
                hasCordsInZ = true;
            }
        }

        boolean is2D = (hasCordsInX && hasCordsInY && !hasCordsInZ) ||
                (hasCordsInX && !hasCordsInY && hasCordsInZ) ||
                (!hasCordsInX && hasCordsInY && hasCordsInZ);

        if (is2D) {
            return "2D Shape";
        }

        if (isPyramid(coordinates)) {
            return "Pyramid";
        }

        return "3D Shape";
    }

    private boolean isSquare(ArrayList<Coordinate> coordinates) {

        if (coordinates.size() != 4) {
            return false;
        }

        float side1 = coordinates.get(0).x() - coordinates.get(1).x();
        float side2 = coordinates.get(1).y() - coordinates.get(2).y();
        boolean hasEqualSides = side1 == side2 || (side1 * -1) == side2;

        if (hasEqualSides) {
            return true;
        }
        return false;
    }

    private boolean isRectangle(ArrayList<Coordinate> coordinates) {

        if (coordinates.size() != 4) {
            return false;
        }

        Face horizontal1 = new Face(coordinates.get(0), coordinates.get(1));
        Face horizontal2 = new Face(coordinates.get(2), coordinates.get(3));

        Face vertical1 = new Face(coordinates.get(1), coordinates.get(2));
        Face vertical2 = new Face(coordinates.get(3), coordinates.get(0));

        boolean sidesAreNotEqual = false;
        boolean anglesAre90 = false;

        if (vertical1.getHeight() == vertical2.getHeight() && vertical1.getHeight() != horizontal1.getLength()) {
            sidesAreNotEqual = true;
        }

        if (horizontal1.getOrigin().x() == horizontal2.getEnd().x()) {
            anglesAre90 = true;
        }

        if (sidesAreNotEqual && anglesAre90) {
            return true;
        }

        return false;
    }

    private boolean isParallelogram(ArrayList<Coordinate> coordinates) {

        if (coordinates.size() != 4) {
            return false;
        }

        Face horizontal1 = new Face(coordinates.get(0), coordinates.get(1));
        Face horizontal2 = new Face(coordinates.get(2), coordinates.get(3));

        Face vertical1 = new Face(coordinates.get(1), coordinates.get(2));
        Face vertical2 = new Face(coordinates.get(3), coordinates.get(0));

        boolean isUniform = false;
        boolean anglesAre90 = false;

        if (vertical1.getHeight() == vertical2.getHeight() && horizontal1.getLength() == horizontal1.getLength()) {
            isUniform = true;
        }

        if (horizontal1.getOrigin().x() == horizontal2.getEnd().x()) {
            anglesAre90 = true;
        }

        if (isUniform && !anglesAre90) {
            return true;
        }

        return false;
    }

    private boolean isPyramid(ArrayList<Coordinate> coordinates) {

        if (coordinates.size() != 5) {
            return false;
        }

        // Pyramid cannot have more than one point
        int cordsInX = 0;
        int cordsInY = 0;
        int cordsInZ = 0;

        for (Coordinate coordinate : coordinates) {
            if (coordinate.x() != 0) {
                cordsInX++;
            }
            if (coordinate.y() != 0) {
                cordsInY++;
            }
            if (coordinate.z() != 0) {
                cordsInZ++;
            }
        }

        boolean pointIsInX = false;
        boolean pointIsInY = false;
        boolean pointIsInZ = false;

        if (cordsInX < cordsInY && cordsInX < cordsInZ) {
            pointIsInX = true;
        }
        if (cordsInY < cordsInX && cordsInY < cordsInZ) {
            pointIsInY = true;
        }
        if (cordsInZ < cordsInY && cordsInZ < cordsInX) {
            pointIsInZ = true;
        }
        
        //Check for misshaped pyramid
        if (!pointIsInX && !pointIsInY && !pointIsInZ ) {
            return false;
        }

        Coordinate tipOfPyramid = null;
        //Find the coordinate that is the top of the pyramid
        if (pointIsInZ) {
            for (Coordinate coordinate : coordinates) {
                if (coordinate.z() != 0) {
                    tipOfPyramid = coordinate;
                }
            }
        }


        coordinates.remove(tipOfPyramid);

        //Check if remaining coordinates form a square or rectangle
        if(isSquare(coordinates) || isRectangle(coordinates)) {
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
