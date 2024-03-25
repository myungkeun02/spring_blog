package org.myungkeun.spring_blog.repositories;

import org.myungkeun.spring_blog.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
}
