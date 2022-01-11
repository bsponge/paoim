package com.example.demo.repo;


import com.example.demo.school.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassRepository extends JpaRepository<Class, Long> {
    @Query("SELECT CASE WHEN COUNT(c) = :size THEN TRUE ELSE FALSE END " +
            "FROM Class c WHERE c.id IN :courseIds AND SIZE(c.students) < c.maxNumberOfStudents-1")
    boolean allExistAndHaveFreeSpace(@Param("courseIds") List<Long> courseIds, @Param("size") long size);
}
