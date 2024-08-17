package com.ak_meer.form_app.repo;

import com.ak_meer.form_app.model.IdCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IdCardRepository extends JpaRepository<IdCard , Long> {
    Optional<IdCard> findByUniqueToken(String uniqueToken);
}
