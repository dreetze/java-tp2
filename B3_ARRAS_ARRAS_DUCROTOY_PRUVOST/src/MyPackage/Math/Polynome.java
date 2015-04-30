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
public class Polynome extends Object implements Affichable2 {
    private Monome[] monomes;
    private int n = 2;
    
    public Monome[] getMonomes() 
    {
        return monomes;
    }

    public void setMonomes( Monome[] monomes ) 
    {
        this.monomes = monomes;
    }
    
    
    public Polynome()
    {
        monomes = new Monome[ n+1 ];
        
        for( int i = 0; i <= n; i++ ) {
            monomes[ i ] = new Monome( i, i );
        }
    }
    
    public Polynome( Polynome p )
    {
        this.monomes = new Monome[ p.getMonomes().length ];
        for( int i = 0; i < this.getMonomes().length; i++ ) {
            monomes[ i ] = new Monome( p.getMonomes()[ i ] );
        }
    }
    
    public Polynome(Numerique[] tableauDouble) {
        Monome[] thisMonome = new Monome[tableauDouble.length];
        for (int i = 0; i < tableauDouble.length; i++) {
            thisMonome[i] = new Monome(tableauDouble[i].getValue(), i);
        }
        setMonomes(thisMonome);
    }

    @Override
    public String toString() 
    {
        String polynome = "P(x)=";
        for ( Monome monome : monomes ) {
            polynome += monome.toString();
        }
        
        return polynome;
    }
    
    @Override
    public void display() 
    {
        System.out.println( toString() );
    }
    
    public Polynome addPolynome( Polynome p ) 
    {
        Polynome res;
        Polynome toAdd;
        if ( this.getMonomes().length > p.getMonomes().length ) {
            res = new Polynome( this );
            toAdd = new Polynome( p );
        } else {
            res = new Polynome( p );
            toAdd = new Polynome( this );
        }
        
        for( int i = 0; i < res.getMonomes().length; i++ ) {
            res.getMonomes()[ i ].setCoefficient(
                    res.getMonomes()[ i ].getCoefficient().add(
                            toAdd.getMonomes()[ i ].getCoefficient()
                    )
            );
        }
 
        return res;
    }   
}
