public class Test {

    public static void main(String[] arr){
        SalariedEmployee a = new SalariedEmployee("Bob","001", 1000 );
        HourlyEmployee b = new HourlyEmployee("Teddy","002",100,10);
        CommissionEmployee c = new CommissionEmployee("HQH","003",0.2,2000);

        Employee[] staff = new  Employee[3];
        staff[0] = a;
        staff[1] = b;
        staff[2] = c;

        for(Employee e: staff)
            e.show();
    }
}

class Employee{
    private String name;
    private String id;

    Employee(String name,String id){
        this.name = name;
        this.id = id;
    }

    public void show(){
        System.out.println("E's name is "+name);
        System.out.println("E's id is "+id);
    }
}

class SalariedEmployee extends Employee{
    private int salary;
    SalariedEmployee(String name, String id,int salary) {
        super(name, id);
        this.salary = salary;
    }

    public void show(){
        System.out.println("E's salary is "+salary);
    }
}

class HourlyEmployee extends Employee{
    private int salps;
    private int hours;

    HourlyEmployee(String name, String id, int salps,int hours){
        super(name, id);
        this.salps = salps;
        this.hours = hours;
    }
    public void show(){

        System.out.printf("E's salarys are %d per hours\n",salps);
        System.out.printf("E's works for %d hours\n",hours);
    }
}

class CommissionEmployee extends Employee{
    private double ratio;
    private int sum;

    CommissionEmployee(String name,String id,double ratio,int sum){
        super(name,id);
        this.ratio = ratio;
        this.sum = sum;
    }

    public void show(){
        System.out.printf("E's ratio is %f\n",ratio);
        System.out.printf("E's sum of salary are %d $ ",sum);
    }


}