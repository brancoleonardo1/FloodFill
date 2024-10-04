import java.awt.Color;

public class FloodFill {
    private ImagePanel imagePanel;
    private int fillColor = Color.BLUE.getRGB();
    private int borderColor = Color.BLACK.getRGB();

    public FloodFill(ImagePanel imagePanel) {
        this.imagePanel = imagePanel;
    }

    public void fill(int x, int y, boolean useStack) {
        int targetColor = imagePanel.getPixelColor(x, y);
        if (targetColor == fillColor || targetColor == borderColor) return;
        if (useStack) {
            floodFillStack(x, y, targetColor);
        } else {
            floodFillQueue(x, y, targetColor);
        }
    }

    private void floodFillStack(int x, int y, int targetColor) {
        Pilha<int[]> stack = new Pilha<>(100);
        stack.push(new int[]{x, y});

        while (!stack.isEmpty()) {
            int[] point = stack.pop();
            int px = point[0];
            int py = point[1];

            if (imagePanel.isInBounds(px, py)) {
                int currentColor = imagePanel.getPixelColor(px, py);

                if (currentColor == borderColor) {
                    continue;
                }

                if (currentColor == targetColor) {
                    imagePanel.setPixelColor(px, py, fillColor);
                    imagePanel.repaintWithDelay();
                    stack.push(new int[]{px + 1, py});
                    stack.push(new int[]{px - 1, py});
                    stack.push(new int[]{px, py + 1});
                    stack.push(new int[]{px, py - 1});
                }
            }
        }
    }

    private void floodFillQueue(int x, int y, int targetColor) {
        Fila<int[]> queue = new Fila<>(100);
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int px = point[0];
            int py = point[1];

            if (imagePanel.isInBounds(px, py)) {
                int currentColor = imagePanel.getPixelColor(px, py);

                if (currentColor == borderColor) {
                    continue;
                }

                if (currentColor == targetColor) {
                    imagePanel.setPixelColor(px, py, fillColor);
                    imagePanel.repaintWithDelay();

                    queue.add(new int[]{px + 1, py});
                    queue.add(new int[]{px - 1, py});
                    queue.add(new int[]{px, py + 1});
                    queue.add(new int[]{px, py - 1});
                }
            }
        }
    }
}
