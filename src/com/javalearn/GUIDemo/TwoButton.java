package com.javalearn.GUIDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: TwoButton
 * @Description: 使用内部类实现两个按钮的程序
 * @Author: xinyuan
 * @CreateDate: 2018/10/4 9:40
 */
public class TwoButton {
    JFrame frame;
    JLabel label;

    public static void main(String[] args){
        TwoButton twoButton = new TwoButton();
        twoButton.go();
    }

    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change Label");
        labelButton.addActionListener(new LabelListener());

        JButton colorButton = new JButton("change circle");
        colorButton.addActionListener(new ColorListener());

        label = new JLabel("i am a label");
        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH,colorButton);
        frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
        frame.getContentPane().add(BorderLayout.EAST,labelButton);
        frame.getContentPane().add(BorderLayout.WEST,label);

        frame.setSize(300,300);
        frame.setVisible(true);
    }

    //内部类
    class LabelListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            label.setText("ouch");
        }
    }

    class ColorListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            frame.repaint();
        }
    }
}
