package com.ikkikki.board.repository;

import com.ikkikki.board.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,String> {
}
