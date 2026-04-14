
package es.uvigo.esei.aed1.activity2.doublyLinked;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

public class DoublyLinked {

  private DoubleNode first;
  private DoubleNode last;
  private int numberOfElements;

  public DoublyLinked() {
    this.first = null;
    this.last = null;
    this.numberOfElements = 0;
  }

  public boolean isEmpty() {
    return this.numberOfElements == 0;
  }

  public int size() {
    return this.numberOfElements;
  }

  public int numberOfOccurrences(int value) {
    int number = 0;

    for (DoubleNode current = this.first; current != null; current = current.getNext()) {
      if (current.hasValue(value)) {
        number++;
      }
    }

    return number;
  }

  public boolean contains(int value) {
    DoubleNode current = this.first;

    while (current != null && !current.hasValue(value)) {
      current = current.getNext();
    }

    return current != null;
  }

  public void addFirst(int value) {
    DoubleNode newDNode = new DoubleNode(null, value, first);
    if (this.isEmpty()) {
      this.last = newDNode;
    } else {
      this.first.setPrevious(newDNode);
    }
    this.first = newDNode;
    this.numberOfElements++;
  }

  public void addLast(int value) {
    DoubleNode newDNode = new DoubleNode(this.last, value, null);
    if (this.isEmpty()) {
      this.first = newDNode;
    } else {
      this.last.setNext(newDNode);
    }
    this.last = newDNode;
    this.numberOfElements++;
  }

  public void remove(int value) {
    if (isEmpty()) {
      System.out.println("Lista vacia");
    } else {
      if (this.first == this.last && this.first.hasValue(value)) {
        this.first = this.last = null;
        numberOfElements--;
      } else {
        if (this.first.hasValue(value)) {
          this.first.getNext().setPrevious(null);
          this.first = this.first.getNext();
          numberOfElements--;
        } else if (this.last.hasValue(value)) {
          this.last.getPrevious().setNext(null);
          this.last = this.last.getPrevious();
          numberOfElements--;
        } else {
          DoubleNode current = this.first.getNext();
          while (current != null && !current.hasValue(value)) {
            current = current.getNext();
          }
          if (current == null) {
            System.out.println("Elemento no contenido enla lista");
          } else {
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
            numberOfElements--;
          }
        }
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder sd = new StringBuilder();
    for (DoubleNode current = this.first; current != null; current = current.getNext()) {

    }
    return "";
  }

}
