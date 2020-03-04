import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
public class testMain {
	
	static DayOfWeek weekDay;
	static DayOfWeek LastWeekDay;
	static int mondays;	
	static int days;
	static int daysToBday;
	
	
	public static void main(String[] args) {
		dates();
		bday();
	}
	
	static void dates() {
		@SuppressWarnings("resource")
		Scanner a = new Scanner(System.in);
		int year;
		LocalDate lastMonday = null;
		LocalDate now = LocalDate.now();
		
		System.out.println("Anfangsjahrzahl eingeben:");
		year = a.nextInt();
		LocalDate test = LocalDate.of(year, 01, 01);
		for(int i = 0; i < i + 1; i++) {
			weekDay = test.getDayOfWeek();
			if(weekDay == DayOfWeek.MONDAY){
				mondays++;
			}
			test = test.plusDays(1);
			if(test.isEqual(LocalDate.now())) {
				break;
			}
		}
		for(int i = 0; i < i + 1; i++) {
			LastWeekDay = now.getDayOfWeek();
			if(LastWeekDay == DayOfWeek.MONDAY){
				lastMonday = now;
				break;
			}
			now = now.minusDays(1);
		}
		System.out.println("Montage: " + mondays);
		System.out.println(DateTimeFormatter.ofPattern("yyyy/MM/dd").format(lastMonday));
		System.out.println(DateTimeFormatter.ofPattern("MM/dd/yy").format(lastMonday));
	}	
	
	static void bday() {
		@SuppressWarnings("unused")
		int year;
		int month;
		int day;		
		int days;	
		@SuppressWarnings("resource")
		Scanner a  = new Scanner(System.in);
		
		System.out.println("Bitte geben sie Ihr Geburtsdatum an (YYYY MM DD):");
		year = a.nextInt();
		month = a.nextInt();
		day = a.nextInt();
		LocalDate test = LocalDate.of(LocalDate.now().getYear()+1, month, day);
		LocalDate testX = LocalDate.of(LocalDate.now().getYear(), month, day);
		
		Period daysTo = Period.between(LocalDate.now(), test);		
		System.out.println("Es sind noch " + daysTo.getMonths() + " Monate und "+ daysTo.getDays()+" Tage zu ihrem Geburtstag!");
		days = (int) ChronoUnit.DAYS.between(LocalDate.now(), testX);
		if(days <= 0) {
			days = (int) ChronoUnit.DAYS.between(test, LocalDate.now());
		}
		System.out.println("Das entspricht "+ Math.abs(days)+ " Tagen.");	
	}
}