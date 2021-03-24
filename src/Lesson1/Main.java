package Lesson1;

public class Main {
    public static void main(String[] args) {


        Participant[] participants = {
                new Cat(20, 10,"Мурзик"),
                new Human(20, 1, "Иван"),
                new Robot(25, 2, "Бишоп")};
        Action[] actions = {
                new Road(20, "беговую дорожку"),
                new Wall(10, "барьер")};



        for (int i = 0; i < participants.length; i++){
            for (int j = 0; j < actions.length; j++){
               if (actions[j].check(participants [i])) {
                    System.out.println(participants[i].getName() + " прошел " +  actions[j].getName());
                }
               else {
                   System.out.println(participants[i].getName() + " не проходит дальше.");
                   break;
               }
            }

        }


    }

}
