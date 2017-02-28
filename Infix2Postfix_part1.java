import java.util.*;
import java.lang.*;
public class Infix2Postfix_part1{
public static void main (String[] args){
  String input;
  String minus = "-";
  String plus = "+";
  String multi = "*";
  String div = "/";
  String postFix = "";
  Stack holder = new Stack();
  StringBuilder poststr = new StringBuilder();
  Scanner Scan = new Scanner(System.in);
  Character temp;
  System.out.println("Please enter expression: ");
  input = Scan.nextLine();
  System.out.println(input);
  for(int i = 0; i < input.length(); i++){
	  temp = input.charAt(i);
	  String temp2 = temp.toString();
      if(temp2 != "+" && temp2 != "-" && temp2 != "*" && temp2 != "/"){
      postFix = postFix + temp2;
      }//checks if temp isn't a symbol
      else {
      if(holder.isEmpty() == true){
        holder.push(new Node(temp2));
      }
      else if(holder.peek().equals(plus) || holder.peek().equals(minus)){
        holder.push(new Node(temp2));
      }//compares operator to + and - and if they are on top of stack you push * -
      else if(holder.peek().equals(multi)|| holder.peek().equals(div)){
        postFix = holder.peek() + postFix;
        holder.peek();
          if(holder.isEmpty() == false){
            holder.pop();
            //postFix[i+1] = holder.peek();
            //i = i + 1;
          }
      }
    }//end else if that checks for operator
    System.out.println(postFix);
  }// end for
}// end main

}
