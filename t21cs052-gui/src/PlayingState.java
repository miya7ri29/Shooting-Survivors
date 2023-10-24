
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class PlayingState implements State {
    private Model model;
    private Image image;
    private View view;
    private long lastBulletTime;
    private long lastEnemyAddTime;
    private long lastEnemyBulletTime;
    private long startTime;

   
    public PlayingState(Model m) {
        model = m;
        lastBulletTime = 0;
        lastEnemyAddTime = 0;
        startTime = System.currentTimeMillis();
        image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("scissors.png"));
    }

    @Override
    public State processTimeElapsed(int msec) {
        // 経過時間の処理
        long currentTime = System.currentTimeMillis();
        // 60秒経過したらゲームクリアの状態に遷移
        if (currentTime - startTime >= 60000) {
            model.setGameClear();
        }

        // 弾の発射間隔を管理して弾を追加する
        if (currentTime - lastBulletTime >= model.getBullets().getRateOfFire()) {
            model.getBullets().add(currentTime);
            lastBulletTime = currentTime;
        }

        // 敵キャラクターの追加間隔を管理して敵キャラクターを追加する
        if (currentTime - lastEnemyAddTime >= 5000) {
            model.getEnemys().add(currentTime);
            lastEnemyAddTime = currentTime;
        }

        // 敵キャラクターの弾丸の発射間隔を管理して弾丸を追加する
        if (currentTime - lastEnemyBulletTime >= 7000) {
            model.getEnemyBullets().add(currentTime);
            lastEnemyBulletTime = currentTime;
        }

        // 敵キャラクターと弾丸の移動を行う
        model.getEnemys().move();
        model.getCharacter().freefall(model.getBlocks());
        model.getBullets().move();
        model.getEnemyBullets().move();

        // 衝突判定を行い、ダメージを受けた場合の処理を行う
        model.getCharacter().checkBulletCollision(model.getEnemyBullets());
        model.getEnemys().checkBulletCollision(model.getBullets());

        return null;
    }

    @Override
    public State processKeyTyped(String typed) {
        // キー入力による操作を行う
        if (typed.equals("ESC"))
            model.setComingBoss();
        model.getCharacter().move(typed);
        return null;
    }

    @Override
    public State processMousePressed(int x, int y) {
      
        return null;
    }

   
    public void paintComponent(Graphics g) {
        // プレイヤーのHPと経験値を表示
        g.setColor(Color.black);
        Font font = new Font("Arial", Font.BOLD, 20);
        g.setFont(font);
        g.drawString("HP " + model.getCharacter().getHp(), 10, 20);
        g.drawString("EXP " + model.getCharacter().getExp(), 10, 40);

        // ブロック、プレイヤー、敵キャラクター、弾丸、爆発エフェクトの描写
        model.getBlocks().drawBlock(g);
        g.setColor(Color.BLUE);
        g.drawImage(image, model.getCharacter().getX(), model.getCharacter().getY(), view);
        model.getBullets().drawBullet(g);
        model.getEnemys().drawEnemy(g);
        model.getEnemyBullets().drawBullet(g);
        model.getEnemys().drawExplosion(g);
        model.getCharacter().drawExplosion(g);
    }
}