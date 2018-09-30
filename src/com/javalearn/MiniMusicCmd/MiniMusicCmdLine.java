package com.javalearn.MiniMusicCmd;
import javax.sound.midi.*;
/**
 * @ClassName: MiniMusicCmdLine
 * @Description: midi音乐播放程序
 * @Author: xinyuan
 * @CreateDate: 2018/9/28 15:58
 */
public class MiniMusicCmdLine {
    public static void main(String[] args){
        MiniMusicCmdLine miniMusicCmdLine = new MiniMusicCmdLine();
        if(args.length > 2){
            System.out.println("Don't forget");
        }else {
//            int instrument = Integer.parseInt(args[0]);
//            int note = Integer.parseInt(args[1]);
            int instrument = 102;
            int note =44;
            miniMusicCmdLine.play(instrument,note);
        }
    }

    public void play(int instrument, int note){
        try{
            //取得Sequencer并将它打开(这个相当于CD播放机)
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            //创建新的Sequence(相当于CD)
            Sequence sequence = new Sequence(Sequence.PPQ,4);
            //从Sequence中创建新的Track（Track相当于单曲CD上唯一歌曲的信息）
            Track track = sequence.createTrack();

            MidiEvent event = null;
            ShortMessage first = new ShortMessage();
            first.setMessage(192,1,instrument,0);
            MidiEvent changeInstrument = new MidiEvent(first,1);
            //填入MidiEvent并让Sequence播放
            track.add(changeInstrument);

            ShortMessage a = new ShortMessage();
            a.setMessage(144,1,note,100);
            MidiEvent noteon = new MidiEvent(a,1);
            track.add(noteon);

            ShortMessage b = new ShortMessage();
            b.setMessage(128,1,note,100);
            MidiEvent noteoff = new MidiEvent(b,16);
            track.add(noteoff);

            player.setSequence(sequence);
            player.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
