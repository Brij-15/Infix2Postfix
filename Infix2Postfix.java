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
	Character plus = '+';
	Character minus = '-';
	Character multi = '*';
	Character div = '/';
	Character Lbrac = '(';
	Character Rbrac = ')';
	char temp;
	StringBuilder postStr = new StringBuilder();
	for(int i = 0; i < input.length(); i++){
		char c = input.charAt(i);
		if(c != plus && c != minus && c != multi && c != div && c != Lbrac && c != Rbrac){
			postStr.append(c);
		}
		else if(c == Rbrac){
			temp = holder.peek();
			postStr.append(temp);
			holder.pop();
		}
		else {
			if(holder.isEmpty() == true){
				holder.push(new Node(c));
			}
			
			else if(holder.peek() == plus || holder.peek() == minus || holder.peek() == multi || holder.peek() == div){
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
				}
			}
			/*if(c == Lbrac){
				holder.push(new Node(c));
			} */
			
		}
	}
		while(holder.isEmpty() == false){
		temp = holder.peek();
		postStr.append(temp);
		holder.pop();
	}
	return postStr;
}
}
