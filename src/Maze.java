package assignment07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Maze {

    private int numRows;
    private int numCols;
    private Node start;
    private Node goal;
    private Node[][] maze;

    /**
     * Constructs a maze (from a file.  Places Nodes where there are whitespaces within the maze boundaries
     * Also sets the start and goal node, along with setting the number of columns and number of rows from the two ints in first line of file (see specifications)
     *
     * Also sets the Node pointers to allow for the pathfinding.
     *
     * @param filename as a string.  See Pathfinder class for file format requirements
     * @throws FileNotFoundException
     */
    public Maze(String filename) throws FileNotFoundException {


        Scanner sc = new Scanner(new File(filename));

        //build the maze
        numRows = sc.nextInt();
        numCols = sc.nextInt();
        maze = new Node[numRows][numCols];

//        fill the maze
        int rowCount = -1;
        while (sc.hasNextLine()) {

            char[] line = sc.nextLine().toCharArray();
            for (int i = 0; i < line.length; i++) {

                if (line[i] == 'S') {

                    //make a node and set it as start
                    start = new Node('S');
                    maze[rowCount][i] = start;
                } else if (line[i] == 'G') {

                    //make a node and set it as goal
                    goal = new Node('G');
                    maze[rowCount][i] = goal;
                } else if (line[i] == 'X') {

                    //this is a wall
                    maze[rowCount][i] = null;
                } else {

                    //this is a blank space so it's a node
                    maze[rowCount][i] = new Node(' ');
                }
            }
            rowCount++;
        }

        setNodeNeighbors();

        if (start == null || goal == null) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Helper method to set each Node's neighbor pointers.  Note walls are represented as null.
     */
    private void setNodeNeighbors() {

        for (int i = 1; i < numRows - 1; i++) {
            for (int j = 1; j < numCols - 1; j++) {

                if (maze[i][j] == null)
                    continue;

                if (maze[i + 1][j] != null)
                    maze[i][j].setDownNode(maze[i + 1][j]);

                if (maze[i - 1][j] != null)
                    maze[i][j].setUpNode(maze[i - 1][j]);

                if (maze[i][j - 1] != null)
                    maze[i][j].setLeftNode(maze[i][j - 1]);

                if (maze[i][j + 1] != null)
                    maze[i][j].setRightNode(maze[i][j + 1]);
            }
        }
    }

    /**
     * Traverses maze in a breadth-first search.  Guarantees the shortest path will be found if it exists.
     */
    public void breadthFirstSearch() {

        LinkedList<Node> queue = new LinkedList<Node>();
        start.setHasVisited(true);
        queue.addFirst(start);
        while (queue.size() > 0) {

            Node current = queue.removeFirst();


            if (current.equals(goal)) {

                while (current.getCameFrom() != null) {

                    current.setPath();
                    current = current.getCameFrom();
                }
                break;
            }

            if (current.getUpNode() != null && !current.getUpNode().isHasVisited()) {

                current.getUpNode().setCameFrom(current);
                current.getUpNode().setHasVisited(true);
                queue.addLast(current.getUpNode());
            }

            if (current.getDownNode() != null && !current.getDownNode().isHasVisited()) {

                current.getDownNode().setCameFrom(current);
                current.getDownNode().setHasVisited(true);
                queue.addLast(current.getDownNode());
            }

            if (current.getLeftNode() != null && !current.getLeftNode().isHasVisited()) {

                current.getLeftNode().setCameFrom(current);
                current.getLeftNode().setHasVisited(true);
                queue.addLast(current.getLeftNode());
            }

            if (current.getRightNode() != null && !current.getRightNode().isHasVisited()) {

                current.getRightNode().setCameFrom(current);
                current.getRightNode().setHasVisited(true);
                queue.addLast(current.getRightNode());
            }
        }
    }

    /**
     * generates a text file with the shortest path notated with '.' from start to goal.  It is in the same format as the input file
     * @param outputFile
     * @throws FileNotFoundException
     */
    public void mazeSolutionLine(String outputFile) throws FileNotFoundException {


        try (PrintWriter output = new PrintWriter(new File(outputFile))) {

            output.println(numRows + " " + numCols);
            char[] characterLine = new char[numCols];
            for (int i = 0; i < numRows; i++) {

                for (int j = 0; j < numCols; j++) {

                    //This inner loop builds a char array line by line
                    if (maze[i][j] == null) {

                       characterLine[j] = 'X';
                    } else if (maze[i][j].isPath() && maze[i][j] != goal) {

                        characterLine[j] = '.';
                    } else {
                        characterLine[j] = maze[i][j].getAttribute();
                    }
                }
                //outer loop adds each line to the PrintWriter
                output.println(characterLine);
            }
        }
    }
}
