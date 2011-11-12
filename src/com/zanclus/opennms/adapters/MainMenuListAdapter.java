/**
 * 
 */
package com.zanclus.opennms.adapters;

import com.zanclus.opennms.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * @author dphillips
 *
 */
public class MainMenuListAdapter extends BaseAdapter {

	private String[] mainMenuItems = null ;
	private Context ctx = null ;

	public MainMenuListAdapter(Context ctx) {
		super() ;
		this.ctx = ctx ;
		mainMenuItems = ctx.getResources().getStringArray(R.array.mainMenuItems) ;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		return mainMenuItems.length ;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int position) {
		return mainMenuItems[position] ;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int position) {
		return position ;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView==null) {
			LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.main_menu_row, null) ;
		}
		TextView menuItemLabel = (TextView) convertView.findViewById(R.id.menuItemLabel) ;
		menuItemLabel.setText(mainMenuItems[position]) ;

		return convertView ;
	}

}
