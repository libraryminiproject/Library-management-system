package com.dxc.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.dxc.model.Newspaper;



public interface NewspapersRepository extends CrudRepository<Newspaper, String> {

	Optional<Newspaper> findByName(String newspapername);

}