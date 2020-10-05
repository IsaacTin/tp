package com.eva.model.person.staff;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comments {
    private List<Comment> comments;

    Comments() {
        this.comments = new ArrayList<>();
    }

    public void addComment(LocalDate date, String comment) {
        this.comments.add(new Comment(date, comment));
    }

    public void deleteComment(int index) {
        this.comments.remove(index - 1);
    }

    public int getSize() {
        return this.comments.size();
    }

    public String getComment(int index) {
        return this.comments.get(index - 1).getDescription();
    }

    /**
     * Get list of comments in chronological order
     * @return list of comments in chronological order
     */
    public String getListOfComments() {
        if (this.comments.size() == 0) {
            return "No comments.";
        } else {
            String list = "";
            Collections.sort(this.comments, (x, y) -> x.getDate().compareTo(y.getDate()));
            for (int i = 0; i < this.comments.size(); i++) {
                list += (i + 1 + ". " + this.comments.get(i).toString());
            }
            return list;
        }
    }
}
