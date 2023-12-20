import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Menu extends Base{
    Menu menu;
    static final String firstQuery = "SELECT photourl FROM item";
    static final String secondQuery = "SELECT name, description FROM item";
    public Menu(JFrame frame){
        super(frame);
        menu = this;

    }

    @Override
    protected void settingMenuButton() {
        super.settingMenuButton();
        menu_but.setBorder(new RoundedBorder(10, Color.decode("#FFFFFF")));
        menu_but.setForeground(Color.WHITE);
        menu_but.setBackground(Color.decode("#DC143C"));
    }
    @Override
    protected void settingAdminButton(){
        super.settingAdminButton();
        admin_but.setBackground(Color.decode("#DC143C"));
        admin_but.setBorder(null);
        admin_but.addActionListener(new SwitchToAdmin());

    }

    private void setTextForMenu(){
        ResultSet rs = getData(secondQuery);
        int x_label = 250;
        int x_description = 400;
        int y = 120;
        try{
            while(rs.next()){
                JLabel label = new JLabel(rs.getString(1));
                label.setBounds(x_label, y+60, 100, 30);

                JTextArea description = new JTextArea(rs.getString(2).replaceAll("\\\\n", "\n"));
                description.setColumns(10);
                description.setRows(15);
                description.setBackground(null);
                description.setBounds(x_description, y+40, 350, 150);

                this.add(label);
                this.add(description);
                y += 220;

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int x_image = 20;
        int y = 120;
        ResultSet rs = getData(firstQuery);
        try{
            while(rs.next()){
                BufferedImage bufferedImage = ImageIO.read(new File(rs.getString(1)));
                Image image = bufferedImage.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
                Image img = new ImageIcon(image).getImage();
                g.drawImage(img, x_image, y, this);
                y += 220;
            }

        }catch(SQLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setTextForMenu();
    }
    private class SwitchToAdmin implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            menu.setVisible(false);
            frame.getContentPane().removeAll();
            frame.setContentPane(new Login(frame));
            frame.invalidate();
            frame.validate();

        }
    }
}