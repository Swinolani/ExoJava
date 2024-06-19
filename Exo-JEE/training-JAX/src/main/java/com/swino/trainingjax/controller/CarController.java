package com.swino.trainingjax.controller;

import com.swino.trainingjax.classe.Car;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/cars")
public class CarController {

    @GET
    @Path("/one")
    @Produces(MediaType.APPLICATION_JSON)
    public Car getCar() {
        return new Car(1,"Toyota",2018,"Red");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1,"Toyota",2018,"Red"));
        cars.add(new Car(2,"Honda",2019,"Blue"));
        cars.add(new Car(3,"Ford",2020,"Black"));
        return cars;
    }
}
