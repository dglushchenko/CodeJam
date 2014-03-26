import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BotTrust {

	public static enum Bot {
		O, B;
	}

	public static class ButtonEvent {
		private Bot bot;
		private int index;

		public ButtonEvent(Bot bot, int index) {
			this.bot = bot;
			this.index = index;
		}

		public Bot getBot() {
			return bot;
		}

		public int getIndex() {
			return index;
		}

		@Override
		public String toString() {
			return "ButtonEvent [bot=" + bot + ", index=" + index + "]";
		}

	}

	public static int calculate(ButtonEvent[] events) {
		int result = 0;

		int oEventIndex = -1;
		int bEventIndex = -1;
		boolean oEventProcessed = true;
		boolean bEventProcessed = true;
		int oIndex = 1;
		int bIndex = 1;
		boolean oFinished = false;
		boolean bFinished = false;
		while (true) {
			// Get next O
			if (oEventProcessed && !oFinished) {
				for (int i = oEventIndex + 1; i < events.length; i++) {
					if (events[i].getBot().equals(Bot.O)) {
						oEventIndex = i;
						oEventProcessed = false;
						break;
					}
				}
				if (oEventProcessed) {
					oFinished = true;
				}
			}
			// Get next B
			if (bEventProcessed && !bFinished) {
				for (int i = bEventIndex + 1; i < events.length; i++) {
					if (events[i].getBot().equals(Bot.B)) {
						bEventIndex = i;
						bEventProcessed = false;
						break;
					}
				}
				if (bEventProcessed) {
					bFinished = true;
				}
			}

			if (oEventProcessed && bEventProcessed) {
				break;
			}

			boolean makeMove = false;
			if (!oFinished) {
				if (events[oEventIndex].getIndex() == oIndex) {
					if (bFinished || oEventIndex < bEventIndex) {
						// press button
						oEventProcessed = true;
						makeMove = true;
					}
				} else {
					// move
					if (events[oEventIndex].getIndex() > oIndex) {
						oIndex++;
					} else {
						oIndex--;
					}
					makeMove = true;
				}
			}

			if (!bFinished) {
				if (events[bEventIndex].getIndex() == bIndex) {
					if (oFinished || bEventIndex < oEventIndex) {
						// press button
						bEventProcessed = true;
						makeMove = true;
					}
				} else {
					// move
					if (events[bEventIndex].getIndex() > bIndex) {
						bIndex++;
					} else {
						bIndex--;
					}
					makeMove = true;
				}
			}

			if (makeMove) {
				result++;
			}

		}

		return result;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("A-large-practice.in"));
		int t = scanner.nextInt();
		int caseNumber = 1;
		while (caseNumber <= t) {
			int n = scanner.nextInt();
			ButtonEvent[] events = new ButtonEvent[n];
			int i = 0;
			while (i < n) {
				events[i++] = new ButtonEvent(Bot.valueOf(scanner.next()), scanner.nextInt());
			}

			int result = calculate(events);

			System.out.println("Case #" + caseNumber++ + ": " + result);

		}
	}
}
