package com.example.androidhorizontalscrollwhenseek;

import org.jh.widget.HorizontalListView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class HorizontalFragment extends Fragment {

	private static final int COUNT = 1000;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.ho_fragment_main, container,
				false);
		final HorizontalListView listView = (HorizontalListView) rootView
				.findViewById(android.R.id.list);
		final TextView textView = (TextView) rootView
				.findViewById(android.R.id.text1);
		listView.setAdapter(new MyAdapter());
		listView.setEnabled(false);
		listView.setSeekBarWidth(540);
		final SeekBar seekBar = (SeekBar) rootView.findViewById(R.id.seekBar);
		seekBar.setMax(COUNT);
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {

				listView.scrollWhenSeek(progress);

				textView.setText(progress + "");
			}
		});

		return rootView;
	}

	private class MyAdapter extends BaseAdapter {

		LayoutInflater inflater = null;

		public MyAdapter() {
			inflater = LayoutInflater.from(getActivity());
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return COUNT;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			TextView tv = null;
			if (convertView == null) {
				convertView = inflater.inflate(R.layout.item, null);
				tv = (TextView) convertView.findViewById(android.R.id.text1);
				convertView.setTag(tv);
			} else {
				tv = (TextView) convertView.getTag();
			}
			tv.setText((position + 1) + "");
			return convertView;
		}

	}

}
