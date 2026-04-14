package es.uvigo.esei.aed1.activity7;

import es.uvigo.esei.aed1.activity7.hospital.Doctor;
import es.uvigo.esei.aed1.activity7.hospital.Hospital;
import es.uvigo.esei.aed1.tads.list.IteratorList;
import es.uvigo.esei.aed1.tads.list.LinkedList;
import es.uvigo.esei.aed1.tads.list.List;

import java.util.ArrayList;
import java.util.Iterator;

public class Activity7 {

  // Exercise 1
  public static List<Integer> getHigherThan(List<Integer> listToFilter, int threshold) throws NullPointerException {
    return null;
  }

  // Exercise 2
  public static <T> List<T> invert(List<T> list) throws NullPointerException {
    return null;
  }

  // Exercise 3
  private static <T> int countValueAppearances(List<T> list, T referenceValue) {
    int contador = 0;

    for (T t : list) {
      if (t.equals(referenceValue)) {
        contador++;
      }
    }

    return contador;
  }

  public static <T> boolean allValuesAppearancesAreEqual(List<T> list) throws NullPointerException {

    return true;
  }

  // Exercise 4
  public static <T extends Comparable<T>> boolean isAscendingOrder(List<T> list) throws NullPointerException {
    if (list == null)
      throw new NullPointerException();
    if (list.size() == 0 || list.size() == 1) {
      return true;
    }

    Iterator<T> itr = list.iterator();
    boolean ascending = true;
    T value = itr.next();

    while (itr.hasNext()) {
      T next = itr.next();
      ascending = value.compareTo(next) <= 0;
      value = next;
    }

    return ascending;
  }

  // Exercise 5
  public static <T> List<T> buildListWithRepeatedValues(List<T> list) throws NullPointerException {
    return null;
  }

  // Exercise 6
  private static <T> boolean countTuplesWithAValue(List<Terna<T>> list, T value) {
    boolean contain = false;

    for (Terna<T> terna : list) {
      if (terna.getValue().equals(value))
        return contain = true;
    }
    return contain;
  }

  public static <T> List<Terna<T>> buildSummaryList(List<T> list1, List<T> list2) throws NullPointerException {
    if (list1 == null || list2 == null) {
      throw new NullPointerException();
    }

    List<Terna<T>> summaryList = new LinkedList<>();

    for (T t : list1) {
      if (!countTuplesWithAValue(summaryList, t)) {
        summaryList.addLast(new Terna<>(t, countValueAppearances(list1, t), countValueAppearances(list2, t)));
      }
    }

    for (T t : list2) {
      if (!countTuplesWithAValue(summaryList, t)) {
        summaryList.addLast(new Terna<>(t, 0, countValueAppearances(list2, t)));
      }
    }

    return summaryList;
  }

  // Exercise 7
  public static int countValuesEqualSumPreceding(List<Integer> list) throws NullPointerException {
    if (list == null) {
      throw new NullPointerException();
    }
    int couter = 0, suma = 0;

    for (Integer number : list) {
      if (number == suma) {
        couter ++;
      }
      suma += number;
    }

    return couter;
  }

  // Exercise 8
  public static <T> List<T> printLots(List<T> list, List<Integer> index) throws NullPointerException {
    return null;
  }

  // Exercise 9
  public static void duplicateValues(List<Integer> list) throws NullPointerException {

  }

  // Exercise 10
  public static Integer getMorePatients(Hospital chuo) {

    Iterator<Doctor> doctores = chuo.getDoctors().iterator();
    
    Doctor doctorMayor = doctores.next();

    while (doctores.hasNext()) {  
      Doctor doctorSiguiente = doctores.next();
      if (doctorMayor.getPatients().size() <= doctorSiguiente.getPatients().size()) {
        doctorMayor = doctorSiguiente;        
      }
    }

    return doctorMayor.getNumero();
  }

  // Exercise 11
  // En este ejercicio debes implementar los métodos get y set de la clase
  // es.uvigo.esei.aed1.activity7.sparsematrix.ListNumberSparseMatrix

}
