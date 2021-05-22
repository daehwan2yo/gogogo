package com.likelion.hackaton.service;

import com.likelion.hackaton.entity.Account;
import com.likelion.hackaton.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {

    /**
     * 필드 인젝션
     * @Autowired
     *
     */

    /**
     * setter injection
     * 스프링이 바로 주입하는게 아니라, 매개변수를 통해 주입이됨
     *
     * 장점 : 앱실행 중간에 다른 객체를 주입 가능 / 테스트 할때 Mock을 직접 주입가능, 가짜 객체를 주입할수 있음
     * 단점 : 앱실행과 스프링이 올라오는 타이밍에 이미 객체간 주입관계가 다 정해짐,
     *      동작이 잘 되고 있는데 바꿀 필요가 없음
     * ---------------------------------------------------------------------------------
     * private MemberRepository memberRepository;
     *
     * @Autowired
     * public void setMemberRepository(MemberRepository memberRepository){
     *     this.memeberRepository = memberRepository;
     * }
     *------------------------------------------------------------------------------------
     *
     *  앱 실행 도중에 주입 객체를 바꾸는 일은 드물고, 추천하지 않기 때문에
     *
     *  Constructor injection 생성자 인잭션 을 추천
     *  스프링이 실행될때 생성자에서 이를 주입시킨다.
     *
     *  ---------------------------------------------------------------------------------
     *  private MemberRepository memberRepository;
     *
     *  @Autowired
     *  public MemberRepository(MemberRepository memberRepository){
     *      this.memberRepository = memberRepository;
     *  }
     *  ---------------------------------------------------------------------------------
     *
     *
     *   롬복 어노테이션을 활용
     *   @AllArgsConstructor
     *   @RequiredArgsConstructor  (final만)
     */


    /**
     *  final의 이유
     *  : 컴파일 시점에 주입이 되었는지 확인을 할수 있다.
     *  (주입이 안된 경우, 빨간줄 에러)
     */
    private final AccountRepository accountRepository;

    // 회원가입
    public Long join(Account account){

        // 중복 확인
        // 문제가 있다면 exception
        validateDuplicateAccount(account);

        accountRepository.save(account);

        return account.getId();
    }

    private void validateDuplicateAccount(Account account) {
        // 유니크 조건을 통해 멀티 쓰레드등에서의 동시성을 방지할수 있음
        accountRepository.findByEmail(account.getEmail()).ifPresent(ac -> new IllegalStateException("이미 존재하는 회원입니다."));
    }

    // 로그인
    public void login(String email, String password){
        Account account = accountRepository.findByEmail(email).orElseThrow(()->new IllegalStateException("존재하지 않는 회원입니다."));
        if(account.getPassword() == password){
            // 로그인 과정
        }
    }

    /**
     * @Transactional
     * Service 외부에서 선언하면 public 은 전부 들어가짐,
     *
     * 메서드 별로 선언시
     * 조회 관련 메서드에 @Transactional(readOnly=true) 하면 성능 향상
     *
     * 메서드에 따로 선언한 transactional 이 우선
     */

}
