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
    
    public String printName() {
        return name.toString();
    }
    
    public String printPercentage() {
        return String.format("%.2f", percentage);
    }
    
    public String printNumber() {
        return number.toString();
    }
    
    @Override
    public String toString() {
        return  name + " ( " + String.format("%.2f", percentage) + " % ), " + number; 
    }
}


