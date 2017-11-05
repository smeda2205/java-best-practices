package item1.service_provider_sketch;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Services {

    private Services(){} //to prevent instantiation

    //Maps service name to services
    private static final Map<String, Provider> providers = new ConcurrentHashMap<>();
    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    public static void registerDefaultProvider(Provider provider){
        registerProvider(DEFAULT_PROVIDER_NAME,provider);
    }

    public static void registerProvider(String name, Provider provider){
        providers.put(name,provider);
    }

    //Service Access API

    public static Service newInstance(){
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name){
        Provider provider
                 = providers.get(name);
        if (provider == null){
            throw new IllegalArgumentException("No provider registered with name : "+name);
        }
        return provider.newService();
    }
}
