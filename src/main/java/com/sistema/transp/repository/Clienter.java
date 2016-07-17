package com.sistema.transp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.sistema.transp.model.Cliente;

public interface Clienter extends CrudRepository<Cliente, Long>{

}
