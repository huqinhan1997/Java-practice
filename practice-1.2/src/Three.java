import javax.swing.JOptionPane;

public class Three {


    private String[][] chess = new String[3][3];

    public boolean isFull() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (chess[i][j].equals("*") || chess[i][j].equals("O")) {
                    count++;
                }
            }
        }
        if (count == 9)
            return true;
        else
            return false;
    }

    public boolean isWin(String s) {
        for (int i = 0; i < 3; i++) {
            if (chess[i][0].equals(s) && chess[i][1].equals(s) && chess[i][2].equals(s))
                return true;
        }
        for (int j = 0; j < 3; j++) {
            if (chess[0][j].equals(s) && chess[1][j].equals(s) && chess[2][j].equals(s))
                return true;
        }
        if (chess[0][0].equals(s) && chess[1][1].equals(s) && chess[2][2].equals(s))
            return true;
        if (chess[2][0].equals(s) && chess[1][1].equals(s) && chess[0][2].equals(s))
            return true;
        else
            return false;

    }

    public void player2() {
        if (!isFull()) {
             boolean o=false;
            while (!o) {
                int randi = (int) (Math.random() * 2);
                int randj = (int) (Math.random() * 2);
                if (chess[randi][randj].equals("*") || chess[randi][randj].equals("O"))
                    o=false;
                else {
                    chess[randi][randj] = "O";
                    break;
                }
            }

        }
        //如果满了

    }

    public static void main(String args[]) {
        Three three=new Three();
        int count = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                three.chess[i][j] = String.valueOf(count++);
        }
        JOptionPane pane = new JOptionPane();

        while (true) {

            String location =pane.showInputDialog(pane, "---------------------" + '\n'
                    + "|" + three.chess[0][0] + "|" + three.chess[0][1] + "|" + three.chess[0][2] + "|" + '\n'
                    + "|" + three.chess[1][0] + "|" + three.chess[1][1] + "|" + three.chess[1][2] + "|" + '\n'
                    + "|" + three.chess[2][0] + "|" + three.chess[2][1] + "|" + three.chess[2][2] + "|" + '\n'
                    + "---------------------" + "\n"
                    + "请输入落子位置");

            String s = "*";
            String b = "O";
            three.chess[(Integer.parseInt(location) - 1) / 3][(Integer.parseInt(location) + 2) % 3] = s;
            if (three.isWin(s)) {
                pane.showMessageDialog(pane, "---------------------" + '\n'
                        + "|" + three.chess[0][0] + "|" + three.chess[0][1] + "|" + three.chess[0][2] + "|" + '\n'
                        + "|" + three.chess[1][0] + "|" + three.chess[1][1] + "|" + three.chess[1][2] + "|" + '\n'
                        + "|" + three.chess[2][0] + "|" + three.chess[2][1] + "|" + three.chess[2][2] + "|" + '\n'
                        + "---------------------" + "\n" + "你赢了");
                break;
            }
            three.player2();
            if (three.isWin(b)) {
                pane.showMessageDialog(pane, "---------------------" + '\n'
                            + "|" + three.chess[0][0] + "|" + three.chess[0][1] + "|" + three.chess[0][2] + "|" + '\n'
                            + "|" + three.chess[1][0] + "|" + three.chess[1][1] + "|" + three.chess[1][2] + "|" + '\n'
                            + "|" + three.chess[2][0] + "|" + three.chess[2][1] + "|" + three.chess[2][2] + "|" + '\n'
                            + "---------------------" + "\n" + "你输了");
                break;
                }
           if(three.isFull()){
                pane.showMessageDialog(pane, "---------------------" + '\n'
                        + "|" + three.chess[0][0] + "|" + three.chess[0][1] + "|" + three.chess[0][2] + "|" + '\n'
                        + "|" + three.chess[1][0] + "|" + three.chess[1][1] + "|" + three.chess[1][2] + "|" + '\n'
                        + "|" + three.chess[2][0] + "|" + three.chess[2][1] + "|" + three.chess[2][2] + "|" + '\n'
                        + "---------------------" + "\n" + "平局");
                break;
            }


        }
    }
}
