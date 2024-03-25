package org.myungkeun.spring_blog.repositories;

import org.myungkeun.spring_blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
