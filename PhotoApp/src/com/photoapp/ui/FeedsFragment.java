package com.photoapp.ui;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.photoapp.R;
import com.photoapp.adapters.DrawerListAdapter;
import com.photoapp.adapters.PictureListAdapter;
import com.photoapp.domain.Datum;
import com.photoapp.domain.FeedInfo;
import com.photoapp.domain.PopularMedia;


/**
 * Fragment to show user Feeds
 * @author amansharma
 *
 */
public class FeedsFragment extends Fragment {

	ArrayList<FeedInfo> feeds;
	private ListView mImagesLv;
	private PictureListAdapter mAdapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View parentView = inflater.inflate(R.layout.fragment_feeds, null);
		mImagesLv = (ListView) parentView.findViewById(R.id.pics_lv);
		feeds = new ArrayList<FeedInfo>();
		
		PopularMedia popularMedia = ((HomeActivity) getActivity()).getPopularMedia();
		
		for(Datum data : popularMedia.getData()) { 
			if(data.getType().equals("video")) {
				feeds.add(new FeedInfo(data.getImages().getLowResolution().getUrl(),
						data.getVideos().getLowResolution().getUrl(),
						data.getUser().getFullName(),data.getLikes().getCount(),
						data.getType()));
			} else {
				feeds.add(new FeedInfo(data.getImages().getStandardResolution().getUrl(),
						data.getUser().getFullName(),data.getLikes().getCount(),
						data.getType()));	
			}
		}
		
		mAdapter = new PictureListAdapter(getActivity(), feeds);
		mImagesLv.setAdapter(mAdapter);
		
		System.out.println();
		return parentView;
	}
}
