
package es.uvigo.esei.aed1.activity2.doublyLinked;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

public class DoublyLinked {

  private DoubleNode first;
  private DoubleNode last;
  private int size;

  public DoublyLinked() {
    this.first = null;
    this.last = null;
    this.size = 0;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return this.size;
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
    DoubleNode newDNode = new DoubleNode(null, value, this.first);
    if (this.isEmpty()) {
      this.first = newDNode;
      this.last = newDNode;
    } else {
      this.first.setPrevious(newDNode);
      this.first = newDNode;
    }
    size++;
  }

  public void addLast(int value) {
    DoubleNode newDNode = new DoubleNode(this.last, value, null);
    if (this.isEmpty()) {
      this.first = newDNode;
      this.last = newDNode;
    } else {
      this.last.setNext(newDNode);
      this.last = newDNode;
    }
    size++;
  }

  public void remove(int value) {
    if (this.isEmpty()) {
      return;
    }
    DoubleNode current = this.first;
    while (current != null && !current.hasValue(value)) {
      current = current.getNext();
    }
    if (current == null) {
      return;
    }
    if (current == this.first && current == this.last) {
      this.first = null;
      this.last = null;
    } else if (current == this.first) {
      this.first = this.first.getNext();
      this.first.setPrevious(null);
    } else if (current == this.last) {
      this.last = this.last.getPrevious();
      this.last.setNext(null);
    } else {
      current.getPrevious().setNext(current.getNext());
      current.getNext().setPrevious(current.getPrevious());
    }
    size--;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (DoubleNode current = this.first; current != null; current = current.getNext()) {
      sb.append(current.getValue()).append(" ");
    }
    return sb.toString();
  }

}
