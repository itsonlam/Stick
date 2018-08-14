package Helpers;

import java.util.prefs.Preferences;

public class Pref {
	
	public static void main(String[] args) {
		
		Preferences pref = Preferences.userNodeForPackage(Pref.class);
		//pref.put("username", "admin");
		//pref.get("username", "admin");
		
	}
}
