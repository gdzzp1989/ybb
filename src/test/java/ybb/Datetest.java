package ybb;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Datetest {
    public static void main(String[] args) throws Exception {

        LocalDate day = LocalDate.now().minus(14, ChronoUnit.DAYS);


        System.out.println( day.format(DateTimeFormatter.ISO_LOCAL_DATE));
    }
}
