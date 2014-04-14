import org.junit.Assert;
import org.junit.Test;


public class MinesweeperMasterTest {

	@Test
	public void testFindBoardImpossible() {
		Assert.assertEquals("Impossible\n", MinesweeperMaster.findBoard(1, 1, 1));
		Assert.assertEquals("Impossible\n", MinesweeperMaster.findBoard(1, 2, 1));
		Assert.assertEquals("Impossible\n", MinesweeperMaster.findBoard(2, 1, 1));
		Assert.assertEquals("Impossible\n", MinesweeperMaster.findBoard(2, 2, 1));
		Assert.assertEquals("Impossible\n", MinesweeperMaster.findBoard(2, 3, 3));
		Assert.assertEquals("Impossible\n", MinesweeperMaster.findBoard(3, 2, 3));
		Assert.assertEquals("Impossible\n", MinesweeperMaster.findBoard(3, 3, 6));
		Assert.assertEquals("Impossible\n", MinesweeperMaster.findBoard(3, 3, 4));
		Assert.assertEquals("Impossible\n", MinesweeperMaster.findBoard(3, 4, 5));
		Assert.assertEquals("Impossible\n", MinesweeperMaster.findBoard(4, 4, 9));
		Assert.assertEquals("Impossible\n", MinesweeperMaster.findBoard(4, 4, 11));
		Assert.assertEquals("Impossible\n", MinesweeperMaster.findBoard(5, 2, 5));
	}
	
	@Test
	public void testFindBoardPossible() {
		Assert.assertEquals("c\n", MinesweeperMaster.findBoard(1, 1, 0));
		Assert.assertEquals(".c\n", MinesweeperMaster.findBoard(1, 2, 0));
		Assert.assertEquals(".\nc\n", MinesweeperMaster.findBoard(2, 1, 0));
		Assert.assertEquals("..\n.c\n", MinesweeperMaster.findBoard(2, 2, 0));
		Assert.assertEquals("*.c\n", MinesweeperMaster.findBoard(1, 3, 1));
		Assert.assertEquals("*\n.\nc\n", MinesweeperMaster.findBoard(3, 1, 1));
		Assert.assertEquals("**\n..\n.c\n", MinesweeperMaster.findBoard(3, 2, 2));
		Assert.assertEquals("*..\n*.c\n", MinesweeperMaster.findBoard(2, 3, 2));
		Assert.assertEquals("***\n*..\n*.c\n", MinesweeperMaster.findBoard(3, 3, 5));
		Assert.assertEquals("*..\n...\n..c\n", MinesweeperMaster.findBoard(3, 3, 1));
		Assert.assertEquals("***\n...\n..c\n", MinesweeperMaster.findBoard(3, 3, 3));
		Assert.assertEquals("****\n*...\n*..c\n", MinesweeperMaster.findBoard(3, 4, 6));
		Assert.assertEquals("**..\n*...\n....\n...c\n", MinesweeperMaster.findBoard(4, 4, 3));
		Assert.assertEquals("****\n*...\n*...\n*..c\n", MinesweeperMaster.findBoard(4, 4, 7));
		Assert.assertEquals("****\n****\n*...\n*..c\n", MinesweeperMaster.findBoard(4, 4, 10));
		Assert.assertEquals("**..\n**.c\n", MinesweeperMaster.findBoard(2, 4, 4));
		Assert.assertEquals("****\n****\n**..\n**.c\n", MinesweeperMaster.findBoard(4, 4, 12));
		Assert.assertEquals("*****\n**...\n*....\n*...c\n", MinesweeperMaster.findBoard(4, 5, 9));
		Assert.assertEquals("*..\n*..\n...\n..c\n", MinesweeperMaster.findBoard(4, 3, 2));
		Assert.assertEquals("****\n****\n*...\n*...\n*..c\n", MinesweeperMaster.findBoard(5, 4, 11));
	}
	
}
