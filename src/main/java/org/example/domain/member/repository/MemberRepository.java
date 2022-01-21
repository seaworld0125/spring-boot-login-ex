package org.example.domain.member.repository;

import java.util.List;
import java.util.Optional;
import org.example.domain.member.model.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    Optional<MemberEntity> findMemberEntityByName(String name);
}
