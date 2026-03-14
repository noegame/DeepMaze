public class Maze {
    Tile start;     // First tile of the maze
    int x = 0;      // x coord of the first tile
    int y = 0;      // y coord of the first tile


    public Maze() {
        this.start = new Tile();
    }

    /**
     * Builds a maze from a matrix of connection values.
     *
     * Matrix values:
     *   0 = no connections
     *   1 = connected above
     *   2 = connected left
     *   3 = connected below
     *   4 = connected right
     *   5 = connected above + below
     *   6 = connected above + left
     *   7 = connected above + right
     *   8 = connected below + left
     *   9 = connected below + right
     *  10 = connected left + right
     *  11 = connected above + below + left
     *  12 = connected above + below + right
     *  13 = connected above + left + right
     *  14 = connected below + left + right
     *  15 = connected above + below + left + right
     *
     * @param tile    The current tile being processed
     * @param matrix  The connection matrix
     * @param marks   Visited matrix (same dimensions as matrix)
     * @param i       Current row index
     * @param j       Current column index
     * @return        The constructed Maze with start set to the first tile visited
     */
    Tile buildMaze(Tile tile, int[][] matrix, boolean[][] marks, int i, int j) {

        marks[i][j] = true;

        int val = matrix[i][j];

        boolean noConnection    = val == 0;
        boolean connectAbove    = val == 1  || val == 5  || val == 6  || val == 7  || val == 11 || val == 12 || val == 13 || val == 15;
        boolean connectBelow    = val == 3  || val == 5  || val == 8  || val == 9  || val == 11 || val == 12 || val == 14 || val == 15;
        boolean connectLeft     = val == 2  || val == 6  || val == 8  || val == 10 || val == 11 || val == 13 || val == 14 || val == 15;
        boolean connectRight    = val == 4  || val == 7  || val == 9  || val == 10 || val == 12 || val == 13 || val == 14 || val == 15;

        if (noConnection) {
            return tile;
        }

        if ((connectAbove && i > 0) && (!marks[i - 1][j])) {
            tile.above = new Tile();
            tile.above.below = tile;
            buildMaze(tile.above, matrix, marks, i - 1, j);
            //System.out.println(i + ", " + j + ": I have a connection above !");
        }

        if ((connectBelow && i < matrix.length - 1) && (!marks[i + 1][j])) {
            tile.below = new Tile();
            tile.below.above = tile;
            buildMaze(tile.below, matrix, marks, i + 1, j);
            //System.out.println(i + ", " + j + ": I have a connection below !");
        }

        if ((connectLeft && j > 0) && (!marks[i][j - 1])) {
            tile.left = new Tile();
            tile.left.right = tile;
            buildMaze(tile.left, matrix, marks, i, j - 1);
            //System.out.println(i + ", " + j + ": I have a left connection !");
        }

        if ((connectRight && j < matrix[0].length - 1) && (!marks[i][j + 1])) {
            tile.right = new Tile();
            tile.right.left = tile;
            buildMaze(tile.right, matrix, marks, i, j + 1);
            //System.out.println(i + ", " + j + ": I have a right connection !");
        }
        return tile;
    }

    /**
     * @brief           Return a matrix that represent where there is a non null tile in the maze
     * @param tile      The current tile being processed
     * @param i         Current row index
     * @param j         Current column index
     * @param sizeX     Width of the maze
     * @param sizeY     Height of the maze
     * @param visited   Matrix to track visited tiles
     */
    int[][] getMazeRepresentation(Tile tile, int i, int j, int sizeX, int sizeY, int[][] visited){

        boolean isATileAbove   = (tile.above != null);
        boolean isATileBelow   = (tile.below != null);
        boolean isALeftTile    = (tile.left != null);
        boolean isARightTile   = (tile.right != null);
        
        boolean isATileAboveToVisit   = isATileAbove      && (i > 0)             && (visited[i - 1][j] == 0);
        boolean isATileBelowToVisit   = isATileBelow      && (i < sizeY - 1)     && (visited[i + 1][j] == 0);
        boolean isALeftTileToVisit    = isALeftTile       && (j > 0)             && (visited[i][j - 1] == 0);
        boolean isARightTileToVisit   = isARightTile      && (j < sizeX - 1)     && (visited[i][j + 1] == 0);

        boolean is_0   = !isATileAbove && !isALeftTile && !isATileBelow && !isARightTile;
        boolean is_1   = isATileAbove && !isATileBelow && !isALeftTile && !isARightTile;
        boolean is_2   = !isATileAbove && !isATileBelow && isALeftTile && !isARightTile;
        boolean is_3   = !isATileAbove && isATileBelow && !isALeftTile && !isARightTile;
        boolean is_4   = !isATileAbove && !isATileBelow && !isALeftTile && isARightTile;
        boolean is_5   = isATileAbove && isATileBelow && !isALeftTile && !isARightTile;
        boolean is_6   = isATileAbove && !isATileBelow && isALeftTile && !isARightTile;
        boolean is_7   = isATileAbove && !isATileBelow && !isALeftTile && isARightTile;
        boolean is_8   = !isATileAbove && isATileBelow && isALeftTile && !isARightTile;
        boolean is_9   = !isATileAbove && isATileBelow && !isALeftTile && isARightTile;
        boolean is_10  = !isATileAbove && !isATileBelow && isALeftTile && isARightTile;
        boolean is_11  = isATileAbove && isATileBelow && isALeftTile && !isARightTile;
        boolean is_12  = isATileAbove && isATileBelow && !isALeftTile && isARightTile;
        boolean is_13  = isATileAbove && !isATileBelow && isALeftTile && isARightTile;
        boolean is_14  = !isATileAbove && isATileBelow && isALeftTile && isARightTile;
        boolean is_15  = isATileAbove && isATileBelow && isALeftTile && isARightTile;

        // STEP 1 : FIND CURRENT TILE NUMBER

        if (is_0){visited[i][j] = 0;}
        if (is_1){visited[i][j] = 1;}
        if (is_2){visited[i][j] = 2;}
        if (is_3){visited[i][j] = 3;}
        if (is_4){visited[i][j] = 4;}
        if (is_5){visited[i][j] = 5;}
        if (is_6){visited[i][j] = 6;}
        if (is_7){visited[i][j] = 7;}
        if (is_8){visited[i][j] = 8;}
        if (is_9){visited[i][j] = 9;}
        if (is_10){visited[i][j] = 10;}
        if (is_11){visited[i][j] = 11;}
        if (is_12){visited[i][j] = 12;}
        if (is_13){visited[i][j] = 13;}
        if (is_14){visited[i][j] = 14;}
        if (is_15){visited[i][j] = 15;}

        //System.out.println("Visited tile at (" + i + ", " + j + ") with value: " + visited[i][j]);

        // STEP 2 : VISIT NEIGHTBOUR TILE

        if (isATileAboveToVisit){
             visited = getMazeRepresentation(tile.above, i - 1, j, sizeX, sizeY, visited);
        }

        if (isATileBelowToVisit){
            visited = getMazeRepresentation(tile.below, i + 1, j, sizeX, sizeY, visited);
        }

        if (isARightTileToVisit){
            visited = getMazeRepresentation(tile.right, i, j + 1, sizeX, sizeY, visited);
        }

        if (isALeftTileToVisit){
            visited = getMazeRepresentation(tile.left, i, j - 1, sizeX, sizeY, visited);
        }

        return visited;

    }
}