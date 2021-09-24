import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    MyFrame thisWindow = this;

    JPanel pal = new JPanel();
    JLabel lb_1 = new JLabel("请以矩阵的形式输入你想要存储的关系,请先输入关系矩阵的规模：");
    JTextField tf_1 = new JTextField(2);
    JButton bt_1 = new JButton("锁定规模");
    JLabel lb_2 = new JLabel("关系矩阵只能输入(1/0)");

    int n;

    JTextField tf_2 = new JTextField(10);
    JButton bt_2 = new JButton("确认矩阵");

    JTextField textfield[][];

    //设置字体
    Font font = new Font("宋体",Font.BOLD,14);
    //设置布局
    FlowLayout flowLayout = new FlowLayout();

    MyFrame(){
    setTitle("离散数学的奥秘");
    setSize(666,456);
    //        setResizable(false);
    setLocationRelativeTo(null);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    //添加字体
        lb_1.setFont(font);
        bt_1.setFont(font);
        lb_2.setFont(font);
        lb_2.setForeground(Color.red);
        //添加点击按钮效果
        bt_1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //生成矩阵输入框
            n = Integer.valueOf(tf_1.getText());
            textfield = new JTextField[n+1][n+1];
            for (int i = 1; i < n+1; i++)
                for (int j = 1; j < n+1; j++) {
                    textfield[i][j] = new JTextField(2);
                    textfield[i][j].setBounds(-80 + j * 100, 70 + i * 40, 30, 20);
                    pal.add(textfield[i][j]);
                }
            bt_1.setEnabled(false);
            bt_2.setBounds(260, 340, 100, 40);
            pal.add(lb_2);
            pal.add(bt_2);
            pal.repaint();
        }
        });
        //将输入的矩阵保存至Matrix
        bt_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean[][] matrix = new boolean[n+1][n+1];
                for(int i =1;i<n+1;i++)
                    for(int j =1;j<n+1;j++) {
                        String str = textfield[i][j].getText();
                        if(!str.equals("1")&&!str.equals("0")){
                            JOptionPane.showMessageDialog(pal,"非法输入");
                            return;
                        }
                        matrix[i][j] = textfield[i][j].getText().equals("1") ? true:false;
                    }

                        //创建一个关系对象
                Closure relationship = new Closure(matrix);
                    //关闭当前窗口
                thisWindow.dispose();
                //将关系对象传递给下一个窗口
                TwoFrame twoframe = new TwoFrame(relationship);
            }
        });





        //修改并添加布局

//        flowLayout.setHgap(20);
//        flowLayout.setVgap(20);
        //设置布局
        pal.setLayout(null);
        lb_1.setBounds(50,10,600,50);
        tf_1.setBounds(500,25,30,20);
        bt_1.setBounds(533,25,100,20);
        lb_2.setBounds(200,50,300,50);
        //添加组件

        pal.add(lb_1);
        pal.add(tf_1);
        pal.add(bt_1);
//        pal.add(tf_2);

        add(pal);

    }
}
class TwoFrame extends JFrame {

    JPanel pal = new JPanel();
    JTextArea textarea = new JTextArea(3,5);
    JScrollPane scrollpane = new JScrollPane(textarea);

    JButton bt_1 = new JButton("自反性判断");
    JButton bt_2 = new JButton("反自反性判断");
    JButton bt_3 = new JButton("对称性判断");
    JButton bt_4 = new JButton("反对称性判断");
    JButton bt_5 = new JButton("传递性判断");
    JButton bt_6 = new JButton("自反闭包");
    JButton bt_7 = new JButton("对称闭包");
    JButton bt_8 = new JButton("传递闭包");
    JButton bt_9 = new JButton("交集运算");
    JButton bt_10 = new JButton("并集运算");
    JButton bt_11 = new JButton("逆关系运算");
    JButton bt_12 = new JButton("复合运算");
    JButton bt_13 = new JButton("尝试在控制台划分等价关系");
    JButton bt_14 = new JButton("尝试在控制台输出极值");
    JButton bt_15 = new JButton("在控制台判断相容关系");

    TwoFrame(Closure relationship) {

        setTitle("关系的复杂运算");

        setSize(1300, 300);

//        setResizable(false);

        setLocationRelativeTo(null);

        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);


        //为每一个按钮添加功能
        bt_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(scrollpane,"该关系是否自反："+relationship.isReflexivity());
                return;
            }
        });

        bt_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(scrollpane,"该关系是否反自反："+relationship.isIrreflexive());
                return;
            }
        });

        bt_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(scrollpane,"该关系是否对称："+relationship.isSymmetry());
                return;
            }
        });

        bt_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(scrollpane,"该关系是否反对称："+relationship.isAntisymmetry());
                return;
            }
        });

        bt_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(scrollpane,"该关系是否传递："+relationship.isTransitivity());
                return;
            }
        });

        bt_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                relationship.reflexivity();
                JOptionPane.showMessageDialog(scrollpane,"自反闭包运算后的结果："+relationship.outMatrix());
                textarea.setText("自反闭包后关系的矩阵形式："+relationship.outMatrix());
                bt_6.setEnabled(false);
                return;
            }
        });

        bt_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                relationship.symmetry();
                JOptionPane.showMessageDialog(scrollpane,"对称闭包运算后的结果："+relationship.outMatrix());
                textarea.setText("对称闭包后关系的矩阵形式："+relationship.outMatrix());
                bt_7.setEnabled(false);
                return;
            }
        });

        bt_8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                relationship.transitivity();
                JOptionPane.showMessageDialog(scrollpane,"传递闭包运算后的结果："+relationship.outMatrix());
                textarea.setText("传递闭包后关系的矩阵形式："+relationship.outMatrix());
                bt_8.setEnabled(false);
                return;
            }
        });



        bt_9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("交集运算");
                frame.setSize(666, 456);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                JPanel pal = new JPanel();
                JButton bt_2 = new JButton("确认");

                pal.setLayout(null);
                frame.add(pal);


                int n = relationship.matrix.length;
                JTextField[][] textfield = new JTextField[n][n];
                for (int i = 1; i < n; i++)
                    for (int j = 1; j < n; j++) {
                        textfield[i][j] = new JTextField(2);
                        textfield[i][j].setBounds(-80 + j * 100, 70 + i * 40, 30, 20);
                        pal.add(textfield[i][j]);
                    }
                bt_2.setBounds(260, 340, 100, 40);
                pal.add(bt_2);
                pal.repaint();
                bt_2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        boolean[][] matrix = new boolean[n][n];
                        for (int i = 1; i < n; i++)
                            for (int j = 1; j < n ;j++) {
                                String str = textfield[i][j].getText();
                                if (!str.equals("1") && !str.equals("0")) {
                                    JOptionPane.showMessageDialog(pal, "非法输入");
                                    return;
                                }
                                matrix[i][j] = textfield[i][j].getText().equals("1") ? true : false;
                            }
                        frame.dispose();
                        relationship.intersection(new Closure(matrix));//求交集
                        textarea.setText("交集运算后关系的矩阵："+relationship.outMatrix());
                    }
                });
            }
        });

        bt_10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("并集运算");
                frame.setSize(666, 456);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                JPanel pal = new JPanel();
                JButton bt_2 = new JButton("确认");

                pal.setLayout(null);
                frame.add(pal);


                int n = relationship.matrix.length;
                JTextField[][] textfield = new JTextField[n][n];
                for (int i = 1; i < n; i++)
                    for (int j = 1; j < n; j++) {
                        textfield[i][j] = new JTextField(2);
                        textfield[i][j].setBounds(-80 + j * 100, 70 + i * 40, 30, 20);
                        pal.add(textfield[i][j]);
                    }
                bt_2.setBounds(260, 340, 100, 40);
                pal.add(bt_2);
                pal.repaint();
                bt_2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        boolean[][] matrix = new boolean[n ][n ];
                        for (int i = 1; i < n ; i++)
                            for (int j = 1; j < n ; j++) {
                                String str = textfield[i][j].getText();
                                if (!str.equals("1") && !str.equals("0")) {
                                    JOptionPane.showMessageDialog(pal, "非法输入");
                                    return;
                                }
                                matrix[i][j] = textfield[i][j].getText().equals("1") ? true : false;
                            }
                        frame.dispose();
                        relationship.union(new Closure(matrix));//求并集
                        textarea.setText("并集运算后关系的矩阵："+relationship.outMatrix());
                    }
                });
            }
        });
        bt_11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                relationship.inverse();
                textarea.setText("逆关系运算后关系的矩阵："+relationship.outMatrix());
            }
        });
        bt_12.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("复合运算");
                frame.setSize(666, 456);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                JPanel pal = new JPanel();
                JButton bt_2 = new JButton("确认");

                pal.setLayout(null);
                frame.add(pal);


                int n = relationship.matrix.length;
                JTextField[][] textfield = new JTextField[n][n];
                for (int i = 1; i < n; i++)
                    for (int j = 1; j < n; j++) {
                        textfield[i][j] = new JTextField(2);
                        textfield[i][j].setBounds(-80 + j * 100, 70 + i * 40, 30, 20);
                        pal.add(textfield[i][j]);
                    }
                bt_2.setBounds(260, 340, 100, 40);
                pal.add(bt_2);
                pal.repaint();
                bt_2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        boolean[][] matrix = new boolean[n ][n ];
                        for (int i = 1; i < n ; i++)
                            for (int j = 1; j < n ; j++) {
                                String str = textfield[i][j].getText();
                                if (!str.equals("1") && !str.equals("0")) {
                                    JOptionPane.showMessageDialog(pal, "非法输入");
                                    return;
                                }
                                matrix[i][j] = textfield[i][j].getText().equals("1") ? true : false;
                            }
                        frame.dispose();
                        relationship.compound(new Closure(matrix));//求复合运算
                        textarea.setText("复合运算后关系的矩阵："+relationship.outMatrix());
                    }
                });
            }
        });

        bt_13.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                SpecificRS specificrs = new SpecificRS(relationship.matrix);
                specificrs.divide();
            }
        });

        bt_14.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                SpecificRS specificrs = new SpecificRS(relationship.matrix);
                specificrs.maximum();
                specificrs.minimum();
            }
        });

        bt_15.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                SpecificRS specificrs = new SpecificRS(relationship.matrix);
                boolean flag = specificrs.compatible();
                System.out.println(flag?"相容关系":"非相容关系");
            }
        });

        textarea.setText("关系的矩阵形式："+relationship.outMatrix());
        textarea.setEditable(false);

        //添加组件
        pal.add(bt_1);
        pal.add(bt_2);
        pal.add(bt_3);
        pal.add(bt_4);
        pal.add(bt_5);
        pal.add(bt_6);
        pal.add(bt_7);
        pal.add(bt_8);
        pal.add(bt_9);
        pal.add(bt_10);
        pal.add(bt_11);
        pal.add(bt_12);
        pal.add(bt_13);
        pal.add(bt_14);
        pal.add(bt_15);

        //设置布局
        this.add(pal,BorderLayout.CENTER);
        this.add(scrollpane,BorderLayout.NORTH);
    }
}
