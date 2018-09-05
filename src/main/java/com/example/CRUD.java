package com.example;

import com.example.entity.Department;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("crud")
public class CRUD {

    @GET //1
    @Produces(MediaType.APPLICATION_JSON)
    public List<Department> list() {
        List<Department> dept = new ArrayList<>();
        dept.add(new Department(1L, "dept1"));
        dept.add(new Department(2L, "dept2"));
        return dept;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Department get(@PathParam("id") Long id) {
        return new Department(id, "dept");
    }

    @POST //2
    @Produces(MediaType.APPLICATION_JSON)
    public Department save(@FormParam("name") String name) {
        Department d = new Department(1L, name);
        return d;
    }

    @PUT //3
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Department update(@PathParam("id") Long id, @FormParam("name") String name) {
        Department d = new Department(id, name);
        return d;
    }

    @DELETE //4
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        System.out.println("删除部门：" + id);
    }

}
