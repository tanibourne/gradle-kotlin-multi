package org.example.member.infrastructure;

import org.example.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Repository

public interface MemberJpaRepository extends JpaRepository<Member,Long > {


}
