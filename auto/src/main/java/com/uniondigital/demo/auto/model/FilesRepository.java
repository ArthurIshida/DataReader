package com.uniondigital.demo.auto.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uniondigital.demo.auto.model.UploadedFiles;

public interface FilesRepository extends JpaRepository<UploadedFiles, Long>{
	UploadedFiles findByName(String name);
}
