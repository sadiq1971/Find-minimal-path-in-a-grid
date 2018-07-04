package com.sadiq;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.function.BiConsumer;


public class Main {



    public static void main(String[] args) {
       // System.out.println("hellow world");

        /*System.out.println("Given Grid:");

        Node sNode = new Node(3,3);
        sNode.inputElement();
        sNode.printGrid();*/
        Scanner sc = new Scanner(System.in);


        System.out.print("Number of Row : ");
        int row = sc.nextInt();

        System.out.print("Number of Coloumn: ");
        int column = sc.nextInt();


        System.out.println("Would you like to input the grid(y) or" +
                " like to generate Random Puzzle(n)   ?");
        System.out.println("Please press 'y' or 'n':");

        String press = sc.next();
        System.out.println(press);

        Node sNode = new Node(row,column);

        if(press.equals("y")){
            System.out.println("Input the element");
            System.out.println("---------------------------------");
            sNode.inputElement();
            sNode.printGrid();
        }
        else
        {
            System.out.println("Generating Random Grid");
            System.out.println("---------------------------------");
            sNode = sNode.generateValidRandomGrid();
            System.out.println("Grid generated successfully");
            sNode.printGrid();


        }

        System.out.println("Start point?");
        Point p1 = new Point(sc.nextInt(), sc.nextInt());

        System.out.println("End point?");
        Point p2 = new Point(sc.nextInt(), sc.nextInt());

        System.out.println("Finding Solution");

        sNode.currentPoint = p1;
        HashMap<String, Node> visited = Search.Astar(sNode, p2);
        String fkey = "none";

        int tNode=0;
        for (String key: visited.keySet()) {
            if(Point.isSame(visited.get(key).currentPoint, p2)){
                fkey = key;
                tNode++;
            }
        }

        System.out.println("Total Node visited : "+tNode);

        if (visited.containsKey(fkey)) {
            Node fNode = visited.get(fkey);
            Node temp = visited.get(fNode.calculateId());
            ArrayList<Node> v = new ArrayList<>();
            v.add(fNode);


            while (true) {
                Node parent = temp.getParent();
                if (parent == null) {
                    break;
                }
               // parent.printGrid();
                v.add(parent);
                String pid = parent.getId();
                temp = visited.get(pid);
            }

            Node n = sNode;
            for (int i = v.size()-1; i >= 0; i--) {
                //v.get(i).printGrid();
                n.grid[v.get(i).currentPoint.x][v.get(i).currentPoint.y] = -2;
            }
            n.printGrid();

            /*if (row == 4 && column ==4) {


              /**  try {
                    for (UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (Exception e) {
                    // If Nimbus is not available, you can set the GUI to another look and feel.
                }*/

               /* App app = new App(v);
                JFrame frame = new JFrame("15 PUZZLE");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(app.panel1);
                frame.pack();
                frame.setVisible(true);*/


          //  }


        }
        else {
            System.out.println("No solution found");
        }

    }
}
