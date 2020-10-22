package seedu.pivot.commons.core;

/**
 * Container for user visible messages.
 */
public class Messages {

    // Common messages
    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";

    // Main page messages
    public static final String MESSAGE_INVALID_CASE_DISPLAYED_INDEX = "The case index provided is invalid";
    public static final String MESSAGE_CASES_LISTED_OVERVIEW = "%1$d cases listed!";
    public static final String MESSAGE_INCORRECT_MAIN_PAGE = "Invalid command. "
            + "Please return to main page to use this command.";
    public static final String MESSAGE_INCORRECT_CASE_PAGE = "Invalid command. "
            + "Please open a case to use this command.";

    // Case page messages
    public static final String MESSAGE_INVALID_DOCUMENT_DISPLAYED_INDEX = "The document index provided is invalid";
    public static final String MESSAGE_INVALID_SUSPECTS_DISPLAYED_INDEX = "The suspect index provided is invalid";
    public static final String MESSAGE_INVALID_WITNESS_DISPLAYED_INDEX = "The witness index provided is invalid";
    public static final String MESSAGE_INVALID_VICTIM_DISPLAYED_INDEX = "The victim index provided is invalid";
}
