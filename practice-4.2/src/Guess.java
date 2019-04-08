import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Guess {
    public static void main(String[] arr){
        DrawFrame frame = new DrawFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class DrawFrame extends JFrame{
    public DrawFrame(){
        setTitle("猜数游戏");
        setSize(300,220);

        DrawPanel panel = new DrawPanel();
        add(panel);
    }
}


class DrawPanel extends JPanel{
    private JButton button1;
    private JButton button2;
   private JButton button3;
   private JLabel label1;
   private JLabel label2;
   private JLabel label3;
   private JTextField textField;
   int count = 0;
   private int Number = 0;
   Random random;

   private void setNumber(){
       random = new Random();
       Number = random.nextInt(100);
   }

   private class Button1Handler implements ActionListener
   {
        public void actionPerformed(ActionEvent e)
        {
            count+=1;
            label1.setText("你已经猜了"+count+"次");
            String str = new String(textField.getText());
            int num = Integer.parseInt(str);
            label3.setVisible(true);
            if(num==Number)
            {   textField.setEnabled(false);
                label2.setVisible(false);
                button1.setEnabled(false);
                label3.setText("猜对了");
                setBackground(null);

            }
            else if(num < Number)
            {
                label3.setText("太小");
                setBackground(Color.blue);
            }
            else if(num > Number)
            {
                label3.setText("太大");
                setBackground(Color.red);
            }
        }

   }
    private class Button2Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            setNumber();
            count = 0;
            label1.setText("你已经猜了"+count+"次");
            button1.setEnabled(true);
            textField.setText(null);
            textField.setEditable(true);
            label3.setVisible(false);
            Number = 5;
            setBackground(null);
        }

    }
    private class Button3Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }

    }

   public DrawPanel(){
       label1 = new JLabel("你已经猜了"+count+"次");
       label1.setBounds(5,0,150,30);
       label2 = new JLabel("输入猜测的数");
       label2.setBounds(30,50,100,30);
       textField = new JTextField(3);
       textField.setBounds(130,50,30,30);
       label3 = new JLabel();
       label3.setBounds(190,50,100,30);
       label3.setVisible(false);

       button1 = new JButton("确认");
       button1.setBounds(10,110,60,30);
       button1.addActionListener(new Button1Handler());

       button2 = new JButton("重新开始");
       button2.setBounds(80,110,100,30);
       button2.addActionListener(new Button2Handler());

       button3 = new JButton("退出");
       button3.setBounds(190,110,60,30);
       button3.addActionListener(new Button3Handler());

       add(button1);
       add(button2);
       add(button3);
       add(label1);
       add(label2);
       add(label3);
       add(textField);
       setNumber();


   }



}
