package com.shop.living.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.shop.living.dto.Member;

@Mapper
public interface MemberDao {

    // ✅ 회원가입
    @Insert("INSERT INTO member (email, pwd, nickname) VALUES (#{email}, #{pwd}, #{nickname})")
    void insertMember(Member member) throws Exception;

    // ✅ 이메일로 회원 정보 조회
    @Select("SELECT * FROM member WHERE email = #{email}")
    Member getMemberByEmail(String email);
}
