import java.awt.Graphics;
import java.io.IOException;

public class Model {

	private View view;
	private Controller controller;
	private State state;
	
	private Character character;
	private Block block;
	private Blocks blocks;
	private Bullet bullet;
	private Bullets bullets;
	private long lastTime;
	private Enemy enemy;
	private Enemys enemys;
	private EnemyBullet enemybullet;
	private EnemyBullets enemybullets;
	private int time;
	private String typedChar = "";
	private int mx, my;
	private boolean enableKeyRollover = false;
	private FileHandler ranking;

	public Model() {
		view = new View(this);
		controller = new Controller(this);
		state = new StartState(this);

		character = new Character(this);
		blocks = new Blocks();
		//bullet = new Bullet(this);
		bullets = new Bullets(this);
		lastTime = 0;
		enemy = new Enemy();
		enemys = new Enemys(this);

		enemybullets = new EnemyBullets(this);
		ranking = new FileHandler("ranking.txt");

	}

	public synchronized void processTimeElapsed(int msec) {

		long currentTime = System.currentTimeMillis();
		if (currentTime - lastTime >= msec) {
			state.processTimeElapsed(msec);
			lastTime = currentTime;
			view.repaint();
		}
	}

	public synchronized void paintComponent(Graphics g) {
		state.paintComponent(g);
		view.repaint();
	}

	public synchronized void processKeyTyped(String typed) {
		state.processKeyTyped(typed);

		view.repaint();
	}

	public synchronized void processMousePressed(int x, int y) {
		mx = x;
		my = y;
		view.playBombSound();
		view.repaint();
	}

	public void start() {
		controller.start();
	}

	public View getView() {
		return view;
	}

	public Controller getController() {
		return controller;
	}

	public int getTime() {
		return time;
	}

	public String getTypedChar() {
		return typedChar;
	}

	public int getMX() {
		return mx;
	}

	public int getMY() {
		return my;
	}

	public boolean getEnableKeyRollover() {
		return enableKeyRollover;
	}

	public State getState() {

		return state;
	}

	public Character getCharacter() {
		return character;
	}

	public Block getBlock() {
		return block;
	}

	public Blocks getBlocks() {
		return blocks;
	}

	public Bullet getBullet() {

		return bullet;
	}

	public Bullets getBullets() {
		return bullets;
	}

	public Enemy getEnemy() {
		return enemy;
	}

	public Enemys getEnemys() {
		return enemys;

	}

	public EnemyBullet getEnemyBullet() {
		return enemybullet;

	}

	public EnemyBullets getEnemyBullets() {
		return enemybullets;
	}

	public FileHandler getRanking() {
		return ranking;
	}

	public void setGameOver() throws IOException {

		state = new GameOverState(this, ranking.getRanking());

	}
	
	public void setStart() {
		state = new StartState(this);
	}

	public void setStrengthen() {
		state = new StrengthenCharacter(this);
	}

	public void setGamePlaying() {
		state = new PlayingState(this);
	}

	public void setHowtoPlay() {
		state = new HowtoPlay(this);

	}

	public void setComingBoss() {
		state = new ComingBossState(this);
	}
	
	public void setGameClear() {
		state = new GameClear(this);
	}

	public void setCharacter(Character character2) {
		// TODO 自動生成されたメソッド・スタブ
		character = character2;
	}
	
	
	
	
	
	
}
