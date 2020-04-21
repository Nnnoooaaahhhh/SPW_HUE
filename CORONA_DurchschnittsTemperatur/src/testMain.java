import java.io.*;
import java.nio.file.*;
import java.text.*;
import java.time.*;
import java.util.*;

public class testMain {

	static int days = 14;
	static int tests = 10;

	static int temps[][] = new int[days][tests];

	public static void main(String args[]) {
		testing();
		calendar();
	}

	@SuppressWarnings("unused")
	static void testing() {
		Random r = new Random();
		int temp = 0;
		int rowaverage;
		int allaverage = 0;
		boolean check = true;
		boolean fileExists = false;

		File measurements;
		Path file = Paths.get("measurments.txt");
		if (Files.exists(file)) {
			fileExists = true;
		} else {
			measurements = new File("measurments.txt");
			fileExists = false;
		}
		try {
			if (fileExists) {
				Files.deleteIfExists(file);
				measurements = new File("measurements.txt");
			}
		} catch (Exception e) {
		}

		Properties props = System.getProperties();
		try {
			FileWriter writer = new FileWriter("measurments.txt");
			writer.write("Temperaturen in Grad Celsius");
			writer.write("\n");
			writer.write("----------------------------");
			writer.write("\n");
			for (int i = 0; i < days; i++) {
				rowaverage = 0;
				for (int j = 0; j < tests; j++) {
					while (check) {
						temp = r.nextInt(35);
						if (temp < 20) {
							check = true;
						} else {
							check = false;
						}
					}
					check = true;
					temps[i][j] = temp;
					rowaverage = rowaverage + temps[i][j];
					allaverage = allaverage + temps[i][j];
					writer.write(temps[i][j] + "  ");
				}
				writer.write("- Durchschnitsstemperatur: " + rowaverage / tests);
				writer.write("\n");
			}
			writer.write("Gesamt-Durschnitts-Temperatur: " + allaverage / (days * tests));
			writer.write("\n");
			DateFormat dateFormatDays = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat dateFormatTime = new SimpleDateFormat("HH:mm:ss");
			Date date = new Date();
			writer.write(dateFormatDays.format(date) + " um " + dateFormatTime.format(date));
			writer.write("\n");
			writer.write(props.getProperty("os.name"));
			writer.write(" Version " + props.getProperty("os.version"));

			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void calendar() {
		String yearx;
		String monthx;
		int year = 0;
		int month = 0;
		int whatDay = 0;
		boolean correctDate = true;
		LocalDate temp = null;
		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < i + 2; i++) {
			try {
				correctDate = true;
				System.out.println("Bitte das Jahr eingeben:");
				yearx = scan.next();
				year = Integer.parseInt(yearx);
				System.out.println("Bitte den Monat eingeben: (1-12)");
				monthx = scan.next();
				month = Integer.parseInt(monthx);
				temp = LocalDate.of(year, month, 1);

			} catch (Exception e) {
				correctDate = false;
				System.out.println("Falsche Eingabe!");
			}
			if (correctDate) {
				break;
			}
		}

		System.out.println("Kalender für " + temp.getMonth() + " " + temp.getYear());
		DayOfWeek day = temp.getDayOfWeek();
		if (day == DayOfWeek.MONDAY) {
			whatDay = 1;
		}
		if (day == DayOfWeek.TUESDAY) {
			whatDay = 2;
		}
		if (day == DayOfWeek.WEDNESDAY) {
			whatDay = 3;
		}
		if (day == DayOfWeek.THURSDAY) {
			whatDay = 4;
		}
		if (day == DayOfWeek.FRIDAY) {
			whatDay = 5;
		}
		if (day == DayOfWeek.SATURDAY) {
			whatDay = 6;
		}
		if (day == DayOfWeek.SUNDAY) {
			whatDay = 7;
		}

		YearMonth monthLength = YearMonth.of(year, month);
		int daysInMonth = monthLength.lengthOfMonth();
		printCalendar(daysInMonth, whatDay);
		scan.close();
	}

	static void printCalendar(int daysInMonth, int whatDay) {
		int weekdayIndex = 0;
		
		System.out.println("Mo  Di  Mi  Do  Fr  Sa  So");
		for (int day = 1; day < whatDay; day++) {
			System.out.print("    ");
			weekdayIndex++;
		}
		for (int day = 1; day < daysInMonth + 1; day++) {
			if (day < 10) {
				System.out.print(day + " ");
			} else {
				System.out.print(day);
			}
			weekdayIndex++;
			if (weekdayIndex == 7) {
				weekdayIndex = 0;
				System.out.println();
			} else {
				System.out.print("  ");
			}
		}
	}
}