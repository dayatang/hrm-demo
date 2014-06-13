package org.dayatang.hrm.organisation.domain;

import org.dayatang.hrm.organisation.utils.OrganisationUtils;
import org.dayatang.utils.DateUtils;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by yyang on 14-6-12.
 */


public class OrganizationTest extends AbstractIntegrationTest {

    @Test
    public final void listChildCompanies() {
        OrganisationUtils organisationUtils = new OrganisationUtils();
        Date date = DateUtils.date(2012, 1, 3);
        Company headquarter = organisationUtils.createCompany("总公司", date);
        headquarter.save();
        Department financial = organisationUtils.createDepartment("财务部", headquarter, date);
        Company company1 = organisationUtils.createCompany("分公司1", headquarter, date);
        Company company2 = organisationUtils.createCompany("分公司2", company1, date);

        List<Company> companies = headquarter.listChildCompanies();

        assertTrue(companies.contains(company1));
        assertFalse(companies.contains(company2));
        assertFalse(companies.contains(financial));
    }

    @Test
    public final void listChildDepartments() {
        OrganisationUtils organisationUtils = new OrganisationUtils();
        Date date = DateUtils.date(2012, 1, 3);
        Company headquarter = organisationUtils.createCompany("总公司", date);
        headquarter.save();
        Department financial = organisationUtils.createDepartment("财务部", headquarter, date);
        Company company1 = organisationUtils.createCompany("分公司1", headquarter, date);
        Department dept1 = organisationUtils.createDepartment("核算科", financial, date);
        Department dept2 = organisationUtils.createDepartment("财务部2", company1, date);

        List<Department> departments = headquarter.listChildDepartments();

        assertTrue(departments.contains(financial));
        assertFalse(departments.contains(company1));
        assertFalse(departments.contains(dept1));
        assertFalse(departments.contains(dept2));
    }

}
