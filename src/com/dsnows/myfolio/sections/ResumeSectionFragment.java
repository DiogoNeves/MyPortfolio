/**
 * 
 */
package com.dsnows.myfolio.sections;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dsnows.myfolio.R;

/**
 * @author dneves
 *
 */
public class ResumeSectionFragment extends Fragment {
	public ResumeSectionFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.resume_layout, null);
	}
}
