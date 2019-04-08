import javax.swing.JOptionPane;


public class judge {
    public static void main(String args[]){
        String str = (String)JOptionPane.showInputDialog(null,"请输入回文串");
        StringBuffer sb = new StringBuffer(str);
        sb.reverse();
        String newstr = new String(sb);
        if(str.equals(newstr))
        {
            JOptionPane.showMessageDialog(null,str+"是回文串");
        }
        else
            JOptionPane.showMessageDialog(null,str+"不是回文串");
    }
}
