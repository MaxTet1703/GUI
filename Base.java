import javax.swing.*;
import java.awt.*;

public class Base extends JPanel {
    public Base(){
        this.setLayout(null);
        this.add(name);
        this.add(menu_but);
        this.add(admin_but);

        name.setBounds(30, 20, 100, 25);
        name.setForeground(Color.WHITE);

        menu_but.setBounds(250, 20, menu_size.width, menu_size.height);

        admin_but.setBounds(450, 20, admin_size.width, admin_size.height);

    }
    Dimension menu_size = new Dimension(130, 25);
    Dimension admin_size = new Dimension(150, 25);
    protected JLabel name = new JLabel("Древний Рим");
    protected JButton menu_but = new JButton("Меню");
    protected JButton admin_but = new JButton("Администратор");

    public void paintComponent(Graphics g){
        g.setColor(Color.decode("#DC143C"));
        g.fillRect(0, 0, 800, 70);
    }
}
