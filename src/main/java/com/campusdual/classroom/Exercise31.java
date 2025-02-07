package com.campusdual.classroom;

import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Exercise31 {

    public static void main(String[] args) {
        String rutaDelArchivo = "lorem.txt";


        //classLoader obten recurso como InputStream
        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(rutaDelArchivo);

             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            if (inputStream == null) {//Verifico si se encontra o archivo
                System.out.println("Archivo non encontrado: " + rutaDelArchivo);
            }

            String lineaPorLinea;
            while ((lineaPorLinea = br.readLine()) != null) {//leo o archivo línea por línea
                System.out.println(lineaPorLinea);
            }
        } catch (IOException e) {
            System.out.println("Error ao leer o archivo: " + e.getMessage());
        }
    }
}

