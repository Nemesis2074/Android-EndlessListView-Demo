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

package net.nemesis2074.endless.demo.data;

import java.util.ArrayList;

/**
 * Simula la consulta a cualquier origen de datos: base de datos, servicio web, etc.
 * 
 * @author Adair Castillo (Nemesis2074)
 */
public class ConnectionSimulator {
	
	/**
	 * Recibe los siguientes parametros (similares a como se utilizan en la sentencia SELECT en SQL):
	 * 
	 * <b>numerOfItems</b>: La cantidad de elementos que se desea obtener.
	 * <b>itemsOffset</b>: El indice del elemento a partir del cual se va a consultar. 
	 * 
	 */
	public static ArrayList<Item> requestItems(int numberOfItems, int itemsOffset) {
		ArrayList<Item> items = new ArrayList<Item>();
		
		try{
			for(int x=0; x<numberOfItems; x++){
				Item item = new Item();
				item.setTitle("Item #" + ((x+1) + itemsOffset) );
				item.setDescription("Fanny pack aesthetic fixie sriracha, elit sartorial freegan biodiesel fingerstache quinoa vinyl. Shoreditch cillum Austin, truffaut pitchfork helvetica accusamus.");
				items.add(item);
			}
		
			Thread.sleep(2000);
		}catch(InterruptedException e){}
		
		return items;
	}

}
