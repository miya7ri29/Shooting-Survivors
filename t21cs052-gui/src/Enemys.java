import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Iterator;
import java.util.LinkedList;

public class Enemys {
    private Model model;
    private LinkedList<Enemy> enemys; // 敵キャラクターを格納するリスト

    private Image image; // 敵キャラクターの通常時の画像
    private Image hitimage; // 敵キャラクターが被弾した時の画像
    private View view;
    
    private int explosionX; // 爆発エフェクトのX座標
    private int explosionY; // 爆発エフェクトのY座標
    private boolean isExploding = false; // 爆発エフェクトが表示中かを管理するフラグ
    private long explosionStartTime; // 爆発エフェクトの表示開始時間
    private static final int EXPLOSION_DURATION = 1000; // 爆発エフェクトの表示時間（ミリ秒）

 
    Enemys(Model model) {
        this.model = model;
        enemys = new LinkedList<>();

        this.image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("bone_ape.png"));
        this.hitimage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("ex1.png"));
    }

    // 敵キャラクターを追加するメソッド
    public void add(long currentTime) {
        if (enemys.size() <= 7) {
            Enemy e = new Enemy();
            enemys.add(e);
        }
    }

    // 敵キャラクターの移動を行うメソッド
    public void move() {
        for (Enemy e : enemys)
            e.move();
    }

    // プレイヤーの弾丸と敵キャラクターの当たり判定をチェックするメソッド
    public void checkBulletCollision(Bullets bullets) {
        LinkedList<Bullet> bulletList = bullets.getBullets();
        Iterator<Enemy> enemyIterator = enemys.iterator();

        while (enemyIterator.hasNext()) {
            Enemy enemy = enemyIterator.next();
            int enemyX = enemy.getX();
            int enemyY = enemy.getY();
            int enemyWidth = 100; 
            int enemyHeight = 100; 

            Iterator<Bullet> bulletIterator = bulletList.iterator();
            while (bulletIterator.hasNext()) {
                Bullet bullet = bulletIterator.next();
                int bulletX = bullet.getX();
                int bulletY = bullet.getY();

                if (bulletX >= enemyX && bulletX <= enemyX + enemyWidth &&
                    bulletY >= enemyY && bulletY <= enemyY + enemyHeight) {
                    // 当たり判定が発生した場合の処理
                    int currentHealth = enemy.getHp();
                    int damage = bullets.getDamage();
                    int newHealth = currentHealth - damage;
                    if (newHealth <= 0) {
                        // 敵キャラクターのHPが0以下になった場合、敵キャラクターと弾丸をリストから削除し、プレイヤーの経験値を増やす
                        bulletIterator.remove();
                        enemyIterator.remove();
                        model.getCharacter().addExperience(enemy.getExpReward());
                        // 爆発エフェクトの表示位置を設定して爆発フラグをtrueにする
                        explosionX = enemyX;
                        explosionY = enemyY;
                        isExploding = true;
                        explosionStartTime = System.currentTimeMillis();
                    } else {
                        // 敵キャラクターのHPが残っている場合、弾丸をリストから削除する
                        bulletIterator.remove();
                        enemy.setHp(newHealth);
                    }
                }
            }
        }
    }

    // 爆発エフェクトの描写を行うメソッド
    public void drawExplosion(Graphics g) {
        if (isExploding) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - explosionStartTime < EXPLOSION_DURATION) {
                // 爆発エフェクトの描写
                g.drawImage(hitimage, explosionX, explosionY, view);
            } else {
                // 爆発エフェクトの表示時間が経過したら爆発フラグをfalseに戻す
                isExploding = false;
            }
        }
    }

    // 敵キャラクターの描写を行うメソッド
    public void drawEnemy(Graphics g) {
        for (Enemy e : enemys) {
            g.drawImage(image, e.getX(), e.getY(), view);
        }
    }

   
    public LinkedList<Enemy> getEnemys() {
        return enemys;
    }
}
