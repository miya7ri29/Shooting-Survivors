import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class Bullets {
    private LinkedList<Bullet> bullets; // 弾のリスト
    private Model model;              
    private long lastBulletTime;       // 最後に弾を追加した時間
    private int speed;                 // 弾の速度
    private int damage;                // 弾の攻撃力
    private int rateoffire;            // 弾の発射間隔

  
    Bullets(Model model) {
        bullets = new LinkedList<>();
        this.model = model;
        speed = 1;                 // 初期速度を1に設定
        damage = 50;               // 初期攻撃力を50に設定
        rateoffire = 2000;         // 初期発射間隔を2000に設定
    }

    // 弾を追加するメソッド
    public void add(long currentTime) {
        Bullet bullet = new Bullet(model, speed, damage);
        bullets.add(bullet);
    }

    // 弾を描画するメソッド
    public void drawBullet(Graphics g) {
        for (Bullet b : bullets) {
            g.setColor(Color.GREEN);
            g.fillOval(b.getX(), b.getY(), 10, 10);
        }
    }

    // 弾を移動させるメソッド
    public void move() {
        for (Bullet b : bullets)
            b.move();
    }

    
    public long getLastBulletTime() {
        return lastBulletTime;
    }

   
    public LinkedList<Bullet> getBullets() {
        return bullets;
    }

    
    public int getSpeed() {
        return speed;
    }

   
    public int getDamage() {
        return damage;
    }

    // 弾の発射間隔を取得するメソッド
    public int getRateOfFire() {
        return rateoffire;
    }

    // 弾の攻撃力を2倍にするメソッド
    public void UpDamage() {
        damage *= 2;
    }

    // 弾の発射間隔を500ms減少させるメソッド
    public void UpRateOfFire() {
        rateoffire -= 500;
    }

    // 弾の速度を4倍にするメソッド
    public void UpSpeed() {
        speed *= 4;
    }
}
