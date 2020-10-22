package seedu.pivot.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.pivot.commons.exceptions.IllegalValueException;
import seedu.pivot.model.investigationcase.Name;
import seedu.pivot.model.investigationcase.Victim;

/**
 * Jackson-friendly version of {@link Victim}.
 */
public class JsonAdaptedVictim {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Victim's %s field is missing!";

    private final String name;

    /**
     * Constructs a {@code JsonAdaptedVictim} with the given {@code name}.
     */
    @JsonCreator
    public JsonAdaptedVictim(@JsonProperty("name") String name) {
        this.name = name;
    }

    /**
     * Converts a given {@code Victim} into this class for Jackson use.
     */
    public JsonAdaptedVictim(Victim source) {
        name = source.getName().alphaNum;
    }

    /**
     * Converts this Jackson-friendly adapted victim object into the model's {@code Victim} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted victim.
     */
    public Victim toModelType() throws IllegalValueException {
        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        return new Victim(modelName);
    }
}
