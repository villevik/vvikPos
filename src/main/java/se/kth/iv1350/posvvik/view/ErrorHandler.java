package se.kth.iv1350.posvvik.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 *
 * @author ville
 */
public class ErrorHandler {

    public void showErrorMessage(String msg) {
        StringBuilder errorMsgBuilder = new StringBuilder();
        errorMsgBuilder.append(createTime());
        errorMsgBuilder.append(", ERROR: ");
        errorMsgBuilder.append(msg);
        System.out.println(errorMsgBuilder);
    }

    /**
     * Prints error message to Dev.
     * @param e
     */
    public void logErrorMsg(Exception e) {
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append("LOG\n");
        logMsgBuilder.append(createTime());
        logMsgBuilder.append(", Exception was thrown: ");
        logMsgBuilder.append(e.getMessage());
        System.out.println(logMsgBuilder);
    }

    /**
     * Get and format current time.
     * @return
     */
    private String createTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }
}
