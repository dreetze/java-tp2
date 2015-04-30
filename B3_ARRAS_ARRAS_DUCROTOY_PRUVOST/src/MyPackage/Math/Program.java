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
public class Program {
    
    public static void main(String args[]) 
    {
        Numerique c1[] = {new Reel(1.2), new Fraction(3,-2), new Entier(4), new Entier()};
        Polynome p1 = new Polynome(c1);
        Numerique c2[] = {new Entier(1), new Reel(0.7), new Entier(-3), new Fraction(-0.25)};
        Polynome p2 = new Polynome(c2);
        Polynome p3, p4;
        Fraction f = new Fraction(3.2);
        f.display();
        p3 = p1.addPolynome(p2);
        p3.display();
        //p4 = p2.mult(f);
        //p4.display();  
    }
}
