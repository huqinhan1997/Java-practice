public class Test {
    public static void main(String[] arr){
        Book a = new Book("AAA",1234);
        Book b = new Book("BBB",5678);
        Student bob = new Student("Bob",1111);
        Student teddy = new Student("Teddy",2222);

        a.lendto(bob);
        a.show();
        bob.show();
        b.lendto(teddy);
        b.show();
        teddy.show();
        System.out.println("-----------------After returning----------------------");
        a.retur();
        a.show();
        bob.show();
        b.retur();
        b.show();
        teddy.show();
    }

}

class Book{
    private String name;
    private int no;
    private String lender;

    Book(String name,int no){
        this.name = name;
        this.no = no;
    }

    public void lendto(Student a){
        this.lender = a.getName();
        a.borrow(name);
    }

    public void retur(){
        this.lender = "Null";
    }

    public void show(){
        System.out.println("The Book's name is "+"<<"+name+">>");
        System.out.printf("The Book's number is %d\n",no);
        System.out.println("The Book is lent by "+lender);
    }

    public String getName(){
        return name;
    }

}

class Student{
    private String name;
    private int no;
    private String book;

    Student(String name, int no){
        this.name = name;
        this.no = no;
    }

    public void borrow(String bookname){
        this.book =bookname;
    }

    public String getName(){
        return name;
    }

    public void show(){
        System.out.println("The Studen's name is "+name);
        System.out.printf("The Student's number is %d\n",no);
        System.out.println("The Student borrowed "+"<<"+book+">>");
    }
}

