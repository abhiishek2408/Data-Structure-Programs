import java.util.HashMap;

public class GetOrDefault {
  public static void main(String[] args) {
    HashMap<String, String> capitalCities = new HashMap<String, String>();
    capitalCities.put("England", "London");
    capitalCities.put("England", "London");
    capitalCities.put("Germany", "Berlin");
    capitalCities.put("Germany", "Berlin");
    capitalCities.put("Norway", "Oslo");
    capitalCities.put("USA", "Washington DC");
    System.out.println(capitalCities.getOrDefault("England", "Unknown"));
    System.out.println(capitalCities.getOrDefault("Canada", "Unknown"));
  }
}



//The Java HashMap getOrDefault() method allows users to retrieve the value 
//associated with a specified key, returning a default value if the key does not exist in the map.