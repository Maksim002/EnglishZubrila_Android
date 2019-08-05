package mainactivity.musicplayer.example.com.englishzubrila.FirstLevel.Elementary;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import mainactivity.musicplayer.example.com.englishzubrila.R;

public class A1Elementary extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elementary_amin);

        VideoView vidView = (VideoView)findViewById(R.id.videoView);

        String videPath = "android.resource://" + getPackageName() + "/" + R.raw.trans;
        Uri uri  = Uri.parse(videPath);
        vidView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        vidView.setMediaController(mediaController);
        mediaController.setAnchorView(vidView);

    }
}
