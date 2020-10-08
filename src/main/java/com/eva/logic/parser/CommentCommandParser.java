package com.eva.logic.parser;

import com.eva.commons.core.index.Index;
import com.eva.commons.exceptions.IllegalValueException;
import com.eva.logic.commands.CommentCommand;
import com.eva.logic.parser.exceptions.ParseException;

import static com.eva.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static com.eva.logic.parser.CliSyntax.PREFIX_COMMENT;
import static java.util.Objects.requireNonNull;

public class CommentCommandParser implements Parser<CommentCommand> {

    public CommentCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_COMMENT);

        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, CommentCommand.MESSAGE_USAGE), ive);
        }

        String details = argMultimap.getValue(PREFIX_COMMENT).orElse("");

        try {
            String[] parsedComment = ParserUtil.parseComment(details);
            return new CommentCommand(index, parsedComment[1], parsedComment[0]);
        } catch (ParseException e) {
            throw new ParseException(e.getMessage());
        }
    }
}
