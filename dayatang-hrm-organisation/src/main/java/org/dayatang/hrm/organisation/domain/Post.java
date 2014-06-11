package org.dayatang.hrm.organisation.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@DiscriminatorValue("Post")
@NamedQueries(
        @NamedQuery(name = "Party.findByOrganization", query = "select o from Post o where o.organization = :organization and o.createDate <= :date and o.terminateDate > :date"))
public class Post extends Party {

<<<<<<< HEAD
	private static final long serialVersionUID = -2205967098970951498L;

	private Organization organization;

	private Job job;

	public Post() {
		super();
	}

	public Post(String name) {
		super(name);
	}

    @ManyToOne
    @JoinColumn(name = "org_id")
	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

    @ManyToOne
    @JoinColumn(name = "job_id")
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public static List<Post> findByOrganization(Organization organization,
			Date date) {
		return getRepository().createNamedQuery("Party.findByOrganization")
				.addParameter("organization", organization).addParameter("date", date).list();
	}

	public Set<Employee> getEmployees(Date date) {
		return new HashSet<Employee>(PostHolding.findEmployeesOfPost(this, date));
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Post)) {
			return false;
		}
		Post that = (Post) other;
		return new EqualsBuilder().append(this.getSn(), that.getSn())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getSn()).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(getName()).build();
	}
=======
    private static final long serialVersionUID = -2205967098970951498L;

    private Organization organization;

    private Job job;

    public Post() {
        super();
    }

    public Post(String name) {
        super(name);
    }

    @ManyToOne
    @JoinColumn(name = "org_id")
    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @ManyToOne
    @JoinColumn(name = "job_id")
    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public static List<Post> findByOrganization(Organization organization,
            Date date) {
        return getRepository().createNamedQuery("Party.findByOrganization")
                .addParameter("organization", organization).addParameter("date", date).list();
    }

    public Set<Employee> getEmployees(Date date) {
        return new HashSet<Employee>(PostHolding.findEmployeesOfPost(this, date));
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append(getName()).build();
    }
>>>>>>> adc9a6bebdbf81e9811bffacadefdd9097ef811f

}
