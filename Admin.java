import org.postgresql.gss.GSSOutputStream;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;

public class Admin extends Base{
    Admin admin;
    JTextField name = new JTextField();
    JPasswordField password = new JPasswordField();
    static final String firstQuery = "SELECT * FROM admin WHERE superuser = '%s' AND password = '%s';";
    public Admin(JFrame frame){
        super(frame);
        admin = this;
        createForm();
    }

    @Override
    protected void settingMenuButton(){
        super.settingAdminButton();
        menu_but.setBackground(Color.decode("#DC143C"));
        menu_but.setBorder(null);
        menu_but.addActionListener(new SwitchToMenu());
    }
    @Override
    protected void settingAdminButton() {
        super.settingMenuButton();
        admin_but.setBorder(new RoundedBorder(10, Color.decode("#FFFFFF")));

        admin_but.setForeground(Color.WHITE);
        admin_but.setBackground(Color.decode("#DC143C"));

    }

    private void createForm(){
        name.setBorder(new RoundedBorder(10, Color.decode("#DC143C")));
        name.setBounds(270, 180, 250, 35);

        password.setBorder(new RoundedBorder(10, Color.decode("#DC143C")));
        password.setBounds(270, 230, 250, 35);

        JLabel label = new JLabel("Вход");
        label.setBounds(360, 130, 150, 35);
        label.setFont(new Font("seri", Font.ITALIC, 25));

        JButton login = new JButton("Войти");
        login.setForeground(Color.WHITE);
        login.setBackground(Color.decode("#DC143C"));
        login.setBorder(null);
        login.setBounds(350, 280, 100, 40);
        login.addActionListener(new AdminLogin());
        this.add(label);
        this.add(name);
        this.add(password);
        this.add(login);

    }
    private class SwitchToMenu implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            admin.setVisible(false);
            frame.getContentPane().removeAll();
            frame.setContentPane(new Menu(frame));
            frame.invalidate();
            frame.validate();

        }
    }
    private class AdminLogin implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String name_value = name.getText();
            String password_value = password.getText();
            if (name_value.isEmpty()){
                name_value = "null";

            }
            if (password_value.isEmpty()){
                password_value = "null";
            }
            String full_query = String.format(firstQuery, name_value, password_value);
            ResultSet rs = getData(full_query);

            try {
                if(rs.next()){
                    System.out.println("Есть такой");
                }else{
                    System.out.println("Нет такого");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}