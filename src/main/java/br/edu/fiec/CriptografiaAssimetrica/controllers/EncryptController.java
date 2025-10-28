package br.edu.fiec.CriptografiaAssimetrica.controllers;

import br.edu.fiec.CriptografiaAssimetrica.models.dtos.AssimetricEncryptDto;
import br.edu.fiec.CriptografiaAssimetrica.services.EncryptService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "encrypt")
public class EncryptController {

    private final EncryptService encryptService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "assimetric", produces = APPLICATION_JSON_VALUE)
    public AssimetricEncryptDto assimetricEncryptDTO(@RequestParam String text) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        return encryptService.assimetricEncryptDTO(text);
    }
}