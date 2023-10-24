import java.awt.Graphics;

public class Bullet {
    private int x;
    private int y;
    private int vx = 1; // X軸方向の速度
 
    private int damage; // 弾の攻撃力

    
    public Bullet(int x, int y, int vx, int vy, int damage) {
        this.x = x;
        this.y = y;
        this.vx = vx;
     
        this.damage = damage;
    }

   
    public Bullet(Model model, int speed, int damage) {
        this.x = model.getCharacter().getX() + 50;
        this.y = model.getCharacter().getY() + 50;
        vx = speed;
        this.damage = damage;

        // キャラクターの向きに応じて速度を調整
        if (model.getCharacter().getLastDirection().equals("LEFT"))
            vx *= -10;
        else if (model.getCharacter().getLastDirection().equals("RIGHT"))
            vx *= 10;
    }

    // 弾を描画する
    public void drawBullet(Graphics g) {
        g.drawOval(x, y, 10, 10);
    }

    // X座標を取得する
    public int getX() {
        return x;
    }

    // Y座標を取得する
    public int getY() {
        return y;
    }

    // X軸方向の速度を取得する
    public int getVX() {
        return vx;
    }

   

    // 弾の攻撃力を取得する
    public int getDamage() {
        return damage;
    }

    // 弾を移動させる
    public void move() {
        x += vx;
      
    }
}
