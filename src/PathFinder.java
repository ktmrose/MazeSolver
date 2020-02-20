package assignment07;

import java.io.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class PathFinder {

    /**
     * This is the driver method
     *
     * Takes in a file name as a string, constructs a Maze object, finds the shortest path if it exists
     * outputs a text file with the shortest path denotes as "." otherwise
     *
     * maze needs to have following format details
     * First line of text file contain the number of rows and the number of columns separated by whitespace
     * Second line is start of maze.
     * maze is a regular rectangle
     * walls are denoted with 'X' start is denoted as 'S' and end/goal is denoted as 'G'
     * Example mazes are in the github repo.
     *
     * @param inputFile path of the maze text file
     * @throws IOException
     */

    public static void solveMaze(String inputFile) throws IOException {

        //build the maze from the file
        Maze maze = new Maze(inputFile);

        //find the path
        maze.breadthFirstSearch();

        //automatically generates the output file name.
        String[] splitFile = inputFile.split("\\.");

        String outputFile = splitFile[0] + "Solution.txt";

        maze.mazeSolutionLine(outputFile);

    }

    public static void main(String[] args) throws IOException {

        solveMaze("mediumMaze.txt");
    }

}


