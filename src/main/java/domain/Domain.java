package domain;

import bl.HibernateUtil;
import entity.Address;
import entity.Employee;
import entity.Project;
import service.AddressService;
import service.EmployeeService;
import service.ProjectService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Domain {

    public static void main(String[] args) throws SQLException {

        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();

        Address address = new Address();
        address.setCountry("France");
        address.setCity("Paris");
        address.setStreet("Kotova");
        address.setPostCode("222221");

        Project project = new Project();
        project.setTitle("Big boss");

        Employee employee = new Employee();
        employee.setFirstName("Zinedin");
        employee.setLastName("Zidan");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1970,Calendar.MAY,6);
        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Set<Employee> employees = new HashSet<Employee>();
        employees.add(employee);
        project.setEmployees(employees);

        Set<Project>projects = new HashSet<Project>();
        projects.add(project);
        employee.setProjects(projects);

        addressService.add(address);
        projectService.add(project);
        employeeService.add(employee);

        HibernateUtil.shutdown();

    }






}
