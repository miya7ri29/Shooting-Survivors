import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class EnemyBullets {
    private LinkedList<EnemyBullet> enemybullets; // 敵の弾丸を格納するリスト

    private Model model;
    private long lastEnemyBulletTime; // 最後に敵の弾丸が発射された時間

    // コンストラクタ
    EnemyBullets(Model model) {
        enemybullets = new LinkedList<>();
        this.model = model;
    }

    // 敵の弾丸を追加するメソッド
    public void add(long currentTime) {
        LinkedList<Enemy> enemys = model.getEnemys().getEnemys();

        // 各敵キャラクターごとに弾丸を生成してリストに追加
        for (Enemy e : enemys) {
            EnemyBullet eb = new EnemyBullet(e.getX() + 50, e.getY() + 50, model.getCharacter().getX(),
                    model.getCharacter().getY(), 20, 30);
            enemybullets.add(eb);
        }
    }

    // 敵の弾丸を描画するメソッド
    public void drawBullet(Graphics g) {
        for (EnemyBullet eb : enemybullets) {
            g.setColor(Color.DARK_GRAY);
            g.fillOval(eb.getX(), eb.getY(), 10, 10);
        }
    }

    // 敵の弾丸を移動するメソッド
    public void move() {
        for (EnemyBullet eb : enemybullets)
            eb.move();
    }

   
    public long getLastBulletTime() {
        return lastEnemyBulletTime;
    }

  
    public LinkedList<EnemyBullet> getEnemyBullets() {
        return enemybullets;
    }
}
