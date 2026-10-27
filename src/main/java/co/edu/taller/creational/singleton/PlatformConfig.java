package co.edu.taller.creational.singleton;

import java.util.HashMap;
import java.util.Map;

public class PlatformConfig {
    // TODO: implement thread-safe Singleton and expose instance() and get(key).
    private static PlatformConfig instance;
    private final Map<String,String> configMap;

    private PlatformConfig(){
        configMap = new HashMap<>();
        configMap.put("environment", "production");
    }

    public static PlatformConfig instance() {
        if (instance == null) {
            synchronized (PlatformConfig.class) {
                if (instance == null) {
                    instance = new PlatformConfig();
                }
            }
        }
        return instance;
    }

    public String get(String key) {
        if (key == null || key.trim().isEmpty()) {
            throw new IllegalArgumentException("Key cannot be blank or null");
        }
        return configMap.get(key);
    }
}