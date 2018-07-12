import java.util.*;

class Solution1{

public static HashMap<Character,String> tokens=new HashMap<>();

public static Set<String> set=new HashSet<>();
Solution1(){
tokens.put('a' ,".-");
tokens.put('b',"-...");
tokens.put('c' ,"-.-.");
tokens.put('d',"-..");
tokens.put('e', ".");
tokens.put('f' ,"..-.");
tokens.put('g' ,"--.");
tokens.put('h' ,"....");
tokens.put('i' ,"..");
tokens.put('j' ,".---");
tokens.put('k' ,"-.-");
tokens.put('l',".-..");
tokens.put('m',"--");	
tokens.put('n' ,"-.");
tokens.put('o' ,"---");
tokens.put('p',".--.");
tokens.put('q',"--.-");
tokens.put('r',".-.");
tokens.put('s' ,"...");
tokens.put('t' ,"-");
tokens.put('u' ,"..-");
tokens.put('v' ,"...-");
tokens.put('w' ,".--");
tokens.put('x' ,"-..-");
tokens.put('y' ,"-.--");
tokens.put('z' ,"--..");
}

public static int compute(String[] s){

	set.clear();
	
	for(String str:s){
		String s1="";
	for(char y : str.toCharArray()){ 
         s1+=tokens.get(y);
             }

	set.add(s1);
	}

//	System.out.println(set.toString());
	return set.size();
}

public static void main(String[] args) {
	Solution1 sol=new Solution1();
	String[] array={"gin", "zen", "gig", "msg"};
	int result1 =sol.compute(array);
	System.out.println(result1);

	Solution1 sol2=new Solution1();
	String[] array1={"a", "z", "g", "m"};
	int result2 =sol2.compute(array1);
	System.out.println(result2);

	Solution1 sol3=new Solution1();
	
	String[] array2={"bhi", "vsv", "sgh", "vbi"};
	int result3 =sol3.compute(array2);
	System.out.println(result3);

	Solution1 sol4=new Solution1();
	String[] array3={"a", "b", "c", "d"};
	int result4 =sol4.compute(array3);
	System.out.println(result4);

	Solution1 sol5=new Solution1();
	String[] array4={"hig", "sip", "pot"};
	int result5 =sol5.compute(array4);
	System.out.println(result5);
}

}