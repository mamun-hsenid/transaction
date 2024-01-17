package com.hsenid.project.transaction.service.UserServiceImpl;

import com.hsenid.project.transaction.exceptionHandler.UserNotFoundException;
import com.hsenid.project.transaction.model.PaymentInfo;
import com.hsenid.project.transaction.model.UserInfo;
import com.hsenid.project.transaction.repository.PaymentReposotry;
import com.hsenid.project.transaction.repository.UserInfoRepository;
import com.hsenid.project.transaction.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Autowired
    private PaymentReposotry paymentReposotry;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void transferBalance(PaymentInfo paymentInfo) {
        paymentInfo.transactionId = UUID.randomUUID().toString();
        Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);
        logger.info("Transaction Id is : "+paymentInfo.transactionId);

        paymentReposotry.save(paymentInfo);

        logger.info("Payment transaction information saved. Details : "+paymentInfo.toString());

        Optional<UserInfo> optionalUser = userInfoRepository.findUserInfoByAccountNumber(paymentInfo.getReceiverAccount());

        optionalUser.ifPresentOrElse(user->{
            user.availableBalance = paymentInfo.getTransactionAmount()+user.availableBalance;
            userInfoRepository.save(user);
        }, ()->{
            throw new UserNotFoundException("User not found");
        });






    }
}
