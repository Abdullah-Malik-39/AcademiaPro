package com.example.Student;
import org.junit.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StudentModuleTest {
    @Test
    public void testAddStudent() throws SQLException {
        String url = "jdbc:sqlite:C:/Users/AbdullAH Malik/IdeaProjects/AcademiaPro/src/main/resources/Database/AcademiaPro.sqlite";
        Connection conn = DriverManager.getConnection(url);
        StudentDAO studentDAO = new StudentDAOImpl(conn);
        StudentService studentService = new StudentService(studentDAO);

        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("john.doe@example.com");
        student.setPhone("1234567890");
        student.setEnrollmentDate(LocalDate.now());
        student.setProgram("Computer Science");

        studentService.addStudent(student);
        int id = 17;
        // Check if the student was added successfully
        Student addedStudent = studentDAO.getStudent(id);
        assertEquals(student.getFirstName(), addedStudent.getFirstName());
        assertEquals(student.getLastName(), addedStudent.getLastName());
        assertEquals(student.getEmail(), addedStudent.getEmail());
        assertEquals(student.getPhone(), addedStudent.getPhone());
        assertEquals(student.getEnrollmentDate(), addedStudent.getEnrollmentDate());
        assertEquals(student.getProgram(), addedStudent.getProgram());
    }

    @Test
    public void testUpdateStudent() throws SQLException {
        String url = "jdbc:sqlite:C:/Users/AbdullAH Malik/IdeaProjects/AcademiaPro/src/main/resources/Database/AcademiaPro.sqlite";
        Connection conn = DriverManager.getConnection(url);
        StudentDAO studentDAO = new StudentDAOImpl(conn);
        StudentService studentService = new StudentService(studentDAO);

        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("john.doe@example.com");
        student.setPhone("1234567890");
        student.setEnrollmentDate(LocalDate.now());
        student.setProgram("Computer Science");

        studentService.addStudent(student);
        int id = 17;
        // Check if the student was added successfully
        Student addedStudent = studentDAO.getStudent(id);
        assertEquals(student.getFirstName(), addedStudent.getFirstName());
        assertEquals(student.getLastName(), addedStudent.getLastName());
        assertEquals(student.getEmail(), addedStudent.getEmail());
        assertEquals(student.getPhone(), addedStudent.getPhone());
        assertEquals(student.getEnrollmentDate(), addedStudent.getEnrollmentDate());
        assertEquals(student.getProgram(), addedStudent.getProgram());

        // Update the student information
        student.setId(id);
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setEmail("jane.doe@example.com");
        student.setPhone("0987654321");
        student.setProgram("Electronics and Communications Engineering");

        studentService.updateStudent(student);

        // Check if the student information was updated successfully
        Student updatedStudent = studentDAO.getStudent(id);
        assertEquals(student.getFirstName(), updatedStudent.getFirstName());
        assertEquals(student.getLastName(), updatedStudent.getLastName());
        assertEquals(student.getEmail(), updatedStudent.getEmail());
        assertEquals(student.getPhone(), updatedStudent.getPhone());
        assertEquals(student.getProgram(), updatedStudent.getProgram());
    }

    @Test
    public void testDeleteStudent() throws SQLException {
        String url = "jdbc:sqlite:C:/Users/AbdullAH Malik/IdeaProjects/AcademiaPro/src/main/resources/Database/AcademiaPro.sqlite";
        Connection conn = DriverManager.getConnection(url);
        StudentDAO studentDAO = new StudentDAOImpl(conn);
        StudentService studentService = new StudentService(studentDAO);

        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("john.doe@example.com");
        student.setPhone("1234567890");
        student.setEnrollmentDate(LocalDate.now());
        student.setProgram("Computer Science");

        studentService.addStudent(student);
        int id = 18;
        // Check if the student was added successfully
        Student addedStudent = studentDAO.getStudent(id);
        assertEquals(student.getFirstName(), addedStudent.getFirstName());
        assertEquals(student.getLastName(), addedStudent.getLastName());
        assertEquals(student.getEmail(), addedStudent.getEmail());
        assertEquals(student.getPhone(), addedStudent.getPhone());
        assertEquals(student.getEnrollmentDate(), addedStudent.getEnrollmentDate());
        assertEquals(student.getProgram(), addedStudent.getProgram());

        // Delete the student
        studentService.deleteStudent(id);

        // Check if the student was deleted successfully
        Student deletedStudent = studentDAO.getStudent(id);
        assertNull(deletedStudent);
    }
}
