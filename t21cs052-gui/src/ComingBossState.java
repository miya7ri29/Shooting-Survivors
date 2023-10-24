import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class ComingBossState implements State {
	private Image image;
	private View view;
	private Model model;

	public ComingBossState(Model model) {
		this.model = model;
		image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("boss.png"));
	}

	@Override
	public State processTimeElapsed(int msec) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public State processKeyTyped(String typed) {
		// TODO 自動生成されたメソッド・スタブ
		if(typed.equals("ENTER"))
			model.setGamePlaying();
		return null;
	}

	@Override
	public State processMousePressed(int x, int y) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, view);
	}

}
