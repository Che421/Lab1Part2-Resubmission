
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateCalculator {
	// method that parses date to a string
	private static LocalDate getDateFromString(String dateString) {
		return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
	}
	//method that calculates the difference between dateOne and dateTwo using the Period class
	private static void printDateDifference(LocalDate dateOne, LocalDate dateTwo) {
		Period diff = Period.between(dateOne, dateTwo);
		System.out.printf("Difference is %d years, %d months and %d days", diff.getYears(), diff.getMonths(),
				diff.getDays());
	}

	public static void main(String[] args) {
		// receives input from console.
		Scanner scanner = new java.util.Scanner(System.in);

		// prompts user to enter date in format
		System.out.println("Enter a date in the format mm/dd/yyyy");

		// receives user input using scanner
		String userDate1 = scanner.next();

		System.out.println("Enter another date in the format mm/dd/yyyy");
		String userDate2 = scanner.next();
		// Catches user input that doesn't use correct format
		try {
			LocalDate dateOne = getDateFromString(userDate1);
			LocalDate dateTwo = getDateFromString(userDate2);
			printDateDifference(dateOne, dateTwo);
		} catch (DateTimeParseException e) {
			System.out.println("Faulty date entered.");
		}
	}
}