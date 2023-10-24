import static org.junit.Assert.*;

import org.junit.Test;

public class EnemyBulletTest {

    @Test
    public void テスト_EnemyBulletの移動確認() {
        // Create an EnemyBullet with initial position (10, 10) and target position (12, 12) and speed (1)
        EnemyBullet eb = new EnemyBullet(10, 10, 12, 12, 1, 1);
        assertEquals(10, eb.getX());
        assertEquals(10, eb.getY());

        // Move the bullet once
        eb.move();
        assertEquals(11, eb.getX());
        assertEquals(11, eb.getY());

        // Move the bullet again
        eb.move();
        assertEquals(12, eb.getX());
        assertEquals(12, eb.getY());
    }

    @Test
    public void テスト_EnemyBulletの速さとダメージを確認() {
        // Create an EnemyBullet with initial position (10, 10) and target position (20, 20) and speed (2) and damage (50)
        EnemyBullet eb = new EnemyBullet(10, 10, 20, 20, 2, 50);
        assertEquals(10, eb.getX());
        assertEquals(10, eb.getY());
        assertEquals(2, eb.getVX());
        assertEquals(2, eb.getVY());
        assertEquals(50, eb.getDamage());
    }

    @Test
    public void テスト_EnemyBulletの速さが正しく設定されるか確認() {
        // Create an EnemyBullet with initial position (10, 10) and target position (20, 20) and speed (3) and damage (100)
        EnemyBullet eb = new EnemyBullet(10, 10, 20, 20, 3, 100);
        assertEquals(10, eb.getX());
        assertEquals(10, eb.getY());
        assertEquals(1, eb.getVX());
        assertEquals(1, eb.getVY());
    }

    @Test
    public void テスト_EnemyBulletの速さが負の値の場合の確認() {
        // Create an EnemyBullet with initial position (10, 10) and target position (20, 20) and speed (-2) and damage (50)
        EnemyBullet eb = new EnemyBullet(10, 10, 20, 20, -2, 50);
        assertEquals(10, eb.getX());
        assertEquals(10, eb.getY());
        assertEquals(-1, eb.getVX());
        assertEquals(-1, eb.getVY());
    }

}