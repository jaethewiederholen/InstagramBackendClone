package com.example.InstagramBackendClone.api.member;

import com.example.InstagramBackendClone.api.common.Message;
import com.example.InstagramBackendClone.api.common.StatusEnum;
import com.example.InstagramBackendClone.domain.account.Account;
import com.example.InstagramBackendClone.domain.member.dto.MemberResponseDto;
import com.example.InstagramBackendClone.domain.member.dto.MemberSaveDto;
import com.example.InstagramBackendClone.domain.member.dto.MemberSaveResponseDto;
import com.example.InstagramBackendClone.service.member.MemberService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api/member")
public class MemberController {
    private final MemberService memberService;
    /**
    회원가입 API
     */
    @Operation(summary = "Create user",
            description = "Create user when user join the site for the first time.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
    })
    @PostMapping()
    @ResponseBody
    public ResponseEntity<Message> join(@RequestBody MemberSaveDto memberSaveDto){
        Message message = new Message();
        try {
            message.setData(memberService.save(memberSaveDto));
        }catch (Exception e) {
            message.setStatus(StatusEnum.BAD_REQUEST);
            message.setMessage("해당 이메일이 이미 존재합니다.");
            return new ResponseEntity<Message>( message,new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
        message.setStatus(StatusEnum.OK);
        message.setMessage("유저 생성 성공");

        return new ResponseEntity<Message>(message, new HttpHeaders(), HttpStatus.OK);

    }

    /**
    ID로 회원 조회 API
     */
    @Operation(summary = "Get user",
            description = "Get user by ID.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<Message> getMember (@PathVariable Long id) {
        Message message = new Message();
        message.setStatus(StatusEnum.OK);
        message.setMessage("유저 조회  성공");
        message.setData(memberService.findById(id));
        return new ResponseEntity<Message>(message, new HttpHeaders(), HttpStatus.OK);
    }


    /**
    전체 회원 조회 API
     */
    @Operation(summary = "Get all users",
            description = "Get all users.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
    })
    @GetMapping("/")
    public ResponseEntity<Message> getMembers () {
        Message message = new Message();
        message.setStatus(StatusEnum.OK);
        message.setMessage("유저 리스트 조회 성공");
        message.setData(memberService.findAllDesc());
        return new ResponseEntity<Message>(message, new HttpHeaders(), HttpStatus.OK);
    }

}
