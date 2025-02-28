import java.util.HashMap;
import java.util.Map;

public class ConfigurationExample {
    public static void main(String[] args) {
        Map<String, String> config = new HashMap<>();
        config.put("timeout", "30");
        config.put("theme", "dark");

        // Retrieve configuration with defaults
        String timeout = config.getOrDefault("timeout", "60");
        String theme = config.getOrDefault("theme", "light");
        String language = config.getOrDefault("language", "en");

        System.out.println("Timeout: " + timeout); // Output: Timeout: 30
        System.out.println("Theme: " + theme);     // Output: Theme: dark
        System.out.println("Language: " + language); // Output: Language: en
    }
}