package photostat_fxml;

import java.util.HashMap;



public class statistics {
	// Here the HashMaps will be stored which include image statistics
	public HashMap<String, Integer> days_map = new HashMap<>();
	public HashMap<String, Integer> months_map = new HashMap<String, Integer>();
	public HashMap<String, Integer> year_map = new HashMap<String, Integer>();
	
	// More to come ...
	
	public String toString() {
		return "Weekdays: " + days_map.toString() + "\n" +
				"Months: " + months_map.toString() + "\n" +
				"Years: " + year_map.toString();
	}
}
