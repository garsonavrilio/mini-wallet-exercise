package com.example.miniwalletexercise.repository.activity;

import com.example.miniwalletexercise.model.Activity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

  Activity findActivityByReferenceIdAndType(UUID referenceId, String type);
}
