import static org.junit.Assert.*;
import org.junit.Test;

public class BulletsTest {

    @Test
    public void 弾を追加するテスト() {
        Model model = new Model();
        Bullets bullets = new Bullets(model);

        // 弾を追加する前はリストが空であることを確認
        assertEquals(0, bullets.getBullets().size());

        // 弾を追加するとリストのサイズが1増えることを確認
        bullets.add(System.currentTimeMillis());
        assertEquals(1, bullets.getBullets().size());
    }

    @Test
    public void 弾を移動させるテスト() {
        Model model = new Model();
        Bullets bullets = new Bullets(model);

        // 初期座標 (10, 10) の弾を追加
        Bullet bullet = new Bullet(10, 10, 1, 0, 1);
        bullets.getBullets().add(bullet);

        // 弾を移動させる前の座標を記録
        int initialX = bullet.getX();
      

        // 弾を移動させる
        bullets.move();

        // 弾が移動したことを確認
        assertEquals(initialX + bullet.getVX(), bullet.getX());
    }

    @Test
    public void 弾の速さを上げるテスト() {
        Model model = new Model();
        Bullets bullets = new Bullets(model);

        int initialSpeed = bullets.getSpeed();

        // 速さを上げるメソッドを呼び出す
        bullets.UpSpeed();

        // 速さが上がっていることを確認
        assertEquals(initialSpeed * 4, bullets.getSpeed());
    }

    @Test
    public void 弾のダメージを上げるテスト() {
        Model model = new Model();
        Bullets bullets = new Bullets(model);

        int initialDamage = bullets.getDamage();

        // ダメージを上げるメソッドを呼び出す
        bullets.UpDamage();

        // ダメージが上がっていることを確認
        assertEquals(initialDamage * 2, bullets.getDamage());
    }

    @Test
    public void 弾の発射間隔を短くするテスト() {
        Model model = new Model();
        Bullets bullets = new Bullets(model);

        int initialRateOfFire = bullets.getRateOfFire();

        // 発射間隔を短くするメソッドを呼び出す
        bullets.UpRateOfFire();

        // 発射間隔が短くなっていることを確認
        assertEquals(initialRateOfFire - 500, bullets.getRateOfFire());
    }
}