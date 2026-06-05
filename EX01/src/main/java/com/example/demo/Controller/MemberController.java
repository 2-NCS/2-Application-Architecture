package com.example.demo.Controller;

import com.example.demo.Domain.Common.Daos.MemberDAO;
import com.example.demo.Domain.Common.Dtos.MemberDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;

@Controller
@Slf4j
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberDAO memberDAO;

    // TODO: DAO 등에서 발생한 예외를 처리할 @ExceptionHandler 메서드를 작성하라.
    //  - (Exception e, Model model) 를 받아 e 메시지를 model 에 담고 "member/error" 뷰 반환
    //  - import : org.springframework.web.bind.annotation.ExceptionHandler
    @ExceptionHandler
    public String SQLExceptionHandler(Exception e, Model model){
        model.addAttribute("e",e.getMessage());             //에러 메시지를 받기 위해 Model에 저장
        return "member/error";          //"member/error"뷰 반환
    }
    @GetMapping("/add")
    public void memberAdd() {
        log.info("GET /member/add...");
    }

    @PostMapping("/add")
    public String memberAddPost(@Valid MemberDTO memberDTO, BindingResult bindingResult,
                                Model model, RedirectAttributes redirectAttributes) throws SQLException {
        log.info("POST /member/add..." + memberDTO);

        // TODO:
        //  1) bindingResult.hasErrors() 이면 FieldError 들을 돌며
        //     model.addAttribute(error.getField(), error.getDefaultMessage()) 후 "member/add" 반환
        //     (import org.springframework.validation.FieldError)
        //  2) 검증 통과 시 memberDAO.insert(memberDTO) 호출
        //  3) redirectAttributes.addFlashAttribute("message","회원등록 성공!") 후 "redirect:/member/list" 반환
        if(bindingResult.hasErrors()) {     //// 1. 데이터 검증 오류 발생 시 처리
        // 발생한 모든 필드 에러를 순회하며 Model에 담아 화면으로 전달 (e.g., id -> "아이디를 입력하세요")
            for (FieldError error : bindingResult.getFieldErrors()) {
                model.addAttribute(error.getField(), error.getDefaultMessage());
            }
            return "member/add"; // 입력 폼 페이지로 돌아가기 (작성 중이던 데이터 및 에러 메시지 유지)
        }
        // 2. 비즈니스 로직 수행 (DB 삽입)
        int result = memberDAO.insert(memberDTO);
        // 3. 성공 알림 메시지 전달 및 리다이렉트
        // addFlashAttribute: 리다이렉트 직후 딱 한 번만 세션을 통해 데이터를 전달함 (새로고침 시 소멸)
        redirectAttributes.addFlashAttribute("message","회원등록 성공!");

        return "redirect:/member/list"; // 회원 목록 페이지로 리다이렉트

    }

    @GetMapping("/list")
    public void list_get(Model model) throws SQLException {
        log.info("GET /member/list...");
        model.addAttribute("list", memberDAO.selectAll());
    }

}
