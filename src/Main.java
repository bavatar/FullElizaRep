import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> therapistHedges = new ArrayList<String>();
        ArrayList<String> userList = new ArrayList<>();
        ArrayList<String> therapistQualifiers = new ArrayList<>();
        Random rnd = new Random();
        int randomInt = 0;
        String userStmt = "";
        userList.add("my teacher hates me");
        userList.add("I don't know what the problem is");
        userList.add("I feel sad");
        userList.add("I feel hyperactive");
        userList.add("I feel achey");
        userList.add("I have a headache");
        userList.add("I have anxiety");
        userList.add("I am feeling great");

        therapistHedges.add("Please tell me more.");
        therapistHedges.add("Many of my patients tell me the same thing.");
        therapistHedges.add("It is getting late, maybe we had better quit.");
        therapistHedges.add("This session is almost over. We need to schedule another session.");
        therapistHedges.add("When did you first notice this?");
        therapistHedges.add("Do you feel this way often?");
//        therapistHedges.add("");
//        therapistHedges.add("");
//        therapistHedges.add("");
//        therapistHedges.add("");
//        therapistHedges.add("");

        therapistQualifiers.add("Why do you say that ");
        therapistQualifiers.add("You seem to think that ");
        therapistQualifiers.add("So, you are concerned that ");
        therapistQualifiers.add("Do you really believe that ");

        while (true) {
            System.out.println("Good day. What is your problem? Enter your response here or Q to quit:");
            userStmt= sc.nextLine();

            if ((userStmt.equalsIgnoreCase("q")) || (userStmt.toLowerCase().contains("i am feeling great"))){
                System.out.println("Let's schedule another appointment.");
                break;
            }

            userStmt = replaceWords(userStmt.toLowerCase());

            randomInt = rnd.nextInt(therapistQualifiers.size());
            if (randomInt > therapistQualifiers.size()/2) {
                userStmt = therapistQualifiers.get(randomInt) + userStmt + "?";
            } else {
                randomInt = rnd.nextInt(therapistHedges.size());
                userStmt = userStmt + "? " + therapistHedges.get(randomInt);
            }
            System.out.println(userStmt);
        }
    }

    public static String replaceWords(String in){
        String outStr = in + " ";
        outStr=outStr.replaceAll("i ","you ");
        outStr=outStr.replaceAll("me","you ");
        outStr=outStr.replaceAll("my ","your ");
        outStr=outStr.replaceAll("am ","are ");
        //System.out.println("replaceWords output: " + outStr);
        return outStr.trim();
    }
}
