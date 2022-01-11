package com.example.demo.school;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataGenerator {
    public static DataGenerator INSTANCE;

    private List<Student> students;
    private ClassContainer classContainer;
    private Map<String, String> credentials;
    private Map<String, String> privileges;

    /*
    public static DataGenerator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataGenerator();
            INSTANCE.setStudents(new ArrayList<>());
            INSTANCE.setClassContainer(new ClassContainer());
            generateData(4, 25, 30);

        }
        return INSTANCE;
    }

    public static void generateData(int numOfGroups, int numOfStudentsPerGroup, int maxNumberOfStudents) {
        INSTANCE.privileges = new HashMap<>();
        INSTANCE.credentials = new HashMap<>();
        INSTANCE.credentials.put("admin", "123");
        INSTANCE.privileges.put("admin", "admin");
        for (int i = 0; i < numOfGroups; i++) {
            Class cls = new Class("Class"+i, maxNumberOfStudents);
            for (int j = 0; j < numOfStudentsPerGroup; j++) {
                List<Integer> marks = new ArrayList<>();
                marks.add(1);
                marks.add(1);
                marks.add(1);

            }
            INSTANCE.classContainer.addClass(cls);
        }
    }

    public void loadCredentialsAndPrivileges() {
        for (Class cls : INSTANCE.classContainer.getGroups().values()) {
            for (Student student : cls.getStudents()) {
                INSTANCE.credentials.put(student.getName(), "123");
                INSTANCE.privileges.put(student.getName(), "student");
            }
        }
    }

    public static DataGenerator getINSTANCE() {
        return INSTANCE;
    }

    public static void setINSTANCE(DataGenerator INSTANCE) {
        DataGenerator.INSTANCE = INSTANCE;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setClassContainer(ClassContainer classContainer) {
        this.classContainer = classContainer;
    }

    public List<Student> getStudents() {
        return students;
    }

    public ClassContainer getClassContainer() {
        return classContainer;
    }

    public Map<String, String> getCredentials() {
        return credentials;
    }

    public Map<String, String> getPrivileges() {
        return privileges;
    }
     */
}
