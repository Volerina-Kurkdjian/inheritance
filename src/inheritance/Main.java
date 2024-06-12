package inheritance;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

public class Main {


    public  static void variables(int a){
        int b=1;

        Predicate<Integer> p1= aa->{
            int ba=0;
            int c=0;
            return ba==c;
        };
    }


    public static void main(String[] args) throws ParseException {


//        System.out.println("Hello world!");
//        var lion=new Lion();
//        lion.setProperties(3,"king");
//        lion.roar();
//
//        System.out.println(new Lion().getType());
//        new Beetle().printData();

        Locale locale = new Locale("en", "UK");
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
        dateFormatSymbols.setWeekdays(new String[]{
                "Unused",
                "Sad Sunday",
                "Manic Monday",
                "Thriving Tuesday",
                "Wet Wednesday",
                "Total Thursday",
                "Fat Friday",
                "Super Saturday",
        });



        String pattern = "EEEEE MMMMM yyyy";
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat(pattern, dateFormatSymbols);

        String date = simpleDateFormat.format(new Date());
        System.out.println(date);


//        String pattern1 = "yyyy-MM-dd";
//        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(pattern1);
//
//        Date date1 = simpleDateFormat1.parse("2018-09-09");
//        System.out.println(date1);


        LocalDate currentDate = LocalDate.now();
        LocalDate currentDateMinus30Days = currentDate.minusDays(30);

        // 2021-03-26
        System.out.println("currentDate: " + currentDate);

        // 2020-09-26
        System.out.println("currentDateMinus30Days : " + currentDateMinus30Days);

        LocalDate date1 = LocalDate.of(2019, 8, 23);
        System.out.println("\ndate1 : " + date1);
        if (date1.isBefore(currentDateMinus30Days)) {
            System.out.println("30 months older than current date!");
        }

        System.out.println("\nLambdas ");
        Set<String> set= Set.of("Mickey","Minnie");
        List<String> list=new ArrayList<>(set);

        set.forEach(s-> System.out.println(s));
        list.forEach(s-> System.out.println(s));



    }






}