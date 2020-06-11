package com.broughton.conferencescheduler.repositories;

import com.broughton.conferencescheduler.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
