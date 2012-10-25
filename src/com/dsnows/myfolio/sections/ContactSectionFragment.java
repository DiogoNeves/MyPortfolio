/**
 * 
 */
package com.dsnows.myfolio.sections;

import java.io.IOException;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dsnows.myfolio.R;

/**
 * @author dneves
 *
 */
public class ContactSectionFragment extends Fragment {
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

