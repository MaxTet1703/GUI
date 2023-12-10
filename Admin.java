import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends Base{

    public Admin(){
        super();
        admin = this;
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
        admin_but.setBorder(new RoundedBorder(10));
        admin_but.setForeground(Color.WHITE);
        admin_but.setBackground(Color.decode("#DC143C"));

    }
    private class SwitchToMenu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = (JFrame) SwingUtilities.windowForComponent(admin);
            frame.setContentPane(menu);
            frame.invalidate();
            frame.validate();

        }
    }
}