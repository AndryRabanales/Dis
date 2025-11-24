public class AuthenticationServer extends Server {
    public AuthenticationServer() {

    }

    @Override
    protected Object runService(Object data) {
        System.out.println("[AuthenticationServer] Running service...");
        String email = data.toString();
        if (email.contains("error")) {
            return "ERROR code 401 for " + email;
        }

        return "SUCCESS code 200 for " + email;
    }

    @Override
    protected String getServerName() {
        return "authentication";
    }
}