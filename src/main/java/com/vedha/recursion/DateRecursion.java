package com.vedha.recursion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class DateRecursion {

    public static LocalDate getDateRecursion(LocalDate date, Set<LocalDate> dates) {

        if (dates.contains(date)) {

            return getDateRecursion(date.plusDays(1), dates);
        } else {

            return date;
        }
    }

    public static void main(String[] args) {

        Set<LocalDate> dates = Set.of(LocalDate.now(), LocalDate.now().plusDays(1),
                LocalDate.now().plusDays(3), LocalDate.now().plusDays(4),
                LocalDate.now().plusDays(5), LocalDate.now().plusDays(6));
        System.out.println("dates = " + dates);

        LocalDate parse = LocalDate.parse("03-02-2025", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println("parse = " + parse);

        int iteration = 0;
        for (LocalDate date : dates) {

            iteration++;
            if (dates.contains(parse)) {

                parse = parse.plusDays(1);
            } else {

                break;
            }
        }

        System.out.println("iteration = " + iteration);
        System.out.println("final parse = " + parse);

        LocalDate date = getDateRecursion(LocalDate.parse("03-02-2025", DateTimeFormatter.ofPattern("dd-MM-yyyy")), dates);
        System.out.println("getDateRecursion = " + date);

    }

}
