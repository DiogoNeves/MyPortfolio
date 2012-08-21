package com.diogo.snows.myfolio;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;

import com.diogo.snows.myfolio.sections.ContactSectionFragment;
import com.diogo.snows.myfolio.sections.ResumeSectionFragment;

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

			mSections = new SectionInfo[] {
						new SectionInfo("contact", new ContactSectionFragment()),
						new SectionInfo("resume", new ResumeSectionFragment()),
						new SectionInfo("portfolio", new ResumeSectionFragment())
					};
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
}
