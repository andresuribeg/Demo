package com.ejemplo.backend.repository;

import com.example.demo.model.UploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadEntityRepository extends JpaRepository<UploadEntity, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
