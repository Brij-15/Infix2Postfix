//Implementing the Node class used to make the reference based stack
public class Node{
  private char value;
  private Node next;

  public Node(char value){
    this.value = value;
    next = null;
  }
  public char getValue(){
    return value;
  }
  public Node getNext(){
    return this.next;
  }
  public void setValue(char value){
    this.value = value;
  }
  public void setNext(Node Next){
    this.next = Next;
  }

}
