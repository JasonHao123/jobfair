package jason.app.jobfair.common.repository;

import jason.app.jobfair.common.BaseTestCase;
import jason.app.jobfair.common.entity.CategoryImpl;

import java.io.FileInputStream;
import java.util.List;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryRepositoryTest extends BaseTestCase{

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
	
	@Test
	public void testFindAll() {
	    List<CategoryImpl> result= repository.findAll();
	    assertNotNull(result);
	    assertEquals(1, result.size());
	}

    @Override
    protected IDataSet getDataSet() throws Exception {
        // TODO Auto-generated method stub
        final FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        builder.setColumnSensing(true);
        return builder.build(this.getClass().getClassLoader()
                .getResourceAsStream("dataset/category/categories.xml"));

    }

}
