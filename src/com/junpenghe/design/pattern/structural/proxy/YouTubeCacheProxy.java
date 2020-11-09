package com.junpenghe.design.pattern.structural.proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Junpeng He
 */
public class YouTubeCacheProxy implements ThirdPartyYouTubeLib {

    private ThirdPartyYouTubeLib youTubeLibService;
    private Map<String, Video> cachePopular = new HashMap<>();
    private Map<String, Video> cacheAll = new HashMap<>();

    public YouTubeCacheProxy() {
        this.youTubeLibService = new ThirdPartyYouTubeClass();
    }

    @Override
    public Map<String, Video> popularVideos() {
        if (cachePopular.isEmpty()) {
            cachePopular = youTubeLibService.popularVideos();
        } else {
            System.out.println("Retrieved list from cache.");
        }
        return cachePopular;
    }

    @Override
    public Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if (video == null) {
            video = youTubeLibService.getVideo(videoId);
            cacheAll.put(videoId, video);
        } else {
            System.out.println("Retrieved video '" + videoId + "' from cache.");
        }
        return video;
    }

    public void reset() {
        cachePopular.clear();
        cacheAll.clear();
    }
}
