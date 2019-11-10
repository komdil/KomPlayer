package com.komapps.komplayer.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.komapps.komplayer.R;

import java.util.ArrayList;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    ArrayList<String> Tabs = new ArrayList<String>();

    private Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        setTitlesOfTabs();
    }

    private void setTitlesOfTabs() {
        Tabs.add(mContext.getString(R.string.all_musics));
        Tabs.add(mContext.getString(R.string.playlists));
        Tabs.add(mContext.getString(R.string.albums));
        Tabs.add(mContext.getString(R.string.artists));
        Tabs.add(mContext.getString(R.string.search_musics));
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return Tabs.get(position);
    }

    @Override
    public int getCount() {
        // Show 5 total pages.
        return Tabs.size();
    }
}