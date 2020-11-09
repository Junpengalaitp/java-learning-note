package com.junpenghe.design.pattern.structural.proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Junpeng He
 */
public interface ThirdPartyYouTubeLib {
    Map<String, Video> popularVideos();
    Video getVideo(String videoId);
}
