package reservedWords;


import java.util.*;

public class ReservedWords {
	static ArrayList<String> reservedWords = new ArrayList<String>();
	static String[] words= {"abstract","assert","boolean","break","byte","switch","catch","char","class","const","continue","default","do","double","else","enum","extends","false","final","finally","float","for","goto","if","implements","import","instanceof","int","interface","long","native","new","null","package","private","protected","public","return","short","static","strictfp","super","case","synchronized","this","throw","throws","transient","true","try","void","volatile","while"};
	static String[] Hints=new String[53];
	static int sum=2;
	
	public static void main(String args[]) {
		initializeArrayList();
		initializeHints();
		Scanner scanner=new Scanner(System.in);
		System.out.print("Test je kennis van Java reserved words. \nKan jij ze allemaal opnoemen?\n ");
		do {
			vraagWoord(scanner);
		}while(!reservedWords.isEmpty());
		
		System.out.println("\n**************************************************\nTopper! Je hebt gewoon alle reserved words opgenoemd. \nMisschien de 10 laatst geraden woorden nog eens extra stampen?\nSucces!");
		scanner.close();
	}
	
	static void vraagWoord(Scanner scanner) {
		System.out.print("\n==============================");
		System.out.println("\n\tNog "+reservedWords.size()+" te gaan \nVoer een reserved word in, of toets H voor een hint: ");
		while (true){
			String input = scanner.next();
			int i = reservedWords.indexOf(input);
			if (i>-1) {
				System.out.println("Goed bezig! '"+input+"' is inderdaad een reserved word.");
				reservedWords.remove(i);
				break;
			} else if (reservedWords.contains(input.toLowerCase())) {
				System.out.println("De reserved words zijn altijd met kleine letters. ");
				continue;
			} else if (input.equalsIgnoreCase("H")) {
				vraagHint(scanner);
				break;
			} else {
				int counter=0;
				for(String w:words) {
					counter++;
					if (w.equals(input)) {
						System.out.print("Dit woord had je al eens opgegeven. ");
						counter--;
					}
				}
				if(counter>52) {
					System.out.print("Dit is geen reserved word. ");
				}
				System.out.println("Probeer het nog eens. ");
				continue;
			}
		}
	}
	
	
	static void vraagHint(Scanner scanner) {
		int index = (reservedWords.size()/sum);
		String s=reservedWords.get(index);
		for(int i=0;i<words.length;i++) {
			if(words[i].equals(s)) {
				index=i;
			}
		}
		System.out.println("Hint: "+Hints[index]);
		String input=scanner.next();
		if(!words[index].equals(input)) {
			System.out.println("Helaas, we zoeken een woord van "+words[index].length()+" letters dat begint met een '"+words[index].charAt(0)+"'.");
			input=scanner.next();
		}
		if(!words[index].equals(input)) {
			System.out.println("Helaas, we zochten het woord '"+words[index]+"'.\nWe strepen 'm voor nu nog niet van de lijst: \nkijk over een paar beurten of je het woord hebt onthouden en voer het dan alsnog in. ");
			sum++;
		} else {
			int i = reservedWords.indexOf(input);
			System.out.println("Yes, '"+input+"' is inderdaad het woord dat we zochten!");
			reservedWords.remove(i);
		}
	}
	
	static void initializeArrayList() {
		for(String s:words) {
			reservedWords.add(s);
		}
	}
	
	static void initializeHints() {
		Hints[0]="This non-access modifier can only be used on methods whose class is defined with the same non-access modifier. \nA class with this modifier cannot be instantieted. ";	//abstract
		Hints[1]="This keyword describes a predicate (a true–false statement) placed in a Java program, \nto indicate that the developer thinks that the predicate is always true at that place. ";	//assert
		Hints[2]="This primitive type can only hold one of two possible values. ";	//boolean
		Hints[3]="This keyword will stop the itterations through a loop. ";	//break
		Hints[4]="This primitive numeric has a minimum value of -128 and a maximum value of 127. ";	//byte
		Hints[5]="This keyword allows you to create a statement that evaluates a variable against one or several constant or literal values. ";	//switch
		Hints[6]="The statements in this block specify what to do if a specific type of exception is thrown by the try block. ";	//catch
		Hints[7]="This is the only primitive numeric data type that is unsigned. ";	//char
		Hints[8]="A type that defines the implementation of a particular kind of object. \nIts definition is sometimes compared to a 'blueprint'.";	//class
		Hints[9]="This word is an abbreviation of the word 'constant' and is used in C and C++.\nIt has no meaning in Java (which uses the word 'final' instead), but it's still a reserved word.";	//const
		Hints[10]="This word will let you skip to the next iteration of the loop you're in. ";	//continue
		Hints[11]="This word can be used only once in a switch statement. \nIt is also used to indicate that an interface method is not abstract. ";	//default
		Hints[12]="After this word comes a code block, followed by a conditional statement, creating a loop. \nThe block of code followed by this word is executed at least once, before the conditional statement is evaluated.";	//do
		Hints[13]="The floating point primitive type that can hold the biggest value. ";	//double
		Hints[14]="This word can be used after a codeblock following an if statement. \nThe codeblock following this word will be executed if the if condition evaluates to false. ";	//else
		Hints[15]="This keyword is used to declare an enumerated type. ";	//enum
		Hints[16]="This word is used to signify an inheritance relationship. ";	//extends
		Hints[17]="The default value assigned to a non-local boolean variable. ";	//false
		Hints[18]="Used on a class, this word ensures that no classes can inherit from that class. ";	//final
		Hints[19]="The block of code following this word will be excecuted, regardless of whether or not an exception was thrown or caught. ";	//finally
		Hints[20]="If you want to initialize this primitive variable type, you have to put an 'f' or 'F' after the literal value. ";	//float
		Hints[21]="This word can create two kinds of loops, one of which is ideal for iterating through an Array or List.";	//for
		Hints[22]="This word is not used in Java, but it's still a reserved word. \nInstead, Java allows the use of labels to break or continue a specific loop. ";	//goto
		Hints[23]="This word is used to evaluate a boolean expression. \nIf the expression evaluates as true, the following codeblock will be executed once. ";	//if
		Hints[24]="This word is used to indicate that a class uses one or more interfaces. ";	//implements
		Hints[25]="This word is used to gain access to other packages or classes or interfaces in other packages. ";	//import
		Hints[26]="This binary operator that takes an object reference as its first operand and a class or interface as its second operand. \nIt evaluates to true if and only if the runtime type of the object is assignment compatible with the class or interface. ";	//instanceof
		Hints[27]="The result of using arithmatic operators on primitive signed non-floating point numerics will automatically be stored as this type. ";	//int
		Hints[28]="This is a special kind of class that can only obtain abstract or default methods. \nIts fields are public, final and static by default. ";	//interface
		Hints[29]="A primitive data type that can hold a 64 bits integer. ";	//long
		Hints[30]="This keyword is used in method declarations. \nIt specifies that the method is not implemented in the same Java source file, but rather in another language. ";	//native
		Hints[31]="This keyword is used to create an instance of a class and call its constructor. ";	//new
		Hints[32]="Only a reference variable can hold this value. \nIf you assign this value to a referece variable, it 'breaks' the leash to the object on heap. ";	//null
		Hints[33]="Where you can store a group of similar or related classes and interfaces. ";	//package
		Hints[34]="Methods or fields defined with this keyword can only be accessed by other members of their own class. ";	//private
		Hints[35]="Methods or fields defined with this keyword can only be accessed by \nmembers of their own class, that class's subclasses or classes from the same package. ";	//protected
		Hints[36]="This keyword allows classes, methods or fields to be accesed by members of any class. ";	//public
		Hints[37]="This word is used inside a method to signify the value that is passed back to the method call. ";	//return
		Hints[38]="This primitive integer type can hold twice as many bits as a byte. ";	//short
		Hints[39]="This keyword creates a class variable or a class method (as opposed to an instance field of method). ";	//static
		Hints[40]="This keyword is used to restrict the precision and rounding of floating point calculations to ensure portability. ";	//strictfp
		Hints[41]="This keyword allows a subclass to access overridden methods and hidden members of its superclass. \nIt's also used to forward a call from a subclass constructor to a superclass constructor.";	//super
		Hints[42]="You can use this word once or more in a switch statement. \nIt can only be followed by a constant or a literal value. ";	//case		
		Hints[43]="This keyword ensures that at most one thread at a time operating on the same object executes that code. ";	//synchronized
		Hints[44]="This word can be used to access class members and as a reference to the current instance. ";	//this
		Hints[45]="This word causes the declared exception instance to be thrown. ";	//throw
		Hints[46]="This word is used in method declarations to specify which exceptions are not handled within the method, \nbut rather passed to the next higher level of the program. ";	//throws
		Hints[47]="This word declares that an instance field is not part of the default serialized form of an object. ";	//transient
		Hints[48]="If this is the outcome of evaluating a condition, the block of code associated with that condition will be executed. ";	//true
		Hints[49]="This word defines a block of statements that have exception handling. ";	//try
		Hints[50]="This word is used to signify that a method does not return any value. ";	//void
		Hints[51]="This word is used in field declarations to specify that the variable is modified asynchronously by concurrently running threads.";	//volatile
		Hints[52]="This word can be used to evaluate a condition before a loop, \nor can be used at the end of a block of code following the 'do' keyword. ";	//while
	}
}
