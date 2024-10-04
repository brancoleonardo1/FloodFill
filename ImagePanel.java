import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
    private BufferedImage image;
    private int delay = 10;

    public ImagePanel(String imagePath) throws IOException {
        image = ImageIO.read(new File(imagePath));
    }

    public int getImageWidth() {
        return image.getWidth();
    }

    public int getImageHeight() {
        return image.getHeight();
    }

    public int getPixelColor(int x, int y) {
        return image.getRGB(x, y);
    }

    public void setPixelColor(int x, int y, int color) {
        image.setRGB(x, y, color);
    }

    public boolean isInBounds(int x, int y) {
        return x >= 0 && x < image.getWidth() && y >= 0 && y < image.getHeight();
    }

    public void repaintWithDelay() {
        repaint();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
}
