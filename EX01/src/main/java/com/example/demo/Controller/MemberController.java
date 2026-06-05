package com.example.demo.Controller;

import com.example.demo.Domain.Common.Daos.MemberDAO;
import com.example.demo.Domain.Common.Dtos.MemberDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        throw new UnsupportedOperationException("TODO");
    }

    @GetMapping("/list")
    public void list_get(Model model) throws SQLException {
        log.info("GET /member/list...");
        model.addAttribute("list", memberDAO.selectAll());
    }

}
