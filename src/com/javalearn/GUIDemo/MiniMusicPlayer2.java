package com.javalearn.GUIDemo;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

/**
 * @ClassName: MiniMusicPlayer2
 * @Description: 音乐同步输出图形
 * @Author: xinyuan
 * @CreateDate: 2018/10/4 11:37
 */
public class MiniMusicPlayer2 {
    static JFrame frame = new JFrame("my first music video");
    static MyDrawPanel ml;

    public static void main(String[] args){
        MiniMusicPlayer2 miniMusicPlayer2 = new MiniMusicPlayer2();
        miniMusicPlayer2.go();
    }

    public void setUpGui(){
        ml = new MyDrawPanel();
        frame.setContentPane(ml);
        frame.setBounds(30,30,300,300);
        frame.setVisible(true);
    }

    public void go(){
        setUpGui();
        try{
            //创建并打开队列
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addControllerEventListener(ml,new int[] {127});
            //创建队列并track
            Sequence sequence = new Sequence(Sequence.PPQ,4);
            Track track = sequence.createTrack();

            int r = 0;
            //创建一堆连续的音符事件
            for(int i=5;i<61;i+=4){
                //调用makeEvent来产生信息和事件并把它们加到track上
                r = (int) ((Math.random() * 50) + 1);
                track.add(makeEevent(144,1,r,100,i));
                track.add(makeEevent(176,1,127,0,i));
                track.add(makeEevent(128,1,r,100,i+2));
            }
            //开始播放
            sequencer.setSequence(sequence);
            sequencer.setTempoInBPM(220);
            sequencer.start();

        }catch (Exception ex){ex.printStackTrace();}
    }

    //创建静态的实用方法来制作信息并返回MidiEvent
    public static MidiEvent makeEevent(int comd, int chan, int one, int two, int tick){
        MidiEvent event = null;
        try{
            ShortMessage a=new ShortMessage();
            a.setMessage(comd,chan,one,two);
            event = new MidiEvent(a,tick);
        }catch (Exception e){}
        return event;
    }

    class MyDrawPanel extends JPanel implements ControllerEventListener{
        boolean msg = false;

        public void controlChange(ShortMessage event){
            msg = true;
            repaint();
        }

        public void paintComponent(Graphics g){
            if(msg){
                Graphics2D g2 = (Graphics2D) g;

                int r = (int) (Math.random() * 250);
                int gr = (int) (Math.random() * 250);
                int b = (int) (Math.random() * 250);

                g.setColor(new Color(r,gr,b));

                int ht = (int) (Math.random()*120) + 10;
                int width = (int) (Math.random()*120) + 10;
                int x = (int) (Math.random()*40) + 10;
                int y = (int) (Math.random()*40) + 10;
                g.fillRect(x,y,width,ht);
                msg = false;
            }
        }
    }
}
