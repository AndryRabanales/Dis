public class Channel {
    private Server server;
        
    public Channel(Server server) {
        this.server = server;
    }

    public Object send(Object data) {
        System.out.println("[Channel] Forwarding request...");
        Object response = server.receiveRequest(data);
        System.out.println("[Channel] Server response: " + response);
        return response;
    }
}