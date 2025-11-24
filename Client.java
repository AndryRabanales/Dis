public class Client {
    private Dispatcher dispatcher;

    public Client(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void doTask(String serviceName, Object data) {
        System.out.println("[Client] Doing task...");
        Channel channel = dispatcher.getChannel(serviceName);
        if (channel == null) {
            System.out.println("[Client] Not found service named: " + serviceName);
            return;
        }
        sendRequest(channel, data);
    }

    protected void sendRequest(Channel channel, Object data) {
        System.out.println("[Client] Sending request...");    

        Object result = channel.send(data);
        System.out.println("[Client] Result: " + result);
    }
}