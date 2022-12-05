package shapes;

public class Face {
    
    Coordinate origin;
    Coordinate end;

    public Face (Coordinate origin, Coordinate end) {
        this.origin  = origin;
        this.end = end;
    }

    public float getLength () {
        float length = origin.x() - end.x();
        if (length < 0) {
            length *= -1;
        }
        return length;
    }
    
    public float getHeight () {
        float height = origin.y() - end.y();
        if (height < 0) {
            height *= -1;
        }
        return height;
    }

    public float getDepth () {
        float depth = origin.z() - end.z();
        if (depth < 0) {
            depth *= -1;
        }
        return depth;
    }
}
