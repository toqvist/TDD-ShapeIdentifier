package shapes;

public class Coordinate {
    private float xCord;
    private float yCord;
    private float zCord;

    public Coordinate (float x, float y, float z) {
        this.xCord = x;
        this.yCord = y;
        this.zCord = z;
    }

    public float x () {
        return this.xCord;
    }

    public float y () {
        return this.yCord;
    }

    public float z () {
        return this.zCord;
    }

    public float setX (float newX) {
        return this.xCord = newX;
    }

    public float setY (float newY) {
        return this.yCord = newY;
    }

    public float setZ (float newZ) {
        return this.zCord = newZ;
    }
}
