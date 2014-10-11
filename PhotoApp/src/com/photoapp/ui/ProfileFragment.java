package com.photoapp.ui;

import java.util.ArrayList;

import org.json.JSONObject;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.google.gson.Gson;
import com.photoapp.R;
import com.photoapp.adapters.DrawerListAdapter;
import com.photoapp.domain.PopularMedia;
import com.photoapp.domain.ProfileDetails;
import com.photoapp.domain.UserInfo;
import com.photoapp.utils.Constants;
import com.photoapp.utils.UserAccount;
import com.photoapp.utils.VolleyResources;

public class ProfileFragment extends Fragment {
	
	private TextView mUserNameTv, mFollowersTv,mFollowingTv;
	UserInfo userInfo;
	private ProfileDetails profileDetails;
	private Typeface mTypeFace; 
	
	ArrayList<String> listItems;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View parentView = inflater.inflate(R.layout.fragment_profile, container,false);
		userInfo = UserAccount.getInstance().getInfo();
		mTypeFace = Typeface.createFromAsset(getActivity().getAssets(), "timeburner_regular.ttf");
		NetworkImageView profileImageView = (NetworkImageView) parentView.findViewById(R.id.profile_pic_iv);
		mUserNameTv = (TextView) parentView.findViewById(R.id.username_tv);
		mFollowersTv = (TextView) parentView.findViewById(R.id.followers_tv);
		mFollowingTv = (TextView) parentView.findViewById(R.id.following_tv);
		
		mUserNameTv.setTypeface(mTypeFace);
		mFollowersTv.setTypeface(mTypeFace);
		mFollowingTv.setTypeface(mTypeFace);
		
		profileDetails = ((HomeActivity)getActivity()).getProfileDetails();
		
		profileImageView.setImageUrl(profileDetails.getData().getProfilePicture(), 
				VolleyResources.getInstance(getActivity()).getmImageLoader());
		mUserNameTv.setText(profileDetails.getData().getFullName());
		mFollowersTv.setText("Followers: " + profileDetails.getData().getCounts().getFollowedBy());
		mFollowingTv.setText("Following: " + profileDetails.getData().getCounts().getFollows());
		
		return parentView;
	}
	    
}
