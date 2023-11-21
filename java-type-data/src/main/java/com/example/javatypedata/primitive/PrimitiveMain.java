package com.example.javatypedata.primitive;

public class PrimitiveMain {
    public static void main(String[] args) {
        // Enteros:
        int numeroEntero = 42;
        long numeroLargo = 1234567890L;
        // Flotantes:
        float numeroFlotante = 3.14f;
        double numeroDoble = 2.71828;
        // Caracteres:
        char caracter = 'A';
        // Booleano:
        boolean esVerdadero = true;
        boolean esFalso = false;

        // Arreglos:
        int[] arregloEnteros = { 1, 2, 3, 4, 5 };
        String[] nombres = { "Juan", "María", "Carlos" };

        // Enteros:
        System.out.println("Número entero: " + numeroEntero);
        System.out.println("Número largo: " + numeroLargo);

        // Flotantes:
        System.out.println("Número flotante: " + numeroFlotante);
        System.out.println("Número doble: " + numeroDoble);

        // Caracteres:
        System.out.println("Carácter: " + caracter);

        // Booleano:
        System.out.println("Es verdadero: " + esVerdadero);
        System.out.println("Es falso: " + esFalso);

        // Arreglos de Enteros, buscar numeros 2 y 4.
        // Formas de busqueda basicas por for y for each.
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] == 2 || arregloEnteros[i] == 4) {
                System.out.println("Arreglo de enteros por for: " + arregloEnteros[i]);
            }
        }

        for (int entero : arregloEnteros) {
            if (entero == 2 || entero == 4) {
                System.out.println("Arreglo de enteros por foreach: " + entero);
            }
        }

        // No recomendado por while
        int count = 0;
        while (count < arregloEnteros.length) {
            if (arregloEnteros[count] == 2 || arregloEnteros[count] == 4) {
                System.out.println("Arreglo de enteros por while no recomendado: " + arregloEnteros[count]);
            }
            count++;
        }

        // Arreglos de String, buscar María.
        // Formas de busqueda basicas por for y for each.
        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i].equalsIgnoreCase("María")) {
                System.out.println("Arreglo de String por for: " + nombres[i]);
            }
        }

        for (String nom : nombres) {
            if (nom.equalsIgnoreCase("MARíA")) {
                System.out.println("Arreglo de String por foreach: " + nom);
            }
        }

    }
}
