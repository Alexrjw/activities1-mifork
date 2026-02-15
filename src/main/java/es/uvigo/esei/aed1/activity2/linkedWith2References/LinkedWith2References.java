package es.uvigo.esei.aed1.activity2.linkedWith2References;

import es.uvigo.esei.aed1.commonLinked.Node;

public class LinkedWith2References {
  private Node first;
  private Node last;
  private int size;

  public LinkedWith2References() {
    first = null;
    last = null;
    size = 0;
  }

  /**
   * Returns true if the list is empty, false otherwise.
   * 
   * @return
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns the number of elements in the list.
   * 
   * @return
   */
  public int size() {
    return size;
  }

  /**
   * Returns the number of ocurrences of value in the list.
   * 
   * @param value
   * @return
   */
  public int numberOfOccurrences(int value) {
    int number = 0;
    // Node current = this.first;
    // while (current.hasValue(value) && current != null) {
    // if (current.hasValue(value)) {
    // number++;
    // }
    // current = current.getNext();
    // }
    for (Node current = this.first; current != null; current = current.getNext()) {
      if (current.hasValue(value))
        number++;

    }
    return number;
  }

  public boolean contains(int value) {
    Node current = this.first;
    while (current != null && !current.hasValue(value)) {
      current = current.getNext();
    }
    return current != null;
  }

  public void addFirst(int value) {
    Node current = new Node(value, null);
    if (this.isEmpty()) {
      this.first = this.last = current;
    } else {
      current.setNext(first);
      this.first = current;
    }
    this.size++;
  }

  public void addLast(int value) {
    Node current = new Node(value, null);
    if (this.isEmpty()) {
      this.first = this.last = current;
    } else {
      this.last.setNext(current);
      this.last = current;
    }
    this.size++;
  }

  public void remove(int value) {

    if (this.isEmpty()) {
      System.out.print(" The list is empty.");
    } else { // Is not empty
      if (this.first == this.last && this.first.hasValue(value)) { // It's the first and the only one.
        this.first = this.last = null;
        this.size--;
      } else if (this.first.hasValue(value)) {
        Node toRemove = this.first;
        this.first = toRemove.getNext();
        toRemove.setNext(null); // ayuda al GC
        this.size--;
      } else { // It's not the first

        Node current = this.first;

        while (current != null && current.getNext() != null && !current.getNext().hasValue(value)) {
          current = current.getNext();
        }
        if (current == null || current.getNext() == null) {
          System.out.print("Value is not contained.");
        } else if (current.getNext() == this.last) { // It's the last
          Node toRemove = current.getNext();
          current.setNext(null);
          this.last = current;
          toRemove.setNext(null);
          this.size--;
        } else { // It's in the middle
          Node toRemove = current.getNext();
          current.setNext(toRemove.getNext());
          toRemove.setNext(null);
          this.size--;
        }
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder tostring = new StringBuilder();
    for (Node current = this.first; current != null; current = current.getNext()) {
      tostring.append(current.getValue()).append(" ");
    }
    return tostring.toString();
  }

}
