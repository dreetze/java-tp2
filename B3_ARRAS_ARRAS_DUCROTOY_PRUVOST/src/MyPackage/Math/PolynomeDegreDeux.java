/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage.Math;

import java.util.ArrayList;

/**
 *
 * @author Ben
 */
public class PolynomeDegreDeux extends Polynome {
        final Fraction ZERO = Fraction.intToFraction( 0 );
        final Fraction DEUX = Fraction.intToFraction( 2 );
        final Fraction QUATRE = Fraction.intToFraction( 4 );
        
    
    public PolynomeDegreDeux()
    {
        super();
    }
    
    public PolynomeDegreDeux( Numerique coeff[] ) 
    {
       super();
    }
    
    public ArrayList<Fraction> CalculSqrt( Monome coeff[] ) 
    {
        Numerique a = coeff[ 0 ].getCoefficient();
        Numerique b = coeff[ 1 ].getCoefficient();
        Numerique c = coeff[ 2 ].getCoefficient();
        ArrayList<Fraction> solution = new ArrayList<Fraction>();
        
        Numerique bCarre = coeff[ 1 ].getCoefficient().mult(coeff[ 1 ].getCoefficient());
        Numerique quatreAC = QUATRE.mult( a.mult( c ) );
        Numerique delta = bCarre.sub( quatreAC );
        Numerique deuxA = a.mult( DEUX );
        b.opposed();
        Fraction deltaF = new Fraction( delta.getValue() );
        
        if ( Fraction.greater( deltaF, ZERO ) ) {
            Fraction racineDelta = new Fraction( Math.sqrt( delta.getValue() ) );
            solution.add( (Fraction) ( b.sub( racineDelta ) ).div( deuxA ));
            solution.add( (Fraction) ( b.add( racineDelta ) ).div( deuxA ));
            
            return solution;
        }
        else if( Fraction.equal( deltaF, ZERO ) ) {
           solution.add( (Fraction) b.div( deuxA ));
           
            return solution;
        } else {
            
            return null;
        }        
    }
}
