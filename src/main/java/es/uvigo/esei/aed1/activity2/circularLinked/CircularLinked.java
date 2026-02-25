package es.uvigo.esei.aed1.activity2.circularLinked;

import es.uvigo.esei.aed1.commonLinked.Node;

public class CircularLinked {
  private Node last;
  private int valueOfElements;

  public CircularLinked() {
    this.last = null;
    this.valueOfElements = 0;
  }

  public boolean isEmpty() {
    return this.valueOfElements == 0;
  }

  public int size() {
    return this.valueOfElements;
  }

  public int firstValue() throws NullPointerException {
    if (this.isEmpty()) {
      throw new NullPointerException("Elemento vacio");
    }
    return last.getNext().getValue();
  }

  public boolean contains(int value) {
    Node current = this.last;
    int i = 0;
    if (this.isEmpty()) {
      System.out.println("No hay elementos");
    } else {
      while (!current.hasValue(value) && i < this.valueOfElements) {
        current = current.getNext();
        i++;
      }
    }
    return i != this.valueOfElements;
  }

  public boolean contains2(int value) {

    return true;
  }

  public int numberOfOccurrences(int value) {
    Node current = this.last;
    int number = 0;
    int i = 0;
    if (this.isEmpty()) {
      System.out.println("No hay elementos");
    } else {
      while (i < this.valueOfElements) {
        if (current.hasValue(value)) {
          number++;          
        }
        current = current.getNext();
        i++;
      }
    }
    return number;
  }

  public void addLast(int value) {
    Node newNode = new Node(value, null);
    if (this.isEmpty()) {
      newNode.setNext(newNode);
      this.last = newNode;
      this.valueOfElements++;
    } else {
      newNode.setNext(this.last.getNext());
      this.last.setNext(newNode);
      this.last = newNode;
      this.valueOfElements++;
    }
  }

  public void removeFirst() {
    if (this.isEmpty()) {
      System.out.println("La lista esta vacia");
    } else if (this.valueOfElements == 1) {
      this.last = null;
      this.valueOfElements--;
    } else {
      Node first = this.last.getNext();
      this.last.setNext(first.getNext()); // asocio el Next al segundo el nuevo primero
      first.setNext(null); // desvinculo first de la lista
      this.valueOfElements--;
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    Node current = this.last.getNext();
    for (int i = 0; i < this.valueOfElements; i++) {
      sb.append(current.getValue()).append(" ");
      current = current.getNext();
    }
    return sb.toString();
  }
}
