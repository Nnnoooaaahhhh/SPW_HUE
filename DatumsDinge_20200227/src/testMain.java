import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
public class testMain {
	
	static ArrayList<LocalDate> allDates = new ArrayList<LocalDate>();

	public static void main(String[] args) {
		dates();
		bday();
	}
	
	static void dates() {
		DayOfWeek weekDay;
		int days = 0;
		String whatDay;
		DayOfWeek whatDayX = null;
		@SuppressWarnings("resource")
		Scanner a = new Scanner(System.in);
		int year;
		LocalDate lastDay = null;
		System.out.println("Nach welchem Wochentag wollen sie suchen?");
		whatDay = a.next();
		if(whatDay.equalsIgnoreCase("Montag")) {
			whatDayX = DayOfWeek.MONDAY;
		}
		if(whatDay.equalsIgnoreCase("Dienstag")) {
			whatDayX = DayOfWeek.TUESDAY;
		}
		if(whatDay.equalsIgnoreCase("Mittwoch")) {
			whatDayX = DayOfWeek.WEDNESDAY;
		}
		if(whatDay.equalsIgnoreCase("Donnerstag")) {
			whatDayX = DayOfWeek.THURSDAY;
		}
		if(whatDay.equalsIgnoreCase("Freitag")) {
			whatDayX = DayOfWeek.FRIDAY;
		}
		if(whatDay.equalsIgnoreCase("Samstag")) {
			whatDayX = DayOfWeek.SATURDAY;
		}
		if(whatDay.equalsIgnoreCase("Sonntag")) {
			whatDayX = DayOfWeek.SUNDAY;
		}
		System.out.println("Anfangsjahrzahl eingeben:");
		year = a.nextInt();
		LocalDate test = LocalDate.of(year, 01, 01);
		for(int i = 0; i < i + 1; i++) {
			weekDay = test.getDayOfWeek();
			if(weekDay == whatDayX){
				days++;
				allDates.add(test);
			}
			test = test.plusDays(1);
			if(test.isEqual(LocalDate.now())) {
				break;
			}
		}
		lastDay = allDates.get(allDates.size()-1);
		System.out.println("Seit dem 1.1." + year + " gab es "+ days +" "+ whatDay + "/e");
		System.out.println("Das Datum des letzten gefunden Montags ist (YYYY/MM/DD): " + DateTimeFormatter.ofPattern("yyyy/MM/dd").format(lastDay)+",");
		System.out.println("oder (MM/DD/YY:) " + DateTimeFormatter.ofPattern("MM/dd/yy").format(lastDay));
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
		System.out.println("Das entpsricht "+ Math.abs(days)+ " Tagen.");	
	}
}
