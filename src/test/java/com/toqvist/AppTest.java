package com.toqvist;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest {
    
    //Should only accept an X, Y or Z coordinate
    
    //A single coordinate should return string "Dot"

    //2 coordinates should return string "Line"

    //3 coordinates should return string "Triangle"

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

    


}
