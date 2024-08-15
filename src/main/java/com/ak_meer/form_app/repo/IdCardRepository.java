package com.ak_meer.form_app.repo;

import com.ak_meer.form_app.model.IdCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdCardRepository extends JpaRepository<IdCard , Long> {
}
