package boardgame;

public class Position {
    private int row;
    private int collumn;

    public Position(int row, int collumn) {
        this.row = row;
        this.collumn = collumn;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCollum() {
        return collumn;
    }

    public void setCollum(int collum) {
        this.collumn = collum;
    }
    @Override
    public String toString(){
        return row + ", " + collumn;
    }

}
