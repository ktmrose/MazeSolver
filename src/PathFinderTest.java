package assignment07;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PathFinderTest {

    File bigMazeSol = new File("bigMazeSol.txt");
    File classicSol = new File("classicSol.txt");

    private static String toString(String filename) throws FileNotFoundException {

        String fileAsString = "";
        Scanner sc = new Scanner(new File(filename));

        while (sc.hasNextLine()) {

            fileAsString += sc.nextLine();
        }
        return fileAsString;
    }

    @Test
    void solveMaze() throws FileNotFoundException {

        ///add a bunch of assertEquals calling each maze solution and toString
        assertEquals(toString("classicSol.txt"), toString("classicSolution.txt"));
        assertEquals(toString("bigMazeSol.txt"), toString("bigMazeSolution.txt"));
        assertEquals(toString("tinyMazeSol.txt"), toString("tinyMazeSolution.txt"));
        assertEquals(toString("mediumMazeSol.txt"), toString("mediumMazeSolution.txt"));
        assertEquals(toString("straightSol.txt"), toString("straightSolution.txt"));
        assertEquals(toString("unsolvableSol.txt"), toString("unsolvableSolution.txt"));
        assertEquals(toString("turnSol.txt"), toString("turnSolution.txt"));

        //Below tests failed because my BFS found a slightly different but still valid shortest path to the goal
        assertEquals(toString("demoMazeSol.txt"), toString("demoMazeSolution.txt"));
        assertEquals(toString("randomMazeSol.txt"), toString("randomMazeSolution.txt"));
        assertEquals(toString("tinyOpenSol.txt"), toString("tinyOpenSolution.txt"));
    }
}