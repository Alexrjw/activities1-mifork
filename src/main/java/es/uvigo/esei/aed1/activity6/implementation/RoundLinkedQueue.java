
package es.uvigo.esei.aed1.activity6.implementation;

import static java.util.Objects.requireNonNull;

public class RoundLinkedQueue<T> implements CustomQueue<T> {
  private Node<T> last;
  private int numberOfElements;

  public RoundLinkedQueue() {
    this.last = null;
    this.numberOfElements = 0;
  }

  @Override
  public boolean isEmpty() {
    return this.numberOfElements == 0;
  }

  @Override
  public int size() {
    return this.numberOfElements;
  }

  @Override
  public T first() throws EmptyException {
    if (this.isEmpty())
      throw new EmptyException();

    return this.last.getNext().getValue();
  }

  @Override
  public void add(T value) throws NullPointerException {
    requireNonNull(value);

    Node<T> newNode = new Node<T>(value, null);

    if (this.last == null) {
      newNode.setNext(newNode);
    } else {
      newNode.setNext(this.last.getNext());
      this.last.setNext(newNode);
    }
    
    this.last = newNode;
    this.numberOfElements++;
  }

  @Override
  public T remove() throws EmptyException {
    if (this.isEmpty())
      throw new EmptyException();

    T value = this.last.getNext().getValue();
    if (numberOfElements == 1) {
      this.last = null;
    }else{
      this.last.setNext(this.last.getNext().getNext());
    }

    numberOfElements--;
    return value;
  }

  @Override
  public void clear() {
    this.last = null;
    this.numberOfElements = 0;
  }
}
