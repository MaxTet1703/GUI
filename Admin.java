import org.postgresql.gss.GSSOutputStream;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;

abstract class Admin extends Base{
    Admin admin;
    static final String firstQuery = "SELECT * FROM admin WHERE superuser = '%s' AND password = '%s';";
    public Admin(JFrame frame){
        super(frame);
        admin = this;
    }
    @Override
    protected void settingAdminButton() {
        super.settingMenuButton();
        admin_but.setBorder(new RoundedBorder(10, Color.decode("#FFFFFF")));

        admin_but.setForeground(Color.WHITE);
        admin_but.setBackground(Color.decode("#DC143C"));


    }
    @Override
    protected void settingMenuButton(){
        super.settingAdminButton();
        menu_but.setBackground(Color.decode("#DC143C"));
        menu_but.setBorder(null);
        menu_but.addActionListener(new SwitchToMenu());
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