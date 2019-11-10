package com.komapps.komplayer.ui.main;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.komapps.komplayer.R;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_main, container, false);
        final TextView textView = root.findViewById(R.id.section_label);
        pageViewModel.getIndex().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer index) {
                textView.setText(index.toString());
                SetupAdapter(root, index);
            }
        });
        return root;
    }

    void SetupAdapter(View view, int indexOfTab) {
        ListView musicListView = (ListView) view.findViewById(R.id.MusicListView);

        ArrayList<MusicContainer> musics = getMusics(indexOfTab);

        MusicAdapter customAdapter = new MusicAdapter(view.getContext(), musics);
        musicListView.setAdapter(customAdapter);
    }

    private ArrayList<MusicContainer> getMusics(int indexOfTab) {
        ArrayList<MusicContainer> musics = new ArrayList<>();
        for (int i = 0; i < 99; i++) {
            MusicContainer musicContainer = new MusicContainer();
            musicContainer.Title = "Assalamu alayka" + i;
            musicContainer.Subtitle = "Moher zain" + i;
            musicContainer.Duration = 3.26;
            musicContainer.Image = BitmapFactory.decodeResource(getResources(), R.mipmap.no_mp3_image);
            musics.add(musicContainer);
        }
        return musics;
    }
}