/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.creditcard;

/**
 *
 * @author user
 */
import java.util.Scanner;

public class CreditCard {

    public static boolean validarTarjeta(String numeroTarjeta) {
        if (numeroTarjeta.length() != 16) {
            return false;
        }

        int suma = 0;

        // Iterar sobre los primeros 15 dígitos
        for (int i = 0; i < 15; i++) {
            int digito = Character.getNumericValue(numeroTarjeta.charAt(i));

            // Multiplicar por 2 los dígitos en posiciones pares
            if (i % 2 == 0) {
                digito *= 2;
                // Si el resultado es mayor que 9, restar 9
                if (digito > 9) {
                    digito -= 9;
                }
            }

            suma += digito;
        }

        // Obtener el dígito de control (último dígito)
        int digitoControl = Character.getNumericValue(numeroTarjeta.charAt(15));
        
        // Validar si la suma más el dígito de control es divisible por 10
        return (suma + digitoControl) % 10 == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce tu número de tarjeta de crédito (16 dígitos): ");
        String numeroTarjeta = scanner.nextLine();

        if (validarTarjeta(numeroTarjeta)) {
            System.out.println("Número de tarjeta válido.");
        } else {
            System.out.println("Número de tarjeta inválido.");
        }

        scanner.close();
    }
}
