package gui.core;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class Utils {
    public DateTimeFormatter formatter() {
        return DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");
    }

    public LocalDate getCurrentDate() {
        return LocalDate.now();
    }
}
