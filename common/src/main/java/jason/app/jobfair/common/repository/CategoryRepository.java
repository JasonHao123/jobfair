package jason.app.jobfair.common.repository;

import jason.app.jobfair.common.constant.CategoryType;
import jason.app.jobfair.common.entity.CategoryImpl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<CategoryImpl, Long>{
    
    public List<CategoryImpl> findByType(CategoryType type);
    
    public List<CategoryImpl> findByTypeAndNameLike(CategoryType type,String pattern);
}
