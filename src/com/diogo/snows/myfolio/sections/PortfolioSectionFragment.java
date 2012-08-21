/**
 * 
 */
package com.diogo.snows.myfolio.sections;

import com.diogo.snows.myfolio.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author dneves
 *
 */
public class PortfolioSectionFragment extends Fragment {
	public PortfolioSectionFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.resume_layout, null);
	}
}
