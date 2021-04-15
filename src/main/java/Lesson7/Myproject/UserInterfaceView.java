package Lesson7.Myproject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInterfaceView {
    Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите название города");
            String city = scanner.nextLine();

            System.out.println("Введите 1 для получения текущей погоды, " +
                    "Введите 2 для получения прогноза погоды на 5 дней" + " " +
                    "Введите 3 для получения информации из базы данных" );
            String command = scanner.nextLine();
            try {
                controller.getWeather(command, city);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
                continue;
            }
            break;
        }
    }

    public void checkUserInput(String userInput) {
        //TODO: задание со звездочкой - обработать ввод пользователя (выбросить эксепш и прервать выполнение, либо предложить
        // пользователю попробовать снова)
    }
}
