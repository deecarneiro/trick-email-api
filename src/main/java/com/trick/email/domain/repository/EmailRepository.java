package com.trick.email.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.trick.email.domain.enums.STATUS;
import com.trick.email.domain.model.Email;
import com.trick.email.domain.model.EmailPropertiesAndContent;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
	
	List<Email> findByidUser(long idUser);
	List<Email> findBystatus(STATUS status);

	@Query(value = "SELECT e FROM Email as e WHERE (:inputString is null or e.subject like :inputString ) or " +
            "(:inputString is null or e.body like :inputString) or (:inputString is null or e.assignment like :inputString) or"+
            "(:inputString is null or e.label like :inputString)"
    )
    List<EmailPropertiesAndContent> findAllByInputString( String inputString);

}
