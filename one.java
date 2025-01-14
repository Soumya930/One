
class Student {
   String name ;
   int rollno;
   int age ; 
   String course;
public void display(){
   System.out.println(" Name :"+ name + "\n" +" Rollno :"+ rollno + "\n"+ " Age :"+ age+ "\n"+ " Course :" + course + "\n" );
}
}
public class one {
   
    public static void main(String[] args) {
      Student soumya = new Student();
      soumya.name = "SJ";
      soumya.rollno = 1002;
      soumya.age =21;
      soumya.course = "Coplur";
      soumya.display();
  
  
  
      Student abhishek = new Student();
    abhishek.name = "AJ";
    abhishek.rollno = 1003;
    abhishek.age =23;
    abhishek.course = " Coplur1";
    abhishek.display();
  
     Student atishay  = new Student();
      atishay.name = "SJ";
      atishay.rollno = 1002;
      atishay.age =21;
      atishay.course = " Coplur";
      atishay.display();
    }
   }
