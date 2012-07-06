package net.nemesis2074.endless.demo.adapter;

import java.util.List;

import net.nemesis2074.endless.demo.R;
import net.nemesis2074.endless.demo.data.Item;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ItemsArrayAdapter extends ArrayAdapter<Item> {

	public ItemsArrayAdapter(Context context, int textViewResourceId, List<Item> objects) {
		super(context, textViewResourceId, objects);
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		
		if(view==null){
			LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = vi.inflate(R.layout.item, null);
		}
		
		TextView txtTitle = (TextView)view.findViewById(R.id.item_title);
		TextView txtDescription = (TextView)view.findViewById(R.id.item_description);
		
		txtTitle.setText(getItem(position).getTitle());
		txtDescription.setText(getItem(position).getDescription());
		
		return view;
	}

	

}
