package dog.pawbook.logic.parser;

/**
 * Simple wrapper for process method.
 */
public class AddCommandParser {
    /**
     * Method to return CommandParser type based on entitiyType.
     * @param entityType the user specified entity to add.
     * @return the respective CommandParser.
     */
    public AddOwnerCommandParser process(String entityType) {
        if (entityType.equals("owner")) {
            return new AddOwnerCommandParser();
        } else { // to implement dogs / programs eventually
            return null;
        }
    }
}
