package org.dayatang.hrm.organisation.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@DiscriminatorValue("PostHolding")
@NamedQueries({
		@NamedQuery(name = "getPostsOfEmployee", query = "select o.commissioner from PostHolding o where o.responsible = :employee and o.fromDate <= :date and o.toDate > :date"),
		@NamedQuery(name = "getEmployeesOfPost", query = "select o.responsible from PostHolding o where o.commissioner = :post and o.fromDate <= :date and o.toDate > :date") })
public class PostHolding extends Accountability<Post, Employee> {

	private static final long serialVersionUID = 7390804525640459582L;

	PostHolding() {
	}

	public PostHolding(Post post, Employee employee, Date date) {
		super(post, employee, date);
	}

	public static List<Post> findPostsOfEmployee(Employee employee, Date date) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("employee", employee);
		params.put("date", date);
		return getRepository().findByNamedQuery("getPostsOfEmployee", params,
				Post.class);
	}

	public static List<Employee> findEmployeesOfPost(Post post, Date date) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("post", post);
		params.put("date", date);
		return getRepository().findByNamedQuery("getEmployeesOfPost", params,
				Employee.class);
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof PostHolding)) {
			return false;
		}
		PostHolding that = (PostHolding) other;
		return new EqualsBuilder()
				.append(this.getCommissioner(), that.getCommissioner())
				.append(this.getResponsible(), that.getResponsible())
				.append(this.getFromDate(), that.getFromDate()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getCommissioner())
				.append(getResponsible()).append(getFromDate()).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(getCommissioner())
				.append(getResponsible()).build();
	}

}
