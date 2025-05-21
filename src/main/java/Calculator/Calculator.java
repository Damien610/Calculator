package Calculator;


import java.util.Arrays;

public class Calculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0.0) {
            throw new IllegalArgumentException("Division par zéro !");
        }
        return a / b;
    }
    
    public double[] sort_array(double[] array) {
    	Arrays.sort(array);
		return array;
    }
}

