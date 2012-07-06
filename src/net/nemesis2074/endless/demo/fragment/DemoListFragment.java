package net.nemesis2074.endless.demo.fragment;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import net.nemesis2074.endless.EndlessListFragment;
import net.nemesis2074.endless.demo.R;
import net.nemesis2074.endless.demo.adapter.ItemsArrayAdapter;
import net.nemesis2074.endless.demo.data.ConnectionSimulator;
import net.nemesis2074.endless.demo.data.Item;

public class DemoListFragment extends EndlessListFragment<Item> {
	
	private static final int NUMBER_OF_ITEMS = 10;
	
	private static final String EXTRA_ITEMS = "items";
	
	private Context context;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		context = activity;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setRetainInstance(true);
	}

	public void init(){
		if(getListItems().size() == 0){
			initListView(new ItemsArrayAdapter(context, R.layout.item, getListItems()));
		}else{
			initListView();
		}
	}
	
	@Override
	public void refreshItems() {
		LoadItemsTask task = new LoadItemsTask();
		task.execute(NUMBER_OF_ITEMS, 0);
	}

	@Override
	public void loadMoreItems(int totalItems) {
		LoadItemsTask task = new LoadItemsTask();
		task.execute(NUMBER_OF_ITEMS, totalItems);
	}
	
	private class LoadItemsTask extends AsyncTask<Integer, Void, Bundle>{

		@Override
		protected Bundle doInBackground(Integer... parameters) {
			ArrayList<Item> items = ConnectionSimulator.requestItems(parameters[0], parameters[1]);
			
			Bundle bundle = new Bundle();
			bundle.putSerializable(EXTRA_ITEMS, items);
			
			return bundle;
		}

		@SuppressWarnings("unchecked")
		@Override
		protected void onPostExecute(Bundle result) {
			if(result != null){
				ArrayList<Item> items = (ArrayList<Item>)result.getSerializable(EXTRA_ITEMS);
				addItems(items);
			}
		}
		
	}

}
