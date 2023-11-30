/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package recursionproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author ajaym
 */
public class RecursionProject {
    
    private static String filePath = "src\\recursionproject\\";

    public static void main(String[] args) throws FileNotFoundException {
  
       Scanner scan = new Scanner(System.in);
       System.out.println("Enter the name of the maze file: ");
       String fileName = scan.nextLine();
        
       Maze maze = new Maze(filePath + fileName);

 


    }
    
}
