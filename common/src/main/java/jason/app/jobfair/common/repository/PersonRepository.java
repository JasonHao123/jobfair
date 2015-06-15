package jason.app.jobfair.common.repository;

import jason.app.jobfair.common.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
