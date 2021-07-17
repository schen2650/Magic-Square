/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magicsquaredetector;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Sarah
 */
public class Main {
    
    public static void main(String[] args) {
        //creates console scanner for file name input
        Scanner s = new Scanner(System.in);
        int size = 0;
        System.out.println("Please enter a file name:");
        File f = new File(s.nextLine());
        //try block to check if file exists
        try{
            //2 file scanners; one to create array size and the other to fill array
            Scanner fs = new Scanner(f);
            Scanner arrayMaker = new Scanner(f);
            //determines array size and makes a square array based on the counnt
            while (fs.hasNextLine()){
                fs.nextLine();
                size++;
            }           
            int[][] sqr = new int[size][size];
            //fills the array with actual values in .txt file
            while (arrayMaker.hasNextInt()){
                for (int i = 0; i < sqr.length; i++){
                    for (int j = 0; j < sqr[i].length; j++)
                        sqr[i][j] = arrayMaker.nextInt();
                }
            }            
            //make an object of MSD using above array and checks whether the array is a magic square
            MagicSquareDetector magi = new MagicSquareDetector(sqr);
            int[][] trans = magi.transposeMatrix(sqr);
            String nums = "";
            if (magi.isMagic()){
                MagicSquare m = new MagicSquare(sqr);
            }else{
                for (int[] i : magi.getJustASquare()){
                    for (int j : i){
                        nums += j + " ";
                    }
                }
                System.out.println("The combination of numbers " + nums + "is not a magic square.");
            }
        }//will throw an exception if the file doesn't exist or if the array isn't a square
        catch (FileNotFoundException | NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }
}
