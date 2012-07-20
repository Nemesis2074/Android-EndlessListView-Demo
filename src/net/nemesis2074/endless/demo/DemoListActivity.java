package net.nemesis2074.endless.demo;

import java.util.ArrayList;
import android.os.AsyncTask;
import android.os.Bundle;
import net.nemesis2074.endless.EndlessListActivity;
import net.nemesis2074.endless.demo.adapter.ItemsArrayAdapter;
import net.nemesis2074.endless.demo.data.ConnectionSimulator;
import net.nemesis2074.endless.demo.data.Item;

/**
 * 
 * Esta clase es un ejemplo de como debe implementarse la clase
 * EndlessListActivity<T>.
 * 
 * @author Adair Castillo (Nemesis2074)
 */
public class DemoListActivity extends EndlessListActivity<Item> {
	
	/**
	 * Nœmero de elementos por bloque.
	 * Se cargaran elementos en la lista de 10 en 10.
	 */
	private static final int NUMBER_OF_ITEMS = 10;
	
	private static final String EXTRA_ITEMS = "items";

	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Modifica el texto indicativo
		setIndicatorText("Loading more items...");
		
		//Inicializa el ListView con un Adapter.
		initListView(new ItemsArrayAdapter(this, R.layout.item, getListItems()));
	}
	
	/**
	 * Carga el primer bloque de elementos
	 */
	@Override
	public void refreshItems() {
		LoadItemsTask task = new LoadItemsTask();
		task.execute(NUMBER_OF_ITEMS, 0);
	}

	/**
	 * Carga los siguientes bloques de elementos hasta llegar al final de la lista.
	 */
	@Override
	public void loadMoreItems(int totalItems) {
		LoadItemsTask task = new LoadItemsTask();
		task.execute(NUMBER_OF_ITEMS, totalItems);
	}
	
	/**
	 * Se encarga de cargar los bloques de elementos.
	 */
	private class LoadItemsTask extends AsyncTask<Integer, Void, Bundle>{

		@Override
		protected Bundle doInBackground(Integer... parameters) {
			//Solicita un bloque de elementos.
			ArrayList<Item> items = ConnectionSimulator.requestItems(parameters[0], parameters[1]);
			
			// Retorna el bloque de elementos en un Bundle.
			Bundle bundle = new Bundle();
			bundle.putSerializable(EXTRA_ITEMS, items);
			return bundle;
		}

		@SuppressWarnings("unchecked")
		@Override
		protected void onPostExecute(Bundle result) {
			
			//Se agrega el nuevo bloque de elementos a la lista.
			if(result != null){
				ArrayList<Item> items = (ArrayList<Item>)result.getSerializable(EXTRA_ITEMS);
				addItems(items);
			}
		}
		
	}

}
