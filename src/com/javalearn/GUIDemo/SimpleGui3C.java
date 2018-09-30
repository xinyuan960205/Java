package com.javalearn.GUIDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: SimpleGui3C
 * @Description: 按下按钮会改变颜色
 * @Author: xinyuan
 * @CreateDate: 2018/9/30 21:31
 */
public class SimpleGui3C implements ActionListener{
    JFrame frame;

    public static void main(String[] args){
        SimpleGui3C simpleGui3C = new SimpleGui3C();
        simpleGui3C.go();
    }
    public void go(){
        //声明框
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //声明组件
        JButton button =new JButton("change color");
        //为按钮添加监听
        button.addActionListener(this);

        MyDrawPanel myDrawPanel = new MyDrawPanel();
        //依照指定的区域把widget放上去
        frame.getContentPane().add(BorderLayout.SOUTH,button);
        frame.getContentPane().add(BorderLayout.CENTER,myDrawPanel);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    //按钮相应事件
    public void actionPerformed(ActionEvent event){
        frame.repaint();//frame重绘，系统自动调用paintComponent方法
    }


}
