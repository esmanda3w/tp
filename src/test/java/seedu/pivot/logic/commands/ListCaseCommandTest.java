package seedu.pivot.logic.commands;

import static seedu.pivot.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.pivot.logic.commands.CommandTestUtil.showCaseAtIndex;
import static seedu.pivot.testutil.TypicalCases.getTypicalPivot;
import static seedu.pivot.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.pivot.logic.commands.casecommands.ListCaseCommand;
import seedu.pivot.model.Model;
import seedu.pivot.model.ModelManager;
import seedu.pivot.model.UserPrefs;

/**
 * Contains integration tests (interaction with the Model) and unit tests for ListCommand.
 */
public class ListCaseCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalPivot(), new UserPrefs());
        expectedModel = new ModelManager(model.getPivot(), new UserPrefs());
    }

    @Test
    public void execute_listIsNotFiltered_showsSameList() {
        assertCommandSuccess(new ListCaseCommand(), model, ListCaseCommand.MESSAGE_LIST_CASE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_listIsFiltered_showsEverything() {
        showCaseAtIndex(model, INDEX_FIRST_PERSON);
        assertCommandSuccess(new ListCaseCommand(), model, ListCaseCommand.MESSAGE_LIST_CASE_SUCCESS, expectedModel);
    }
}
