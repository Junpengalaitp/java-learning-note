package com.junpenghe.design.pattern.structural.facade.vedio;

import java.io.File;

/**
 * @author Junpeng He
 */
public class Demo {
    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
        // ...
    }
}
