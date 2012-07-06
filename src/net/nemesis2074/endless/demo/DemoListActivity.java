package net.nemesis2074.endless.demo;

import java.util.ArrayList;
import android.os.AsyncTask;
import android.os.Bundle;
import net.nemesis2074.endless.EndlessListActivity;
import net.nemesis2074.endless.demo.adapter.ItemsArrayAdapter;
import net.nemesis2074.endless.demo.data.ConnectionSimulator;
import net.nemesis2074.endless.demo.data.Item;

public class DemoListActivity extends EndlessListActivity<Item, Bundle> {
	
	private static final int NUMBER_OF_ITEMS = 10;
	
	private static final String EXTRA_ITEMS = "items";

	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if(getListItems().size() == 0){
			initListView(new ItemsArrayAdapter(this, R.layout.item, getListItems()));
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
	public void loadMoreItems(int totalItems, Bundle extraInfo) {
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
