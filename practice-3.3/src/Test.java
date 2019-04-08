import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Test {
    public static void main(String[] arr){
        DrawFrame frame = new DrawFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class DrawFrame extends JFrame{
    public DrawFrame(){
        setTitle("hehe");
        setSize(800,800);

        DrawPanel panel = new DrawPanel();
        add(panel);
    }
}


class DrawPanel extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Random random = new Random();
      //  int rand = random.nextInt(300);
      //  int op = random.nextInt(3);
        for(int i = 0; i <20;i++)
        {
            int op = random.nextInt(3);
            int xl1 = random.nextInt(400);
            int yl1= random.nextInt(400);
            int xl2 = random.nextInt(400);
            int yl2 = random.nextInt(400);

            if(op == 0){
            MyLine A = new MyLine(xl1,yl1,xl2,yl2);
                A.draw(g);
        }
            if(op == 1){
                MyRectangle B = new MyRectangle(xl1,yl1,xl2,yl2);
                B.draw(g);
            }

            if(op == 2){
                MyOval C = new MyOval(xl1,yl1,xl2,yl2);
                C.draw(g);
            }

        }

        }

}
abstract class MyShape{
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public MyShape(){
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = 0;
        this.y2 = 0;
    }

    public MyShape(int x1,int y1,int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void setV(int x1,int y1,int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getX1(){
        return x1;
    }
    public int getX2(){
        return x2;
    }
    public int getY1(){
        return y1;
    }
    public int getY2(){
        return y2;
    }

    abstract void draw(Graphics g);
}

class MyLine extends MyShape{
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    public MyLine(int x1, int y1, int x2, int y2){
        super(x1,y1,x2,y2);
        this.x1 = super.getX1();
        this.y1 = super.getY1();
        this.x2 = super.getX2();
        this.y2 = super.getY2();
    }

    void draw(Graphics g){
        g.drawLine(x1,y1,x2,y2);
    }
}

class MyRectangle extends MyShape{
    private int x0;
    private int y0;
    private int width;
    private int height;

    public MyRectangle(int x1, int y1, int x2, int y2){
        super(x1,y1,x2,y2);
        x0 = super.getX1();
        y0 = super.getY1();
        width = super.getY1();
        height = super.getY2();
    }

    void draw(Graphics g){
        g.drawRect(x0,y0,width,height);
    }
}

class MyOval extends MyShape{
    private int x0;
    private int y0;
    private int width;
    private int height;

    public MyOval(int x1, int y1,int x2,int y2){
        super(x1, y1, x2, y2);
        x0 = super.getX1();
        y0 = super.getY1();
        width = super.getX2();
        height = super.getY2();

    }
    void draw(Graphics g){
        g.drawOval(x0,y0,width,height);
    }
}