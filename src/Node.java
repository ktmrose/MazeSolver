package assignment07;

import java.util.ArrayList;

public class Node {
    /**
     * Below is a bunch of getters and setters for the member variables which includes:
     * References to the neighbor nodes (downNode, upNode, leftNode, rightNode)
     * Flags for nodes that have been visited and/or is part of the path solution
     * Reference to the Node that came before the node when traversing path.
     * Also contains attribute that stores the corresponding character that codes for the node (is it whitespace or S or G) to help with constructing solution maze
     * @return
     */

    public Node getCameFrom() {
        return cameFrom;
    }

    public void setCameFrom(Node cameFrom) {
        this.cameFrom = cameFrom;
    }

    public boolean isPath() {
        return isPath;
    }

    public void setPath() {
        isPath = true;
    }

    public Node getUpNode() {
        return upNode;
    }

    public void setUpNode(Node upNode) {
        this.upNode = upNode;
    }

    public Node getDownNode() {
        return downNode;
    }
    public void setDownNode(Node downNode) {
        this.downNode = downNode;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public boolean isHasVisited() {
        return hasVisited;
    }

    public void setHasVisited(boolean hasVisited) {
        this.hasVisited = hasVisited;
    }

    public char getAttribute() {
        return attribute;
    }

    private boolean hasVisited;
    private Node cameFrom;
    private boolean isPath;
    private char attribute;
    private Node upNode;
    private Node downNode;
    private Node leftNode;
    private Node rightNode;

    public Node(char symbol){

        isPath = false;
        hasVisited = false;
        attribute = symbol;
    }

}
