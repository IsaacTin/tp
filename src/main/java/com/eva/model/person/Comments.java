package com.eva.model.person;

import com.eva.model.person.exceptions.InvalidCommandException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;


import static java.util.Objects.requireNonNull;

public class Comments {
    public HashMap<LocalDate, ArrayList<String>> comments;

    public Comments() {
        this.comments = new HashMap<>();
    }

    public void addComment(LocalDate date, String description) {
        requireNonNull(description);
        if (!comments.containsKey(date)) {
            comments.put(date, new ArrayList<>());
        }
        comments.get(date).add(description);
    }

    public void deleteComment(LocalDate date, int index) throws InvalidCommandException {
        if (!comments.containsKey(date)) {
            throw new InvalidCommandException("No date with comments");
        } else if (index - 1 > comments.get(date).size()) {
            throw new InvalidCommandException("Index out of bounds");
        } else {
            comments.get(date).remove(index - 1);
        }
    }

    public boolean hasComments() {
        return !this.comments.isEmpty();
    }
}
