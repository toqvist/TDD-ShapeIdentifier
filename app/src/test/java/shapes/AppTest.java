package shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class AppTest {

    ShapeIdentifier si = new ShapeIdentifier();
    ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
    
    //An empty list should return String "None"
    @Test void emptyListShouldRetunNone () {
        
        assertEquals("None", si.identify(coordinates));
    }

    //A single coordinate should return string "Dot"
    @Test void canIdentifyDot () {

        coordinates.add(new Coordinate(0, 0, 0));
        assertEquals("Dot", si.identify(coordinates));
    }

    //2 coordinates should return string "Line"
    @Test void canIdentifyLinePoints () {

        coordinates.add(new Coordinate(0, 0, 0));
        coordinates.add(new Coordinate(1, 0, 0));
        assertEquals("Line", si.identify(coordinates));
    }

    @Test void lineMustHaveTwoDifferentPoints () {
        coordinates.add(new Coordinate(0, 0, 0));
        coordinates.add(new Coordinate(0, 0, 0));
        assertEquals("Dot", si.identify(coordinates));

        coordinates.get(0).setX(1);
        assertEquals("Line", si.identify(coordinates));
    }

    //3 coordinates should return string "Triangle"
    // @Test void canIdentifyTriangle () {

    //     coordinates.add(new Coordinate(0, 0, 0));
    //     coordinates.add(new Coordinate(1, 0, 0));
    //     assertEquals("Triangle", si.identify(coordinates));
    // }

    //4 equidistanced coordinates with angles of 90° should return string "Square"

    //4 coordinates with angles of 90° and two equal sides that are different
    // from the other two, of which are also equal, should return string "Rectangle"

    //4 coordinates with angles of <90 or >90 should reuturn string "Parallelogram"

    //Having two of either X, Y or Z coordinates should return "2D"
    
    //Having all three coordinates XYZ should return "3D"

    //A 2D square + a single point in 3rd space should return string "Pyramid"
    
    //8 coordinates with 6 equal faces, with 3 sides meeting at each vertex should return string "Cube"
    
    //4 coordinates in 3D space should return string "Rectangular Prism"

    //A 3D shape that is unrecognized by the program reuturns string "3D Shape"

    //Interface should only accept an X, Y or Z coordinate
    // @Test void identifierAcceptsOnlyXYZ () {
    //     assertEquals("Only X, Y and Z coordinates supported.", si.identify(coordinates));
    // }

}
