package org.dayatang.hrm.organisation.domain;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dayatang.domain.EntityRepository;
import com.dayatang.domain.InstanceFactory;

public class PersonTest extends AbstractIntegrationTest {
	
	private Person person1;
	private Person person2;

	@Before
	public void setUp() throws Exception {
		person1 = new Person();
		person1.setIdNumber("p1");
		person1.setIm(ImType.QQ, "349591542");
		person1.setIm(ImType.MSN, "cnyangyu@hotmail.com");
		person1.save();
		
		person2 = new Person();
		person2.setIdNumber("p2");
		person2.setIm(ImType.QQ, "666666");
		person2.setIm(ImType.MSN, "ryyang@hotmail.com");
		person2.save();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetIms() {
		String jpql = "select o from Person o join o.ims i where KEY(i) = :imType and i = :im";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("imType", ImType.QQ);
		params.put("im", "666666");
		List<Person> persons = InstanceFactory.getInstance(EntityRepository.class).find(jpql, params, Person.class);
		assertFalse(persons.contains(person1));
		assertTrue(persons.contains(person2));
	}

}
