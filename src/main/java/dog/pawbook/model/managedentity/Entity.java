package dog.pawbook.model.managedentity;

import static dog.pawbook.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import dog.pawbook.model.managedentity.tag.Tag;

public abstract class Entity {
    // Identity fields
    protected final Name name;

    // Data fields
    protected final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Entity(Name name, Set<Tag> tags) {
        requireAllNonNull(name, tags);
        this.name = name;
        this.tags.addAll(tags);
    }

    public Name getName() {
        return name;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both entities have the same identity and data fields.
     * This defines a stronger notion of equality between two entities.
     */
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Entity)) {
            return false;
        }

        Entity otherEntity = (Entity) other;

        return otherEntity.getName().equals(getName()) && otherEntity.getTags().equals(getTags());
    }

    /**
     * Returns true if both entities have the same name.
     * This defines a weaker notion of equality between two entities.
     */
    public <T extends Entity> boolean isSameEntity(T otherEntity) {
        if (otherEntity == this) {
            return true;
        }

        return otherEntity != null
                && otherEntity.getName().equals(getName());
    }

    /**
     * Returns an array of properties that should be displayed.
     */
    public abstract String[] getOtherPropertiesAsString();

    public abstract Map<String, String> getOtherPropertiesAsDict();
}
