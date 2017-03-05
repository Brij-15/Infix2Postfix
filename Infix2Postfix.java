import java.lang.*;
import java.util.*;
public class Infix2Postfix {
public static void main (String[] args){
	String input = "";
	Scanner scan = new Scanner(System.in);
	while(input != "done"){
	System.out.println("Please enter in expression you want converted :");
	input = scan.nextLine();
	System.out.println("The postFix notation is " + convert(input));
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
	Character space = ' ';
	Character num1, num2,checkSpace;
	int t1=0,t2=0,t3;
	String w1,w2,w3;
	char temp;
	StringBuilder postStr = new StringBuilder();
	StringBuilder calcStr = new StringBuilder();
	StringBuilder result_ch = new StringBuilder();
	
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
		for(int j = 0; j < postStr.length(); j++){ //calculation starts
			//if(postStr.charAt(j) != space){
			calcStr.append(postStr.charAt(j));
			//}
		}
		for(int k = 0; k < calcStr.length(); k++){
			Character a = calcStr.charAt(k);
			if(a == plus || a == minus || a == multi || a == div){
				if(a == plus){
					num1 = calcStk.peek();
					if(num1 == space){
						calcStk.pop();
						num1 = calcStk.peek();
					}
					calcStk.pop();
					if(calcStk.isEmpty() == false){
					checkSpace = calcStk.peek();
					if(checkSpace != space){
						w1 = num1.toString();
						w2 = checkSpace.toString();
						t1 = Integer.parseInt(w1);
						t3 = Integer.parseInt(w2);
						t3 = t3*10;
						t1 = t1+t3;
						calcStk.pop();
					} else {
						calcStk.pop();
						 t1 = Character.getNumericValue(num1);
					}
					} 
					num2 = calcStk.peek();
					calcStk.pop();
					if(num2 == space){
						num2 = calcStk.peek();
					}
					if(calcStk.isEmpty() == false){
					calcStk.pop();
					checkSpace = calcStk.peek();
					if(checkSpace != space){
						w1 = num2.toString();
						w2 = checkSpace.toString();
						t2 = Integer.parseInt(w1);
						t3 = Integer.parseInt(w2);
						t3 = t3*10;
						t2 = t2+t3;
					} 
					} else {
						t2 = Character.getNumericValue(num2);
					}
					int result = t1 + t2;
					result_ch.append(Integer.toString(result).charAt(0));
					result_ch.append(Integer.toString(result).charAt(1));
					
				}//doneish 
				else if(a == minus){
					num1 = calcStk.peek();
					if(num1 == space){
						calcStk.pop();
						num1 = calcStk.peek();
					}
					calcStk.pop();
					if(calcStk.isEmpty() == false){
					checkSpace = calcStk.peek();
					if(checkSpace != space){
						w1 = num1.toString();
						w2 = checkSpace.toString();
						t1 = Integer.parseInt(w1);
						t3 = Integer.parseInt(w2);
						t3 = t3*10;
						t1 = t1+t3;
						calcStk.pop();
					} else {
						calcStk.pop();
						 t1 = Character.getNumericValue(num1);
					}
					} 
					num2 = calcStk.peek();
					if(num2 == space){
						calcStk.pop();
						num2 = calcStk.peek();
					}
					calcStk.pop();
					if(calcStk.isEmpty() == false){
					//calcStk.pop();
					checkSpace = calcStk.peek();
					if(checkSpace != space){
						w1 = num2.toString();
						w2 = checkSpace.toString();
						t2 = Integer.parseInt(w1);
						t3 = Integer.parseInt(w2);
						t3 = t3*10;
						t2 = t2+t3;
					} 
					} else {
						t2 = Character.getNumericValue(num2);
					}
					int result = t2 - t1;
					if(result > 9){
					result_ch.append(Integer.toString(result).charAt(0));
					result_ch.append(Integer.toString(result).charAt(1));
					} else {
						result_ch.append(Integer.toString(result).charAt(0));
					}
				}
				else if(a == multi){
					num1 = calcStk.peek();
					if(num1 == space){
						calcStk.pop();
						num1 = calcStk.peek();
					}
					calcStk.pop();
					if(calcStk.isEmpty() == false){
					checkSpace = calcStk.peek();
					if(checkSpace != space){
						w1 = num1.toString();
						w2 = checkSpace.toString();
						t1 = Integer.parseInt(w1);
						t3 = Integer.parseInt(w2);
						t3 = t3*10;
						t1 = t1+t3;
						calcStk.pop();
					} else {
						calcStk.pop();
						 t1 = Character.getNumericValue(num1);
					}
					} 
					num2 = calcStk.peek();
					if(num2 == space){
						calcStk.pop();
						num2 = calcStk.peek();
					}
					calcStk.pop();
					if(calcStk.isEmpty() == false){
					//calcStk.pop();
					checkSpace = calcStk.peek();
					if(checkSpace != space){
						w1 = num2.toString();
						w2 = checkSpace.toString();
						t2 = Integer.parseInt(w1);
						t3 = Integer.parseInt(w2);
						t3 = t3*10;
						t2 = t2+t3;
					} 
					} else {
						t2 = Character.getNumericValue(num2);
					}
					int result = t2 * t1;
					if(result > 9){
					result_ch.append(Integer.toString(result).charAt(0));
					result_ch.append(Integer.toString(result).charAt(1));
					} else {
						result_ch.append(Integer.toString(result).charAt(0));
					}
				}
				else if(a == div){
					num1 = calcStk.peek();
					if(num1 == space){
						calcStk.pop();
						num1 = calcStk.peek();
					}
					calcStk.pop();
					if(calcStk.isEmpty() == false){
					checkSpace = calcStk.peek();
					if(checkSpace != space){
						w1 = num1.toString();
						w2 = checkSpace.toString();
						t1 = Integer.parseInt(w1);
						t3 = Integer.parseInt(w2);
						t3 = t3*10;
						t1 = t1+t3;
						calcStk.pop();
					} else {
						calcStk.pop();
						 t1 = Character.getNumericValue(num1);
					}
					} 
					num2 = calcStk.peek();
					if(num2 == space){
						calcStk.pop();
						num2 = calcStk.peek();
					}
					//calcStk.pop();
					if(calcStk.isEmpty() == false){
					calcStk.pop();
					checkSpace = calcStk.peek();
					if(checkSpace != space){
						w1 = num2.toString();
						w2 = checkSpace.toString();
						t2 = Integer.parseInt(w1);
						t3 = Integer.parseInt(w2);
						t3 = t3*10;
						t2 = t2+t3;
					} 
					} else {
						t2 = Character.getNumericValue(num2);
					}
					int result = t2 / t1;
					if(result > 9){
					result_ch.append(Integer.toString(result).charAt(0));
					result_ch.append(Integer.toString(result).charAt(1));
					} else {
						result_ch.append(Integer.toString(result).charAt(0));
					}
				}
			} else { // a is a number
				calcStk.push(new Node(a));
			}
		}
		System.out.println("The answer is "+result_ch);
	return postStr;
}

}
