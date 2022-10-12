package com.example.miniwalletexercise.service.init;

import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.init.InitRequestDTO;
import com.example.miniwalletexercise.dto.init.InitResponseDTO;

public interface InitService {

  ResponseDTO<InitResponseDTO> init(InitRequestDTO initRequestDTO);

}
