import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;
import java.util.Scanner;

public class Application extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.getMessage().getContentRaw().toLowerCase().equals("!ping")) {
            event.getChannel().sendMessage("Pong!").queue();
        }else if(event.getMessage().getContentRaw().toLowerCase().length() >=2){
            if (event.getMessage().getContentRaw().toLowerCase().substring(0,2).equals("!r")){
                String str;
                Random random = new Random();
                int nb;
                int rd;
                str = event.getMessage().getContentRaw().toLowerCase();
                if (str.length() >= 2){
                    try {
                        str=str.substring(2,str.length());
                        //System.out.println("str : \""+str+"\"");
                        //System.out.println("roll!");
                        //System.out.println("d: "+str.indexOf("d"));
                        nb = Integer.parseInt(str.substring(0, str.indexOf("d")));
                        //System.out.println("nb : "+nb);
                        for(int i = 0; i<nb; i++){
                            rd = random.nextInt(1,Integer.parseInt(str.substring(str.indexOf("d")+1, str.length()))+1);
                            //System.out.println("rd :"+rd);
                            event.getChannel().sendMessage(rd+"").queue();
                        }
                    }catch (Exception e){
                        System.err.println("format inconnu. ex : !r{x}d{y}");
                        event.getChannel().sendMessage("format inconnu. ex : !r{x}d{y}");
                    }
                }
            }else{
                System.out.println("ok");
            }
        }
    }
}
