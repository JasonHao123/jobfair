package jason.app.jobfair.common.service.impl;

import jason.app.jobfair.common.model.Category;
import jason.app.jobfair.common.repository.CategoryRepository;
import jason.app.jobfair.common.service.ICategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepo;

    public List<Category> listJobTypes() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Category> listEducationLevels() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Category> findFeatureByPattern(String pattern) {
        // TODO Auto-generated method stub
        return null;
    }


}