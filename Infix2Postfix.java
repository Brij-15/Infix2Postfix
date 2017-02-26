import java.util.*;

public class Infix2Postfix{
public static void main (String[] args){
  String input;
  String temp;
  Stack holder = new Stack();
  System.out.println("Please enter expression: ");
  input = System.console().readLine();
  String postFix[] = new String[input.length()];
  System.out.println(input);
  for(int i = 0; i < input.length(); i++){
    temp = input.charAt(i);
    if(temp >= 0 && temp < 10){
      postFix[i] = temp;
    }//end if that compares numbers
    else if(temp.equals("+")||temp.equals("-")||temp.equals("*")||temp.equals("/")){
      if(holder.isEmpty() == true){
        holder.push(new Node(temp));
      }
      else if(holder.peek().equals("+") || holder.peek().equals("-")){
        holder.push(new Node(temp));
      }//compares operator to + and - and if they are on top of stack you push * -
      else if(holder.peek().equals("*") || holder.peek().equals("/")){
        postFix[i] = holder.peek();
        holder.peek();
          if(holder.isEmpty() == false){
            holder.pop();
            postFix[i+1] = holder.peek();
            i = i + 1; 
          }
      }
    }//end else if that checks for operator
  }// end for
}// end main

}
