
package es.uvigo.esei.aed1.activity5;

import java.util.ArrayList;
import java.util.Set;

import es.uvigo.esei.aed1.tads.stack.LinkedStack;
import es.uvigo.esei.aed1.tads.stack.Stack;

public class Activity5 {

  // Exercise 1
  public static String reverseWords(String text) {
    return null;
  }

  // Exercise 2 i
  public static <T> boolean equalStacks(Stack<T> stack1, Stack<T> stack2) throws NullPointerException {
    if (stack1 == null || stack2 == null)
      throw new NullPointerException("Una pila es null");

    if (stack1.size() == stack2.size()) {
      while (!stack1.isEmpty() && stack1.top().equals(stack2.top())) {
        stack1.pop();
        stack2.pop();
      }
    }
    return stack1.isEmpty() && stack2.isEmpty();
  }

  // Exercise 2 ii
  public static <T> Stack<T> copy(Stack<T> stack) throws NullPointerException {
    if (stack == null)
      throw new NullPointerException("La pila es null");

    Stack<T> auxStack = new LinkedStack<>(), copy = new LinkedStack<>();
    while (!stack.isEmpty()) {
      auxStack.push(stack.pop());
    }
    while (!auxStack.isEmpty()) {
      copy.push(auxStack.top());
      stack.push(auxStack.pop());
    }
    return copy;
  }

  // Exercise 3
  public static String fromBase10ToBase2(int numberBase10) {
    return null;
  }

  // Exercise 4
  public static int getNumDiamonds(String sand) {
    Stack<Character> aux = new LinkedStack<>();
    int cout = 0;
    for (int i = 0; i < sand.length(); i++) {
      if (!aux.isEmpty() && sand.charAt(i) == '>') {
        aux.pop();
        cout++;
      } else if (sand.charAt(i) == '<') {
        aux.push(sand.charAt(i));
      }
    }
    return cout;
  }

  // Exercise 5
  public static String codifyMessage(String message) {
    return null;
  }

  // Exercise 6
  public static <T> T unstackAnItem(Stack<T> stack, int index) throws NullPointerException, IllegalArgumentException {

    if (stack == null)
      throw new NullPointerException();

    if (index < 1 || index > stack.size())
      throw new IllegalArgumentException();

    Stack<T> aux = new LinkedStack<>();

    for (int i = 1; i < index; i++)
      aux.push(stack.pop());

    T unstacked = stack.pop();

    while (!aux.isEmpty()) {
      stack.push(aux.pop());
    }
    return unstacked;
  }

  // Exercice 7
  public static boolean isWellParentized(String mathExpression) {
    Stack<Character> aux = new LinkedStack<>();
    Set<Character> keysOpen = Set.of('{', '(', '[');
    Set<Character> keysClose = Set.of('}', ')', ']');

    for (int i = 0; i < mathExpression.length(); i++) {
      if (!aux.isEmpty() && keysClose.contains(mathExpression.charAt(i))) {
        switch (mathExpression.charAt(i)) {
          case '}':
            if (aux.top() == '{')
              aux.pop();
            break;
          case ')':
            if (aux.top() == '(')
              aux.pop();
            break;
          case ']':
            if (aux.top() == '[')
              aux.pop();
            break;
          default:
            return false;
        }
      } else if (keysOpen.contains(mathExpression.charAt(i))) {
        aux.push(mathExpression.charAt(i));
      } else { // esta mal implementado mete basura
        aux.push(mathExpression.charAt(i));
      }
    }
    return aux.isEmpty();
  }

  // Exercise 8
  public static String addDigits(int number) {
    return null;
  }

  // Exercise 9
  public static String removeCharDuplicated(String text) {
    return null;
  }

  // Exercise 10
  public static <T> void replaceValues(Stack<T> stack, T newValue, T oldValue) throws NullPointerException {

  }

  // Exercise 11
  public static <T> void pushValuesLimited(Stack<T> stack, T value) throws NullPointerException {

  }

}
