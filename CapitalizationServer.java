public class CapitalizationServer extends Server {
    public CapitalizationServer() {

    }

    @Override
    protected Object runService(Object data) {
        System.out.println("["+getServerName()+"] Running service...");
        return data.toString().toUpperCase();
    }

    @Override
    protected String getServerName() {
        return "capitalization";
    }
}