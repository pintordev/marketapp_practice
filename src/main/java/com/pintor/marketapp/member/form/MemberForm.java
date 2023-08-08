package com.pintor.marketapp.member.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberForm {

    @NotEmpty
    @Size(min = 3, max = 25)
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private String nickname;

    @NotEmpty
    @Email
    private String email;
}
