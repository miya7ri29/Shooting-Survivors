import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class Character {
    private Model model;
    private int x;
    private int y;

    private int hp;
    private int exp;
    private int level;
    private String lastdirection;
    private boolean isOnBlock;
    private int explosionX;
    private int explosionY;
    private Image hitimage;
    private View view;
    private boolean isExploding = false;
    private long explosionStartTime;
    private static final int EXPLOSION_DURATION = 1000;

   
    public Character(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public Character(Model model) {
        this.model = model;
        this.x = 90;
        this.y = 300;
        this.exp = 0;
        this.hp = 180;
        this.level = 1;
        this.isOnBlock = false;
        this.lastdirection = "RIGHT";
        this.hitimage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("ex1.png"));
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

 
    public int getExp() {
        return exp;
    }

    // キャラクターのHPを減少させるメソッド
    public void reduceHealth(int damage) {
        this.hp -= damage;
        if (hp <= 0) {
            hp = 0;
            try {
                model.setGameOver();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // キャラクターの経験値を加算するメソッド
    public void addExperience(int amount) {
        this.exp += amount;
        int expToNextLevel = level * 100;
        if (exp >= expToNextLevel) {
            level++;
            model.setStrengthen();
        }
    }

    // キャラクターを移動させるメソッド
    public void move(String string) {
        if (string.equals("LEFT")) {
            x -= 20;
            lastdirection = "LEFT";
        }
        if (string.equals("RIGHT")) {
            x += 20;
            lastdirection = "RIGHT";
        }
        if (string.equals("UP") && isOnBlock) {
            y -= 200;
            isOnBlock = false;
        }
        if (string.equals("DOWN"))
            y++;
    }

    // 敵の弾との衝突をチェックするメソッド
    public void checkEnemyBulletCollision(EnemyBullets enemyBullets) {
        LinkedList<EnemyBullet> enemyBulletList = enemyBullets.getEnemyBullets();
        Iterator<EnemyBullet> enemyBulletIterator = enemyBulletList.iterator();

        while (enemyBulletIterator.hasNext()) {
            EnemyBullet enemyBullet = enemyBulletIterator.next();
            int enemyBulletX = enemyBullet.getX();
            int enemyBulletY = enemyBullet.getY();

            if (enemyBulletX >= getX() && enemyBulletX <= getX() + 100 && enemyBulletY >= getY()
                    && enemyBulletY <= getY() + 100) {
                explosionX = enemyBulletX;
                explosionY = enemyBulletY;
                isExploding = true;
                explosionStartTime = System.currentTimeMillis();
                enemyBulletIterator.remove();
            }
        }
    }

    // キャラクターの爆発を描画するメソッド
    public void drawExplosion(Graphics g) {
        if (isExploding) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - explosionStartTime < EXPLOSION_DURATION) {
                g.drawImage(hitimage, explosionX, explosionY, view); // 爆発エフェクトを描画
            } else {
                isExploding = false;
            }
        }
    }

    // 空中にいるかどうかを判定するメソッド
    public void freefall(Blocks blocks) {
        if (y >= 700) {
            try {
                model.setGameOver();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (blocks.isCharacterOnBlock(this)) {
            isOnBlock = true;
        } else {
            isOnBlock = false;
        }
        if (!isOnBlock) {
            y += 10;
        }
    }

    // キャラクターのHPを増加させるメソッド
    public void UpHp() {
        hp += 60;
    }

    // キャラクターがブロックの上にいるかどうかを判定するメソッド
    public boolean isOnBlock(Blocks blocks) {
        return blocks.isCharacterOnBlock(this);
    }

    // キャラクターの最後の移動方向を取得するメソッド
    public String getLastDirection() {
        return lastdirection;
    }

    // 敵の弾との衝突をチェックするメソッド
    public void checkBulletCollision(EnemyBullets enemyBullets) {
        LinkedList<EnemyBullet> bullets = enemyBullets.getEnemyBullets();
        Iterator<EnemyBullet> iterator = bullets.iterator();

        while (iterator.hasNext()) {
            EnemyBullet enemybullet = iterator.next();
            int enemybulletX = enemybullet.getX();
            int enemybulletY = enemybullet.getY();

            if (enemybulletX >= x && enemybulletX <= x + 100 && enemybulletY >= y && enemybulletY <= y + 100) {
                reduceHealth(enemybullet.getDamage());
                iterator.remove();
            }
        }
    }

    // キャラクターのレベルを取得するメソッド
    public int getLevel() {
        return level;
    }


	public static String toString(char keyChar) {
		
		return null;
	}
}
