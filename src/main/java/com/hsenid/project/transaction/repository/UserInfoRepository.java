package com.hsenid.project.transaction.repository;

import com.hsenid.project.transaction.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    UserInfo save(UserInfo user);

    Optional<UserInfo> findUserInfoByAccountNumber(Long accountNumber);
}
