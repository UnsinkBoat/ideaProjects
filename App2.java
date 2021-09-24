import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App2 {
    public static void main(String[]args){
        JFrame frame = new YFrame();
    }
}

class YFrame extends JFrame{
    Definition[]x;
    Range y;
    Mapping map = new Mapping();

    YFrame(){
        setTitle("映射相关性质");
        setSize(700,200);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pal = new JPanel();
        JLabel lb_1 = new JLabel("输入X的取值范围（整数）");
        JTextField tf_1 = new JTextField(5);
        JTextField tf_2 = new JTextField(5);
        JButton bt_1 = new JButton("X确定");

        JLabel lb_2 = new JLabel("输入Y的取值范围（整数）");
        JTextField tf_3 = new JTextField(5);
        JTextField tf_4 = new JTextField(5);
        JButton bt_2 = new JButton("Y确定");


        JButton bt_3 = new JButton("在控制台判断是否为映射");
        JButton bt_4 = new JButton("在控制台判断是否为单射");
        JButton bt_5 = new JButton("在控制台判断是否为满射");
        JButton bt_6 = new JButton("在控制台判断是否为双射");



        bt_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int min = Integer.valueOf(tf_1.getText());
                int max = Integer.valueOf(tf_2.getText());
                x = new Definition[max-min+1];
                int t = min;
                for(int i = 0;i<max-min+1;i++){
                    x[i] = new Definition(t++);
                }
                bt_1.setEnabled(false);
            }
        });

        bt_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int min = Integer.valueOf(tf_3.getText());
                int max = Integer.valueOf(tf_4.getText());
                Integer[] x = new Integer[max-min+1];
                int t = min;
                for(int i = 0;i<max-min+1;i++){
                    x[i] = t++;
                }
                y = new Range(x);
                bt_2.setEnabled(false);
            }
        });

        bt_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println( map.ismapping(x,y)?"是映射":"不是映射");
            }
        });

        bt_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println( map.singleshot(x,y)?"是单射":"不是单射");
            }
        });

        bt_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println( map.fullshot(x,y)?"是满射":"不是满射");
            }
        });

        bt_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println( map.doubleshot(x,y)?"是双射":"不是双射");
            }
        });


        pal.add(lb_1);
        pal.add(tf_1);
        pal.add(tf_2);
        pal.add(bt_1);
        pal.add(lb_2);
        pal.add(tf_3);
        pal.add(tf_4);
        pal.add(bt_2);
        pal.add(bt_3);
        pal.add(bt_4);
        pal.add(bt_5);
        pal.add(bt_6);

       add(pal);
    }
}
