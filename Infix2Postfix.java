import java.lang.*;
import java.util.*;
public class Infix2Postfix {
public static void main (String[] args){
	String input = "";
	Scanner scan = new Scanner(System.in);
	while(input != "done"){
	System.out.println("Please enter in expression you want converted :");
	input = scan.nextLine();
	System.out.println(convert(input));
	}	
	scan.close();
}

@SuppressWarnings("static-access")
public static StringBuilder convert(String input){
	Stack holder = new Stack();
	Stack calcStk = new Stack();
	Character plus = '+';
	Character minus = '-';
	Character multi = '*';
	Character div = '/';
	Character Lbrac = '(';
	Character Rbrac = ')';
	char temp;
	StringBuilder postStr = new StringBuilder();
	StringBuilder calcStr = new StringBuilder();
	
	for(int i = 0; i < input.length(); i++){
		char c = input.charAt(i);
		if(c != plus && c != minus && c != multi && c != div && c != Lbrac && c != Rbrac){
			postStr.append(c);
			try{ //if next char is a number then append it on to string b/c its greater than 9
				char t = input.charAt(i+1);
			if(t != plus && t != minus && t != multi && t != div && t != Lbrac && t != Rbrac){
				postStr.append(t +" ");
				i = i + 1;
			} else {
				postStr.append(" ");//adds space between numbers 
			}
			} catch (StringIndexOutOfBoundsException s){
				//postStr.append(" ");
			}
		}
		else if(c == Lbrac){
			holder.push(new Node(c));
		}
		else if(c == Rbrac){
			temp = holder.peek();
			postStr.append(temp);
			holder.pop();
			holder.pop();
		}
		else {
			if(holder.isEmpty() == true){
				holder.push(new Node(c));
			}
			else if(holder.peek() == plus || holder.peek() == minus || holder.peek() == multi || holder.peek() == div||holder.peek() == Lbrac || holder.peek() == Rbrac){
					if(c == div || c == multi){
						if(holder.peek() == div || holder.peek() == multi){
							temp = holder.peek();
							postStr.append(temp); 
							holder.pop();
						}
						holder.push(new Node(c));
				} 
					else if(c == plus || c == minus){
						if(holder.peek() == multi || holder.peek() == div){
							temp = holder.peek();
							postStr.append(temp);
							holder.pop();
							holder.push(new Node(c));
						}
						if(holder.peek() == Lbrac){
							holder.push(new Node(c));
						}
				}
			}
		}
	}
		while(holder.isEmpty() == false){
		temp = holder.peek();
		postStr.append(temp);
		holder.pop();
	}
		for(int j = 0; j < postStr.length(); j++){
			calcStr.append(postStr.charAt(j));
		}
		for(int k = 0; k < calcStr.length(); k++){
			char a = calcStr.charAt(k);
			if(a == plus || a == minus || a == multi || a == div){
				if(a == plus){
					int num1 = calcStk.peek();
					calcStk.pop();
					int num2 = calcStk.peek();
					calcStk.pop();
					int result = num2 + num1;
					calcStk.push(new Node((char) result)); //problem here need way to conver int to char, rn it converts it to ascii 
				}
				else if(a == minus){
					int num1 = calcStk.peek();
					calcStk.pop();
					int num2 = calcStk.peek();
					calcStk.pop();
					int result = num2 - num1;
					calcStk.push(new Node((char) result));
				}
				else if(a == multi){
					int num1 = calcStk.peek();
					calcStk.pop();
					int num2 = calcStk.peek();
					calcStk.pop();
					int result = num2 * num1;
					calcStk.push(new Node((char) result));
				}
				else if(a == div){
					int num1 = calcStk.peek();
					calcStk.pop();
					int num2 = calcStk.peek();
					calcStk.pop();
					int result = num2 / num1;
					calcStk.push(new Node((char) result));
				}
			} else { // a is a number
				calcStk.push(new Node(a));
			}
			System.out.println(" ");
			calcStk.print();
			System.out.println("");
		}
	return postStr;
}

}
