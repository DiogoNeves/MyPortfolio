package com.diogo.snows.myfolio;

import java.io.IOException;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends FragmentActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Create the adapter that will return a fragment for each of the three
		// primary sections
		// of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		// return true;
		return false;
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the primary sections of the app.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		private final class SectionInfo {
			private final String mTitle;
			private final Fragment mFragment;

			/**
			 * @return the mTitle
			 */
			public String getTitle() {
				return mTitle;
			}

			/**
			 * @return the mViewGroup
			 */
			public Fragment getFragment() {
				return mFragment;
			}

			public SectionInfo(String title, Fragment fragment) {
				mTitle = title;
				mFragment = fragment;
			}
		}

		private SectionInfo[] mSections;

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);

			mSections = new SectionInfo[] { new SectionInfo("contact",
					new ContactSectionFragment()) };
		}

		@Override
		public Fragment getItem(int i) {
			return mSections[i].getFragment();
		}

		@Override
		public int getCount() {
			return mSections.length;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return mSections[position].getTitle();
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class ContactSectionFragment extends Fragment {
		public ContactSectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View contactView = inflater.inflate(R.layout.contact_layout, null);

			ImageView qrCode = (ImageView) contactView
					.findViewById(R.id.qrcode);
			if (qrCode != null) {
				try {
					AssetManager assetManager = getActivity().getAssets();
					Bitmap qrImage = BitmapFactory.decodeStream(assetManager
							.open("qrcode.png"));
					qrCode.setImageBitmap(qrImage);
				} catch (IOException e) {
				}
			}

			return contactView;
		}
	}
}
