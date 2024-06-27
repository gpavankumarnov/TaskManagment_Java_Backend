package com.example.project.repository;
import com.example.project.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TaskManagementRepository extends JpaRepository<Tasks, Long> {
}
