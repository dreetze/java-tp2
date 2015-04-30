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
public class Reel extends Numerique {
     
    private double nbr;

    public double getNbr() 
    {
        return nbr;
    }

    public void setNbr( double nbr ) 
    {
        this.nbr = nbr;
    }
    
    public Reel( double a ) 
    {
        this.setNbr( a );
        System.out.println( "JE SUIS LE CONSTRUCTEUR REEL" + this.getNbr() );
    }

    @Override
    Numerique add( Numerique numerique ) 
    {
        return new Reel( this.getValue() + numerique.getValue() );
        
    }

    /**
     *
     */
    @Override
    public void display() 
    {
        System.out.println( this );
    }

    @Override
    double getValue() 
    {
        return this.getNbr();
    }

    @Override
    Numerique opposed() 
    {
        this.setNbr( this.getValue() * ( -1 ) );
        
        return this;
    }

    @Override
    Numerique mult(Numerique numerique) 
    {
        this.setNbr( this.getValue() * numerique.getValue() );
        
        return this;
    }
}
