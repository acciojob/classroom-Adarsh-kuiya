package com.driver;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class StudentRepository {
    private HashMap<String,Student>studentDb;
    private HashMap<String,Teacher>teacherDB;
    private HashMap<String,String>studentTeacherDb;

    public StudentRepository(){
    studentDb=new HashMap<>();
    teacherDB=new HashMap<>();
    studentTeacherDb=new HashMap<>();
    }
    public void addStudent(Student student){
      studentDb.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher){
      teacherDB.put(teacher.getName(),teacher);
    }

    public void addStudentTeacherPair(String student, String teacher){
        studentTeacherDb.put(student, teacher);
    }

    public Student getStudentByName(String studentName){
        return studentDb.get(studentName);
    }

    public Teacher getTeacherByName(String teacherName){
      return  teacherDB.get(teacherName);
    }

    public List<String> getStudentsByTeacherName(String teacherName){
        List<String> studentList = new ArrayList<>();
        for (String student : studentTeacherDb.keySet()) {
            if (studentTeacherDb.get(student).equals(teacherName)) {
                studentList.add(student);
            }
        }

        return studentList;
    }
    public List<String> getAllStudents(){
    return new ArrayList<>(studentDb.keySet());
    }

    public void delete_teacher_by_name(String teacherName){
        if(teacherDB.containsKey(teacherName))
        teacherDB.remove(teacherName);
    }

    public void deleteAllTeachers(){
      teacherDB.clear();
    }


}
