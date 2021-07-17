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
public class MagicSquare {
    private final int[][] magicSqr;

    public MagicSquare(int[][] magicSqr) {
            this.magicSqr = magicSqr;
            System.out.println(toString());
    }
    
    public String toString(){
        String nums = "";
        for (int[] i : magicSqr){
            for (int j : i){
                nums += j + " ";
            }
        }
        int cons = 0;
        for (int i = 0; i < magicSqr.length; i++){
            cons += magicSqr[0][i];
        }
        return String.format("The combination of numbers %1$s is a magic square of order %2$s. The magic constant is %3$s.", nums, getMagicSqr().length, cons);
    }

    public int[][] getMagicSqr() {
        return magicSqr;
    }
}
