/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magicsquaredetector;

/**
 *
 * @author Sarah
 */
public class MagicSquareDetector {
    private int[][] justASquare;

    public MagicSquareDetector(int[][] justASquare) {
        this.justASquare = justASquare;
    }

    public int[][] getJustASquare() {
        return justASquare;
    }

    public void setJustASquare(int[][] justASquare) {
        this.justASquare = justASquare;
    }
    
    //if method returns true, then array is a magic square. false if not.
    public boolean isMagic(){
        int count = 0;
        int sum = 0;
        int magiCon = 0;
        int[][]trans = transposeMatrix(justASquare);
        //loops through the array to check for duplicate elements
        for (int[] i : justASquare){
            for (int j : i){
                int dupe = 0;
                for (int[] x : trans){
                    for (int y : x){
                        if (Integer.compare(j, y) == 0)
                            dupe++;
                    }
                }
                if (dupe > 1){
                    System.out.println("Duplicate value found.");
                    return false;
                }
            }
        }
        //sets the sum constant for the square
        for (int i = 0; i < justASquare[0].length; i++){
            magiCon += justASquare[0][i];
        }
        //checks whether the sum of each row equals the constant
        for (int i = 0; i < justASquare.length; i++){
            for (int j = 0; j < justASquare[i].length; j++){
                sum += justASquare[i][j];
            }
            if (sum==magiCon)
                count++;
            sum = 0;
        }
        //checks whether the sum of each column is equivalent to the constant
        for (int i = 0; i < trans.length; i++){
            for (int j = 0; j < trans[i].length; j++){
                sum += trans[i][j];
            }
            if (sum == magiCon)
                count++;
            sum = 0;
        }
        //checks whether sum of foward diagonal equals constant
        for (int i = 0; i < justASquare.length; i++){
            sum += justASquare[i][i];     
        }
        if (sum == magiCon){
            count++;
        }
        sum = 0;
        //checks whether sum of backwards diagonal equals constant
        int r = 0;
        for (int i = justASquare.length-1; i >= 0; i--){
            sum += justASquare[r][i];
            r++;
        }
        if (sum == magiCon){
            count++;
        }
        //checks if the sum of all rows, colums, and diagonals are equivalent to the constant
        if (count == (justASquare.length*2)+2)
            return true;
        return false;
    }
    //transposes the array
    public int[][] transposeMatrix(int[][] square){
        int size = square.length;
        int[][] transpose = new int[size][size];
        for (int i = 0; i < square.length; i++){
            for (int j = 0; j < square[i].length; j++){
                transpose[i][j] = square[j][i];
            }
        }
        return transpose;
    }
}
