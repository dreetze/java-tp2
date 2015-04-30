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
public abstract class Numerique implements Affichable2 {
    
    abstract double getValue();
    abstract Numerique add( Numerique p_operand );
    abstract Numerique opposed();
    abstract Numerique mult( Numerique numerique );
    
    public Fraction inversed( Numerique numerique ) 
    {
        Fraction f = new Fraction( numerique.getValue() );
        int tmp = f.getDen();
        f.setDen( f.getNum() );
        f.setNum( tmp );
        return f;
    }
    
    public Numerique div( Numerique numerique ) 
    {
        return this.mult( this.inversed( numerique ) );
    }
    
    public Numerique sub( Numerique numerique ) 
    {
        return this.add( this.opposed());
    }  
}
