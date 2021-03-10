package dog.pawbook.logic.commands;

import dog.pawbook.logic.parser.AddEntityCommandParser;
import dog.pawbook.logic.parser.AddOwnerCommandParser;

public abstract class AddEntityCommand extends Command {
    public static final String COMMAND_WORD = "add";

    public AddEntityCommandParser process(String entityType) {
        if (entityType.equals("owner")) {
            return new AddOwnerCommandParser();
        } else { // to implement dogs / programs eventually
            return null;
        }
    }
}
