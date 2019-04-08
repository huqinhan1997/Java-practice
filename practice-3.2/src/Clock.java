import javax.swing.*;
import java.awt.*;

public class Clock {
    public static void main(String[] arr){
        DrawFrame frame = new DrawFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class DrawFrame extends JFrame{
    public DrawFrame(){
        setTitle("Clock");
        setSize(300,300);

        DrawPanel panel = new DrawPanel();
        add(panel);
    }
}

class DrawPanel extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int r = 100;
        int x = 150;
        int y = 150;
        g.drawOval(x-r,y-r,2*r,2*r);


        double alfa;
        int xPos;
        int yPos;
        int xPos2;
        int yPos2;

        g.setColor(Color.red);
        for(int i=0;i<=360;i+=6) {
            alfa = Math.toRadians(i);  //角度用弧度表示
            xPos = x + (int) (r * Math.cos(alfa));   // x坐标
            yPos = y - (int) (r * Math.sin(alfa));   // y坐标
            xPos2 = x + (int) ((r-4) * Math.cos(alfa));   // x坐标
            yPos2 = y - (int) ((r-4) * Math.sin(alfa));   // y坐标

            g.drawLine(xPos,yPos,xPos2,yPos2);
        }

        g.drawString("12",145,45);
        g.drawString("9",40,155);
        g.drawString("6",145,265);
        g.drawString("3",250,155);

        g.drawLine(150,150,150,60);
        g.setColor(Color.green);
        g.drawLine(150,150,190,150);
        g.setColor(Color.blue);
        g.drawLine(150,150,200,100);

    }


}