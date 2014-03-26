import org.junit.Assert;
import org.junit.Test;

public class BotTrustTest {

	@Test
	public void testCalculateOrangeLast() {
		final BotTrust.ButtonEvent[] events = new BotTrust.ButtonEvent[] { 
				new BotTrust.ButtonEvent(BotTrust.Bot.O, 2), 
				new BotTrust.ButtonEvent(BotTrust.Bot.B, 1), 
				new BotTrust.ButtonEvent(BotTrust.Bot.B, 2), 
				new BotTrust.ButtonEvent(BotTrust.Bot.O, 4) 
		};
		
		Assert.assertEquals(6, BotTrust.calculate(events));
	}

	@Test
	public void testCalculateBlueLast() {
		final BotTrust.ButtonEvent[] events = new BotTrust.ButtonEvent[] { 
				new BotTrust.ButtonEvent(BotTrust.Bot.B, 2), 
				new BotTrust.ButtonEvent(BotTrust.Bot.O, 1), 
				new BotTrust.ButtonEvent(BotTrust.Bot.O, 2), 
				new BotTrust.ButtonEvent(BotTrust.Bot.B, 4) 
		};
		
		Assert.assertEquals(6, BotTrust.calculate(events));
	}

}
