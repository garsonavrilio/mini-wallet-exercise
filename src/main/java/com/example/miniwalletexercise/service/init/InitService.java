package com.example.miniwalletexercise.service.init;

import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.init.InitResponseDTO;
import java.util.UUID;

public interface InitService {

  ResponseDTO<InitResponseDTO> init(UUID customerXid);

}
