import javax.swing.*;
import java.awt.*;

public class Base extends JPanel {
    Admin admin;
    Menu menu;
    public Base(){
        this.setLayout(null);
        settingNameLabel();
        settingMenuButton();
        settingAdminButton();

    }
    protected JLabel name = new JLabel("Древний Рим");
    protected JButton menu_but = new JButton("Меню");
    protected JButton admin_but = new JButton("Администратор");

    protected void settingNameLabel(){
        this.add(name);
        name.setBounds(30, 30, 100, 25);
        name.setForeground(Color.WHITE);
    }
    protected void settingAdminButton(){
        this.add(admin_but);
        Dimension admin_size = new Dimension(170, 40);
        admin_but.setBounds(450, 20, admin_size.width, admin_size.height);
        admin_but.setForeground(Color.WHITE);
    }
    protected void settingMenuButton(){
        this.add(menu_but);
        Dimension menu_size = new Dimension(130, 40);
        menu_but.setBounds(250, 20, menu_size.width, menu_size.height);
        menu_but.setForeground(Color.WHITE);

    }
    public void paintComponent(Graphics g){
        g.setColor(Color.decode("#DC143C"));
        g.fillRect(0, 0, 800, 80);
    }
}
