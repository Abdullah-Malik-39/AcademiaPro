package com.example.Student;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    private final Connection connection;

    public StudentDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addStudent(Student student) {
        String query = "INSERT INTO students (first_name, last_name, email, phone, enrollment_date, program) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getEmail());
            statement.setString(4, student.getPhone());
            statement.setString(5, student.getEnrollmentDate().toString());
            statement.setString(6, student.getProgram());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student getStudent(int id) {
        String query = "SELECT * FROM students WHERE id = ?";
        Student student = null;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                int studentId = result.getInt("id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String email = result.getString("email");
                String phone = result.getString("phone");
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate enrollmentDate = LocalDate.parse( result.getString("enrollment_date")) ;
                String program = result.getString("program");
                student = new Student(studentId, firstName, lastName, email, phone, enrollmentDate, program);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        String query = "SELECT * FROM students";
        List<Student> students = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String email = result.getString("email");
                String phone = result.getString("phone");
                LocalDate enrollmentDate = LocalDate.parse( result.getString("enrollment_date")) ;
                String program = result.getString("program");
                Student student = new Student(id, firstName, lastName, email, phone, enrollmentDate, program);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void updateStudent(Student student) {
        String query = "UPDATE students SET first_name = ?, last_name = ?, email = ?, phone = ?, enrollment_date = ?, program = ? " +
                "WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getEmail());
            statement.setString(4, student.getPhone());
            statement.setString(5, student.getEnrollmentDate().toString());
            statement.setString(6, student.getProgram());
            statement.setInt(7, student.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
