//Brij Patel 101008373 Java Stack Reference Based Implementation
public class Stack{
private static Node top;
private static int items;

public Stack(){
  top = null;
  items = 0;
}

public boolean isEmpty(){
  if(top == null){
    return true; //stack is empty
  }
    return false;
}

public void popAll(){
  top = null;
  items = 0;
}

public static void push(Node newItem){
  newItem.setNext(top);
  top = newItem;
  items = items + 1;
}

public void pop (){
  if(top != null){
    Node temp = top;
    top = top.getNext();
  }
}

public static String peek(){
  return top.getValue();
}

public static void main (String[] args){
Stack test = new Stack();
push(new Node("12"));
System.out.println(peek());
push(new Node("31"));
push(new Node("21"));
System.out.println(test);

}
}
