package ru.vladigeras.quarkus.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.vladigeras.quarkus.model.dto.Car;
import ru.vladigeras.quarkus.model.dto.CreateCarRequest;
import ru.vladigeras.quarkus.model.entity.CarEntity;

@Mapper
public interface CarMapper {

	@Mapping(target = "id", source = "id")
	@Mapping(target = "createdAt", source = "createdAt")
	@Mapping(target = "name", source = "name")
	@Mapping(target = "price", source = "price")
	@BeanMapping(ignoreByDefault = true)
	Car map(CarEntity car);

	@Mapping(target = "name", source = "name")
	@Mapping(target = "price", source = "price")
	@BeanMapping(ignoreByDefault = true)
	CarEntity map(CreateCarRequest car);
}
