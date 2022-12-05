package shapes;

import java.util.ArrayList;

public class ShapeIdentifier {
    
    public String identify (ArrayList<Coordinate> coordinates) {
        if (coordinates.isEmpty()) {
            return "None";
        }
        
        if (coordinates.size() == 1) {
            return "Dot";
        }

        if (coordinates.size() == 2) {
            return "Line";
        }

        return "None";
    }


}
