/*
 * Copyright (c) 2012 Adair Castillo (Nemesis2074)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

/**
 * Ejemplo de ArrayAdapter.
 * 
 * @author Adair Castillo (Nemesis2074)
 */
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
