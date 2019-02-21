package com.javalearn.GUIDemo;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName: SimpleAnimation
 * @Description: 动画程序
 * @Author: xinyuan
 * @CreateDate: 2018/10/4 10:29
 */
public class SimpleAnimation {
    int x=70;
    int y=70;

    public static void main(String[] args){
        SimpleAnimation simpleAnimation =new SimpleAnimation();
        simpleAnimation.go();
    }

    public void go(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(drawPanel);
        frame.setSize(300,300);
        frame.setVisible(true);

        for(int i=0;i<130;i++){
            x++;
            y++;
            drawPanel.repaint();

            try{
                Thread.sleep(50);
            }catch (Exception ex){

            }
        }
    }

    class MyDrawPanel extends JPanel{
        public void paintComponent(Graphics g){
            //添加两行代码，为了把前面画的覆盖
            g.setColor(Color.white);
            g.fillOval(0,0,this.getWidth(),this.getHeight());
            g.setColor(Color.MAGENTA);
            //设定绘制对象坐标
            g.fillOval(x,y,40,40);
        }
    }
}
