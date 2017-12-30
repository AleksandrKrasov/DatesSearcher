/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dates;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Саня
 */
public class DataChecker {
    
    private final String YYYY_MM_DD;
    private final String DD_MM_YYYY;
    private final String year;
    private final String month1;
    private final String month2;
    private final String keyWord;
    private String text;
    private ArrayList<String> result;
    
    

    public DataChecker(String text) {
        YYYY_MM_DD = "([0-9]{4})[-/.](0[1-9]|1[012])[-/.](0[1-9]|1[0-9]|2[0-9]|3[01])";
        DD_MM_YYYY = "(0[1-9]|[12][0-9]|3[01])[-/.](0[1-9]|1[012])[- /.](19|20)\\d\\d";
        year = "([0-9]+)[ ](год|году|года|годом|г.)";
        month1 = "(двадцать|тридцать)[ ]([А-Яа-я])+(ого|ое)[ ]"
                + "(января|февраля|марта|апреля|мая|июня|июля|августа|сентября|октября|ноября|декабря)";
        month2 = "(([А-Яа-я])+(ого|ое|его)|([0-9]{1,2}))[ ]"
                + "(января|февраля|марта|апреля|мая|июня|июля|августа|сентября|октября|ноября|декабря)";
        keyWord = "сегодня|сегодняшний|завтрашний|завтра|послезавтра|послезавтрашний|вчера|вчерашний|"
                + "январь|февраль|март|апрель|май|июнь|июль|август|сентябрь|октябрь|ноябрь|декабрь|"
                + "новый год|рождество христово|международный женский день|пасха|День труда|день победы|"
                + "троица|день конституции украины|день независимости украины|день защитника украины|"
                + "рождество христово";
        this.text = text.toLowerCase();
        result = new ArrayList<>();
    }
    
    public void findYYYY_MM_DD(){
        Pattern pattern = Pattern.compile(YYYY_MM_DD);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find())
            result.add(matcher.group());
            //System.out.println(matcher.group());
    }
    
    public void findDD_MM_YYYY(){
        Pattern pattern = Pattern.compile(DD_MM_YYYY);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find())
            result.add(matcher.group());
            //System.out.println(matcher.group());
    }
    
    public void findYear(){
        Pattern pattern = Pattern.compile(year);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find())
            result.add(matcher.group());
            //System.out.println(matcher.group());
    }
    
    public void findMonth1(){
        Pattern pattern = Pattern.compile(month1);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            String buff = matcher.group();
            text = text.replace(buff, "");
            result.add(buff);
            //System.out.println(buff);
        }
    }
    
    public void findMonth2(){
        Pattern pattern = Pattern.compile(month2);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            String buff = matcher.group();
            text = text.replace(buff, "");
            result.add(buff);
            //System.out.println(buff);
        }
    }
    
    public void findKeyWord(){
        Pattern pattern = Pattern.compile(keyWord);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find())
            result.add(matcher.group());
            //System.out.println(matcher.group());
    }
    
    public void findDates(){
        findYYYY_MM_DD();
        findDD_MM_YYYY();
        findYear();
        findMonth1();
        findMonth2();
        findKeyWord();
    }

    public ArrayList<String> getResult() {
        return result;
    }
}

