package data;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.UIManager.get;


public class NewParser {

    private Document doc;
    private Document doc2;
    //private String group = "PKo-31";
    private String group = "http://rea.perm.ru/?page_id=1036&id=Timetable/rs_PKo-31";
    private List<String> day1 = new ArrayList<>();
    private List<String> day2 = new ArrayList<>();

    public List<String> getHTML() {
        try {
            //doc = Jsoup.connect("http://rea.perm.ru/?page_id=1036&id=Timetable/rs_" + group).get();
            //doc = Jsoup.connect("http://rea.perm.ru/?page_id=1036&id=Timetable/rasp_2020.11.19").get();
            doc = Jsoup.connect(group).get();
            Elements timetable = doc.getElementsByTag("tbody");
            Elements group_timetable = doc.select("tr");
            int count = 0;
            for (int i = 1; i < group_timetable.size(); i++) {
                if (trProcessing(group_timetable.get(i))) {
                    Element line = group_timetable.get(i);
                    Elements colomn = line.select("td");
                    day1.add(colomn.get(1).text());
                    count++;
                    if (count % 8 != 0) {
                        i++;
                        count = 0;
                    }
//                day1.removeIf(n->(n.isEmpty()));
                }
            }

            /*
            Elements day1;
            Elements day2;
            Elements day3;
            int count = 0;
            for (int i = 0; i <group_timetable.size() ; i++) {
                if (trProcessing(group_timetable.get(i))){
                    if(i/2==0&&i!=4){
                        day1 = timetable.get(i).children();
                    }
                    if(i/3==0){
                        day2 = timetable.get(i).children();
                    }
                    if(i/4==0){
                        day3 =timetable.get(i).children();

                    }

                }
            }
*/

        /*    for (int i = 1; i <group_timetable.size() ; i++) {
                group_timetable.get(0).getElementsByTag("")
                System.out.println(group_timetable.getElementByTag());
                System.out.println(group_timetable.get(i).text());
            }*/

        } catch (IOException e) {
            e.printStackTrace();
        }
        return day1;
    }

    private boolean trProcessing(Element element) {
        return element.hasAttr("valign") || element.hasClass("fon");
    }
}
