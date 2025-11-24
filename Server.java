public abstract class Server {
    public boolean acceptConnection() {
        System.out.println("["+getServerName()+"] Accepting connection...");
        return true;
    }

    protected abstract Object runService(Object data);

    public Object receiveRequest(Object data) {
        System.out.println("["+getServerName()+"] Receiving request...");
        Object result = runService(data);
        System.out.println("["+getServerName()+"] Service done with result: " + result);
        return result;
    }

    protected abstract String getServerName();
}

