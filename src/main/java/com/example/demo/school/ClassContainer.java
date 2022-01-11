package com.example.demo.school;


import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ClassContainer {
    private final Map<String, Class> groups;

    public ClassContainer() {
        this.groups = new LinkedHashMap<>();
    }

    public void addClass(Class cls) {
        groups.put(cls.getName(), cls);
    }

    public void remove(String name) {
        groups.remove(name);
    }

    public Map<String, Class> getGroups() {
        return this.groups;
    }

    public List<Class> findEmpty() {
        Collection<Class> classes = groups.values();
        return List.of();
    }

    /*
    public void summary() {

        System.out.println("Groups summary:");
        for (Map.Entry<String, Class> pair : groups.entrySet()) {
            System.out.printf("com.example.labfx.school.Class name: %s\n", pair.getKey());
            System.out.printf("%d%% fill\n", (int)(100 * ((double)pair.getValue().getGroupSize() / pair.getValue().getMaxNumberOfStudents())));
        }
    }

     */
}
