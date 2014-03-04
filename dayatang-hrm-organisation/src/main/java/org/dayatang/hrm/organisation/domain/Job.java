package org.dayatang.hrm.organisation.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@DiscriminatorValue("Job")
public class Job extends Party {

	private static final long serialVersionUID = -5433410950032866468L;

    @Override
    public String[] businessKeys() {
        return new String[] {"sn"};
    }

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(getName()).build();
	}

}
