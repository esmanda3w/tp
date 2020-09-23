package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REMARK;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.RemarkCommand;
import seedu.address.model.person.Remark;

class RemarkCommandParserTest {
    private RemarkCommandParser parser = new RemarkCommandParser();

    @Test
    public void parse_indexSpecified_success() {
        String remark = "Test remark";
        String emptyRemark = "";

        // Non-empty remark
        String userInput = INDEX_FIRST_PERSON.getOneBased() + " " + PREFIX_REMARK + remark;
        RemarkCommand expectedCommand = new RemarkCommand(INDEX_FIRST_PERSON, new Remark(remark));
        assertParseSuccess(parser, userInput, expectedCommand);


        // Empty remark
        userInput = INDEX_FIRST_PERSON.getOneBased() + " " + PREFIX_REMARK + emptyRemark;
        expectedCommand = new RemarkCommand(INDEX_FIRST_PERSON, new Remark(emptyRemark));
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_missingCompulsoryField_failure() {
        String remark = "Test remark";
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, RemarkCommand.MESSAGE_USAGE);

        // No index and remark
        assertParseFailure(parser, RemarkCommand.COMMAND_WORD, expectedMessage);

        // No index
        assertParseFailure(parser, RemarkCommand.COMMAND_WORD + " " + remark, expectedMessage);
    }
}
