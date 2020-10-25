package seedu.pivot.model.investigationcase;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.pivot.testutil.CaseBuilder;

public class CaseTitleContainsKeywordsPredicateTest {

    @Test
    public void equals() {
        List<String> firstPredicateKeywordList = Collections.singletonList("first");
        List<String> secondPredicateKeywordList = Arrays.asList("first", "second");

        CaseTitleContainsKeywordsPredicate firstPredicate =
                new CaseTitleContainsKeywordsPredicate(firstPredicateKeywordList);
        CaseTitleContainsKeywordsPredicate secondPredicate =
                new CaseTitleContainsKeywordsPredicate(secondPredicateKeywordList);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        CaseTitleContainsKeywordsPredicate firstPredicateCopy =
                new CaseTitleContainsKeywordsPredicate(firstPredicateKeywordList);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different person -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_titleContainsKeywords_returnsTrue() {
        // One keyword
        CaseTitleContainsKeywordsPredicate predicate =
                new CaseTitleContainsKeywordsPredicate(Collections.singletonList("Alice"));
        assertTrue(predicate.test(new CaseBuilder().withTitle("Alice Bob").build()));

        // Multiple keywords
        predicate = new CaseTitleContainsKeywordsPredicate(Arrays.asList("Alice", "Bob"));
        assertTrue(predicate.test(new CaseBuilder().withTitle("Alice Bob").build()));

        // Only one matching keyword
        predicate = new CaseTitleContainsKeywordsPredicate(Arrays.asList("Bob", "Carol"));
        assertTrue(predicate.test(new CaseBuilder().withTitle("Alice Carol").build()));

        // Mixed-case keywords
        predicate = new CaseTitleContainsKeywordsPredicate(Arrays.asList("aLIce", "bOB"));
        assertTrue(predicate.test(new CaseBuilder().withTitle("Alice Bob").build()));
    }

    @Test
    public void test_titleDoesNotContainKeywords_returnsFalse() {
        // Zero keywords
        CaseTitleContainsKeywordsPredicate predicate = new CaseTitleContainsKeywordsPredicate(Collections.emptyList());
        assertFalse(predicate.test(new CaseBuilder().withTitle("Alice").build()));

        // Non-matching keyword
        predicate = new CaseTitleContainsKeywordsPredicate(Arrays.asList("Carol"));
        assertFalse(predicate.test(new CaseBuilder().withTitle("Alice Bob").build()));


        //TODO: Possible test issue, mention of email here.

        // TODO: Might need testing for keywords matching other fields but not name in the future.
        // Keywords match email and address, but does not match name
        predicate = new CaseTitleContainsKeywordsPredicate(Arrays.asList("12345", "alice@email.com", "Main", "Street"));
        assertFalse(predicate.test(new CaseBuilder().withTitle("Alice")
                .build()));
    }
}
