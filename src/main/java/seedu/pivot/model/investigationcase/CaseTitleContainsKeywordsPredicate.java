package seedu.pivot.model.investigationcase;

import java.util.List;
import java.util.function.Predicate;

import seedu.pivot.commons.util.StringUtil;

/**
 * Tests that a {@code Case}'s {@code Title} matches any of the keywords given.
 */
public class CaseTitleContainsKeywordsPredicate implements Predicate<Case> {
    private final List<String> keywords;

    public CaseTitleContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Case investigationCase) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(investigationCase.getTitle().getAlphaNum(),
                        keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof CaseTitleContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((CaseTitleContainsKeywordsPredicate) other).keywords)); // state check
    }

}
