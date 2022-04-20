package com.example.InstagramBackendClone.api.member;

import com.example.InstagramBackendClone.api.member.dto.MemberResponseDto;
import com.example.InstagramBackendClone.api.member.dto.MemberSaveDto;
import com.example.InstagramBackendClone.api.member.dto.MemberSaveResponseDto;
import com.example.InstagramBackendClone.domain.member.Member;
import com.example.InstagramBackendClone.service.member.MemberService;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.View;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api/member")
public class MemberController {
    private final MemberService memberService;
    /*
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
    public MemberSaveResponseDto join(@RequestBody MemberSaveDto memberSaveDto){

        return memberService.save(memberSaveDto);
    }

    /*
    ID로 회원 조회 API
     */
    @Operation(summary = "Get user",
            description = "Get user by ID.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
    })
    @GetMapping("/{id}")
    public MemberResponseDto getMember (@PathVariable Long id) {
        return memberService.findById(id);
    }

    /*
    전체 회원 조회 API
     */
    @Operation(summary = "Get all users",
            description = "Get all users.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
    })
    @GetMapping("/")
    public List<MemberResponseDto> getMembers () {
        return memberService.findAllDesc();
    }

}
