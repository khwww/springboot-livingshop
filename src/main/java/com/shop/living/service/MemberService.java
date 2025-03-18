package com.shop.living.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.living.dao.MemberDao;
import com.shop.living.dto.Member;
import com.shop.living.util.PasswordUtil;

@Service
public class MemberService {

    @Autowired
    private MemberDao memberDao;

    // ✅ 회원가입 (비밀번호 해싱 후 저장)
    public void insertMember(Member member) throws Exception {
        String hashedPwd = PasswordUtil.hashPassword(member.getPwd());
        member.setPwd(hashedPwd);
        memberDao.insertMember(member);
    }

    // ✅ 로그인 (비밀번호 검증)
    public Member login(Member member) throws Exception {
        Member storedMember = memberDao.getMemberByEmail(member.getEmail());
        if (storedMember != null && PasswordUtil.checkPassword(member.getPwd(), storedMember.getPwd())) {
            return storedMember; // 비밀번호 일치하면 로그인 성공
        }
        return null;
    }
}
