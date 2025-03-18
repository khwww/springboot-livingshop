package com.shop.living.dto;

public class Member {
    private String email;
    private String pwd;
    private String nickname;

    // 기본 생성자
    public Member() {}

    // 매개변수 생성자
    public Member(String email, String pwd, String nickname) {
        this.email = email;
        this.pwd = pwd;
        this.nickname = nickname;
    }

    // Getter & Setter
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPwd() { return pwd; }
    public void setPwd(String pwd) { this.pwd = pwd; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    @Override
    public String toString() {
        return "Member [email=" + email + ", nickname=" + nickname + "]";
    }
}
