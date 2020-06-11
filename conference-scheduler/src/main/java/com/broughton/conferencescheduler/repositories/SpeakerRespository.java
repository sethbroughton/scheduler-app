package com.broughton.conferencescheduler.repositories;

import com.broughton.conferencescheduler.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRespository extends JpaRepository<Speaker, Long> {
}
