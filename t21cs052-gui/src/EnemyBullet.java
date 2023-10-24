public class EnemyBullet {
    private int x;
    private int y;
    private int vx;
    private int vy;
    private int damage;

  
    public EnemyBullet(int startX, int startY, int targetX, int targetY, int speed, int damage) {
        this.x = startX;
        this.y = startY;
        this.damage = damage;

        // ターゲットまでのベクトルを計算
        double dx = (double) targetX - (double) startX;
        double dy = (double) targetY - (double) startY;

        // ベクトルの大きさ（距離）を計算
        double magnitude = Math.sqrt(dx * dx + dy * dy);

        // 正規化された方向ベクトルを計算
        double normalizedDx = dx / magnitude;
        double normalizedDy = dy / magnitude;

        // 正規化された方向ベクトルに速度をかけて移動ベクトルを得る
        this.vx = (int) (normalizedDx * speed);
        this.vy = (int) (normalizedDy * speed);
    }

  
    public int getX() {
        return x;
    }

   
    public int getY() {
        return y;
    }

  
    public int getVX() {
        return vx;
    }

    
    public int getVY() {
        return vy;
    }

   
    public int getDamage() {
        return damage;
    }

    // 弾丸の移動メソッド
    public void move() {
        x += vx;
        y += vy;
    }
}
