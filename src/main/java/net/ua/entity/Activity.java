package net.ua.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "activity")
public class Activity implements Serializable{

    @Id
    @Column(name = "ActivityId")
    private int activityId;

    @Column(name = "Title")
    private String title;

    @Column(name = "Place")
    private String place;

    @Column(name = "Start")
    private Date start;

    @Column(name = "End")
    private Date end;

    @Column(name = "Deadline")
    private Date deadline;

    @Column(name = "Type")
    private int type;

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Activity)) return false;

        Activity activity = (Activity) o;

        if (getActivityId() != activity.getActivityId()) return false;
        if (getType() != activity.getType()) return false;
        if (getTitle() != null ? !getTitle().equals(activity.getTitle()) : activity.getTitle() != null) return false;
        if (getPlace() != null ? !getPlace().equals(activity.getPlace()) : activity.getPlace() != null) return false;
        if (getStart() != null ? !getStart().equals(activity.getStart()) : activity.getStart() != null) return false;
        if (getEnd() != null ? !getEnd().equals(activity.getEnd()) : activity.getEnd() != null) return false;
        return !(getDeadline() != null ? !getDeadline().equals(activity.getDeadline()) : activity.getDeadline() != null);

    }

    @Override
    public int hashCode() {
        int result = getActivityId();
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getPlace() != null ? getPlace().hashCode() : 0);
        result = 31 * result + (getStart() != null ? getStart().hashCode() : 0);
        result = 31 * result + (getEnd() != null ? getEnd().hashCode() : 0);
        result = 31 * result + (getDeadline() != null ? getDeadline().hashCode() : 0);
        result = 31 * result + getType();
        return result;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityId=" + activityId +
                ", title='" + title + '\'' +
                ", place='" + place + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", deadline=" + deadline +
                ", type=" + type +
                '}';
    }
}
