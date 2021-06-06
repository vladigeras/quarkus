package ru.vladigeras.quarkus.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vladigeras.quarkus.model.entity.CarEntity;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, String> {

	@Query(value = "SELECT c FROM CarEntity c WHERE c.name LIKE CONCAT('%',:name,'%')")
	List<CarEntity> findByName(@Param("name") String name);
}
