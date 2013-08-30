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
@DiscriminatorValue("OrgLineMgmt")
@NamedQueries({
		@NamedQuery(name = "getParentOfOrganization", query = "select o.commissioner from OrgLineMgmt o where o.responsible = :organization and o.fromDate <= :date and o.toDate > :date"),
		@NamedQuery(name = "findChildrenOfOrganization", query = "select o.responsible from OrgLineMgmt o where o.commissioner = :organization and o.fromDate <= :date and o.toDate > :date"),
		@NamedQuery(name = "findByResponsible", query = "select o from OrgLineMgmt o where o.responsible = :organization and o.fromDate <= :date and o.toDate > :date") })
public class OrgLineMgmt extends Accountability<Organization, Organization> {

	private static final long serialVersionUID = 7390804525640459582L;

	OrgLineMgmt() {
	}

	public OrgLineMgmt(Organization parent, Organization child, Date date) {
		super(parent, child, date);
	}

	public static Organization getParentOfOrganization(
			Organization organization, Date date) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("organization", organization);
		params.put("date", date);
		List<Organization> companies = getRepository().findByNamedQuery(
				"getParentOfOrganization", params, Organization.class);
		return companies.isEmpty() ? null : companies.get(0);
	}

	public static List<Organization> findChildrenOfOrganization(
			Organization organization, Date date) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("organization", organization);
		params.put("date", date);
		return getRepository().findByNamedQuery("findChildrenOfOrganization",
				params, Organization.class);
	}

	public static List<OrgLineMgmt> findAll() {
		return getRepository().findAll(OrgLineMgmt.class);
	}

	public static OrgLineMgmt getByResponsible(Organization responsible,
			Date date) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("organization", responsible);
		params.put("date", date);
		List<OrgLineMgmt> lineMgmts = getRepository().findByNamedQuery(
				"findByResponsible", params, OrgLineMgmt.class);
		return lineMgmts.isEmpty() ? null : lineMgmts.get(0);
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof OrgLineMgmt)) {
			return false;
		}
		OrgLineMgmt that = (OrgLineMgmt) other;
		return new EqualsBuilder()
				.append(this.getCommissioner(), that.getCommissioner())
				.append(this.getResponsible(), that.getResponsible())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getCommissioner())
				.append(getResponsible()).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(getCommissioner())
				.append(getResponsible()).build();
	}

}
