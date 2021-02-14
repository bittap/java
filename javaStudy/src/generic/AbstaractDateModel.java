package generic;

import java.util.Calendar;

public abstract class AbstaractDateModel<T> implements DateModel<String> {
	
	private Calendar calendarValue;
	 private boolean selected;
	
	protected AbstaractDateModel() {
		calendarValue = Calendar.getInstance();
		selected = false;
	}
	
    public T getValue() {
        if (!selected) {
            return null;
        }
        return fromCalendar(calendarValue);
    }
	
	@Override
	public void setYear(int year) {
		int oldDayValue = this.calendarValue.get(Calendar.DATE);
		T oldValue = getValue();
	}
	
	@Override
	public int getYear() {
		return 0;
	}
	
	protected abstract T fromCalendar(Calendar from);
}
