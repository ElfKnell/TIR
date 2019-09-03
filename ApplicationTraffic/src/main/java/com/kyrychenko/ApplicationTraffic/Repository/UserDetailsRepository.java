package com.kyrychenko.ApplicationTraffic.Repository;

import com.kyrychenko.ApplicationTraffic.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<User, String> {
}
