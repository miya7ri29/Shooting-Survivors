import java.util.Random;

public class Enemy {
    private int x;
    private int y;
    private int vy; // Y軸方向の速度
    private int hp; // ヒットポイント（体力）
    private int expReward; // 倒された時にプレイヤーに与える経験値の報酬

   
    public Enemy() {
        this.x = randomx();
        this.y = randomy();
        this.vy = 5;
        this.hp = 100;
        this.expReward = 25;
    }

    
    public Enemy(int x, int y, int vy) {
        this.x = x;
        this.y = y;
        this.vy = vy;
    }

    // Y座標をランダムに決定するメソッド
    private int randomy() {
        Random random = new Random(System.currentTimeMillis());
        return random.nextInt(700);
    }

    // X座標をランダムに決定するメソッド
    private int randomx() {
        Random random = new Random(System.currentTimeMillis());

        int n = random.nextInt(10) - 5;
        if (n >= 0)
            return 1100;
        else
            return 0;
    }

  
    public int getX() {
        return x;
    }

  
    public int getY() {
        return y;
    }

   
    public int getHp() {
        return hp;
    }

  
    public int getExpReward() {
        return expReward;
    }

    // 敵の移動メソッド
    public void move() {
        y += vy;
        if (y >= 700)
            vy *= -1;
        if (y <= 0)
            vy *= -1;
    }

    // 敵がダメージを受けるメソッド
    public void takeDamage(int damage) {
        hp -= damage;
    }

    // ヒットポイントをセットするメソッド
    public void setHp(int newhp) {
        this.hp = newhp;
    }
}

