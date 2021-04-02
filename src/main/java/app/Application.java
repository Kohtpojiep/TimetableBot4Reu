package app;

import data.NewParser;
import data.ParserPK_21;
import newDataModule.dao.*;
import newDataModule.entities.*;
import org.checkerframework.checker.units.qual.K;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;
import spark.Session;
import view.discord.bot.DiscordBotView;
import view.telegram.bot.BotViewTelegram;
import view.vk.bot.VkBotView;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
       //ParserPK_21 parserPK_21 = new ParserPK_21();
       // System.out.println(parserPK_21.parse());

       /* my bullshit
        NewParser newParser = new NewParser();
        System.out.println( newParser.getHTML());
        newParser.getHTML().forEach(System.out::println);
        */
        SessionFactory factory = null;

        try {
            factory = new Configuration().configure().buildSessionFactory();

            ScheduleDAO scheduleDAO = new ScheduleDAO(factory);
            LessonDAO lessonDAO = new LessonDAO(factory);
            Lesson schedulew = lessonDAO.read(1);
            System.out.println("Group1: " + schedulew.getInformation());
            System.out.println("Group1: " + schedulew.getTeacher().getTeacherName());

            GroupDAO groupDAO = new GroupDAO(factory);
            System.out.println("Group1: " + groupDAO.getByName("ПКо-21").getGroupName());
            System.out.println("Group1: " + groupDAO.getList().size());
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            if (factory != null) {
                factory.close();
            }
        }
    }
}