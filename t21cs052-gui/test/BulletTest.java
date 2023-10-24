import static org.junit.Assert.*;
import org.junit.Test;

public class BulletTest {

    @Test
    public void 弾が与えられた座標を持っているか確認する() {
        Bullet b = new Bullet(10, 10, 1, 0, 1);
        assertEquals(10, b.getX());
        assertEquals(10, b.getY());
    }

    @Test
    public void 弾が移動することを確認する() {
        Bullet b = new Bullet(10, 10, 1, 0, 1);
        assertEquals(10, b.getX());
        assertEquals(10, b.getY());

        b.move();
        assertEquals(11, b.getX());
        assertEquals(10, b.getY());

        b.move();
        assertEquals(12, b.getX());
        assertEquals(10, b.getY());
    }

    @Test
    public void 弾が速さとダメージを保持しているか確認する() {
        Bullet b = new Bullet(10, 10, 2, 1, 5);
        assertEquals(2, b.getVX());
      
        assertEquals(5, b.getDamage());
    }

}