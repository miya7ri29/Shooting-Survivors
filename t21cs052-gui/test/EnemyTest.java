import static org.junit.Assert.*;

import org.junit.Test;

public class EnemyTest {

    @Test
    public void 指定された座標を保持しているか確認する() {
        Enemy e = new Enemy(10, 10, -1);
        assertEquals(10, e.getX());
        assertEquals(10, e.getY());
    }

    @Test
    public void 移動することを確認する() {
        Enemy e = new Enemy(10, 10, -1);
        assertEquals(10, e.getX());
        assertEquals(10, e.getY());

        e.move();
        assertEquals(10, e.getX());
        assertEquals(9, e.getY());

        e.move();
        assertEquals(10, e.getX());
        assertEquals(8, e.getY());
    }

    @Test
    public void ダメージを受けることを確認する() {
        Enemy e = new Enemy();
        assertEquals(50, e.getHp());

        e.takeDamage(10);
        assertEquals(40, e.getHp());

        e.takeDamage(20);
        assertEquals(20, e.getHp());
    }

    @Test
    public void ダメージを受けてHPが負の値になる場合に注意する() {
        Enemy e = new Enemy();
        assertEquals(50, e.getHp());

        e.takeDamage(60); // HPが負の値になることを確認する
        assertEquals(-10, e.getHp());
    }

    @Test
    public void HPが設定されることを確認する() {
        Enemy e = new Enemy();
        assertEquals(50, e.getHp());

        e.setHp(30);
        assertEquals(30, e.getHp());

        e.setHp(0);
        assertEquals(0, e.getHp());

        e.setHp(-10); // 負の値も設定できることを確認する
        assertEquals(-10, e.getHp());
    }

    @Test
    public void 経験値報酬が取得できることを確認する() {
        Enemy e = new Enemy();
        assertEquals(25, e.getExpReward());
    }
}
