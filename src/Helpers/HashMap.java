package Helpers;

import java.util.Map;

public class HashMap {
	private final static int TABLE_SIZE = 128;
	
	private static HashEntry[] table;
	
	HashMap(){
		table = new HashEntry[TABLE_SIZE];
		for (int i=0; i < TABLE_SIZE; i++){
			table[i] = null;
		}
	}
	
	public int get(int key){
		int hash = (key % TABLE_SIZE);
			while(table[hash] != null && table[hash].getKey() != key)
				hash = (hash + 1) % TABLE_SIZE;
			if (table[hash] == null)
				return -1;
			else
				return table[hash].getValue();
	}
	
	public static void put(int key, int value){
		int hash = (key % TABLE_SIZE);
		while (table[hash] != null && table[hash].getKey() != key)
			hash=(hash+1) % TABLE_SIZE;
		table[hash] = new HashEntry(key, value);
		}
	

}


