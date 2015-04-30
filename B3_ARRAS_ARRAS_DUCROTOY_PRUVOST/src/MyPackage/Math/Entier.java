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
public class Entier extends Fraction {

    public Entier() 
    {
        super();
    }

    public Entier( Fraction fraction ) 
    {
        super( fraction );
    }

    public Entier( int a, int b ) 
    {
        super( a, b );
    }

    public Entier( long a, long b ) 
    {
        super( a, b );
    }

    public Entier( double x ) 
    {
        super( x );
    }
    
    public Entier( int w ) 
    {
       super( w, 1 );
    }
}
