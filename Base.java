import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

abstract class Base extends JPanel {
//    Абстрактный класс, описывающий общее поведения для всех страниц приложения
    JFrame frame;
    public Base(JFrame frame){
        this.setLayout(null);
        this.frame = frame;
        settingNameLabel();
        settingMenuButton();
        settingAdminButton();
    }
    protected JLabel name = new JLabel("Древний Рим");
    protected JButton menu_but = new JButton("Меню");
    protected JButton admin_but = new JButton("Администратор");


    protected void settingNameLabel(){
//        Стилизация надписи "Древний Рим"
        this.add(name);
        name.setBounds(30, 30, 100, 25);
        name.setForeground(Color.WHITE);
    }
    protected void settingAdminButton(){
//        базовая стилизация кнопки "Администратор"
        this.add(admin_but);
        Dimension admin_size = new Dimension(170, 40);
        admin_but.setBounds(450, 20, admin_size.width, admin_size.height);
        admin_but.setForeground(Color.WHITE);
    }
    protected void settingMenuButton(){
//        Базовая стилизация кнопки "Меню"
        this.add(menu_but);
        Dimension menu_size = new Dimension(130, 40);
        menu_but.setBounds(250, 20, menu_size.width, menu_size.height);
        menu_but.setForeground(Color.WHITE);

    }
    protected ResultSet getData(String query){
//        Получение данных при помощи SQL
        SqlConnection sqlConn = new SqlConnection();
        ResultSet rs = sqlConn.getData(query);
        return rs;
    }
    public void paintComponent(Graphics g){
//        background для панели меню
        g.setColor(Color.decode("#DC143C"));
        g.fillRect(0, 0, 800, 80);
    }

}
