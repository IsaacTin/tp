package com.eva.logic.commands;

import static com.eva.commons.util.CollectionUtil.requireAllNonNull;
import static com.eva.logic.parser.CliSyntax.PREFIX_COMMENT;

import com.eva.commons.core.index.Index;
import com.eva.logic.commands.exceptions.CommandException;

import com.eva.model.Model;

import javax.xml.stream.events.Comment;

public class CommentCommand extends Command{

    public static final String COMMAND_WORD = "remark";

    public static final String MESSAGE_USAGE = COMMAND_WORD + "TESTING";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "Comment command not done yet";

    public static final String MESSAGE_ARGUMENTS = "Index: %1$d, Comment: %2$s, Instruction: %3$s";

    private final Index index;
    private final String comment;
    private final String instruction;

    public CommentCommand(Index index, String comment, String instruction) {
        requireAllNonNull(index, comment, instruction);
        this.index = index;
        this.comment = comment;
        this.instruction = instruction;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        throw new CommandException(String.format(MESSAGE_ARGUMENTS, index.getOneBased(), comment));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof CommentCommand)) {
            return false;
        }

        CommentCommand e = (CommentCommand) other;
        return index.equals(e.index) && comment.equals(e.comment) && instruction.equals(e.instruction);
    }

    private void addComment(String comment) {}
}
