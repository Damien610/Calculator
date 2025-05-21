package Calculator;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private final Calculator calc = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(5, calc.add(2, 3));
        assertEquals(-5, calc.add(-2, -3));
        assertEquals(1, calc.add(4, -3));
        assertEquals(2, calc.add(2, 0));
        assertEquals(0, calc.add(0, 0));
        assertEquals(5.6, calc.add(2.5, 3.1));
        assertEquals(-0.6, calc.add(2.5, -3.1), 1e-9);
    }

    @Test
    public void testSubtract() {
        assertEquals(1, calc.subtract(4, 3));
        assertEquals(1, calc.subtract(-2, -3));
        assertEquals(5, calc.subtract(2, -3));
        assertEquals(2, calc.subtract(2, 0));
        assertEquals(-2, calc.subtract(0, 2));
        assertEquals(3.3, calc.subtract(5.5, 2.2));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calc.multiply(2, 3));
        assertEquals(6, calc.multiply(-2, -3));
        assertEquals(-6, calc.multiply(2, -3));
        assertEquals(0, calc.multiply(2, 0));
        assertEquals(0, calc.multiply(0, 5));
        assertEquals(10.0, calc.multiply(2.5, 4.0));
    }

    @Test
    public void testDivide() {
        assertEquals(2, calc.divide(6, 3));
        assertEquals(2, calc.divide(-6, -3));
        assertEquals(-2, calc.divide(6, -3));
        assertEquals(0.0, calc.divide(0, 5));
        assertEquals(3.0, calc.divide(7.5, 2.5));
        assertThrows(IllegalArgumentException.class, () -> calc.divide(1, 0));
        assertThrows(IllegalArgumentException.class, () -> calc.divide(1.0, 0.0));
    }

    @Test
    public void testSortedArray() {
        double[] ArrayTestPositive = {12, 8, 2, 5};
        double[] ArrayTestFloat = {3.14, 1.59, 2.65, 5.35};
        double[] ArrayTestNegative = {-2, -9, -6, -1};
        double[] ArrayTestMix = {3.14, -3, 0, 4};
        double[] ArrayTestDoublon = {4, 0, 4, 0};

        ArrayTestPositive = calc.sort_array(ArrayTestPositive);
        ArrayTestFloat = calc.sort_array(ArrayTestFloat);
        ArrayTestNegative = calc.sort_array(ArrayTestNegative);
        ArrayTestMix = calc.sort_array(ArrayTestMix);
        ArrayTestDoublon = calc.sort_array(ArrayTestDoublon);

        assertEquals(true, veryfy_sorted_table(ArrayTestPositive));
        assertEquals(true, veryfy_sorted_table(ArrayTestFloat));
        assertEquals(true, veryfy_sorted_table(ArrayTestNegative));
        assertEquals(true, veryfy_sorted_table(ArrayTestMix));
        assertEquals(true, veryfy_sorted_table(ArrayTestDoublon));
    }

    public boolean veryfy_sorted_table(double[] tableau) {
        for (int i = 0; i < tableau.length - 1; i++) {
            if (tableau[i] > tableau[i + 1]) {
                System.out.println("Erreur à l’indice " + i + " : " + tableau[i] + " > " + tableau[i + 1]);
                return false;
            }
        }
        return true;
    }
}
