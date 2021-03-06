package dog.pawbook.logic.parser;

/**
 * Simple wrapper for process method.
 */
public class DeleteCommandParser {
    /**
     * Method to return CommandParser type based on entitiyType.
     * @param entityType the user specified entity to add.
     * @return the respective CommandParser.
     */
    public DeleteOwnerCommandParser process(String entityType) {
        if (entityType.equals("owner")) {
            return new DeleteOwnerCommandParser();
        } else { // to implement dogs / programs eventually
            return null;
        }
    }
}
