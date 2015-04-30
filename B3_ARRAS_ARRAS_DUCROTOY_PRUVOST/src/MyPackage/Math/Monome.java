/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage.Math;

/**
 *
 * @author Ben
 */
public class Monome extends Object implements Affichable2 {
    
    private Numerique coefficient;
    private int degre;

    private Monome() {}
    
    /**
     *
     * @param m
     */
    public Monome( Monome m ) 
    {
        this.coefficient = m.getCoefficient();
        this.degre = m.getDegre();
    }

    public Numerique getCoefficient() 
    {
        return coefficient;
    }

    public void setCoefficient( Numerique coefficient ) 
    {
        this.coefficient = coefficient;
    }

    public int getDegre() 
    {
        return degre;
    }

    public void setDegre( int degre ) 
    {
        this.degre = degre;
    }

    /**
     *
     * @param coefficient
     * @param degre
     */
    public Monome( double coefficient, int degre ) 
    {
        this.setCoefficient( new Fraction( coefficient ) );
        this.setDegre( degre );
    }

    @Override
    public String toString() 
    {
        return this.getCoefficient() + "x^" + this.getDegre();
    }
    
    @Override
    public void display()
    {
        System.out.println( toString() );
    }
}