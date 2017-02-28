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

public char peek(){
  return top.getValue();
}

public static void print(){
	for(Node temp = top; temp != null; temp = temp.getNext()){
		System.out.println(temp.getValue());		
	}
}

public static void main (String[] args){
Stack test = new Stack();
char first = '1';
char second = '2';
char third = '3';

test.push(new Node(first));
System.out.println(test.peek());
test.push(new Node(second));
test.push(new Node(third));
System.out.println(test.peek());
test.pop();
test.pop();
System.out.println(test.peek());
//System.out.println(test);

}
}
