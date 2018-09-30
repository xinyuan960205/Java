package com.javalearn.GUIDemo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: SimpleGui1B
 * @Description: 实现按钮的ActionListener接口
 * @Author: xinyuan
 * @CreateDate: 2018/9/28 18:27
 */
public class SimpleGui1B implements ActionListener {
    JButton button;

    public static void main(String[] args){
        SimpleGui1B gui1B = new SimpleGui1B();
        gui1B.go();
    }

    public void go(){
        JFrame frame = new JFrame();
        button = new JButton("click me");

        button.addActionListener(this);

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event){
        button.setText("I have been clicked");
    }
}
