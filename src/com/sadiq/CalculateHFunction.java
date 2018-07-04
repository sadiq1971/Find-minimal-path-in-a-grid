package com.sadiq;

public class CalculateHFunction extends Distance{

    float heuristicfunc1(int startGrid[][], int finalGrid[][]){
        float hValue = 0;

        for (int i = 0; i < startGrid.length; i++) {
            for (int j = 0; j < startGrid[i].length; j++) {
                if(startGrid[i][j] != 0){
                    if(startGrid[i][j] != finalGrid[i][j]){
                        hValue++;
                    }
                }
            }
        }


        return hValue;
    }

    float eucledian(Point c, Point d){
        float hValue = 0;
        hValue = getSqrtDistance(c, d);

        return hValue;
    }

    float manhattan(Point c, Point d){
        float hValue = 0;
        hValue = getManhattanDistance(c, d);

        return hValue;
    }

    float heuristicfunc4(int startGrid[][], int finalGrid[][]){
        float hValue = 0;

        for (int i = 0; i < startGrid.length; i++) {
            for (int j = 0; j < startGrid[i].length; j++) {
                if(startGrid[i][j] != 0){
                    Point p2 = Point.getPoint(finalGrid, startGrid[i][j]);
                    if(p2.x != i){
                        hValue++;
                    }
                    if(p2.y != j){
                        hValue++;
                    }

                }
            }
        }


        return hValue;
    }
}

