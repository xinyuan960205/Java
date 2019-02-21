package com.javalearn.GUIDemo;

import javax.sound.midi.*;

/**
 * @ClassName: MiniMusicPlayer1
 * @Description: 音乐录像程序：实现使用静态makeEvent方法
 * @Author: xinyuan
 * @CreateDate: 2018/10/4 11:19
 */
public class MiniMusicPlayer1 {

    public static void main(String[] args){
        try{
            //创建并打开队列
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            //创建队列并track
            Sequence sequence = new Sequence(Sequence.PPQ,4);
            Track track = sequence.createTrack();
            //创建一堆连续的音符事件
            for(int i=5;i<61;i+=4){
                //调用makeEvent来产生信息和事件并把它们加到track上
                track.add(makeEevent(144,1,i,100,i));
                track.add(makeEevent(144,1,i,100,i+2));
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
}
