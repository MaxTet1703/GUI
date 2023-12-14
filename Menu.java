import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Menu extends Base{
    Menu menu;
    public Menu(){
        super();
        menu = this;
    }

    @Override
    protected void settingMenuButton() {
        super.settingMenuButton();
        menu_but.setBorder(new RoundedBorder(10));
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

    private class SwitchToAdmin implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = (JFrame) SwingUtilities.windowForComponent(menu);
            frame.setContentPane(new Admin());
            frame.invalidate();
            frame.validate();

        }
    }
}