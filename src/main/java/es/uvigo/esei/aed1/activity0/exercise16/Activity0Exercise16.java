
package es.uvigo.esei.aed1.activity0.exercise16;

import java.util.Scanner;

public class Activity0Exercise16 {
  static Scanner input = new Scanner(System.in);
  // exercise 16

  /**
   * Calcula el maximo de los enteros almacenados en el array
   * 
   * @param array contiene los enteros
   * @return el valor mínimo
   */
  public static int maximum(int[] array) {
    int mayor = array[0];

    for (int i = 1; i < array.length; i++) {
      if (mayor < array[i]) {
        mayor = array[i];
      }
    }
    return mayor;
  }

  /**
   * Calcula el mínimo de los enteros almacenados en el array
   * 
   * @param array contiene los enteros
   * @return el valor mínimo
   */
  public static int minimum(int[] array) {
    int menor = array[0];

    for (int i = 1; i < array.length; i++) {
      if (menor > array[i]) {
        menor = array[i];
      }
    }
    return menor;
  }

  /**
   * Calcula el promedio de los enteros almacenados en el array
   * 
   * @param array contiene los enteros
   * @return el valor promedio
   */
  public static double average(int[] array) {
    int average = array[0];

    for (int i = 1; i < array.length; i++) {
      average += array[i];
    }
    return (double) average / array.length;
  }

  public static int readInteger(String message) {
    System.out.println(message);
    return Integer.parseInt(input.nextLine());
  }

  /**
   * almacena enteros en el array haciendo uso del método readInteger
   * 
   * @param array que almacenará los enteros
   */
  public static void readArray(int[] array) {

    for (int i = 0; i < array.length; i++) {
      array[i] = readInteger("Ingresa un numero entero " + (i + 1) + ": ");
    }
    input.close();
  }

}
