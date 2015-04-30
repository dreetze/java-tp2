package MyPackage.Math;

public class Fraction extends Numerique {
	
    private int num;
    private int den;
    private Boolean signe;
    private double y;
    private double x;
    private static final Fraction ZERO = Fraction.intToFraction( 0 );
    private static final Fraction PLUS_ONE = Fraction.intToFraction( 1 );
    private static final Fraction MINUS_ONE = Fraction.intToFraction( -1 );

    /**
     *
     */
    public Fraction() 
    {
        this( ZERO );
        System.out.println( "JE SUIS LE CONSTRUCTEUR PAR DEFAUT"+ this.getNum() + "/" + this.getDen() );
    }

    /**
     *
     * @param fraction
     */
    public Fraction( Fraction fraction )
    {
        this.setNum( fraction.getNum() );
        this.setDen( fraction.getDen() );
        System.out.println( "JE SUIS LE CONSTRUCTEUR fraction "+ fraction.getNum() + "/" + fraction.getDen() );
    }

    /**
     *
     * @param a
     * @param b
     */
    public Fraction( int a, int b ) 
    {
            this.setNum( a );
            this.setDen( b );
            System.out.println( "JE SUIS LE CONSTRUCTEUR INT"+ this.getNum() + "/" + this.getDen() );
    }

    /**
     *
     * @param a
     * @param b
     */
    public Fraction( long a, long b ) 
    {
            this.setNum( (int) a );
            this.setDen( (int) b );
            System.out.println( "JE SUIS LE CONSTRUCTEUR LONG"+ this.getNum() + "/" + this.getDen() );
    }
	
    /**
     *
     * @param x
     */
    public Fraction( double x ) 
    {
        if ( x > 0 ) {
            this.setSigne( true );
        } else {
            this.setSigne( false );
        }
        y = Math.abs( x );
        int n0 = (int) y;
        int d0 = 1;
        int t = n0;
        
        if( y - n0 != 0 ) {
            y = 1/(float) ( y - (int) y );
            int d1 = (int) y;
            int n1 = n0*d1+1;
            while( Math.abs( Math.abs( x ) - (float) n1/d1 ) > Math.pow( 1, -6 ) ) {
                y = 1/ (float) ( y - (int) y );
                int d2 = (int) y * d1 + d0;
                int n2 = t * d2 + (int) y * ( n1 - t * d1 ) + n0 - t * d0;
                d0 = d1; 
                n0 = n1; 
                d1 = d2; 
                n1 = n2;
            }
            int numerator = (int) n1;
            this.setNum( numerator );
            int denominator = (int) d1;
            this.setDen( denominator );
            System.out.println( numerator + "/" + denominator );
        } else {
            int numerator = (int) n0;
            this.setNum( numerator );
            int denominator = (int) d0;
            this.setDen( denominator );
            System.out.println( numerator + "/" + denominator );
        }
    }
	
    private int partieEntiere( double x ) 
    {
        return (int) x;
    }

    public Boolean getSigne() 
    {
        return signe;
    }

    public void setSigne( Boolean signe ) 
    {
        this.signe = signe;
    }

    public int getNum() 
    {
        return this.num;
    }
    
    public int getDen()
    {
        return this.den;
    }
    
    public void simplify() 
    {

        int r;
        int numerateur = this.getNum();
        int denominateur = this.getDen();
        r = this.pgcd( num, den );

        num=num/r;
        den=den/r;
        this.setNum( numerateur );
        this.setDen( denominateur );

    }

    public void setNum( int num ) 
    {
        this.num = num;
    }

    public void setDen( int den ) 
    {
        this.den = den;
    }
    
    private int pgcd( int a, int b ) 
    {
        while( b!=0 ) {
            int c=a%b;
            a=b;
            b=c;
        }
        
        return a;
    }
    
    public Fraction add( Fraction p_operand ) 
    {
        this.setNum( p_operand.getDen() * this.getNum() + this.getDen() * p_operand.getNum() );
        this.setDen( p_operand.getDen() * this.getDen() );
        this.simplify();
        
        return this;
    }
    
    public Fraction sub( Fraction p_operand ) 
    {
        this.setNum( p_operand.getDen() * this.getNum() - this.getDen() * p_operand.getNum() );
        this.setDen( p_operand.getDen() * this.getDen() );
        this.simplify();
        
        return this;
    }
    
    public Fraction mul( Fraction p_operand ) 
    {
        this.setNum( p_operand.getNum() * this.getNum() );
        this.setDen( p_operand.getDen() * this.getDen() );
        this.simplify();
        
        return this;
    }
    
    public Fraction div( Fraction p_operand ) 
    {
        this.setNum( p_operand.getDen() * this.getNum() );
        this.setDen( p_operand.getNum() * this.getDen() );
        this.simplify();
        
        return this;
    }
    
    public static Fraction realToFraction( double a ) 
    {
        
        return new Fraction( a );
    }
    
    public static Fraction intToFraction( int a ) 
    {
        return new Fraction( a,1 );
    }
    
    public double fractionToDouble() 
    {
        return this.getNum() / this.getDen();
    }
    
    public static boolean equal( Fraction p_leftOperand, Fraction p_rightOperand ) 
    {
        p_leftOperand.simplify();
        p_rightOperand.simplify();
        
        if( p_leftOperand.getDen() == p_rightOperand.getDen() ) {
            if( p_leftOperand.getNum() == p_rightOperand.getNum() ) {
                if( p_leftOperand.getSigne() == p_rightOperand.getSigne() ) {
                    
                    return true;
                }
            }
        }
        
        return false;      
    }
    
    public static boolean different( Fraction p_leftOperand, Fraction p_rightOperand ) 
    {
        p_leftOperand.simplify();
        p_rightOperand.simplify();
        
        return !Fraction.equal(p_leftOperand, p_rightOperand);
    }
    
    public static boolean greater( Fraction p_leftOperand, Fraction p_rightOperand ) 
    {
        p_leftOperand.simplify();
        p_rightOperand.simplify();
        
        int num1 = p_leftOperand.getNum() * p_leftOperand.getDen();
        int num2 = p_rightOperand.getNum() * p_leftOperand.getDen();
        
        if( num1 > num2 ) 
        {
            
           return true;
        }
        if( num2 > num1 ) 
        {
            
            return false;
        }
        
        return false;
    }
    
    public static boolean greaterOrEqual( Fraction p_leftOperand, Fraction p_rightOperand ) 
    {
        p_leftOperand.simplify();
        p_rightOperand.simplify();
        
        if( Fraction.equal( p_leftOperand, p_rightOperand ) ) {
            
            return true;
        }
        
        if( Fraction.greater( p_leftOperand, p_rightOperand ) ) {
            
            return true;
        }
        
        return false;
    }
    
    public static boolean lower( Fraction p_leftOperand, Fraction p_rightOperand ) 
    {
        p_leftOperand.simplify();
        p_rightOperand.simplify();
        
        if( Fraction.equal( p_leftOperand, p_rightOperand ) ){
            
            return false;
        }
        if( Fraction.greater( p_leftOperand, p_rightOperand ) ) {
            
            return false;
        }
        
        return true;
    }
    
    public static boolean lowerOrEqual( Fraction p_leftOperand, Fraction p_rightOperand ) 
    {
        p_leftOperand.simplify();
        p_rightOperand.simplify();
        
        if( Fraction.equal( p_leftOperand, p_rightOperand ) ){
            
            return true;
        }
        
        if( Fraction.greater( p_leftOperand, p_rightOperand ) ) {
            
            return false;
        }
        
        return true;
    }

    @Override
    double getValue() 
    {
        return this.getNum() / this.getDen();
    }

    /**
     *
     */
    @Override
    public void display() 
    {
        System.out.println( this.toString() );
    }

    @Override
    Numerique add(Numerique p_operand) 
    {
        return this.add( new Fraction( p_operand.getValue() ) );
    }

    @Override
    Numerique opposed() 
    {
        if( this.getSigne() ) {
            this.setSigne(signe);
            
            return this;
        } else {
            
            return this;
        }
    }

    @Override
    Numerique mult( Numerique numerique ) 
    {
        return this.mul( new Fraction( numerique.getValue() ) );
    }
    
    @Override
    public String toString() 
    {
        return "["+ this.getSigne() +"] "+ this.getNum() +"/" + this.getDen();
    }
}