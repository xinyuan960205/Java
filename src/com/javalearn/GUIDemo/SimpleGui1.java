package com.javalearn.GUIDemo;

import javax.swing.*;

/**
 * @ClassName: SimpleGui1
 * @Description: 第一个GUI Demo
 * @Author: xinyuan
 * @CreateDate: 2018/9/28 16:41
 */
public class SimpleGui1 {
    public static void main(String[] args){
        //创建frame
        JFrame frame = new JFrame();
        //创建widget
        JButton button = new JButton("click me");
        //在Windows关闭时把程序结束掉
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //把widget加到frame上
        frame.getContentPane().add(button);
        //设定大小
        frame.setSize(300,300);
        //显示出来
        frame.setVisible(true);

    }
}
