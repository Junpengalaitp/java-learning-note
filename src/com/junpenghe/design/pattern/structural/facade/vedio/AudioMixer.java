package com.junpenghe.design.pattern.structural.facade.vedio;

import java.io.File;

/**
 * @author Junpeng He
 */
public class AudioMixer {
    public File fix(VideoFile result){
        System.out.println("AudioMixer: fixing audio...");
        return new File("tmp");
    }
}
