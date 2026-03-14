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
     *   2 = connected up
     *   3 = connected left
     *   4 = connected down
     *   5 = connected right
     *   6 = connected up + down
     *   7 = connected up + left
     *   8 = connected up + right
     *   9 = connected down + left
     *  10 = connected down + right
     *  11 = connected left + right
     *  12 = connected up + down + left
     *  13 = connected up + down + right
     *  14 = connected up + left + right
     *  15 = connected down + left + right
     *  16 = connected up + down + left + right
     *
     * @param tile    The current tile being processed
     * @param matrix  The connection matrix
     * @param marks   Visited matrix (same dimensions as matrix)
     * @param i       Current row index
     * @param j       Current column index
     * @return        The constructed Maze with start set to the first tile visited
     */
    Tile buildMaze(Tile tile, int[][] matrix, boolean[][] marks, int i, int j) {
        if (tile == null) return null;
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return null;
        if (marks[i][j]) return null;

        marks[i][j] = true;

        int val = matrix[i][j];

        boolean connectUp    = val == 2  || val == 6  || val == 7  || val == 8  || val == 12 || val == 13 || val == 14 || val == 16;
        boolean connectDown  = val == 4  || val == 6  || val == 9  || val == 10 || val == 12 || val == 13 || val == 15 || val == 16;
        boolean connectLeft  = val == 3  || val == 7  || val == 9  || val == 11 || val == 12 || val == 14 || val == 15 || val == 16;
        boolean connectRight = val == 5  || val == 8  || val == 10 || val == 11 || val == 13 || val == 14 || val == 15 || val == 16;

        if ((connectUp && i > 0) && (!marks[i - 1][j])) {
            tile.up = new Tile();
            tile = buildMaze(tile.up, matrix, marks, i - 1, j);
        }

        if ((connectDown && i < matrix.length - 1) && (!marks[i + 1][j])) {
            tile.bottom = new Tile();
            tile = buildMaze(tile.bottom, matrix, marks, i + 1, j);
        }

        if ((connectLeft && j > 0) && (!marks[i][j - 1])) {
            tile.left = new Tile();
            tile = buildMaze(tile.left, matrix, marks, i, j - 1);
        }

        if ((connectRight && j < matrix[0].length - 1) && (!marks[i][j + 1])) {
            tile.right = new Tile();
            tile = buildMaze(tile.right, matrix, marks, i, j + 1);
        }
        return tile;
    }

    /**
     * @brief Return a matrix that represent where there is a non null tile in the maze
     * @param tile
     * @param i
     * @param j
     * @param sizeX
     * @param sizeY
     * @param visited Default value should be 0 !!!
     */
    int[][] getMazeRepresentation(Tile tile, int i, int j, int sizeX, int sizeY, int[][] visited){

        boolean isAnUpperTileToVisit   = (tile.up != null)         && (i > 0)             && (visited[i - 1][j] != 0);
        boolean isAnLowerTileToVisit   = (tile.bottom != null)     && (i < sizeY - 1)     && (visited[i + 1][j] != 0);
        boolean isAnLeftTileToVisit    = (tile.left != null)       && (j > 0)             && (visited[i][j - 1] != 0);
        boolean isAnRightTileToVisit   = (tile.right != null)      && (j < sizeX - 1)     && (visited[i][j + 1] != 0);

        boolean isAnUpperTile   = (tile.up != null);
        boolean isAnLowerTile   = (tile.bottom != null);
        boolean isAnLeftTile    = (tile.left != null);
        boolean isAnRightTile   = (tile.right != null);

        boolean is_0   = !isAnUpperTile && !isAnLeftTile && !isAnLowerTile && !isAnRightTile;
        boolean is_1   = false; // Non utilisé (pas de valeur 1 dans la matrice)
        boolean is_2   = isAnUpperTile && !isAnLowerTile && !isAnLeftTile && !isAnRightTile;
        boolean is_3   = !isAnUpperTile && !isAnLowerTile && isAnLeftTile && !isAnRightTile;
        boolean is_4   = !isAnUpperTile && isAnLowerTile && !isAnLeftTile && !isAnRightTile;
        boolean is_5   = !isAnUpperTile && !isAnLowerTile && !isAnLeftTile && isAnRightTile;
        boolean is_6   = isAnUpperTile && isAnLowerTile && !isAnLeftTile && !isAnRightTile;
        boolean is_7   = isAnUpperTile && !isAnLowerTile && isAnLeftTile && !isAnRightTile;
        boolean is_8   = isAnUpperTile && !isAnLowerTile && !isAnLeftTile && isAnRightTile;
        boolean is_9   = !isAnUpperTile && isAnLowerTile && isAnLeftTile && !isAnRightTile;
        boolean is_10  = !isAnUpperTile && isAnLowerTile && !isAnLeftTile && isAnRightTile;
        boolean is_11  = !isAnUpperTile && !isAnLowerTile && isAnLeftTile && isAnRightTile;
        boolean is_12  = isAnUpperTile && isAnLowerTile && isAnLeftTile && !isAnRightTile;
        boolean is_13  = isAnUpperTile && isAnLowerTile && !isAnLeftTile && isAnRightTile;
        boolean is_14  = isAnUpperTile && !isAnLowerTile && isAnLeftTile && isAnRightTile;
        boolean is_15  = !isAnUpperTile && isAnLowerTile && isAnLeftTile && isAnRightTile;
        boolean is_16  = isAnUpperTile && isAnLowerTile && isAnLeftTile && isAnRightTile;

        // STEP 1 : FIND CURRENT TILE NUMBER

        if (is_0){visited[i][j] = 0;}
        if (is_1){visited[i][j] = 1;} // never used
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
        if (is_16){visited[i][j] = 16;}



        // STEP 2 : VISIT NEIGHTBOUR TILE

        if (isAnUpperTileToVisit){
             visited = getMazeRepresentation(tile.up, i - 1, j, sizeX, sizeY, visited);
        }

        if (isAnLowerTileToVisit){
            visited = getMazeRepresentation(tile.bottom, i + 1, j, sizeX, sizeY, visited);
        }

        if (isAnRightTileToVisit){
            visited = getMazeRepresentation(tile.right, i, j + 1, sizeX, sizeY, visited);
        }

        if (isAnLeftTileToVisit){
            visited = getMazeRepresentation(tile.left, i, j - 1, sizeX, sizeY, visited);
        }

        return visited;

    }
}