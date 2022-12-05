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

}
