/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mazesolver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;


/**
 *
 * @author ashle
 */
public class MazeSolver extends JFrame {
    /**
     * I will use two dimensional array to represented
     * the maze graph
     * 
     * other conventions
     * 
     * maze[row][col]
     * values 0= not-visited node
     * 1= wall [blocked]
     * 2= visited node
     * 9= target node
     * so lets take the maze array code from internet
     * 
     * in this implementation border must be filled with '1' to avoid array
     * indexOfbound
     * 
     */
    private int [][] maze = 
{ {1,1,1,1,1,1,1,1,1,1,1,1,1},
  {1,0,1,0,1,0,1,0,0,0,0,0,1},
  {1,0,1,0,0,0,1,0,1,1,1,0,1},
  {1,0,0,0,1,1,1,0,0,0,0,0,1},
  {1,0,1,0,0,0,0,0,1,1,1,0,1},
  {1,0,1,0,1,1,1,0,1,0,0,0,1},
  {1,0,1,0,1,0,0,0,1,1,1,0,1},// lets define the target  node as "9" at potion (11, 8)
  {1,0,1,0,1,1,1,0,1,0,1,0,1},
  {1,0,0,0,0,0,0,0,0,0,1,9,1},
  {1,1,1,1,1,1,1,1,1,1,1,1,1}

};
    
    private List<Integer> path = new ArrayList<Integer>();
    
    public MazeSolver(){
        setTitle("Maze Solver");
        setSize(640, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // let's test the depth first
        // checking the first and the last item of 
        // path list
        DepthFirst.searchpath(maze, 1, 1, path);
        System.out.println(path);
        }
    
    @Override
    public void paint(Graphics g){
       g.translate(50, 50);
        //let's draw the maze row;
        for(int row =0; row<maze.length; row++){
            for(int col=0; col<maze[0].length; col++){
                Color color;
                switch (maze[row][col]){
                    case 1: color = Color.BLACK; break;
                    case 9: color = Color.RED; break;
                    default: color = Color.WHITE;
                }
                g.setColor(color);
                g.fillRect(30*col, 30*row, 30, 30);
                g.setColor(Color.RED);
                g.drawRect(30*col, 30*row, 30, 30);
            }
          }
          for(int i =0; i<path.size(); i+=2){
              int pathx= path.get(i);
              int pathy = path.get(i+1); 
              
              System.out.println("X coordinates"+pathx);
              System.out.println("Y coordinates"+pathy);
              
              g.setColor(Color.GREEN);
              g.fillRect(30*pathx, 30*pathy, 30, 30);
          } 
       
        }
    
    public static void main(String[]args){
                MazeSolver mazesolver = new MazeSolver();
                mazesolver.setVisible(true);
            }}
    
    // lets see if it is working ....
    

