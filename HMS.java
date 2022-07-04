import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.*;
class Doctor{
	String Dname, dept, specialization, location;
	int phone;
	int did;
		
	void checkReport() {
		
	}
	void PesscribeMeds() {
		
	}
	void PescribeTest() {
		
	}
}

class Patient {
	int page, pid;
	long phone;
	String address, pname, sex;
	/*
	Patient(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id :");
		pid=sc.nextInt();
		System.out.println("Enter name :");
		pname=sc.next();
		System.out.println("Enter age :");
		page=sc.nextInt();
		System.out.println("Enter phone :");
		phone=sc.nextInt();
		System.out.println("Enter sex :");
		sex=sc.next();
		System.out.println("Enter address :");
		address=sc.next();
	}*/
	
	void PayBills() {
		System.out.println("Bill Generated : ");
		
	}
	
	void pdisplay() {
		System.out.println("Id : "+pid+"\nNAME : "+pname+ "\nAGE : "+page+ "\nPHONE : "+phone+"\nSEX : "+sex+"\nADDRESS : "+address);
	}
	
}
class Department{
	int depid;
	String dept_name;
	
	Department(){
		Scanner dsc=new Scanner(System.in);
		System.out.println("Enter id :");
		depid=dsc.nextInt();
		System.out.println("Enter name :");
		dept_name=dsc.next();
	}
	
	void AddDept() {
		
	}
	void RemoveDept() {
		
	}
	void AddDoc() {
		
		
	}
	void RemDoc() {
		
	}
}
class Rooms {
	int room_no;
	String location;
}
class Admin{
	void addPatients() {
		
	}
	void remPatients() {
		
	}
	void allotPatient(){
		
	}
	void DisplayallP() {
		
	}
}


public class HMS{
	public static void main(String args[]) {

		int ch1=0,ch2=0,ch3=0,ch4=0,ch5=0;
		Patient pat =new Patient();
		int bill=0;
		
		//LinkedList<Patient> list = new LinkedList<Patient>();
		do{ 
		System.out.println("--------------------------------");
		System.out.println("Select the Portal");
		System.out.println("1.Admin");
		System.out.println("2.Doctor");
		System.out.println("3.Nurse");
		System.out.println("4.Patient");
		System.out.println("5.Department");
		System.out.println("6.Exit");
		System.out.println("--------------------------------");
		System.out.println("Enter your Choice: ");
		Scanner sc1=new Scanner(System.in);
		ch1=sc1.nextInt();

			if(ch1==1){
			do{
				System.out.println("--------------------------------");
				System.out.println("1.Add Patients");
				System.out.println("2.Add Doctors");
				System.out.println("3.Display Patients");
				System.out.println("4.Display Doctors");
				System.out.println("5.Bills");
				System.out.println("6.Exit");
				System.out.println("--------------------------------");
				System.out.println("Enter your Choice: ");
				Scanner sc2=new Scanner(System.in);
				ch2=sc2.nextInt();
				int ppid;
				switch(ch2){
					case 1:
						try {
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS","root","$Prasanth123");
							PreparedStatement stmt = con.prepareStatement("insert into patients values(?,?,?,?,?,?)");
							Scanner ppsc=new Scanner(System.in);
							System.out.println("Enter id :");
							int pid=ppsc.nextInt();
							System.out.println("Enter name :");
							String pname=ppsc.next();
							System.out.println("Enter age :");
							int page=ppsc.nextInt();
							System.out.println("Enter sex :");
							String psex=ppsc.next();
							System.out.println("Enter phone :");
							int phone=ppsc.nextInt();
							System.out.println("Enter address :");
							String address=ppsc.next();
							
							
							stmt.setInt(1, pid);
							stmt.setString(2, pname);
							stmt.setInt(3, page);
							stmt.setString(4, psex);
							stmt.setInt(5, phone); 
							stmt.setString(6, address); 
							
							stmt.execute();
							con.close();
							System.out.println("Data saved Successfully....!");
						}
						catch(Exception e) {
							System.out.println(e);
						}
						break;
						
					case 2: 
						try {
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS","root","$Prasanth123");
							PreparedStatement stmt = con.prepareStatement("insert into doctors values(?,?,?,?,?,?,?)");
							Scanner ppsc=new Scanner(System.in);
							System.out.println("Enter id :");
							int did=ppsc.nextInt();
							System.out.println("Enter name :");
							String dname=ppsc.next();
							System.out.println("Enter age :");
							int dage=ppsc.nextInt();
							System.out.println("Enter Department :");
							String ddept=ppsc.next();
							System.out.println("Enter Specilization :");
							String dspec=ppsc.next();
							System.out.println("Enter phone :");
							int dph=ppsc.nextInt();
							System.out.println("Enter Location :");
							String dloc=ppsc.next();
							
							
							stmt.setInt(1, did);
							stmt.setString(2, dname);
							stmt.setInt(3, dage);
							stmt.setString(4, ddept);
							stmt.setString(5, dspec); 
							stmt.setInt(6, dph); 
							stmt.setString(7, dloc);
							
							stmt.execute();
							con.close();
							System.out.println("Data saved Successfully....!");
						}
						catch(Exception e) {
							System.out.println(e);
						}
						break;
					
					case 3:
						try {
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS","root","$Prasanth123");
							Statement stmt = con.createStatement();
							ResultSet rs= stmt.executeQuery("Select * from patients");
							while(rs.next()) {
								System.out.println("Id : "+rs.getInt(1)+"\n Name : "+rs.getString(2)+"\n Age : "+rs.getInt(3)+ "\n Sex : "+rs.getString(4)+"\nPhone : "+rs.getInt(5)+"\nAddress : "+rs.getString(6));
								System.out.println("--------------------------------");
							}	
							
						}
						catch(Exception e) {
							System.out.println(e);
						}
	
						
					case 4:
						
						try {
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS","root","$Prasanth123");
							Statement stmt = con.createStatement();
							ResultSet rs= stmt.executeQuery("Select * from doctors");
							while(rs.next()) {
								System.out.println("Id : "+rs.getInt(1)+"\n Name : "+rs.getString(2)+"\n Age : "+rs.getInt(3)+ "\n DEPT : "+rs.getString(4)+"\nSPECIALICATION : "+rs.getString(5)+"\nPhone : "+rs.getInt(6)+"\nAddress : "+rs.getString(7));
								System.out.println("--------------------------------");
							}							
							
						}
						catch(Exception e) {
							System.out.println(e);
						}
							/*Iterator i=list.iterator();
							while(i.hasNext())
							{
							Patient x=(Patient ) i.next();
							x.pdisplay();
							System.out.println("--------------------------------");
								}*/
						
					case 5 :
						try {
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS","root","$Prasanth123");
							PreparedStatement stmt = con.prepareStatement("UPDATE patients SET bill = ? WHERE pid =?");
							Scanner usc=new Scanner(System.in);
							
							
							System.out.println("Enter the Patient id to add bill :");
							int ubil=usc.nextInt();
							System.out.println("Enter Amount :");
							int bdre=usc.nextInt();
							stmt.setInt(1, bdre);
							stmt.setInt(2, ubil);
							
							stmt.execute();
							con.close();
							System.out.println("Data Updated.........!");
						
						}
						catch(Exception e) {
							System.out.println(e);
						}
						
						break;	
					}
			}
			while(ch2!=6);
		}
		if(ch1==2) {
			do{
				System.out.println("--------------------------------");
				System.out.println("1.Write Patients Report");
				System.out.println("2.Get Patients Report");
				System.out.println("3.Pescribe Medicine");
				System.out.println("4.Pescribe Test");
				System.out.println("5.Display Patient-NA-");
				System.out.println("6.Exit");
				System.out.println("--------------------------------");
				System.out.println("Enter your Choice: ");
				Scanner sc3=new Scanner(System.in);
				ch3=sc3.nextInt();
				switch(ch3){
					case 1:
						try {
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS","root","$Prasanth123");
							PreparedStatement stmt = con.prepareStatement("UPDATE patients SET report = ? WHERE pid =?");
							Scanner usc=new Scanner(System.in);
							
							
							System.out.println("Enter the Patient id to write report :");
							int uid=usc.nextInt();
							System.out.println("Enter Report :");
							String dre=usc.next();
							stmt.setString(1, dre);
							stmt.setInt(2, uid);
							
							stmt.execute();
							con.close();
							System.out.println("Data Updated.........!");
						
						}
						catch(Exception e) {
							System.out.println(e);
						}
						
						break;
						
					case 2:
						try {
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS","root","$Prasanth123");
							Statement stmt = con.createStatement();
							ResultSet rs= stmt.executeQuery("select pid, name, report from patients");
							while(rs.next()) {
								System.out.println("Id : "+rs.getInt(1)+"\nName : "+rs.getString(2)+"\nReport : "+rs.getString(3));
								System.out.println("--------------------------------");
							}	
							
						}
						catch(Exception e) {
							System.out.println(e);
						}
						
						
						/*try {
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS","root","$Prasanth123");
							PreparedStatement stmt = con.prepareStatement("select report from patients where pid = ?");
							Scanner gpsc=new Scanner(System.in);
							System.out.println("Enter id :");
							int gid=gpsc.nextInt();
							
							
							stmt.setInt(1, gid); 
							
							stmt.execute();
							
							System.out.println("Data retrived Successfully....!");
							 
							
							
							
								System.out.println("Report : "+stmt.getResultSet());
								System.out.println("--------------------------------");
								con.close();
						
						}
						catch(Exception e) {
							System.out.println(e);
						}*/
						
						
						break;
					
					case 3:
						try {
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS","root","$Prasanth123");
							PreparedStatement stmt = con.prepareStatement("UPDATE patients SET medicine = ? WHERE pid =?");
							Scanner usc=new Scanner(System.in);
							
							
							System.out.println("Enter the Patient id to write prescribe medicine :");
							int uid=usc.nextInt();
							System.out.println("now prescribe medicines :");
							String dre=usc.next();
							stmt.setString(1, dre);
							stmt.setInt(2, uid);
							
							stmt.execute();
							con.close();
							System.out.println("Data Updated.........!");
						
						}
						catch(Exception e) {
							System.out.println(e);
						}
						
						
						break;
						
					case 4: 
						try {
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS","root","$Prasanth123");
							PreparedStatement stmt = con.prepareStatement("UPDATE patients SET test = ? WHERE pid =?");
							Scanner usc=new Scanner(System.in);
							
							
							System.out.println("Enter the Patient id to write prescribe test :");
							int uid=usc.nextInt();
							System.out.println("now prescribe test :");
							String dre=usc.next();
							stmt.setString(1, dre);
							stmt.setInt(2, uid);
							
							stmt.execute();
							con.close();
							System.out.println("Data Updated.........!");
						
						}
						catch(Exception e) {
							System.out.println(e);
						}
						
						break;
						
					}
			}while(ch3!=6);
		}	
		if(ch1==3) {
			do{
				System.out.println("--------------------------------");
				System.out.println("1.Allot rooms");
				System.out.println("2.get patient rooms");
				System.out.println("3.Get Medicine of patients");
				System.out.println("4.Get Test");
				System.out.println("5.Exit");
				System.out.println("--------------------------------");
				System.out.println("Enter your Choice: ");
				Scanner sc4=new Scanner(System.in);
				ch4=sc4.nextInt();
				switch(ch4){
					case 1:
						try {
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS","root","$Prasanth123");
							PreparedStatement stmt = con.prepareStatement("UPDATE patients SET room_no = ? WHERE pid =?");
							Scanner rusc=new Scanner(System.in);
							
							
							System.out.println("Enter the Patient id to allot room :");
							int ruid=rusc.nextInt();
							System.out.println("Enter Room_no to allot :");
							String rdre=rusc.next();
							stmt.setString(1, rdre);
							stmt.setInt(2, ruid);
							
							stmt.execute();
							con.close();
							System.out.println("Data Updated.........!");
						
						}
						catch(Exception e) {
							System.out.println(e);
						}
						
						break;
						
					case 2:
						try {
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS","root","$Prasanth123");
							Statement stmt = con.createStatement();
							ResultSet rs= stmt.executeQuery("select pid, name, room_no from patients");
							while(rs.next()) {
								System.out.println("Id : "+rs.getInt(1)+"\nName : "+rs.getString(2)+"\nRoom_no : "+rs.getString(3));
								System.out.println("--------------------------------");
							}	
							
						}
						catch(Exception e) {
							System.out.println(e);
						}
						break;
						
					case 3:
						try {
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS","root","$Prasanth123");
							Statement stmt = con.createStatement();
							ResultSet rs= stmt.executeQuery("select pid, name, medicine from patients");
							while(rs.next()) {
								System.out.println("Id : "+rs.getInt(1)+"\nName : "+rs.getString(2)+"\nMedicine : "+rs.getString(3));
								System.out.println("--------------------------------");
							}	
							
						}
						catch(Exception e) {
							System.out.println(e);
						}
						
						break;
						
					case 4: 
						try {
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS","root","$Prasanth123");
							Statement stmt = con.createStatement();
							ResultSet rs= stmt.executeQuery("select pid, name, test from patients");
							while(rs.next()) {
								System.out.println("Id : "+rs.getInt(1)+"\nName : "+rs.getString(2)+"\nTest : "+rs.getString(3));
								System.out.println("--------------------------------");
							}	
							
						}
						catch(Exception e) {
							System.out.println(e);
						}
						
						break;
						
						

						
						
					/*	Iterator i=list.iterator();
						while(i.hasNext())
						{
							Patient x=(Patient ) i.next();
							x.pdisplay();
							System.out.println("--------------------------------");
								}*/
							
					
					}
			}while(ch4!=5);
		}
		if(ch1==4) {
			do{
				System.out.println("--------------------------------");
				System.out.println("1.Pay Bills");
				System.out.println("2.Payment History ");
				System.out.println("3.Display Record");
				System.out.println("4.Exit");
				System.out.println("--------------------------------");
				System.out.println("Enter your Choice: ");
				Scanner sc5=new Scanner(System.in);
				ch4=sc5.nextInt();
				switch(ch4){
					case 1:
						System.out.println("Bill generated ");
						System.out.println("Total Amount due  "+bill); 
						
						break;
				
				
				
				
				}

			}
				while(ch4!=4);
		}	
			
		if(ch1==2)
		{/*
			Iterator i=list.iterator();
			while(i.hasNext())
			{
				//Emp x=(Emp) i.next();
			//	x.display();
			}*/
			
		}
		if(ch1==3)
		{
		/*	Iterator i=list.iterator();
			while(i.hasNext())
			{
			//	Emp x=(Emp) i.next();
				//x.riseSalary();
			}*/
		}
		}while(ch1!=6);
		System.out.println("Total no. of Employees Created:");
		
	}
}

/*
class MS {
String name,desig;
int age, salary;
long mobile;
MS() {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter name :");
	name=sc.nextLine();
	System.out.println("Enter Age :");
	age=sc.nextInt();
	System.out.println("Enter Mobile No :");
	mobile=sc.nextInt();
}
public void display()
{
	System.out.println("NAME : "+name+ "\nAGE : "+age+"\nMobile : "+mobile);	
}

}
//"\nSALARY : "+salary+"\nDESIGNAION : "+desig+"

class Portal extends MS{
int Empid;
int deptid;

}

class Admin extends Portal{

}
class Doctor extends Portal{

}
class Nurse extends Portal{

}
class user extends Portal{

}*/