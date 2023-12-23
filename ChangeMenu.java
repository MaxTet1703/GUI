import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChangeMenu extends Admin{
    String type_image[] = {".jpg", ".jpeg", ".png"};
    String absolutePath = System.getProperty("user.dir").concat("/media/");
    JLabel label = new JLabel("Добавить позицию");
    JLabel select = new JLabel();
    JTextField name = new JTextField();
    JTextArea description = new JTextArea();
    JButton openPhoto = new JButton("Выбрать изображение");
    JButton submit = new JButton("Сохранить");
    JLabel wrong = new JLabel("");
    static final String firstQuery = "INSERT INTO item VALUES (%s, '%s', '%s', '%s');";
    static final String secondQuery = "SELECT COUNT(*) FROM item";
    String imagePath = "";
    String name_input = "";
    String descr = "";
    String id = "";
    public ChangeMenu(JFrame frame) {
        super(frame);
        SettingAddForm();
        addForm();
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

    }
    private void AddPosition(){
        wrong.setVisible(false);
        this.remove(wrong);

        name_input = name.getText();
        descr = description.getText();
        System.out.println(descr);
        if (name_input.isEmpty() || descr.isEmpty() || imagePath.isEmpty()){
            wrong.setText("Заполните всю форму");
            this.add(wrong);
            return;
        }
        File image = new File(imagePath);
        boolean is_correct = false;
        for(String el: type_image){
            if (image.getName().endsWith(el)){
                is_correct = true;
                break;
            }
        }
        if (!is_correct){
            wrong.setText("Неверный формат фотографии");
            this.add(wrong);
            return;
        }

        image.renameTo(new File(absolutePath, image.getName()));
        imagePath = "media/".concat(image.getName());

        ResultSet rs = getData(secondQuery);
        try{
            rs.next();
            int count = rs.getInt(1);
            count ++;
            id = Integer.toString(count);
        }catch (SQLException e){
            e.printStackTrace();
        }
        String resultQuery = String.format(firstQuery, id, name_input, descr, imagePath);

       try{
           SqlConnection connect = new SqlConnection();
           connect.InsertData(resultQuery);
           wrong.setForeground(Color.GREEN);
           this.add(wrong);
       }catch(SQLException e){
           wrong.setText("Ошибка сервера");
           this.add(wrong);
           return;
       }

       imagePath = "";
       name_input = "";
       imagePath = "";
       id = "";

    }

    private class SubmitData implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            AddPosition();
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
