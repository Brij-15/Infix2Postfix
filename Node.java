//Implementing the Node class used to make the reference based stack
public class Node{
  private String value;
  private Node next;

  public Node(String value){
    this.value = value;
    next = null;
  }
  public String getValue(){
    return value;
  }
  public Node getNext(){
    return this.next;
  }
  public void setValue(String value){
    this.value = value;
  }
  public void setNext(Node Next){
    this.next = Next;
  }
  public String toString(){
    return getValue();
  }

}
