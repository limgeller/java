package view;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

public abstract class AbsViewTemplate extends AbsView{

	@Override
	public void show() {
		showMenu();
		String input = getKeyInputString("¹øÈ£ : ");
		if(isValidNumber(input)) {
			execute(NumberUtils.toInt(input));
		}
	}
	protected boolean isValidNumber(String input) {
		if(StringUtils.isBlank(input)) {
			return false;
		}
		if(StringUtils.isNumeric(input)) {
			int number = NumberUtils.toInt(input);
			if(number >= getMinMenuNumber()&& number <= getMaxMenuNumber()) {
				return true;
			}
		}
		return false;
	}
	abstract protected void showMenu();
	abstract protected int getMinMenuNumber();
	abstract protected int getMaxMenuNumber();
	abstract protected void execute(int number);
}
