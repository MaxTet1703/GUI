import javax.swing.*;

public class Main {
//    Запуск приложения
    public static void main(String[] args) {
        GUI();
    }
    public static void GUI() {
//        Создание фрэйма и добавление панели со списком позиций меню
        JFrame main = new JFrame("Старый Рим");
        main.setSize(800, 600);
        main.setLocation(500, 250);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);

        Menu menu = new Menu(main);
        main.setContentPane(menu);
    }
}
