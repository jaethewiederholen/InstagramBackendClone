package com.example.InstagramBackendClone.api.member;

import com.example.InstagramBackendClone.api.common.Message;
import com.example.InstagramBackendClone.api.common.StatusEnum;
import com.example.InstagramBackendClone.domain.account.dto.AccountSaveDto;
import com.example.InstagramBackendClone.domain.member.dto.MemberSaveDto;
import com.example.InstagramBackendClone.service.Account.AccountService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api/account")
public class AccountController {

    private final AccountService accountService;
    /**
     * 계정 생성 API
     */
    @Operation(summary = "Create Account",
            description = "Create Account for certain user.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
    })
    @PostMapping()
    @ResponseBody
    public ResponseEntity<Message> join(@RequestBody AccountSaveDto accountSaveDto){
        Message message = new Message();
        message.setData(accountService.save(accountSaveDto));
        message.setStatus(StatusEnum.OK);
        message.setMessage("계정 생성 성공");

        return new ResponseEntity<Message>(message, new HttpHeaders(), HttpStatus.OK);

    }

}
