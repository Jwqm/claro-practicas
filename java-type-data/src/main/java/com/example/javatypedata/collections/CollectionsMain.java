package com.example.javatypedata.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionsMain {
    public static void main(String[] args) {
        // List
        List<String> lista = new ArrayList<String>();

        // Agregar elementos
        lista.add("Elemento 1");
        lista.add("Elemento 2");
        lista.add("Elemento 3");

        // Acceder a elementos
        System.out.println("Elemento en la posición 0: " + lista.get(0));

        // Iterar sobre la lista
        System.out.println("Elementos de la lista:");
        for (String elemento : lista) {
            System.out.println(elemento);
        }

        // EJEMPLO CON MAP
        Map<Integer, String> mapa = new HashMap<>();

        // Agregar elementos
        mapa.put(1, "Valor 1");
        mapa.put(2, "Valor 2");
        mapa.put(3, "Valor 3");

        // Acceder a elementos
        System.out.println("Valor correspondiente a la clave 2: " + mapa.get(2));

        // Iterar sobre las claves y valores del mapa
        System.out.println("Claves y valores del mapa:");
        for (Map.Entry<Integer, String> entry : mapa.entrySet()) {
            System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue());
        }

        // Otra forma de recorrer el map usando expresiones lambda
        mapa.forEach((clave, valor) -> System.out.println("Clave: " + clave + ", Valor: " + valor));

        // Con api stream
        mapa.entrySet().stream()
                .forEach(entry -> System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue()));
    }
}
