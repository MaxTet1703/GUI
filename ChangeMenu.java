import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ChangeMenu extends Admin{
    String absolutePath = getClass().getProtectionDomain().getCodeSource().getLocation().getPath().concat("media/");
    JLabel label = new JLabel("Добавить позицию");
    JLabel select = new JLabel();
    JTextField name = new JTextField();
    JTextArea description = new JTextArea();
    JButton openPhoto = new JButton("Выбрать изображение");
    JButton submit = new JButton("Сохранить");
    JLabel wrong = new JLabel("Неверно заполнены данные");
    static final String firstQuery = "INSERT INTO item VALUES (%d, '%s', '%s', '%s');";
    static final String secondQuery = "SELECT COUNT(*) FROM item";
    String imagePath;
    String name_input;
    String descr;
    public ChangeMenu(JFrame frame) {
        super(frame);
        SettingAddForm();
        addForm();
        System.out.println(absolutePath);
    }
    private void SettingAddForm(){
        label.setFont(new Font("seri", Font.ITALIC, 22));
        label.setBounds(300, 90, 320, 45);

        wrong.setBounds(300, 130, 200, 30);
        wrong.setForeground(Color.decode("#DC143C"));

        name.setBounds(210, 170, 220, 40);

        description.setBounds(210, 220, 350, 200);

        openPhoto.setBounds(210, 420, 200, 35);
        openPhoto.setForeground(Color.WHITE);
        openPhoto.setBackground(Color.decode("#DC143C"));
        openPhoto.addActionListener(new ChooseImage());

        select.setBounds(500, 425, 300, 30);

        submit.setBounds(300, 475, 200, 35);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.decode("#DC143C"));
        submit.addActionListener(new SubmitData());
    }
    private void addForm(){
        this.add(label);
        this.add(name);
        this.add(description);
        this.add(openPhoto);
        this.add(submit);
        this.add(select);
        this.add(wrong);
        wrong.setVisible(false);
    }

    private class SubmitData implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            name_input = name.getText();
            descr = description.getText();
            if (name_input.isEmpty() || descr.isEmpty() || imagePath.isEmpty()){
                wrong.setVisible(true);
                return;
            }
            File image = new File(imagePath);
            try {
                Path temp = Files.move(Paths.get(imagePath), Paths.get(absolutePath.concat(image.getName())));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    private class ChooseImage implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            JFileChooser fc = new JFileChooser();
            int r = fc.showSaveDialog(null);
            if(r == JFileChooser.APPROVE_OPTION){
                select.setText(null);
                select.setText(fc.getSelectedFile().getAbsolutePath());
                imagePath = select.getText();
            }
        }
    }
}
