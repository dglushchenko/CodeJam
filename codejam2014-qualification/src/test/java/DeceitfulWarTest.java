import org.junit.Assert;
import org.junit.Test;


public class DeceitfulWarTest {

	@Test
	public void testWar() {
		Assert.assertEquals(0, DeceitfulWar.war(new double[] {1, 2, 3}, new double[] {1.1, 2.1, 3.1}));
		Assert.assertEquals(3, DeceitfulWar.war(new double[] {10, 20, 30}, new double[] {1.1, 2.1, 3.1}));
	}

	@Test
	public void testDeceitfulWar() {
		Assert.assertEquals(2, DeceitfulWar.deceitfulWar(new double[] {1, 2, 3}, new double[] {1.1, 2.1, 3.1}));
		Assert.assertEquals(3, DeceitfulWar.war(new double[] {10, 20, 30}, new double[] {1.1, 2.1, 3.1}));
	}
	

}
