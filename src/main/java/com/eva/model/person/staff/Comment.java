package com.eva.model.person.staff;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Comment {
    private LocalDate date;
    private String description;

    Comment(LocalDate date, String description) {
        this.date = date;
        this.description = description;
    }


    public LocalDate getDate() {
        return this.date;
    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        return this.date.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
    }
}
