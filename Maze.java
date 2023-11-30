/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursionproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author ajaym
 */
public class Maze {

    private int rows =0;
    private int coloumns;
    private int numRows;
    private int numColoumns;
    private int endRow;
    private int endColoumn;
    private int x = 0;
    private int y = 0;
    private String grid[][];
    private int feetR = 2;
    private int feetC = 0;
    private int handR = 3;
    private int handC = 0;
    
    


    public Maze(String filename) throws FileNotFoundException {
        
        Scanner scan = new Scanner(new File(filename));
        coloumns = (scan.nextLine().length() + 1) / 2;
        //rows++;
        while(scan.hasNextLine()){
            rows++;
            scan.nextLine();
            }
        System.out.println("Rows " + rows);
        System.out.println("Coloumns " + coloumns);
        
        grid = new String[rows+1][coloumns+1];
        scan.close();
        scan = new Scanner(new File(filename));
        while(scan.hasNextLine()){
            for(int i =0; i < grid.length; i++){
                String[] line = scan.nextLine().split(" ");
                for(int j = 0; j < line.length; j++){
                    grid[i][j] = line[j];
                    System.out.print(line[j]);
                   
                }
                System.out.println();
              
            }
            
        }
        mazeAlgorothm(feetR, feetC, handR, handC, grid);
    
    }
    public void printMaze(String[][] grid, int rows, int coloumns){
        for(int i =0; i < rows; i++){
                for(int j = 0; j < coloumns; j++){
                    System.out.print(grid[i][j]);
                   
                }
                System.out.println();
              
            }
            
        }
    

    
    
    public void mazeAlgorothm(int feetR, int feetC, int handR, int handC, String[][] grid){
        String direction = "null";
        System.out.println("************");
        
        if(grid[feetR][feetC] == "F"){
            System.out.println("You finished the maze!");
            printMaze(grid,13,13);
        }
        else if(grid[feetR][feetC] != "F"){
            if(feetR < handR){
                direction = "East";
        }
            else if(feetR > handR){
                direction = "West";
            }
            else if(feetC > handC){
                direction = "South";
            }
            else if(feetR < handR){
                direction = "North";
            }
            
           grid[feetR][feetC] = "X";
            
           if(direction.equals("East")){
               if(grid[handR][handC] == "."){
                   direction = "South";
                   mazeAlgorothm(feetR+1,feetC,handR+1,handC, grid);
               }
                else if(grid[handR][handC] == "#" && grid[feetR][feetC+1] == "."){
                   mazeAlgorothm(feetR,feetC + 1,handR,handC + 1, grid);
          
               }
               else if(grid[handR][handC] == "#" && grid[feetR][feetC+1] == "#"){
                   direction = "North";
                   mazeAlgorothm(feetR,feetC,handR,handC,grid);
               }
              
           }
           else if(direction == "West"){
                if(grid[handR][handC] == "."){
                    direction = "North";
                   mazeAlgorothm(feetR-1,feetC,handR-1,handC, grid);
                }
                else if(grid[handR][handC] == "#" && grid[feetR][feetC-1] == "."){
                   mazeAlgorothm(feetR,feetC-1,handR,handC-1, grid);
               }
                else if(grid[handR][handC] == "#" && grid[feetR][feetC+1] == "#"){
                   direction = "South";
                   mazeAlgorothm(feetR,feetC,handR,handC,grid);
               }
           }
           else if(direction == "North"){
                if(grid[handR][handC] == "."){
                    direction = "East";
                   mazeAlgorothm(feetR,feetC+1,handR,handC+1, grid);
                }
                else if(grid[handR][handC] == "#" && grid[feetR-1][feetC] == "."){
                   mazeAlgorothm(feetR-1,feetC,handR-1,handC, grid);
                }
                else if(grid[handR][handC] == "#" && grid[feetR][feetC+1] == "#"){
                   direction = "West";
                   mazeAlgorothm(feetR,feetC,handR,handC,grid);
                }
           }
           else if(direction == "South"){
                if(grid[handR][handC] == "."){
                   direction = "West";
                   mazeAlgorothm(feetR,feetC-1,handR,handC-1, grid);
                }
                else if(grid[handR][handC] == "#" && grid[feetR+1][feetC] == "."){
                   mazeAlgorothm(feetR+1,feetC,handR+1,handC, grid);
               }
               else if(grid[handR][handC] == "#" && grid[feetR][feetC+1] == "#"){
                   direction = "East";
                   mazeAlgorothm(feetR,feetC,handR,handC,grid);
               }
           }
           printMaze(grid,rows,coloumns);
        }
    }
}
            
       
    
            


