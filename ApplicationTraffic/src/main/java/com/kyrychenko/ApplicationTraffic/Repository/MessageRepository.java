package com.kyrychenko.ApplicationTraffic.Repository;

import com.kyrychenko.ApplicationTraffic.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
