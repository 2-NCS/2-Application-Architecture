package com.example.demo.Domain.Common.Dtos;

// TODO: Lombok( @Data @NoArgsConstructor @AllArgsConstructor @Builder ) 과
//       검증( jakarta.validation.constraints.NotBlank, Email ) import 를 추가하라.

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

// TODO: 아래 클래스에 Lombok 애너테이션을 붙여 getter/setter/builder 가 생성되도록 하라.
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {

    // TODO: 각 필드에 알맞은 검증 애너테이션을 추가하라.
    private Long id;                  // 식별자 (검증 없음, DB AUTO_INCREMENT)
    private String name;              // TODO: @NotBlank
    private String email;             // TODO: @NotBlank + @Email
    private String phone;             // TODO: @NotBlank
    private LocalDateTime createAt;   // 등록일시 (검증 없음)

}
