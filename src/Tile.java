public class Tile {
    Tile above;
    Tile right;
    Tile left;
    Tile below;

    boolean isTileLeft =    this.left != null;
    boolean isTileRight =   this.right != null;
    boolean isTileAbove =      this.above != null;
    boolean isTileBelow =    this.below != null;

    Tile getLeft()
    {
        return this.left;
    }

    Tile getRight()
    {
        return this.right;
    }

    Tile getBelow()
    {
        return this.below;
    }

    Tile getAbove()
    {
        return this.above;
    }

    Tile(){
        this.above = null;
        this.below = null;
        this.right = null;
        this.left = null;
    }



    void show(){
        System.out.println("I have a tile left: " + Boolean.toString(isTileLeft));

        System.out.println("I have a tile right: "+ Boolean.toString(isTileRight));

        System.out.println("I have a tile above: "+ Boolean.toString(isTileAbove));

        System.out.println("I have a tile below: "+ Boolean.toString(isTileBelow));


    }
}