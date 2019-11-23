package com.example.superapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoFragment extends Fragment {

    VideoView videoView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_video,null);

        videoView = (VideoView) view.findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(getContext());
        videoView.setMediaController(mediaController);
        Uri video = Uri.parse("android.resource://" + getContext().getPackageName()+"/" + R.raw.amsterdam);
        videoView.setVideoURI(video);
        mediaController.setAnchorView(videoView);
        videoView.start();




        return view;
    }
}
