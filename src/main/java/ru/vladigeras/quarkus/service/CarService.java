package ru.vladigeras.quarkus.service;

import java.util.List;
import ru.vladigeras.quarkus.model.dto.Car;
import ru.vladigeras.quarkus.model.dto.CreateCarRequest;

public interface CarService {

	List<Car> get(String name);

	void save(CreateCarRequest createCarRequest);

	void delete(String id);
}
