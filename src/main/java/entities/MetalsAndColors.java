package entities;

// TODO lombok required
// TODO default fields values is nor really good approach, make a constant
// TODO For multiple values use collections
// TODO Specified data types carefully, "3" should no be a String
public class MetalsAndColors {
    public String element = "Water, Fire";
    public String odd = "3";
    public String even = "8";
    public String metal = "Selen";
    public String color = "Red";
    public String salad = "Cucumber";

    public MetalsAndColors(){
    }

    public MetalsAndColors(String element, String odd, String even, String metal, String color, String salad) {
        this.element = element;
        this.odd = odd;
        this.even = even;
        this.metal = metal;
        this.color = color;
        this.salad = salad;
    }
}
