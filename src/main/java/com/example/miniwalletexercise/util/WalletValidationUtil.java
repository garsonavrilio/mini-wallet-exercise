package com.example.miniwalletexercise.util;

import static com.example.miniwalletexercise.constant.StatusConstant.ENABLED;

import com.example.miniwalletexercise.exception.ServiceException;
import com.example.miniwalletexercise.model.Wallet;
import com.example.miniwalletexercise.repository.activity.ActivityRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WalletValidationUtil {

  @Autowired
  private ActivityRepository activityRepository;

  public static Wallet isValid(Wallet wallet) {
    if (wallet.getStatus().equals(ENABLED)) {
      return wallet;
    }
    throw errorWalletEnable();
  }

  public void validateReferenceIdAndType(UUID uuid, String type){
    if(Objects.nonNull(activityRepository.findActivityByReferenceIdAndType(uuid, type))){
      throw errorReferenceId();
    }
  }

  private static ServiceException errorWalletEnable() {
    Map<String, String> errors = new HashMap<>();
    errors.put("Wallet", "status is disabled");
    return new ServiceException(errors);
  }

  private static ServiceException errorReferenceId() {
    Map<String, String> errors = new HashMap<>();
    errors.put("Reference_id", "must be unique");
    return new ServiceException(errors);
  }
}
