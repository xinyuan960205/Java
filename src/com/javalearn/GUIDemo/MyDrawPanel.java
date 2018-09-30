package com.javalearn.GUIDemo;

import java.awt.*;
import javax.swing.*;

/**
 * @ClassName: MyDrawPanel
 * @Description: 自己创建绘图组件
 * @Author: xinyuan
 * @CreateDate: 2018/9/30 20:03
 */
public class MyDrawPanel extends JPanel{
    public void paintComponent(Graphics g){
        //把g看成是画笔，设置它的颜色
        g.setColor(Color.blue);
        //设置他要画的图形
        g.fillRect(20,50,100,100);
    }
}
