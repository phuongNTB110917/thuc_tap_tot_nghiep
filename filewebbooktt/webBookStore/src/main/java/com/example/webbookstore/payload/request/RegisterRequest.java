package com.example.webbookstore.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
//    @NotBlank
//    @Email
//    private String email;
//
//    @NotBlank
//    @Size(max = 100)
//    private String name;
//
//    @Min(100000)
//    @Max(999999)
//    private int otp;
//    @NotBlank
//    @Size(min = 8, max = 32)
//    private String newPass;
//    @NotBlank
//    @Size(min = 8, max = 32)
//    private String confirmPass;
//
//    private Set<String> role;
//
//
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getOtp() {
//        return otp;
//    }
//
//    public void setOtp(int otp) {
//        this.otp = otp;
//    }
//
//    public String getNewPass() {
//        return newPass;
//    }
//
//    public void setNewPass(String newPass) {
//        this.newPass = newPass;
//    }
//
//    public String getConfirmPass() {
//        return confirmPass;
//    }
//
//    public void setConfirmPass(String confirmPass) {
//        this.confirmPass = confirmPass;
//    }
//}

    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    @NotBlank
    @Size(min = 8, max = 32)
    private String confirmPass;


    public RegisterRequest(@NotBlank @Size(min = 3, max = 20) String name,@NotBlank @Size(min = 3, max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
                         @NotBlank @Size(min = 6, max = 40) String password, @NotBlank @Size(min = 8, max = 32) String confirmPass) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPass = confirmPass;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private  String name;
        private String email;
        private String username;
        private String password;
        private String confirmPass;

        public Builder addName(final String name) {
            this.name = name;
            return this;
        }

        public Builder addEmail(final String email) {
            this.email = email;
            return this;
        }
        public Builder addUsername(final String username) {
            this.username = username;
            return this;
        }

        public Builder addPassword(final String password) {
            this.password = password;
            return this;
        }

        public Builder addConfirmPass(final String confirmPass) {
            this.confirmPass = confirmPass;
            return this;
        }

        public RegisterRequest build() {
            return new RegisterRequest(name, username, email, password, confirmPass);
        }
    }

}