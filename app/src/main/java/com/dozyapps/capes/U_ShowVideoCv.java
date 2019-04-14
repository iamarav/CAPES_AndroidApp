package com.dozyapps.capes;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class U_ShowVideoCv extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u_activity_show_video_cv);

        final VideoView videoView=(VideoView)findViewById(R.id.video);

        String url=getIntent().getExtras().getString("videourl");
        Uri uri = Uri.parse(url);
        MediaController mediaController=new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.start();
    }
}
