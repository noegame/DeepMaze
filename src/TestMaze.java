public class TestMaze {

    public static void main(String args[]) {

        test1();

    }


    static void testMatrix(int[][] creationMatrix) {

        Maze MyMaze = new Maze();

        boolean[][] marks = {
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };

        int[][] mazeRepresentation = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        // On a construit le labyrinthe.
        MyMaze.start = MyMaze.buildMaze(MyMaze.start, creationMatrix, marks, 0, 0);

        // Find original creation matrix from maze topology
        mazeRepresentation = MyMaze.getMazeRepresentation(MyMaze.start, 0, 0, 5, 5, mazeRepresentation);

        System.out.println("\nMatrice de création");
        MyMaze.printMatrix(creationMatrix);
        System.out.println("\nMatrice retrouvé");
        MyMaze.printMatrix(mazeRepresentation);

        boolean equal = true;
        for (int i = 0; i < creationMatrix.length; i++) {
            for (int j = 0; j < creationMatrix[0].length; j++) {
                if (creationMatrix[i][j] != mazeRepresentation[i][j]) {
                    equal = false;
                    System.out.println("FAIL    Matrice de création non retrouvé depuis le labyrinthe");
                    return;
                }
            }
        }
        System.out.println("PASS    Matrice de création bien retrouvé depuis le labyrinthe");
    }

    static void test1() {

        int[][] creationMatrix = {
                {4, 10, 8, 0, 0},
                {0, 0, 5, 0, 0},
                {0, 0, 5, 0, 0},
                {0, 4, 6, 0, 0},
                {0, 0, 0, 0, 0}
        };

        testMatrix(creationMatrix);
    }
}

