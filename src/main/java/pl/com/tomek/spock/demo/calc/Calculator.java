package pl.com.tomek.spock.demo.calc;

public class Calculator {

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double c, double d) {
        if( d == 0){
            throw new ArithmeticException("nie dziel przez 0");
        }
        return c / d;
    }


}
