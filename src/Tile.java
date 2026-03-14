public class Tile {
    Tile up;
    Tile right;
    Tile left;
    Tile bottom;

    Tile getLeft()
    {
        return this.left;
    }

    Tile getRight()
    {
        return this.right;
    }

    Tile getBottom()
    {
        return this.bottom;
    }

    Tile getUp()
    {
        return this.up;
    }

    Tile(){
        this.up = null;
        this.bottom = null;
        this.right = null;
        this.left = null;
    }
}