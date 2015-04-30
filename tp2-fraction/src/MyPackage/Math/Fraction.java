/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage.Math;

/**
 *
 * @author Nico
 */
public class Fraction {
	
    private long num;
    private long den;
    private Boolean signe;
    private double y;
    private double x;

    public Fraction() {
            this.num = (long) num;
            this.den = (long) den;
            System.out.println("JE SUIS LE CONSTRUCTEUR PAR DEFAUT"+ num + "/" + den);
    }

    public Fraction(int a, int b) {
            this.num = (int) a;
            this.den = (int) b;
            System.out.println("JE SUIS LE CONSTRUCTEUR INT"+ num + "/" + den);
    }

    public Fraction(long a, long b) {
            this.num = (long) a;
            this.den = (long) b;
            System.out.println("JE SUIS LE CONSTRUCTEUR LONG"+ num + "/" + den);
    }
    
    public Fraction(double x) {
            y = Math.abs(x);
            int n0 = (int) y;
            int d0 = 1;
            int t = n0;
            if(y - n0 != 0){
            y = 1/(float) (y - (int) y);
            int d1 = (int) y;
            int n1 = n0*d1+1;
            while(Math.abs(Math.abs(x) - (float) n1/d1) > Math.pow(1, -6)){
                    y = 1/ (float) (y - (int) y);
                    int d2 = (int) y * d1 + d0;
                    int n2 = t * d2 + (int) y * (n1 - t * d1) + n0 - t * d0;
                    d0 = d1; 
                    n0 = n1; 
                    d1 = d2; 
                    n1 = n2;
            }
                    int numerator = (int) n1;
                    int denominator = (int) d1;
                    System.out.println(numerator + "/" + denominator);
            } else {
                    int numerator = (int)n0;
                    int denominator = (int)d0;
                    System.out.println(numerator + "/" + denominator);
            }
    }
    
    public static void main(String[] args) {


    }
}