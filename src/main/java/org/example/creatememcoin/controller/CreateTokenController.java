package org.example.creatememcoin.controller;

import jakarta.validation.Valid;
import org.example.creatememcoin.dto.CreateTokenDto;
import org.example.creatememcoin.jdbc.service.CreateTableTokenService;
import org.example.creatememcoin.hibernate.service.CheckingForAToken;
import org.example.creatememcoin.hibernate.service.CreateNewToken;
import org.example.creatememcoin.hibernate.service.GetAllToken;
import org.example.creatememcoin.hibernate.service.GetNameToken;
import org.example.creatememcoin.model.TokenServiceModel;
import org.example.creatememcoin.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class CreateTokenController {
    @Autowired
    private CreateNewToken createNewToken;
    @Autowired
    private GetNameToken getNameToken;
    @Autowired
    private GetAllToken getAllToken;
    @Autowired
    private CheckingForAToken checkingForAToken;
    @Autowired
    private CreateTableTokenService createTableTokenService;
    private final Logger logger = LoggerFactory.getLogger(CreateTokenController.class);

    @PostMapping("/token")
    public ResponseEntity<?> CreateNewToken(@Valid @RequestBody CreateTokenDto createTokenDto, BindingResult bindingResult) {
        if (!checkingForAToken.checkingForAToken(createTokenDto.getNameToken())){
            bindingResult.addError(new FieldError("createTokenDto", "nameToken", "Токен " + createTokenDto.getNameToken() + " уже существует!"));
        }

        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors()
                    .stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(Map.of("errors", errors));
        }
        //createNewToken.createNewToken(createTokenDto);
        //createTableTokenService.createTable(createTokenDto.getNameToken());
        TokenService tokenService = new TokenService(createTableTokenService, createTokenDto, createNewToken);
        boolean info = tokenService.startThreadAll();
        logger.info("Работа потоков по созданию нового токена. Статус: " + info);
        if(info){
            return ResponseEntity.ok().body("Статус создания нового токена: " + info);
        }else {
            return ResponseEntity.internalServerError().body("Статус создания нового токена: " + info);
        }
    }

    @GetMapping("/token")
    public ResponseEntity<List<TokenServiceModel>> GetAllToken() {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getAllToken.getAllToken());
    }

    @GetMapping("/token/{name}")
    public ResponseEntity<?> getNameToken(@PathVariable String name) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getNameToken.getNameToken(name));
    }
}
