package seedu.address.model.person.staff;

import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;

import java.util.Date;
import java.util.Set;

public class Staff extends Person {
    private KPI kpi;
    private LeaveInfo leaveinfo;

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
    public Staff(Name name, Phone phone, Email email, Address address, Set<Tag> tags, KPI kpi, LeaveInfo leaveinfo) {
        super(name, phone, email, address, tags);
        this.kpi = kpi;
        this.leaveinfo = leaveinfo;
    }

    /**
     * Adds information into Staff KPI information
     *
     * @param date date of review
     * @param PerformanceInfo Performance index of the date being reviewed
     */
    public void addKpiInfo(Date date, double PerformanceInfo) {
        this.kpi.add(date, PerformanceInfo);
    }
  
}
