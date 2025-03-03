package dft;

public class Complex {

    public double r, i;

    public Complex(double re, double im) {
        r = re;
        i = im;
    }

    public Complex() {
        this(0, 0);
    }

    public Complex add(Complex c) {
        return new Complex(r + c.r, i + c.i);
    }

    public Complex sub(Complex c) {
        return new Complex(r - c.r, i - c.i);
    }

    public Complex mul(Complex c) {
        return new Complex(r*c.r - i*c.i, r*c.i + i*c.r);
    }

    public Complex div(double a) {
        return new Complex(r/a, i/a);
    }

    public static Complex exp(double a) {
        return new Complex(Math.cos(a), Math.sin(a));
    }
    
    public static double amplitude(Complex number) {
    	return Math.sqrt(Math.pow(number.r, 2) + Math.pow(number.i, 2));
    }
    
    public static double phase(Complex number) {
    	return Math.atan2(number.i, number.r);
    }

	@Override
	public String toString() {
		return "Complex [r=" + r + ", i=" + i + "]";
	}
     

}

