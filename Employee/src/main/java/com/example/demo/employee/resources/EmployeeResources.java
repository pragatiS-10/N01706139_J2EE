package com.example.demo.employee.resources;

import com.example.demo.employee.model.Employee;
import com.example.demo.employee.services.EmployeeServices;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResources {
    @Inject
    EmployeeServices employeeServices;

    @GET
    public Response getAllEmployees(){
        return Response.ok(employeeServices.getAllEmployees()).build();
    }

    @GET
    @Path("/{id}")
    public Response getEmployeeById(@PathParam("id") int id){
        return Response.ok(employeeServices.getEmployeeById(id)).build();
    }

    @POST
    public Response addEmployee(Employee employee){
        employeeServices.addEmployee(employee);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    public Response updateEmployee(Employee employee, @PathParam("id") int id){
        employeeServices.updateEmployee(employee, id);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEmployee(@PathParam("id") int id){
        employeeServices.deleteEmployee(employeeServices.getEmployeeById(id));
        return Response.ok().build();
    }
}
