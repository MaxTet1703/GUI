import javax.swing.border.Border;
import java.awt.*;

public class RoundedBorder implements Border {
    public int radius;
    public Color color;
    RoundedBorder(int radius, Color color) {
        this.radius = radius;
        this.color = color;
    }
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(color);
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}
