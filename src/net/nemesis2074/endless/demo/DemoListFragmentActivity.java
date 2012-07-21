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
