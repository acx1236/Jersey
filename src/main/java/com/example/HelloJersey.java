package com.example;

import com.example.entity.Department;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("hello")
public class HelloJersey {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String index() {
        return "Hello  Jersey !";
    }

    /**
     * Produces -> 返回的数据类型
     * Consumes -> 接收的数据类型
     */

    @GET
    @Path("m1")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello,I am text!";
    }

    @POST
    @Path("m2")
    @Produces(MediaType.TEXT_XML)
    public String sayXMLHello() {
        return "<?xml version=\"1.0\"?>" + "<hello> Hello,I am xml!" + "</hello>";
    }

    @GET
    @Path("{id}")
    public String pathParamId(@PathParam("id") Long id) {
        System.out.println(id);
        return "success";
    }

    @GET
    @Path("{year}/{month}/{day}")
    public String pathParamName(@PathParam("year") String year, @PathParam("month") String month, @PathParam("day") String day) {
        return year + "年" + month + "月" + "日";
    }

    @GET
    @Path("json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Department> json() {
        List<Department> dept = new ArrayList<>();
        dept.add(new Department(1L, "dept1"));
        dept.add(new Department(2L, "dept2"));
        return dept;
    }

    @GET
    @Path("xml")
    @Produces(MediaType.APPLICATION_XML)
    public List<Department> xml() {
        List<Department> dept = new ArrayList<>();
        dept.add(new Department(1L, "dept1"));
        dept.add(new Department(2L, "dept2"));
        return dept;
    }

    @GET
    @Path("list")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Department> list() {
        List<Department> dept = new ArrayList<>();
        dept.add(new Department(1L, "dept1"));
        dept.add(new Department(2L, "dept2"));
        return dept;
    }

}