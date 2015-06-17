package jason.app.jobfair.common.service.impl;

import jason.app.jobfair.common.BaseTestCase;
import jason.app.jobfair.common.model.Category;
import jason.app.jobfair.common.service.ICategoryService;

import java.util.List;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImplTest extends BaseTestCase{

	@Autowired
	private ICategoryService categoryService;
	@Test
	public void testListJobTypes() {
		List<Category> types = categoryService.listJobTypes();
		assertNotNull(types);
		assertEquals(1,types.size());
	}

	@Test
	public void testListEducationLevels() {
		List<Category> types = categoryService.listEducationLevels();
		assertNotNull(types);
		assertEquals(1,types.size());
	}

	@Test
	public void testFindFeatureByPatternFound() {
		List<Category> types = categoryService.findFeatureByPattern("hel");
		assertNotNull(types);
		assertEquals(1,types.size());
	}
	
	@Test
	public void testFindFeatureByPatternNotFound() {
		List<Category> types = categoryService.findFeatureByPattern("ell");
		assertNotNull(types);
		assertEquals(0,types.size());
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
        final FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        builder.setColumnSensing(true);
        return builder.build(this.getClass().getClassLoader().getResourceAsStream("dataset/category/categories.xml"));

	}

}
