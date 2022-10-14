package com.example.miniwalletexercise.controller;

import static com.example.miniwalletexercise.constant.StatusConstant.SUCCESS;
import static com.example.miniwalletexercise.util.HashingUtil.hash;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.example.miniwalletexercise.constant.ApiConstant;
import com.example.miniwalletexercise.constant.ParamConstant;
import com.example.miniwalletexercise.controller.v1.InitController;
import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.init.InitResponseDTO;
import com.example.miniwalletexercise.service.init.InitService;
import java.net.URI;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class InitControllerTest {

  private static final UUID uuid = UUID.randomUUID();

  @InjectMocks
  private InitController initController;
  @Mock
  private InitService initService;

  private MockMvc mockMvc;

  @Before
  public void setup(){
    mockMvc = MockMvcBuilders.standaloneSetup(initController).build();
  }

  @Test
  public void initControllerTest_Success() throws Exception {
    when(initService.init(uuid))
        .thenReturn(generateResponse());
    MvcResult mvcResult = mockMvc.perform(
        MockMvcRequestBuilders.post(new URI(ApiConstant.INIT))
            .param(ParamConstant.CUSTOMER_XID, uuid.toString()))
        .andReturn();

    assertEquals(HttpStatus.CREATED.value(), mvcResult.getResponse().getStatus());
  }

  private ResponseDTO<InitResponseDTO> generateResponse(){
    return ResponseDTO.<InitResponseDTO>builder()
        .status(SUCCESS)
        .data(InitResponseDTO.builder()
            .token(hash(uuid))
            .build())
        .build();
  }

}
