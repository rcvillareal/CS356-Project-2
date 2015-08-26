/**
 * Rodney Villareal
 * CS 356 Project 2
 * Statistic class that implements the methods
 * in the Visitor interface for the visitor
 * pattern.
 */

public class Statistic implements Visitor {

	@Override
	public int getSum(User user) {
		int sum = user.getUserTotal();
		return sum;
	}
	@Override
	public int getSum(Group group) {
		int sum = group.getGroupTotal();
		return sum;
	}
	@Override
	public int getSum(Messages message) {
		int sum = message.getMessageTotal();
		return sum;
	}
	@Override
	public double getPercent(Positives positives) {
		double percent = positives.getPositivePercent();
		return percent;
	}
}
