package com.lijian.videoplayer;

import android.view.Surface;

/**
 * Created by lijian on 2017/6/14.
 */

public class VideoPlayer {
    static {
        System.loadLibrary("videoplayer");
    }

    public boolean play(final Surface surface) {
        //耗时操作，需要在非UI线程执行
        new Thread(new Runnable() {
            @Override
            public void run() {
                nativePlay(surface, "/sdcard/test.mp4");
            }
        }).start();
        return true;
    }

    public boolean stop() {
        return nativeStop();
    }

    native private int nativePlay(Surface surface, String fileName);

    native private boolean nativeStop();

}
