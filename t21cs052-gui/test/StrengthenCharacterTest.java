import static org.junit.Assert.*;
import org.junit.Test;

public class StrengthenCharacterTest {

    @Test
    public void 弾の攻撃力が正しくアップデートされるかを確認するテスト() {
        Model model = new Model();
        StrengthenCharacter strengthenCharacter = new StrengthenCharacter(model);

        // 弾の初期攻撃力を確認
        int initialDamage = model.getBullets().getDamage();

        // "ALT"キー入力で弾の攻撃力をアップデート
        strengthenCharacter.processKeyTyped("ALT");

        // 弾の攻撃力がアップデートされているかを確認
        assertTrue(model.getBullets().getDamage() > initialDamage);
    }

    @Test
    public void 弾の連射速度が正しくアップデートされるかを確認するテスト() {
        Model model = new Model();
        StrengthenCharacter strengthenCharacter = new StrengthenCharacter(model);

        // 弾の初期連射速度を確認
        int initialRateOfFire = model.getBullets().getRateOfFire();

        // "SHIFT"キー入力で弾の連射速度をアップデート
        strengthenCharacter.processKeyTyped("SHIFT");

        // 弾の連射速度がアップデートされているかを確認
        assertTrue(model.getBullets().getRateOfFire() < initialRateOfFire);
    }

    @Test
    public void 弾の速度が正しくアップデートされるかを確認するテスト() {
        Model model = new Model();
        StrengthenCharacter strengthenCharacter = new StrengthenCharacter(model);

        // 弾の初期速度を確認
        int initialSpeed = model.getBullets().getSpeed();

        // "CTRL"キー入力で弾の速度をアップデート
        strengthenCharacter.processKeyTyped("CTRL");

        // 弾の速度がアップデートされているかを確認
        assertTrue(model.getBullets().getSpeed() > initialSpeed);
    }

    @Test
    public void キャラクターの体力が正しくアップデートされるかを確認するテスト() {
        Model model = new Model();
        StrengthenCharacter strengthenCharacter = new StrengthenCharacter(model);

        // キャラクターの初期体力を確認
        int initialHp = model.getCharacter().getHp();

        // "ESC"キー入力でキャラクターの体力をアップデート
        strengthenCharacter.processKeyTyped("ESC");

        // キャラクターの体力がアップデートされているかを確認
        assertTrue(model.getCharacter().getHp() > initialHp);
    }
}