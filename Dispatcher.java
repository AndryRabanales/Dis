import java.util.HashMap;
import java.util.LinkedHashMap;

public class Dispatcher {
    private HashMap<String, Server> locationMap;

    public Dispatcher() {
        locationMap = new LinkedHashMap<>();
    }

    public void registerService(String serviceName, Server server) {
        System.out.println("[Dispatcher] Registering service...");
        locationMap.put(serviceName, server);
    }

    public void unregisterService(String serviceName) {
        System.out.println("[Dispatcher] Removing service...");
        locationMap.remove(serviceName);
    }

    public Server locateServer(String serviceName) {
        System.out.println("[Dispatcher] Locating server...");
        return locationMap.get(serviceName);
    }

    public Channel establishChannel(Server server) {
        System.out.println("[Dispatcher] Establishing channel...");
        boolean accepted = server.acceptConnection();
        if (accepted) {
            Channel channel = new Channel(server);
            return channel;
        } else {
            return null;
        }
    }

    public Channel getChannel(String serviceName) {
        System.out.println("[Dispatcher] Retrieving channel...");

        if (!locationMap.containsKey(serviceName)) {
            System.out.println("[Dispatcher]: Cannot find server for service named: " + serviceName);
            return null;
        }

        Server server = locateServer(serviceName);    
        System.out.println("[Dispatcher]: Located server: " + server);
        return establishChannel(server);
    }
}