import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

abstract class Admin extends Base{
//    Абстрактный класс, описывающий компоненты для оболочки администратора
    Admin admin;
    static final String firstQuery = "SELECT * FROM admin WHERE superuser = '%s' AND password = '%s';";
    public Admin(JFrame frame){
        super(frame);
        admin = this;
    }
    @Override
    protected void settingAdminButton() {
//        Стилизация кнопки "Администратор" для оболочки администраторы
        super.settingMenuButton();
        admin_but.setBorder(new RoundedBorder(10, Color.decode("#FFFFFF")));

        admin_but.setForeground(Color.WHITE);
        admin_but.setBackground(Color.decode("#DC143C"));


    }
    @Override
    protected void settingMenuButton(){
//        Стилизация кнопки "Меню" для оболочки администратора
        super.settingAdminButton();
        menu_but.setBackground(Color.decode("#DC143C"));
        menu_but.setBorder(null);
        menu_but.addActionListener(new SwitchToMenu());
    }
    private class SwitchToMenu implements ActionListener {
//        Прослушка кнопки "Меню, чтобы перейти на старницу с меню блюд"
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