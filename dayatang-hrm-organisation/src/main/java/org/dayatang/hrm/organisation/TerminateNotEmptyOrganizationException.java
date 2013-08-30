package org.dayatang.hrm.organisation;

import org.dayatang.hrm.HrException;

public class TerminateNotEmptyOrganizationException extends HrException {

	private static final long serialVersionUID = 3374491448887378505L;

	public TerminateNotEmptyOrganizationException() {
	}

	public TerminateNotEmptyOrganizationException(String message) {
		super(message);
	}

	public TerminateNotEmptyOrganizationException(Throwable cause) {
		super(cause);
	}

	public TerminateNotEmptyOrganizationException(String message,
			Throwable cause) {
		super(message, cause);
	}

}
