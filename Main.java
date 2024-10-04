import java.io.IOException;
import javax.swing.JFrame;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String imagePath = "imagem1.png";
        ClassLoader classLoader = Main.class.getClassLoader();
        URL imageUrl = classLoader.getResource(imagePath);

        if (imageUrl == null) {
            System.err.println("Imagem não encontrada: " + imagePath);
            return;
        }

        ImagePanel imagePanel = new ImagePanel(imageUrl.getPath());

        JFrame frame = new JFrame("Flood Fill com bordas");
        frame.add(imagePanel);
        frame.setSize(imagePanel.getImageWidth(), imagePanel.getImageHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        boolean useStack = false;
        System.out.println("Escolha: 1 para Pilha, 2 para Fila");
        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();
        if (escolha == 1) {
            useStack = true;
        }

        int startX = 500;
        int startY = 350;

        FloodFill floodFill = new FloodFill(imagePanel);
        floodFill.fill(startX, startY, useStack);
    }
}
