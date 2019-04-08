import javax.swing.*;
import java.awt.*;

public class DrawMathfunction {
    public static void main(String[] arr){
        DrawFrame frame = new DrawFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}

class DrawFrame extends JFrame{
   public DrawFrame(){
        setTitle("MathFunction");
        setSize(300,300);

        DrawPanel panel = new DrawPanel();
        add(panel);
    }
}

class DrawPanel extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int o = 0;
        int maxx = 200;
        int minx = -200;
        int maxy = 200;
        int miny = -200;
        g.translate(150,150);

        Graphics2D g2 = (Graphics2D) g;
        g2.rotate((180/180)*Math.PI);
        //Draw X axis.
        g.drawLine(minx,0,maxx,0);
        g.drawLine(maxx,0,maxx-1,1);
        g.drawLine(maxx,0,maxx-1,-1);

        //Draw Y axis.
        g.drawLine(0,miny,0,maxy);
        g.drawLine(0,maxy,1,maxy-1);
        g.drawLine(0,maxy,-1,maxy-1);

        //Draw Function.
        int[] arrayX = new int[201];
        int[] arrayY = new int[201];
        arrayX[0]=-100;

        for(int i = 0; i<200; i++)
        {
            arrayX[i+1] = arrayX[i]+1;
        }

        for(int i = 0; i<200;i++)
        {
            arrayY[i]=Function(arrayX[i]);
        }

        g.drawPolyline(arrayX,arrayY,200);
    }

    private int Function(int x) {
        int y = x*x;
        return y;
    }

}

