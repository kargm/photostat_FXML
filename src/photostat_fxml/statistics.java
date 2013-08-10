package photostat_fxml;

import java.util.HashMap;

public class statistics {
    // Here the HashMaps will be stored which include image statistics
    public HashMap<String, Integer> days_map = new HashMap<>();
    public HashMap<String, Integer> months_map = new HashMap<>();
    public HashMap<String, Integer> year_map = new HashMap<>();
    public favourite favouriteDay = new favourite();
    public favourite favouriteMonth = new favourite();
    public favourite favouriteYear = new favourite();
    
    // More to come ...
    
    @Override
    public String toString() {
        return "Weekdays: " + days_map.toString() + "\n" +
                "Months: " + months_map.toString() + "\n" +
                "Years: " + year_map.toString() + "\n" +
                "Favourite Day: " + this.getFavourite(days_map) + "\n" +
                "Favourite Month: " + this.getFavourite(months_map) + "\n" +
                "Favourite Year: " + this.getFavourite(year_map);
     
    }
    
    // This function gets the name and value of the HashEntry with the highest number of keys
    // Also it calculates the percentage with respect to the total amount of numbers
    public favourite getFavourite(HashMap<String, Integer> map) {
        favourite fav = new favourite();
        int numberEntries = 0;
        
        for (String key : map.keySet()) { 
                // Init
                if (fav.name == null) {
                    fav.name = key;
                    fav.number = map.get(key);
                }
                if (map.get(key) > fav.number) {
                    fav.name = key;
                    fav.number = map.get(key);
                }
                numberEntries += map.get(key);
        }
        fav.percentage = (float) fav.number / (float) numberEntries * 100; 
        return fav;
    }
}
