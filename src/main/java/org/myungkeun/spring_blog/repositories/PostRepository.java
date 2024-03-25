package org.myungkeun.spring_blog.repositories;

import org.myungkeun.spring_blog.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
