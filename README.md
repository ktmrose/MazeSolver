# MazeSolver
Solves mazes using breadth-first-search traversal, if a solution exists.  Takes in a maze as a .txt file (see example maze folder for format) and generates a new .txt file with the shortest path indicated with "." if it exists. If the maze is unsolvable, the solution text file will look identical to the input maze file.

The first line of the .txt file should have the number of rows and the number of columns, seperated by a space.
Walls are marked with "X", the start is marked with "S", and the end is marked with "G".  An example is shown below:

7 9
XXXXXXXXX
X       X
XXXX XX X
X       X
X XX XX X
XGX   S X
XXXXXXXXX

When in the proper format, program will output a similar looking text file with the word "Solution" appended to the input file name with the shorest path as shown below:

7 9
XXXXXXXXX
X       X
XXXX XX X
X....   X
X.XX.XX X
XGX ..S X
XXXXXXXXX

# Background
This was a term project completed after a rigorous 5-week Data Structures and Algorithms course and with only about 3 months of total coding experience and no more than 2 months of experience working with Java.

The assignment requirements are below.  No code was provided to us aside from the single method signature the professor used for his autograder. General program structure was alluded to (see below), but the final design and implementation was my own.

# Assignment Requirements
PathFinder class:

Create a class PathFinder in package assignment08, with the following method:

public static void solveMaze(String inputFile, String outputFile)

This method will read a maze from a file with the given input name, and output the solved maze to a file with the given output name. You must use the filenames exactly as is (do not change the directory or path). We will provide the full path to files we want to read/write in our tests. See required specifications below. This method must use a graph and graph pathfinding to solve the problem.

Your program may contain any other methods or classes necessary for your solution (it is recommended you create a separate Graph and Node classes). 
