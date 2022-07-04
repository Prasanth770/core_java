package Emp;
import java.util.*;

class Pro
{
	String name;
	int age, id;
	int phone;
	String address, dept;
	Pro()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter name :");
		name=sc.nextLine();
		System.out.println("Enter Age :");
		age=sc.nextInt();
		System.out.println("Enter phone :");
		phone=sc.nextInt();
		System.out.println("Enter address :");
		address=sc.next();
		
		
	}
	void display()
	{
		System.out.println("Id : "+id+"NAME:"+name+ "\nAGE:"+age+ "DEPT : "+dept+"\nPhone:"+phone+"\nAddress:"+address);	
	}
	
	
}

class Student extends Pro {
	int sid;
	String dept;
	public Student(){
		Scanner ssc=new Scanner(System.in);
		System.out.println("Enter Id :");
		sid=ssc.nextInt();
		System.out.println("Enter Student Couse :");
		dept=ssc.next();
		
	}
	void display()
	{
		System.out.println("Id : "+sid+"\nNAME : "+name+ "\nAGE : "+age+"\nCourse : "+dept+"\nPhone : "+phone+"\nAddress : "+address);	
	}
	
	
}

class Staff extends Pro{
	int fid;
	String dept;
	Staff() {
		Scanner fsc=new Scanner(System.in);
		System.out.println("Enter Faculty Id : ");
		fid=fsc.nextInt();
		System.out.println("Enter Faculty dept :");
		dept=fsc.next();
	}
	
	void display()
	{
		System.out.println("Id : "+fid+"\nNAME:"+name+ "\nAGE:"+age+"\nDept"+dept+"\nPhone:"+phone+"\nAddress:"+address);	
	}

	
}

public class Profile {
	public static void main(String args[])
	{
		int ch1=0,ch2=0;
		
	//	ArrayList<Emp> list=new ArrayList<Emp>();
		LinkedList list = new LinkedList();
		do{ 
		System.out.println("--------------------------------");
		System.out.println("1.Registration");
		System.out.println("2.Display Records");
		System.out.println("3.Services");
		System.out.println("4.Time Tables");
		System.out.println("5.Exit");
		System.out.println("--------------------------------");
		System.out.println("Enter your Choice: ");
		Scanner sc1=new Scanner(System.in);
		ch1=sc1.nextInt();

			if(ch1==1){
			do{
				System.out.println("--------------------------------");
				System.out.println("1.Student");
				System.out.println("2.Staff");
				System.out.println("3.-----");
				System.out.println("4.Exit");
				System.out.println("--------------------------------");
				System.out.println("Enter your Choice: ");
				Scanner sc2=new Scanner(System.in);
				ch2=sc2.nextInt();
				switch(ch2){
					case 1:
						
						list.add( new Student() );
						
						break;
						
					case 2:
						list.add(new Staff());
						break;
					
					case 3:
						System.out.println("1.Hostel");
						System.out.println("2.Library");
						System.out.println("3.Attendence");
						System.out.println("4.Examination");
						
						break;
						
					case 4:
						
						System.out.println("-------------------------------------------------------------------");
						System.out.println("----------YOU WILL BE REDIRECTED BACK TO MENU----------------------");
						break;
					}
			}while(ch2!=5);
		}
		if(ch1==2)
		{
			System.out.println("--------------------------------");
			Iterator i=list.iterator();
			while(i.hasNext())
			{
				Pro x=(Pro) i.next();
				x.display();
				System.out.println("--------------------------------");
			}
			
		}
		if(ch1==3)
		{
			System.out.println("--------------------------------");
			System.out.println("1.Hostel");
			System.out.println("2.Library");
			System.out.println("3.Attendence");
			System.out.println("4.Examination");
			System.out.println("--------------------------------");
			System.out.println("---ONLY FOR OPTIONS-----");
			System.out.println("----------YOU WILL BE REDIRECTED BACK TO MENU----------------------");
			
		}
		if(ch1==4) {
			System.out.println("----------Time tables will be displayed here--------");
			System.out.println("----------YOU WILL BE REDIRECTED BACK TO MENU----------------------");
			
			
		}
		
		
		}while(ch1!=5);
		System.out.println("---------END--------");
	}
}