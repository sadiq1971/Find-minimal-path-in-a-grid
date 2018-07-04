package com.sadiq;


import java.util.Random;
import java.util.Scanner;

public class Node extends CalculateHFunction{
    int[][] grid;
    int row;
    int column;
    float heureisticValue;
    int depth;
    float totalCost;
    String id;
    Node parent;
    Point currentPoint;
    boolean isValid;

    public float calculateHeureisticValue(Point currentPoint, Point destination) {

        return eucledian(currentPoint,destination);
    }


    public Point getCurrentPoint() {
        return currentPoint;
    }

    public void setCurrentPoint(Point currentPoint) {
        this.currentPoint = currentPoint;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setHeureisticValue(float heureisticValue) {
        this.heureisticValue = heureisticValue;
    }

    public float getHeureisticValue() {
        return heureisticValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String calculateId(){
        id="";
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                id = id.concat(String.valueOf(this.grid[i][j]));
            }
        }
        this.id = id;
        return id;
    }

    public Node(int row, int column){
        this.row = row;
        this.column =column;
        grid = new int[row][column];
    }

    public void inputElement(){
        Scanner sc = new Scanner(System.in);
        //System.out.println("Please input the elements of the grid");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nInput taken successfully");

    }

    public void printGrid(){

        String mark = "____";
        for (int i = 0; i < column; i++) {
            System.out.print(" " + mark);
        }

        System.out.println();

        for (int i = 0; i < row; i++) {
            System.out.print("|");
            for (int j = 0; j < column; j++) {

                if(grid[i][j] == -2){
                    System.out.print("_00_");
                }

                else if(grid[i][j]!=-1){
                    System.out.print("____");
                }

                else {
                    System.out.print("_bb_");

                }

                //System.out.print(grid[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }



        System.out.println();
        System.out.println();
    }



    Node move(Move move){
        Node child = new Node(this.row, this.column);

        for (int i = 0; i < child.grid.length; i++) {
            for (int j = 0; j < child.grid[i].length; j++) {
                child.grid[i][j] = this.grid[i][j];
            }
        }

       // child.printGrid();
        Point p = this.getCurrentPoint();
        Point des = null;


        switch (move){
            case UP: {

                des = new Point(p.x - 1, p.y);
                break;
            }
            case DOWN:{
                des = new Point(p.x + 1, p.y);
                break;
            }

            case LEFT:{
                des = new Point(p.x, p.y-1);
                break;
            }
            case RIGHT: {
                des = new Point(p.x, p.y + 1);
                break;
            }
            case LU:{
                des = new Point(p.x - 1, p.y -1);
                break;
            }
            case LB: {
                des = new Point(p.x + 1, p.y-1);
                break;
            }
            case RU:{
                des = new Point(p.x -1 , p.y+1);
                break;

            }
            case RB: {
                des = new Point(p.x+1, p.y + 1);
                break;
            }

        }

        if(des.x < 0 || des.x >= this.row|| des.y >= this.column || des.y < 0){
            child.isValid = false;
            //System.out.println("h1");
            return child;

        }
        if(this.grid[des.x][des.y] == -1){
            child.isValid = false;
            return child;
           // System.out.println("h2");

        }

        else {
            child.isValid = true;
            child.grid[des.x][des.y] = -1;
            child.setCurrentPoint(des);
            //child.printGrid();
        }

        return child;

    }

    boolean isSame(Node node){
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                //System.out.println("this: " + this.grid[i][j] +"    new: "+ node.grid[i][j]);
                if(this.grid[i][j] != node.grid[i][j]){
                    return false;
                }
            }
        }
        return true;
    }


    public Node generateValidRandomGrid(){
        Node temp = this;
        Scanner sc = new Scanner(System.in);

        System.out.println("Probability?: ");
        int p = sc.nextInt();
        for (int i = 0; i < temp.row; i++) {
            for (int j = 0; j < temp.column; j++) {
                Random r = new Random();
                int a = r.nextInt(9);
                if(a < p){
                    temp.grid[i][j] = -1;
                }
                else {
                    temp.grid[i][j] = 0;
                }
            }
        }
        return temp;
    }
}
