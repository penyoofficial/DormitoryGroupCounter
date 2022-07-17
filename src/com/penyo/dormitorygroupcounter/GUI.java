package com.penyo.dormitorygroupcounter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 该类定义友好的图形用户界面。
 * 
 * @author Penyo
 */
public class GUI {
    Frame frame = new Frame("宿舍群计算器");
    Panel input = new Panel(new GridLayout(2, 1)),
            output = new Panel(new GridLayout(2, 1)),
            io = new Panel(new GridLayout(1, 2));
    Label inGuide = new Label("人数"),
            outGuide = new Label("群数"),
            comment = new Label("你的宿舍有多少人呢？", Label.RIGHT);
    TextField in = new TextField(20),
            out = new TextField(20);

    public GUI() {
        assembling();
        setLayout();
        registAction();
    }

    /**
     * 该方法用于构建各组件之间的逻辑关系。
     */
    private void assembling() {
        input.add(inGuide);
        input.add(in);

        output.add(outGuide);
        output.add(out);

        io.add(input);
        io.add(output);

        frame.add(io);
        frame.add(comment, BorderLayout.SOUTH);
    }

    /**
     * 该方法用于美化界面。
     */
    private void setLayout() {
        inGuide.setFont(new Font(null, Font.PLAIN, 9));
        inGuide.setForeground(Color.GRAY);

        outGuide.setFont(new Font(null, Font.PLAIN, 9));
        outGuide.setForeground(Color.GRAY);

        out.setEditable(false);

        comment.setFont(new Font(null, Font.ITALIC, 11));

        Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
        final int W = 320, H = 100;
        frame.setBounds((int) (scr.getWidth() - W) / 2,
                (int) (scr.getHeight() - H) / 2, W, H);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    /**
     * 该方法用于使组件具备交互性。
     */
    private void registAction() {
        in.addTextListener(e -> {
            // 处理输入
            StringBuilder corrected = new StringBuilder(in.getText());
            if (corrected.length() < 1)
                return;
            for (int i = 0; i < corrected.length(); i++)
                if (corrected.charAt(i) < '0' || corrected.charAt(i) > '9') {
                    if (corrected.charAt(i) == '-' && i == 0)
                        break;
                    corrected.deleteCharAt(i--);
                    in.setText(corrected.toString());
                    return;
                }
            if (in.getText().equals("-"))
                return;

            // 部署计算
            int people = Integer.parseInt(in.getText());
            if (people > 233)
                in.setText("233");
            Core c = new Core(people);
            new Thread() {
                @Override
                public void run() {
                    out.setText("" + c.getBasicEvent());
                    comment.setText(c.toString());
                }
            }.start();
        });
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
