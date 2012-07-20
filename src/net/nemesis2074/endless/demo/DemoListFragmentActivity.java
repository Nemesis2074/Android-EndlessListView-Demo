package net.nemesis2074.endless.demo;

import net.nemesis2074.endless.demo.fragment.DemoListFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * 
 * Esta actividad contiene el fragmento que implementa EndlessListFragment<T>.
 * 
 * @author Adair Castillo (Nemesis2074)
 */
public class DemoListFragmentActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_demo);
		
		//Obtiene la referencia al fragmento.
		DemoListFragment fragment = (DemoListFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_demo);
		//Inicializa la carga de elementos en el fragmento.
		fragment.init();
	}

	
	
}
