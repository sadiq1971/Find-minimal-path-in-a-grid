package com.sadiq;

public class Point {
    public int x;
    public int y;
    public Point(int x , int y){
        this.x = x;
        this.y = y;
    }

    public  static Point getPoint(int grid[][], int value){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == value){
                    return new Point(i, j);
                }
            }
        }
        return null;
    }


    public static boolean isSame(Point p1, Point p2){
        if(p1.x ==p2.x && p1.y == p2.y ){
            return true;
        }

        else return false;
    }

}
