package com.example.javatypedata.structures;

public class StructureMain {

    public static void main(String[] args) {
        // If
        int number = 5;
        if (number == 5) {
            System.out.println("El numero es 5");
        } else {
            System.out.println("El numero no es 5");
        }

        int[] numberArray = { 1, 2, 3, 4, 5 };
        // For
        for (int i = 0; i < numberArray.length; i++) {
            System.out.println("Numero del for " + numberArray[i]);
        }

        // While
        boolean flag = true;
        int count = 0;
        while (flag) {
            if (count == 5)
                flag = false;
            System.out.println("While nro " + count);
            count++;
        }

        // Test metodo
        dividir(5, 5);
        dividir(5, 0);
    }

    public static int dividir(int a, int b) {
        try {
            int result = a / b;
            System.out.println(result);
            return result;
        } catch (ArithmeticException ae) {
            System.out.println("Error: " + ae.getMessage() + " causa: " + ae.getCause());
            return -1;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " causa: " + e.getCause());
            return -1;
        } finally {
        }

    }
}
