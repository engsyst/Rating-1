package net.ua.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PlannedWork implements Serializable {

	private static final long serialVersionUID = -6149382721437811060L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int plannedWorkId;

	@ManyToOne
	@JoinColumn(name = "CategoryId", nullable = false)
	private int categoryId;

	@Column(name = "HoursCount")
	private double hoursCount;

	@ManyToOne
	@JoinColumn(name = "DisciplineId", nullable = false)
	private int disciplineId;

	@ManyToOne
	@JoinColumn(name = "PlanId", nullable = false)
	private int planId;

	@Override
	public String toString() {
		return "PlannedWork{" + "plannedWorkId=" + plannedWorkId + ", categoryId=" + categoryId + ", hoursCount"
				+ hoursCount + ", disciplineId" + disciplineId + ", planId" + planId + "}";
	}
}
