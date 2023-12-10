import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GUI();
    }
    private static void GUI() {
        JFrame main = new JFrame("Старый Рим");
        main.setSize(800, 500);
        main.setLocation(500, 250);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        main.setVisible(true);

        Admin admin = new Admin();
        Menu menu = new Menu();

        menu.admin = admin;
        admin.menu = menu;



        main.getContentPane().add(menu);









    }
}
