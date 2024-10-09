package com.crds.digiops.freedup.util;

import java.time.LocalDate;

public class DateCheckerWithLocalDate {
    public static boolean isDateInRange(String dateString) {
        LocalDate date = LocalDate.parse(dateString);

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Get the 28th of the previous month
        LocalDate previousMonth28th = currentDate.minusMonths(1).withDayOfMonth(28);

        // Get the 15th of the current month
        LocalDate currentMonth15th = currentDate.withDayOfMonth(15);

        // Check if the date is after the 28th of the previous month and before the 15th of the current month
        return date.isAfter(previousMonth28th) && date.isBefore(currentMonth15th);
    }

    public static boolean isDateInRangeSecondHalf(String dateString) {
        LocalDate date = LocalDate.parse(dateString);

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Get the 12th of the previous month
        LocalDate previousMonth12th = currentDate.minusMonths(1).withDayOfMonth(12);

        // Get the 3rd of the current month
        LocalDate currentMonth3rd = currentDate.withDayOfMonth(3);

        // Check if the date is after the 12th of the previous month and before the 3rd of the current month
        return date.isAfter(previousMonth12th) && date.isBefore(currentMonth3rd);
    }
    
    
    public static void main(String[] args) {
        // Example usage
        String dateString = "2024-03-10"; // 10th May 2024

        if (isDateInRange(dateString)) {
            System.out.println("Date is within the range.");
        } else {
            System.out.println("Date is not within the range.");
        }
    }
}