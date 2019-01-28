package com.your.package.name;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class FileManagerAndroid {

    ArrayList<String> filenames;
    ArrayAdapter<String> adapter;


    @Override
    public View onCreate(Bundle savedInstanceState) {
        songlist =  findViewById(R.id.songlist);  //listview widget
        filenames = new ArrayList<>();
        getMusic();         // music files funtions
        adapter=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, filenames);
        songlist.setAdapter(adapter);
        setContentView(R.layout.activity_main);
    }

    private void  getMusic() {

        File path = Environment.getExternalStorageDirectory();
        String filename ;
        Queue<File> files = new LinkedList<>();         //Linklist

        files.addAll(Arrays.asList(path.listFiles()));  //adding all files of path in linklist

        while (!files.isEmpty()){
            File file = files.remove();
            if (file.isDirectory()){
                files.addAll(Arrays.asList(file.listFiles()));
            }
            else if (file.getName().endsWith(".mp3")){      // .mp3 is music file extension change as your need (.doc, .mp4)
                filename = file.getName();
                filenames.add(filename);

            }
            else if (file.getName().endsWith(".ogg")){
                filename = file.getName();
                filenames.add(filename);
            }
            else if (file.getName().endsWith(".amr")){
                filename = file.getName();
                filenames.add(filename);
            }
            else if (file.getName().endsWith(".wav")){
                filename = file.getName();
                filenames.add(filename);
            }
            else if (file.getName().endsWith(".wma")){
                filename = file.getName();
                filenames.add(filename);
            }
            else if (file.getName().endsWith(".flac")){
                filename = file.getName();
                filenames.add(filename);
            }
        }
    }
}
