
package es.uvigo.esei.aed1.activity0.exercise17;

import java.util.Scanner;

public class Activity0Exercise17 {
  static Scanner input = new Scanner(System.in);

  // exercise 17
  /**
   * muestra un mensaje por pantalla y lee un número entero de teclado
   * 
   * @param message el mensaje a visualizar
   * @return el número entero leido de teclado
   */
  public static int readNumber(String message) {
    System.out.println(message);
    return Integer.parseInt(input.nextLine());
  }

  /**
   * muestra un mensaje por pantalla y lee un número real de teclado
   * 
   * @param message el mensaje a visualizar
   * @return el número real leido de teclado
   */
  public static double readDouble(String message) {
    System.out.println(message);
    return Double.parseDouble(input.nextLine());
  }

  /**
   * muestra un mensaje por pantalla y lee una matriz de números reales
   * 
   * @param matrix  que almacena números reales
   * @param message el mensaje a visualizar
   */
  public static void readNotes(double[][] matrix, String message) {
    System.out.println(message);

    for (int i = 0; i < matrix.length; i++) {
      System.out.println("the notes of student ( " + (i + 1) + " ) are");
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = readDouble("note [ " + (j + 1) + " ]: ");
      }
    }
  }

  /**
   * muestra por pantalla un mensaje y el contenido de una matriz de números
   * reales
   * 
   * @param matrix  que almacena numeros reales
   * @param message el mensaje a visualizar
   */
  public static void printNotes(double[][] matrix, String message) {
    System.out.println(message);
    System.out.println("\n---------");

    for (int i = 0; i < matrix.length; i++) {
      System.out.println("Student " + (i + 1));
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + "|");
      }
      System.out.println("\n---------");
    }
    input.close();
  }
}
