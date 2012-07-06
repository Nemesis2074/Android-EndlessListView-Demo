package net.nemesis2074.endless.demo.data;

import java.util.ArrayList;


public class ConnectionSimulator {
	
	/**
	 * Simula la consulta a cualquier origen de datos: base de datos, servicio web, etc.
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
