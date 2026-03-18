public class TestMaze {

    public static void main(String args[]){

    }

    {


}
    Maze MyMaze = new Maze();

    // Creation Matrix
    int[][] matrix = {
            {4, 10, 8, 0, 0},
            {0, 0, 15, 0, 0},
            {0, 0, 15, 0, 0},
            {0, 15, 15, 0, 0},
            {0, 0, 0, 0, 0}
    };

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



    // Print original creation matrix
    boolean sontIdentiques = true;

    // Vérification des dimensions
        if (matrix.length != mazeRepresentation.length || matrix[0].length != matrice2[0].length) {
        sontIdentiques = false;
    } else {
        // Comparaison élément par élément
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrice2[i][j]) {
                    sontIdentiques = false;
                    break;
                }
            }
            if (!sontIdentiques) break;
        }
    }


}






