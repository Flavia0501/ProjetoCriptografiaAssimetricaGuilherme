package br.edu.fiec.CriptografiaAssimetrica.services;

import br.edu.fiec.CriptografiaAssimetrica.models.dtos.AssimetricEncryptDto;
import org.springframework.stereotype.Service;
import javax.crypto.*;
import java.security.*;

@Service
public class EncryptService {

    public AssimetricEncryptDto assimetricEncryptDTO(String text) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        //Gerar SecretKey
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        PublicKey publicKey = keyPair.getPublic();
        System.out.println("Chave pública gerada:" + publicKey);

        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("Chave privada gerada:" + privateKey);

        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPPadding");
        //Encrypt
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] encrypted = cipher.doFinal(text.getBytes());

        //Decrypt
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        String decrypted = new String(cipher.doFinal(encrypted));

        return new AssimetricEncryptDto(encrypted, decrypted);
    }
}
