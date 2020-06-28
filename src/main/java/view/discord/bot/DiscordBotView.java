package view.discord.bot;

import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.TextChannel;
import view.BotView;
import view.discord.refac.RefacDiscord;
import view.discord.сommands.GetTT;

import java.util.Arrays;

public class DiscordBotView implements BotView {
    private static JDA jda;

    public DiscordBotView() {
        try {
            jda = new JDABuilder(AccountType.BOT)
                    .setToken(RefacDiscord.token)
                    .build()
                    .awaitReady();
            jda.getPresence().setStatus(OnlineStatus.ONLINE);
            jda.getPresence().setActivity(Activity.watching("расписание каждые 5 минут"));

            jda.addEventListener(new GetTT(this)); // получать расписание по команде
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void sendTimetableForSubs(String[][] timetable) {
        TextChannel channel = jda.getTextChannelById("621681835348459520");
        EmbedBuilder eb = new EmbedBuilder();
        String date = timetable[0][0];
        String reaIcon = RefacDiscord.LINK_REU_ICON;
        String gorin = RefacDiscord.LINK_GORIN;

        eb.setAuthor("\uD83D\uDCDA РАСПИСАНИЕ"); // 📚
        eb.setThumbnail(reaIcon);
        eb.setTitle(date, RefacDiscord.LINK_REU_PK_21);
        for (int i = 1; i < timetable[0].length; i++)
            setLesson(eb, timetable[0][i], timetable[1][i]);
        eb.setFooter("как всегда говно", gorin);

        channel.sendMessage(eb.build()).queue();
    }

    private void setLesson(EmbedBuilder eb, String time, String lesson) {
        eb.addField("`" + time + "`", lesson, false);
    }
}
