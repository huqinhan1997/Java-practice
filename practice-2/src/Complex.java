import java.util.Scanner;

public class Complex {
   private double real;
   private double image;

    Complex(double x, double y){
        this.real = x;
        this.image = y;
    }

    Complex(){
        real = 0;
        image = 0;
    }

    public void show(){
        if(image<0)
            System.out.println(real+""+image+"i\n");
        else if (image==0)
            System.out.println(real+"\n");
        else if (image>0)
            System.out.println(real+"+"+image+"i\n");

    }
    public double getReal(){
        return real;
    }

    public double getImage(){
        return image;
    }

    public Complex add(Complex a){
        return new Complex(real+a.getReal(),image+a.getImage());
    }

    public Complex minus(Complex a){
        return new Complex(real-a.getReal(),image-a.getImage());
    }

    public static void main(String[] arr){
        System.out.println("请输入操作（+、-)");
        Scanner scan = new Scanner(System.in);
        String op = scan.next();
        if(op.equals("+"))
        {
            System.out.println("请输入第一个复数A的实部和虚部");
            Scanner scan2 = new Scanner(System.in);


            Complex A = new Complex();
            A.real = scan2.nextDouble();
            A.image = scan2.nextDouble();

            System.out.println("请输入第二个复数B的实部和虚部");
            Scanner scan3 = new Scanner(System.in);
            Complex B = new Complex();
            B.real = scan3.nextDouble();
            B.image = scan3.nextDouble();

            Complex C = A.add(B);
            C.show();

        }
        else if(op.equals("-"))
        {
            System.out.println("请输入被减数A的实部和虚部");
            Scanner scan2 = new Scanner(System.in);


            Complex A = new Complex();
            A.real = scan2.nextDouble();
            A.image = scan2.nextDouble();

            System.out.println("请输入减数B的实部和虚部");
            Scanner scan3 = new Scanner(System.in);
            Complex B = new Complex();
            B.real = scan3.nextDouble();
            B.image = scan3.nextDouble();

            Complex C = A.minus(B);
            C.show();

        }

    }


}
