package com.patriciocontreras.sistemausuarios.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patriciocontreras.sistemausuarios.entity.Contact;
//se pone como parametro primero con que clase va a trabajar jpa
@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<Contact, Serializable> {

	
}
