package com.studentportal.guardian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuardianRepo extends JpaRepository<Guardian,Long> {

}
