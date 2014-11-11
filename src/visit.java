import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;
import java.io.*;
class customer {
	Hashtable<String,String> list = new Hashtable<String,String>(); 
	String name;
	boolean member =false;
	String memberType ;

	public void dadd(){
		list.put("naresh","premium");
		list.put("teja","gold");
		list.put("anvesh","silver");
		list.put("anvesh1","premium");
	}
	public boolean addCustomer(String name ,  int amnt   ){
		String type=null;
		if (amnt==3000) {
			type="premium";
		}
		else if(amnt==2000){
			type="gold";

		}
		else if(amnt==1000){
			type="silver";
		}
		list.put(name,type);
		System.out.println("...........registered succesfully.................");
		setMemberType(type);
		if (this.memberType != null) {
			setMember(true);
		}
		return true;

	}

	public customer() {
		// TODO Auto-generated constructor stub
	}
	public String getName(){
		//System.out.println("at customer"+this.name);
		return this.name;
	}
	public boolean isMember(){
		return this.member;
	}
	public void setMember(boolean member){
		this.member=member;
	}
	public String getMemberType(){
		return this.memberType;
	}
	public void setMemberType(String memberType){
		this.memberType=memberType;
	}
	public void customer(String name) {
		// TODO Auto-generated method stub
		dadd();
		this.name=name;
		if(list.containsKey(name)) {
			System.out.println(list.get(name));
			setMemberType(list.get(name));
			setMember(true);
		}
		else {
			System.out.println("not our member ");
			System.out.println("do you want to register");
			System.out.println("our membership types");
			System.out.println(" RS : 3000 for premium");
			System.out.println(" RS : 2000 for gold");
			System.out.println(" RS : 1000 fo r silver");
			System.out.println("enter amnt ");
			Scanner sc= new Scanner(System.in);
			addCustomer(name ,sc.nextInt());
		}
		//System.out.println("at customer methood"+this.name);
	}
}
public class visit {

	customer c=new customer();
	Date date;
	double serviceexpenses;
	double productexpenses;
	public visit(String name,Date date){
		c.customer(name);
		this.date=date;
		//System.out.println(c.name);
	}
	public visit() {
		// TODO Auto-generated constructor stub
	}
	public String getName(){
		return c.getName();
	}
	public double getserviceexpense(){
		return this.serviceexpenses;
	}
	public void setserviceexpense(double d){
		this.serviceexpenses=d;
	}
	public double getproductexpense(){
		return this.productexpenses;
	}
	public void setproductexpense(double d){
		this.productexpenses=d;
	}
	public String getMembershipType(){
		return c.memberType;
	}
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("enter coustomer name");
		Scanner sc=new Scanner(System.in);
		discountrate d= new discountrate();
		visit  v= new visit(sc.next(), date);
		System.out.println(date.toString());
		System.out.println("amount of service");
		v.setserviceexpense(sc.nextInt());
		System.out.println("amount of product");
		v.setproductexpense(sc.nextInt());
		System.out.println( "hello "+ v.getName()+ " you are our  "+ v.getMembershipType() +" customer");
		System.out.println("payment processing please wait");
		System.out.println("................................");
		System.out.println("getting discounts ");
		System.out.println(d.getServiceDiscount(v.getMembershipType()));
		System.out.println(d.getProductDiscount(v.getMembershipType()));
		v.setserviceexpense(v.getserviceexpense()-(v.getserviceexpense()*d.getServiceDiscount(v.getMembershipType())));
		v.setproductexpense(v.getproductexpense()-(v.getproductexpense()*d.getProductDiscount(v.getMembershipType())));
		System.out.println(v.getserviceexpense());
		System.out.println(v.getproductexpense());
		System.out.println(v.getserviceexpense()+v.getproductexpense());

	}
}
class discountrate {
	static double serivceDiscountPremium=0.2;
	static double serivceDiscountGold=0.15;
	static double serivceDiscountSilver=0.1;
	static double productDiscountPremium=0.1;
	static double productDiscountGold=0.1;
	static double productDiscountSilver=0.1;
	public  static double getServiceDiscount(String type){
		if (type.equalsIgnoreCase("premium")) {
			return 0.2;
		}
		else if (type.equalsIgnoreCase("gold")) {
			return 0.15;
		}
		else if(type.equalsIgnoreCase("silver")){
			return 0.10;
		}
		else{
			return 0.0;
		}
	}
	public  static double getProductDiscount(String type){
		return 0.1;
	}

}

