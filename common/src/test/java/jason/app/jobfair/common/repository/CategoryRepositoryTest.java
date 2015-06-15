package jason.app.jobfair.common.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import jason.app.jobfair.common.entity.CategoryImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
@ContextConfiguration(locations="classpath:META-INF/test-context.xml")
public class CategoryRepositoryTest {

	@Autowired
	CategoryRepository repository;
	
	@Test
	public void test() {
	    String categoryName = "jason";
		CategoryImpl post = new CategoryImpl();
		post.setName(categoryName);
		repository.save(post);
		
		CategoryImpl dbpost = repository.findOne(post.getId());
		assertNotNull(dbpost);
		assertEquals(categoryName, dbpost.getName());
		
	}

}
