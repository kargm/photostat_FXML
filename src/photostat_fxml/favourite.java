/*
 * A class to represent favourite elements of a hashtable with name and percentage
 */
package photostat_fxml;

/**
 *
 * @author kargm
 */
public class favourite {
    public String name;
    public Integer number;
    public Float percentage;
    
    @Override
    public String toString() {
        return  name + " ( " + String.format("%.2f", percentage) + " % , " + number + ")"; 
    }
}


