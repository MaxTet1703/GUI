import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends Admin{
//    Страница входа для администратора
    JTextField name = new JTextField();
    JPasswordField password = new JPasswordField();
    JLabel label = new JLabel("Вход");
    JButton login = new JButton("Войти");
    JLabel wrong = new JLabel("Неверные данные");
    static final String firstQuery = "SELECT * FROM admin WHERE superuser = '%s' AND password = '%s';";
    Login log;

    public Login(JFrame frame) {
        super(frame);
        SettingAdminForm();
        AddAdminForm();
        log = this;
    }

    private void SettingAdminForm(){
//        Настройка внешнего вида формы для входа администратора в административную оболочку
        name.setBorder(new RoundedBorder(10, Color.decode("#DC143C")));
        name.setBounds(270, 180, 250, 35);

        password.setBorder(new RoundedBorder(10, Color.decode("#DC143C")));
        password.setBounds(270, 230, 250, 35);

        label.setBounds(360, 110, 150, 35);
        label.setFont(new Font("seri", Font.ITALIC, 25));


        login.setForeground(Color.WHITE);
        login.setBackground(Color.decode("#DC143C"));
        login.setBorder(null);
        login.setBounds(350, 280, 100, 40);
        login.addActionListener(new AdminLogin());

        wrong.setForeground(Color.RED);
        wrong.setFont(new Font("seri", Font.ITALIC, 18));
        wrong.setBounds(315, 140, 170, 35);

    }
    private void AddAdminForm(){
//        Дабавление компонентов формы в оболочку страницы
        this.add(label);
        this.add(name);
        this.add(password);
        this.add(login);
        this.add(wrong);
        wrong.setVisible(false);
    }
    private void errorResponse(){
//        Сообщение об ошибке, если не найден администратор
        wrong.setVisible(true);
    }
    private class AdminLogin implements ActionListener{
//        Прослушка события отправления данных на бд
        @Override
        public void actionPerformed(ActionEvent e){
//            Обработка информации с формы и проверка, есть ли администратор с полученными данными
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
                    log.setVisible(false);
                    frame.getContentPane().removeAll();
                    frame.setContentPane(new ChangeMenu(frame));
                    frame.invalidate();
                    frame.validate();
                }else{
                    errorResponse();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }


}
