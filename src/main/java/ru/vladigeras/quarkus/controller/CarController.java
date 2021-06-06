package ru.vladigeras.quarkus.controller;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import ru.vladigeras.quarkus.model.dto.Car;
import ru.vladigeras.quarkus.model.dto.CreateCarRequest;
import ru.vladigeras.quarkus.service.CarService;

@RequiredArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/api/v1/cars")
public class CarController {

	private final CarService carService;

	@GET
	public List<Car> get(@QueryParam("name") String name) {
		return carService.get(name);
	}

	@POST
	public void save(CreateCarRequest createCarRequest) {
		carService.save(createCarRequest);
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") String id) {
		carService.delete(id);
	}
}