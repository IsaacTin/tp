package com.eva.model.person.staff;

import java.time.LocalDate;
import java.util.Set;

import com.eva.model.person.Address;
import com.eva.model.person.Email;
import com.eva.model.person.Name;
import com.eva.model.person.Person;
import com.eva.model.person.Phone;
import com.eva.model.tag.Tag;

public class Staff extends Person {
    private Kpi kpi;
    private LeaveInfo leaveinfo;
    private Comments comments;

    /**
     * Constructor to create Staff object.
     *
     * @param name name of Staff
     * @param phone Phone number of staff
     * @param email email of staff
     * @param address address of staf
     * @param tags tag of staff
     * @param kpi KPI of staff
     * @param leaveinfo Leave information of staff
     */
    public Staff(Name name, Phone phone, Email email, Address address, Set<Tag> tags, Kpi kpi, LeaveInfo leaveinfo) {
        super(name, phone, email, address, tags);
        this.kpi = kpi;
        this.leaveinfo = leaveinfo;
        this.comments = new Comments();
    }

    /**
     * Adds information into Staff KPI information
     *
     * @param date date of review
     * @param performanceInfo Performance index of the date being reviewed
     */
    public void addKpiInfo(LocalDate date, double performanceInfo) { }

    /**
     * Delete specific KPI information
     *
     * @param date date of KPI being deleted
     */
    public void deleteKpiInfo(LocalDate date) { }

    /**
     * Add Leave information
     *
     * @param date date of review
     */
    public void addLeaveInfo(LocalDate date) { }

    /**
     * Delete Leave information
     *
     * @param date date of review
     */
    public void deleteLeaveInfo(LocalDate date) { }


    /**
     * Pass instruction into Comment object to add comment into comments under staff
     * @param date date of comment
     * @param description description of comment
     */
    public void addComment(LocalDate date, String description) {
        this.comments.addComment(date, description);
    }

    /**
     * Pass instruction into Comment object to delete comment
     * @param index index of comment in list of comments to delete
     */
    public void deleteComment(int index) {
        this.comments.deleteComment(index);
    }

    /**
     * Get list of all comments, arranged in chronological order, with index of each comment
     * @return list of comments
     */
    public String getListOfComments() {
        return this.comments.getListOfComments();
    }

    /**
     * Get specific comment being looked for
     * @param index index of comment on list to get
     * @return comment description
     */
    public String getComment(int index) {
        return this.comments.getComment(index);
    }

    /**
     * Build string of description of staff
     * @return description of staff
     */
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Phone: ")
                .append(getPhone())
                .append(" Email: ")
                .append(getEmail())
                .append(" Address: ")
                .append(getAddress())
                .append(" No. of comments: ")
                .append(this.comments.getSize())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }
}
