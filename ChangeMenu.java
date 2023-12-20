import javax.swing.*;
import java.awt.*;

public class ChangeMenu extends Admin{
    JLabel label = new JLabel("Добавить позицию");
    JTextField name = new JTextField();
    JTextArea description = new JTextArea();
    JButton openPhoto = new JButton("Выбрать изображение");
    JButton submit = new JButton("Сохранить");
    static final String firstQuery = "INSERT INTO item VALUES (%d, '%s', '%s', '%s');";
    public ChangeMenu(JFrame frame) {
        super(frame);
        SettingAddForm();
        addForm();
    }
    private void SettingAddForm(){
        label.setFont(new Font("seri", Font.ITALIC, 20));
        label.setBounds(300, 90, 320, 55);

        name.setBounds(210, 140, 220, 40);

        description.setBounds(210, 190, 350, 200);

        openPhoto.setBounds(210, 420, 200, 35);
        openPhoto.setForeground(Color.WHITE);
        openPhoto.setBackground(Color.decode("#DC143C"));

        submit.setBounds(300, 480, 200, 35);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.decode("#DC143C"));


    }
    private void addForm(){
        this.add(label);
        this.add(name);
        this.add(description);
        this.add(openPhoto);
        this.add(submit);
    }
}
