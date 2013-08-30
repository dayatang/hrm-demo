package org.dayatang.hrm.organisation.application;

import java.util.Date;

import org.dayatang.hrm.organisation.domain.Organization;
import org.dayatang.hrm.organisation.domain.Party;
import org.dayatang.hrm.organisation.domain.Post;

public interface OrganisationApplication {
	void createOrganization(Organization orgToCreate, Organization parent,
			Date date);

	void terminateParty(Party party, Date date);

	void changeParentOfOrganization(Organization organization,
			Organization newParent, Date date);

	void createPostUnderOrganization(Post post, Organization organization,
			Date date);
}
