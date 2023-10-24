import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public abstract class TextDisplayState implements State {
    protected Model model;
    protected String[] textLines;
    protected Font font;

    public TextDisplayState(Model model, String[] textLines, Font font) {
        this.model = model;
        this.textLines = textLines;
        this.font = font;
    }

    @Override
    public State processTimeElapsed(int msec) {
        return null;
    }

    @Override
    public State processMousePressed(int x, int y) {
        return null;
    }

    @Override
    public abstract State processKeyTyped(String typed);

    @Override
    public void paintComponent(Graphics g) {
        int x = 100;
        int y = 100;
        int lineHeight = 50;
        Color textColor = Color.BLACK;
        for (String text : textLines) {
            drawText(g, text, textColor, font, x, y);
            y += lineHeight;
        }
    }

    private void drawText(Graphics g, String text, Color color, Font font, int x, int y) {
        g.setFont(font);
        g.setColor(color);
        g.drawString(text, x, y);
    }
}