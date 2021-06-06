package ru.vladigeras.quarkus.service.impl;

import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;
import java.util.List;
import javax.inject.Singleton;
import lombok.RequiredArgsConstructor;
import ru.vladigeras.quarkus.mapper.CarMapper;
import ru.vladigeras.quarkus.model.dto.Car;
import ru.vladigeras.quarkus.model.dto.CreateCarRequest;
import ru.vladigeras.quarkus.repository.CarRepository;
import ru.vladigeras.quarkus.service.CarService;

@RequiredArgsConstructor
@Singleton
public class CarServiceImpl implements CarService {

	private final CarRepository carRepository;
	private final CarMapper carMapper;

	@Override
	public List<Car> get(String name) {
		var result = nonNull(name) ? carRepository.findByName(name)
			: carRepository.findAll();
		return result.stream().map(carMapper::map).collect(toList());
	}

	@Override
	public void save(CreateCarRequest createCarRequest) {
		carRepository.save(carMapper.map(createCarRequest));
	}

	@Override
	public void delete(String id) {
		carRepository.deleteById(id);
	}
}
