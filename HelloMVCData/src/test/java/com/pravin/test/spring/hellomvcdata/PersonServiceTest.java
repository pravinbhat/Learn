/**
 * 
 */
package com.pravin.test.spring.hellomvcdata;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import com.pravin.learn.spring.hellomvcdata.model.Person;
import com.pravin.learn.spring.hellomvcdata.service.PersonService;

/**
 * @author bhatp
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		loader=AnnotationConfigContextLoader.class,
		classes = {PersonService.class})
public class PersonServiceTest {
	
	@Autowired
	private PersonService personService;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("In setUpBeforeClass !");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("In setUpBeforeClass !");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("In setUpBeforeClass !");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("In setUpBeforeClass !");
	}

	/**
	 * Test method for {@link com.pravin.learn.spring.hellomvcdata.service.PersonService#addPerson(com.pravin.learn.spring.hellomvcdata.model.Person)}.
	 */
	@Test
	public void testAddPerson() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pravin.learn.spring.hellomvcdata.service.PersonService#listPerson()}.
	 */
	@Test
	public void testListPerson() {
		assertNotNull("Service class is not yet initialized", personService);
		List <Person> list = personService.listPerson();
		assertTrue((null != list && list.size() > 0));
		
	}

	/**
	 * Test method for {@link com.pravin.learn.spring.hellomvcdata.service.PersonService#searchPerson(java.lang.String)}.
	 */
	@Test
	public void testSearchPerson() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pravin.learn.spring.hellomvcdata.service.PersonService#deletePerson(com.pravin.learn.spring.hellomvcdata.model.Person)}.
	 */
	@Test
	public void testDeletePerson() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.pravin.learn.spring.hellomvcdata.service.PersonService#updatePerson(com.pravin.learn.spring.hellomvcdata.model.Person)}.
	 */
	@Test
	public void testUpdatePerson() {
		fail("Not yet implemented");
	}

}
