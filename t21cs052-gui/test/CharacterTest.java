import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CharacterTest {

	private Character character;

	@Before
	public void setUp() {
		Model model = new Model();
		character = new Character(model);
	}

	@Test
	public void a_キャラクターが指定された座標を持つか判定する() {
		Character c = new Character(10, 10);
		assertEquals(10, c.getX());
		assertEquals(10, c.getY());
	}

	@Test
	public void b_キャラクターが移動することを確認する() {
		assertEquals(90, character.getX());
		assertEquals(300, character.getY());

		character.move("LEFT");
		assertEquals(70, character.getX());
		assertEquals(300, character.getY());

		character.move("RIGHT");
		assertEquals(90, character.getX());
		assertEquals(300, character.getY());
	}

	@Test
	public void c_キャラクターが自由落下することを確かめる() {
		Blocks blocks = new Blocks();

	
		character.freefall(blocks);
		assertEquals(90, character.getX());
		assertEquals(310, character.getY());

		
		character.freefall(blocks);
		assertEquals(90, character.getX());
		assertEquals(320, character.getY());

		
		character.freefall(blocks);
		assertEquals(90, character.getX());
		assertEquals(330, character.getY());

	
		character.freefall(blocks);
		assertEquals(90, character.getX());
		assertEquals(330, character.getY());
	}

	@Test
	public void d_キャラクターが足場で着地することを確認する() {
		Blocks blocks = new Blocks();

	
		character.freefall(blocks);
		assertEquals(90, character.getX());
		assertEquals(310, character.getY());

	
		character.freefall(blocks);
		assertEquals(90, character.getX());
		assertEquals(320, character.getY());

	
		character.freefall(blocks);
		assertEquals(90, character.getX());
		assertEquals(330, character.getY());

		character.freefall(blocks);
		assertEquals(90, character.getX());
		assertEquals(330, character.getY());

	}
	
	@Test
	public void e_キャラクターのHPがダメージを受けて減少することを確認する() {
		assertEquals(180, character.getHp());
		character.reduceHealth(30);
		assertEquals(150, character.getHp());
	}

	@Test
	public void f_キャラクターの経験値が加算されることを確認する() {
		assertEquals(0, character.getExp());
		character.addExperience(50);
		assertEquals(50, character.getExp());
	}

	@Test
	public void g_キャラクターがレベルアップすることを確認する() {
		assertEquals(1, character.getLevel());
		assertEquals(0, character.getExp());
		
		// レベルアップに必要な経験値を達成しない場合はレベルが変わらないことを確認
		character.addExperience(50);
		assertEquals(1, character.getLevel());
		assertEquals(50, character.getExp());
		
		// レベルアップに必要な経験値を達成するとレベルが1つ上がることを確認
		character.addExperience(50);
		assertEquals(2, character.getLevel());
		assertEquals(100, character.getExp());
	}




	

	@Test
	public void k_キャラクターの最後の向きを取得することを確認する() {
		assertEquals("RIGHT", character.getLastDirection());
		character.move("LEFT");
		assertEquals("LEFT", character.getLastDirection());
		character.move("RIGHT");
		assertEquals("RIGHT", character.getLastDirection());
	}
	
	

}
