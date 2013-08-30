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
@DiscriminatorValue("Employment")
@NamedQueries({
		@NamedQuery(name = "getEmployer", query = "select o.commissioner from Employment o where o.responsible = :employee and o.fromDate <= :date and o.toDate > :date"),
		@NamedQuery(name = "getEmployees", query = "select o.responsible from Employment o where o.commissioner = :employer and o.fromDate <= :date and o.toDate > :date") })
public class Employment extends Accountability<Company, Employee> {

	private static final long serialVersionUID = 7390804525640459582L;

	Employment() {
	}

	public Employment(Company company, Employee employee, Date date) {
		super(company, employee, date);
	}

	public static Company getEmployer(Employee employee, Date date) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("employee", employee);
		params.put("date", date);
		List<Company> companies = getRepository().findByNamedQuery(
				"getEmployer", params, Company.class);
		return companies.isEmpty() ? null : companies.get(0);
	}

	public static List<Employee> getEmployees(Company employer, Date date) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("employer", employer);
		params.put("date", date);
		return getRepository().findByNamedQuery("getEmployees", params,
				Employee.class);
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Employment)) {
			return false;
		}
		Employment that = (Employment) other;
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
