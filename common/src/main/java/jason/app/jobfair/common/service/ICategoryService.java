package jason.app.jobfair.common.service;

import jason.app.jobfair.common.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> listJobTypes();

    List<Category> listEducationLevels();

    List<Category> findFeatureByPattern(String pattern);

}
