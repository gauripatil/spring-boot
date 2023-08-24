package com.mylearning.sprintgboot.firstrestapi.user;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
}
