package es.uvigo.esei.aed1.activity3.orderedByValueLinkedDummy;

import es.uvigo.esei.aed1.commonLinked.Node;

public class OrderedByValueLinkedDummy {
  private NodePair dummy;
  private int numberOfElements;

  public OrderedByValueLinkedDummy() {
    this.dummy = new NodePair(null, null);
    this.numberOfElements = 0;
  }

  public boolean contains(int value) {
    NodePair current = this.dummy.getNext();
    while (current != null && current.getPair().getValue() < value) {
      current = current.getNext();
    }
    return current != null && current.getPair().getValue() == value;
  }

  public void add(int value) {
    NodePair current = this.dummy;
    while (current.getNext() != null && current.getNext().getPair().getValue() < value) {
      current = current.getNext();
    }
    if (current.getNext() != null && current.getNext().getPair().getValue() == value) {
      current.getNext().getPair().setCounter(current.getNext().getPair().getCounter() + 1);
    } else {
      NodePair newPair = new NodePair(new Pair(1, value), current.getNext());
      current.setNext(newPair);
    }
    numberOfElements++;
  }

  public void remove(int value) {
    NodePair current = this.dummy;
    while (current.getNext() != null && current.getNext().getPair().getValue() < value) {
      current = current.getNext();
    }
    if (current.getNext() == null || current.getNext().getPair().getValue() > value) {
      System.out.println("Valor no encontrado");
    } else {
      if (current.getNext() != null && current.getNext().getPair().getCounter() == 1) {
        current.setNext(current.getNext().getNext());
      }else{
        current.getNext().getPair().setCounter(current.getNext().getPair().getCounter() - 1);
      }
      this.numberOfElements--;
    }
  }

  @Override
  public String toString() {
    // StringBuilder sd = new StringBuilder();
    // for (NodePair current = this.dummy.getNext(); current != null; current.getNext()) {
    //   sd.append(" [" + current.getPair().getCounter() + "," + current.getPair().getValue() + "] ");
    // }
    // return sd.toString();
    String toString = "";
    for (NodePair current = this.dummy.getNext(); current != null; current.getNext()) {
      toString += current.getPair() + " ";
    }
    return toString;
  }
}
