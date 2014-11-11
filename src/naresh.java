import java.util.Hashtable;


public class naresh {
	static Hashtable<Integer,Integer> list = new Hashtable<Integer,Integer>(); 
	public static void main(String[] args){
		list.put(14,3);
		System.out.println(list.containsKey(14));
		System.out.println(list.contains(3));
		System.out.println(list.get(14));
		System.out.println(((int)(Math.random()*6))+1
				);
	}
	
}
