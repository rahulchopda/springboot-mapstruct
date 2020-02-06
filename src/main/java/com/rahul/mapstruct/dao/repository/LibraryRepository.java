package com.rahul.mapstruct.dao.repository;

import com.rahul.mapstruct.dao.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LibraryRepository extends JpaRepository<Library, UUID> {

}
