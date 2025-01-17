package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandResult.DisplayType.YEAR;

/**
 * Displays the user's yearly schedule.
 */
public class YearCommand extends Command {

    public static final String COMMAND_WORD = "year";

    public static final String COMMAND_ACTION = "View Yearly Schedule";

    public static final String USER_TIP = "To view your yearly schedule, type: " + COMMAND_WORD;

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows your yearly schedule.\n"
            + "Example: " + COMMAND_WORD;

    public static final String SHOWING_YEAR_MESSAGE = "Showing your yearly calendar."
            + " You can go back to list view by typing \""
            + ListCommand.COMMAND_WORD
            + "\" or navigate the calendar with \""
            + NextCommand.COMMAND_WORD
            + "\" and \""
            + BackCommand.COMMAND_WORD
            + "\".";

    @Override
    public CommandResult execute() {
        return new CommandResult(SHOWING_YEAR_MESSAGE, YEAR);
    }
}
