import java.awt.Graphics;

public interface State {
public State processTimeElapsed(int msec);
public State processKeyTyped(String typed);
public State processMousePressed(int x, int y);
public void paintComponent(Graphics g);


}
