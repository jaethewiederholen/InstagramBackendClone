package com.example.InstagramBackendClone.service.Account;

import com.example.InstagramBackendClone.domain.account.Account;
import com.example.InstagramBackendClone.domain.account.AccountRepository;
import com.example.InstagramBackendClone.domain.account.dto.AccountSaveDto;
import com.example.InstagramBackendClone.domain.member.Member;
import com.example.InstagramBackendClone.domain.member.MemberRepository;
import com.example.InstagramBackendClone.service.member.MemberService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public HashMap<String, Object> save(AccountSaveDto accountSaveDto){
        HashMap<String, Object> result = new HashMap<String,Object>();
        Optional<Member> member = memberRepository.findById(accountSaveDto.getMemberId());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(accountSaveDto.getBirthDate(), formatter);
        Account account = Account.createAccount()
                .birthDate(birthDate)
                .name(accountSaveDto.getName())
                .build();

        member.get().addAccount(account);
        accountRepository.save(account);
        result.put("id", account.getId());
        result.put("member_id", account.getMember());
        return result;
    }

}
