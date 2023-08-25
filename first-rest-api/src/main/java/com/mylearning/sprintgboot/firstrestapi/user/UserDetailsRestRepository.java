package com.mylearning.sprintgboot.firstrestapi.user;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface UserDetailsRestRepository extends PagingAndSortingRepository<UserDetails, Long> {
    List<UserDetails> findByRole(String admin);

    // http://localhost:8080
    // http://localhost:8080/userDetailses?page=2&size=1
}
