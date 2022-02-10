import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] argv) throws LoginException{
        JDA jda = JDABuilder.createDefault(argv[0]).addEventListeners(new Application()).build();

    }
}
