package org.dayatang.hrm.organisation.domain;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.CompareToBuilder;

import org.dayatang.domain.ValueObject;

@Embeddable
public class PersonEducationInfo implements ValueObject,
        Comparable<PersonEducationInfo> {

    private static final long serialVersionUID = 4425849994689476079L;

<<<<<<< HEAD
	private Date fromDate;
=======
    private Date fromDate;
>>>>>>> adc9a6bebdbf81e9811bffacadefdd9097ef811f

    private Date toDate;

    private String university;

<<<<<<< HEAD
    @Column(name = "from_date")
	public Date getFromDate() {
		return fromDate;
	}
=======
    @Temporal(TemporalType.DATE)
    public Date getFromDate() {
        return fromDate;
    }
>>>>>>> adc9a6bebdbf81e9811bffacadefdd9097ef811f

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    @Temporal(TemporalType.DATE)
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
