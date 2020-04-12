package view.bot;

import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.TextChannel;
import view.BotView;
import view.bot.discordCommands.GetTT;
import view.refacs.RefacDiscord;

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

    public static void main(String[] args) {
        BotView bot = new DiscordBotView();
    }

    public void sendTimetable(String[][] timetable) {
        TextChannel channel = jda.getTextChannelById("626093012317110273");
        EmbedBuilder eb = new EmbedBuilder();
        String date = timetable[0][1];
        String reaIcon = RefacDiscord.LINK_REU_ICON;
        String gorin = RefacDiscord.LINK_GORIN;

        eb.setAuthor("\uD83D\uDCDA РАСПИСАНИЕ"); // 📚
        eb.setThumbnail(reaIcon);
        eb.setTitle(date, RefacDiscord.LINK_REU_PK_21);
        for (int i = 1; i < timetable.length; i++)
            setLesson(eb, timetable[i][0], timetable[i][1]);
        eb.setFooter("как всегда говно", gorin);

        channel.sendMessage(eb.build()).queue();
    }

    private void setLesson(EmbedBuilder eb, String time, String lesson) {
        eb.addField("`" + time + "`", lesson, false);
    }
}
