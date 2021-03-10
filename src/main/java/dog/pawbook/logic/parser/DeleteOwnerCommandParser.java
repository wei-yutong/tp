package dog.pawbook.logic.parser;

import static dog.pawbook.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import dog.pawbook.commons.core.index.Index;
import dog.pawbook.logic.commands.DeleteOwnerCommand;
import dog.pawbook.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteOwnerCommand object
 */
public class DeleteOwnerCommandParser implements Parser<DeleteOwnerCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteOwnerCommand
     * and returns a DeleteOwnerCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteOwnerCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new DeleteOwnerCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteOwnerCommand.MESSAGE_USAGE), pe);
        }
    }

}
