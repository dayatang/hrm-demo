package org.dayatang.hrm.organisation.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.CompareToBuilder;

import org.dayatang.domain.ValueObject;

@Embeddable
public class PersonEducationInfo implements ValueObject,
		Comparable<PersonEducationInfo> {

	private static final long serialVersionUID = 4425849994689476079L;

	@Column(name = "from_date")
	private Date fromDate;

	private Date toDate;

	private String university;

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	@Override
	public int compareTo(PersonEducationInfo other) {
		return new CompareToBuilder().append(this.fromDate, other.fromDate)
				.build();
	}

}
