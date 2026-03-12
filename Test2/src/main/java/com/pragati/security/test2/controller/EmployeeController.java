package com.pragati.security.test2.controller;

import com.pragati.security.test2.model.Employee;
import com.pragati.security.test2.service.EmployeeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeController {

    @Inject
    private EmployeeService service;

    @POST
    public Response create(Employee employee) {
        return Response.ok(service.create(employee)).build();
    }

    @GET
    public List<Employee> getAll() {
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        Employee emp = service.getById(id);
        if (emp == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(emp).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Employee employee) {
        Employee updated = service.update(id, employee);
        if (updated == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        if (!service.delete(id))
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok().build();
    }
}
