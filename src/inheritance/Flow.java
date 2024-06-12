package inheritance;

import java.util.ArrayList;
import java.util.List;

public class Flow {



    public static void main(String[] args) {

        List par=new ArrayList();

        int day=6;
        switch(day){

            case 1:
                System.out.println("Sunday");
            case 6:
                System.out.println("Saturday");
            default:
                System.out.println("Weekday");
            case 0:
                System.out.println("Maria");

        }

        String s1="1";
        String s2=s1.concat("2");
        s1= s2.concat("3");
        System.out.println(s2);
        System.out.println(s1);

        String alpha="";
        for(char current='a';current<='z';current++){
            alpha+=current;
        }
        System.out.println(alpha);

        Flow f1=new Flow();
        Flow f2=new Flow();
        Flow f3=f1;

        System.out.println(f1==f3);
        System.out.println(f1.equals(f3));
        System.out.println(f1.equals(f2));

        String c="ceva";
        c+=2;
        System.out.println(c);
        c.concat("cccc");
        c+=false;
        System.out.println(c);


       // System.out.println( getSortedOrder("Ana","Mara"));
    }

//    private static int getSortedOrder(String firstName,final String lastName){
//
//        String middleName="Patricia";
//        final String suffix="JR";
//
//        int id=0;

//        switch(firstName){
//            case "Test":
//                return 52;
//            case middleName:
//                id=5;
//                break;
//            case suffix:
//                id=0;
//                break;
//            case lastName:
//                id=8;
//                break;
//            case 5:
//                id=7;
//                break;
//            case 'J':
//                id=0;
//                break;
//        }
//    }
}
