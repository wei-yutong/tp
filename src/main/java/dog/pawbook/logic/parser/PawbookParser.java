package dog.pawbook.logic.parser;

import static dog.pawbook.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static dog.pawbook.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dog.pawbook.logic.commands.AddEntityCommand;
import dog.pawbook.logic.commands.AddOwnerCommand;
import dog.pawbook.logic.commands.Command;
import dog.pawbook.logic.commands.DeleteCommand;
import dog.pawbook.logic.commands.EditCommand;
import dog.pawbook.logic.commands.ExitCommand;
import dog.pawbook.logic.commands.FindCommand;
import dog.pawbook.logic.commands.HelpCommand;
import dog.pawbook.logic.commands.ListCommand;
import dog.pawbook.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class PawbookParser {

    /**
     * Used for initial separation of command word, entity type, and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)"
            + "(?<entityType>(owner|program|dog))?(?<arguments>.*)");

    private AddEntityCommand generateAddCommand(String entityType, String arguments) {
        if (entityType.equals("owner")) {
            return new AddEntityCommand.process(entityType);
        } else { // to implement dog/programs eventually
            return null;
        }
    }

 /*
    private AddEntityCommandParser process(String entityType) {
        if (entityType.equals("owner")) {
            return new AddOwnerCommandParser();
        } else { // to implement dogs / programs eventually
            return null;
        }
    }

 */
    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        final String entityType = matcher.group("entityType");

        switch (commandWord) {

        case AddOwnerCommand.COMMAND_WORD:
            return new AddOwnerCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);

        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
            return new ListCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
