package com.bank.persistence.repository;

import com.bank.persistence.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ClientJPARepository extends JpaRepository<ClientEntity,Long> {
}
