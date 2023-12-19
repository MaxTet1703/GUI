import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends Base{
    Admin admin;
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
        JTextField name = new JTextField();
        name.setBorder(new RoundedBorder(10, Color.decode("#DC143C")));
        name.setBounds(270, 180, 250, 35);

        JPasswordField password = new JPasswordField();
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
}