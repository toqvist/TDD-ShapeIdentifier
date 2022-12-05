package shapes;

public class Coordinate {
    private float x;
    private float y;
    private float z;

    public Coordinate (float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float x () {
        return this.x;
    }

    public float y () {
        return this.y;
    }

    public float z () {
        return this.z;
    }
}
