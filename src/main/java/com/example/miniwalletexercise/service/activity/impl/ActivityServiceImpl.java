package com.example.miniwalletexercise.service.activity.impl;

import com.example.miniwalletexercise.converter.activity.ActivityConverter;
import com.example.miniwalletexercise.model.Wallet;
import com.example.miniwalletexercise.repository.activity.ActivityRepository;
import com.example.miniwalletexercise.service.activity.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService {

  @Autowired
  private ActivityRepository activityRepository;
  @Autowired
  private ActivityConverter activityConverter;

  @Override
  public void storeActivity(Wallet wallet, String type) {
    activityRepository.save(activityConverter.toEntity(wallet, type));
  }
}
