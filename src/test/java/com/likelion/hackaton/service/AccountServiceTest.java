package com.likelion.hackaton.service;

import com.likelion.hackaton.entity.Account;
import com.likelion.hackaton.entity.City;
import com.likelion.hackaton.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
/**
 *  Account 테스트
 *  요구사항 :
 *  1. 회원가입 성공 여부 확인
 *  2. 회원가입 할때 중복된 이메일 이라면 예외 발생
 *  3. 로그인 성공 여부 확인
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void 회원가입() throws Exception{
        // given
        City city = City.builder()
                .name("Seoul")
                .build();

        Account account = Account.builder()
                .city(city)
                .email("test@email.com")
                .password("test_password")
                .name("test_user")
                .build();

        // when
        Long id = accountService.join(account);


        // then
        assertEquals(account,accountRepository.findById(id));
    }

    @Test
    public void 중복_회원_예외() throws Exception{
        // given
        // when
        // then
    }

}