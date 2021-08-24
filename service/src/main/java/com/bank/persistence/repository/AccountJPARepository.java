package com.bank.persistence.repository;

import com.bank.persistence.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AccountJPARepository extends JpaRepository<AccountEntity, Long> {
    @Query(value = "SELECT ACCOUNT.ID FROM ACCOUNT WHERE ACCOUNT.CODE = ?1", nativeQuery = true)
    Long findIdByCode(String code);
}
