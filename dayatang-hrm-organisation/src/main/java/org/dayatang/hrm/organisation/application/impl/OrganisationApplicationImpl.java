package org.dayatang.hrm.organisation.application.impl;

import java.util.Date;

import org.dayatang.hrm.organisation.application.OrganisationApplication;
import org.dayatang.hrm.organisation.domain.OrgLineMgmt;
import org.dayatang.hrm.organisation.domain.Organization;
import org.dayatang.hrm.organisation.domain.Party;
import org.dayatang.hrm.organisation.domain.Post;

public class OrganisationApplicationImpl implements OrganisationApplication {

	@Override
	public void createOrganization(Organization orgToCreate,
			Organization parent, Date date) {
		orgToCreate.setCreateDate(date);
		orgToCreate.save();
		new OrgLineMgmt(parent, orgToCreate, date).save();
	}

	@Override
	public void terminateParty(Party party, Date date) {
		party.terminate(date);

	}

	@Override
	public void changeParentOfOrganization(Organization organization,
			Organization newParent, Date date) {
		OrgLineMgmt.getByResponsible(organization, date).terminate(date);
		new OrgLineMgmt(newParent, organization, date).save();
	}

	@Override
	public void createPostUnderOrganization(Post post,
			Organization organization, Date date) {
		post.setOrganization(organization);
		post.setCreateDate(date);
		post.save();
	}

}
