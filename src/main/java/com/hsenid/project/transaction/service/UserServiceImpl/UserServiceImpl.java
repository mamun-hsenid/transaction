package com.hsenid.project.transaction.service.UserServiceImpl;

import com.hsenid.project.transaction.model.UserInfo;
import com.hsenid.project.transaction.repository.UserInfoRepository;
import com.hsenid.project.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserInfoRepository userInfoRepository;
    @Override
    public void addUser(UserInfo user) {
        userInfoRepository.save(user);
    }
}
