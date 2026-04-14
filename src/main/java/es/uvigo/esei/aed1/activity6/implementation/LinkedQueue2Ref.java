
package es.uvigo.esei.aed1.activity6.implementation;

import static java.util.Objects.requireNonNull;

public class LinkedQueue2Ref<T> implements CustomQueue<T> {
  private Node<T> first;
  private Node<T> last;
  private int numberOfElements;

  public LinkedQueue2Ref() {
    this.first = null;
    this.last = null;
    this.numberOfElements = 0;
  }

  @Override
  public boolean isEmpty() {
    return numberOfElements == 0;
  }

  @Override
  public int size() {
    return numberOfElements;
  }

  @Override
  public T first() throws EmptyException {
    if (this.isEmpty()) {
      throw new EmptyException();
    }

    return this.first.getValue();
  }

  @Override
  public void add(T value) throws NullPointerException {
    // if (value == null) {
    //   throw new NullPointerException();
    // }
    requireNonNull(value);

    Node<T> newNode = new Node<T>(value, null);

    if (this.isEmpty()) {
      this.first = newNode;
    } else {
      this.last.setNext(newNode);
    }

    this.last = newNode;
    this.numberOfElements++;
  }

  @Override
  public T remove() throws EmptyException {
    if (this.isEmpty()) {
      throw new EmptyException();
    }

    T nodeRemoved = this.first.getValue();
    this.first = this.first.getNext();

    if (this.first == null)
      this.last = null;

    this.numberOfElements--;
    return nodeRemoved;
  }

  @Override
  public void clear() {
    this.first = this.last = null;
    this.numberOfElements = 0;
  }

}
