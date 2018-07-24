package Helpers;

public class HashEntry {
	private int key;
	private int value;
	
	HashEntry(int key, int value){
		this.key = key;
		this.value = value;
	}
	
	//testing will need to change to String
	public int getValue() {
		return value;
	}
	 public int getKey() {
         return key;
   }
}
