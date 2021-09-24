abstract public class Relationship {

    protected boolean matrix[][];


    public Relationship() {
    }

    public Relationship(boolean[][] matrix) {
        this.matrix = matrix;
    }

    abstract public String outMatrix();
}
