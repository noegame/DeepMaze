/**
 * {@code @Author} : Noé Game
 */

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello and welcome!");

        Maze MyMaze = new Maze();

        // Creation Matrix
        int[][] matrix = {
                { 4, 10,  8, 0,  0},
                { 0,  0, 15,  0,  0},
                { 0,  0, 15,  0,  0},
                { 0, 15, 15,  0,  0},
                { 0,  0,  0,  0,  0}
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


        // Create the Maze
        MyMaze.start = MyMaze.buildMaze(MyMaze.start, matrix, marks, 0 ,0);

        // Find original creation matrix from maze topology
        mazeRepresentation = MyMaze.getMazeRepresentation(MyMaze.start, 0, 0, 3, 3, mazeRepresentation);

        // Print original creation matrix
        for (int i=0; i<5; i++)
        {
            for (int j=0; j<5; j++)
            {
                System.out.print(mazeRepresentation[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        MyMaze.start.show();
    }
}