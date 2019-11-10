package com.komapps.komplayer.ui.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.komapps.komplayer.R;

import java.util.ArrayList;

public class MusicAdapter extends BaseAdapter {
    private ArrayList<MusicContainer> mainList;
    private Context context;
    private String countryList[];
    private int flags[];
    private LayoutInflater inflter;

    public MusicAdapter(Context applicationContext, ArrayList<MusicContainer> musics) {
        this.context = applicationContext;
        mainList = musics;
    }

    @Override
    public int getCount() {
        return mainList.size();
    }

    @Override
    public Object getItem(int i) {
        return mainList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        if (view == null) {

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.musics_listvew_item, null);
        }
        SetupItem(view, mainList.get(position));
        return view;
    }

    void SetupItem(View view, MusicContainer musicContainer) {

        ImageView musicIcon = (ImageView) view.findViewById(R.id.musicIcon);
        musicIcon.setImageBitmap(musicContainer.Image);

        TextView titleTextView=(TextView)view.findViewById(R.id.musicTitle);
        titleTextView.setText(musicContainer.Title);

        TextView subTitleTextView=(TextView)view.findViewById(R.id.musicSubtitle);
        subTitleTextView.setText(musicContainer.Subtitle);

        TextView durationTextView=(TextView)view.findViewById(R.id.musicDuration);
        durationTextView.setText(musicContainer.Duration.toString());
    }
}
