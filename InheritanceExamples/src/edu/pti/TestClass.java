package edu.pti;

/**
 * This class will implement all the class of this package.
 * Will invoke toString methods of the classes
 * @author Padma Dangal
 *
 */
public class TestClass {

	public static void main(String[] args) {

       Student student = new Student("Padma", "Dangal", "19025 perry Hwy", 16046, 4125672345l, "Programming", 3.4);
       System.out.println(student.toString());
       
       CollegeEmployee cemployee = new CollegeEmployee("Tek", "Mainali", "118 Nobles Lane", 15346, 412356278, "2858365856", 45000, "Finalcial Aid");
       System.out.println(cemployee.toString());
       
       Faculty faculty = new Faculty("Andrew", "Paul", "111 okdale Ave", 15623, 724536927, "660753425", 55000, "Human Resource", true);
      System.out.println(faculty.toString()); 
      
      Person p1 = new Person("Kashi", "Baral", "123 River Rd", 78354, 786534234);
      Person p2 = new Person("Kashi", "Baral", "123 River Rd", 78354, 786534234);
      
      System.out.println(p1.equal(p2));
       
      Person p3 = new Person("Bhupal", "Odari", "123 River Rd", 78354, 786534234);
    
      System.out.println(p1.equal(p3));
	}

}
