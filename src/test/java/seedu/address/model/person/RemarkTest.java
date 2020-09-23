package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

class RemarkTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Remark(null));
    }

    @Test
    public void equals() {
        Remark standardRemark = new Remark("Test remark");

        // same values -> returns true
        Remark remarkWithSameValue = new Remark("Test remark");
        assertTrue(standardRemark.equals(remarkWithSameValue));

        // same object -> returns true
        assertTrue(standardRemark.equals(standardRemark));

        // null -> returns false
        assertFalse(standardRemark.equals(null));

        // different types -> returns false
        assertFalse(standardRemark.equals(new Address("Singapore")));

        // different descriptor -> returns false
        assertFalse(standardRemark.equals(new Remark("")));
    }
}
