package br.com.artur.check.password.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PasswordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String URI = "/password/validation";

    @Test
    @DisplayName("Should return true for password validation")
    public void getValidPassword() throws Exception {
        String passwd = "ASDfghzxc@1";

        mockMvc.perform(get(URI.concat("/"+passwd))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("isValid").value(true));
    }

    @Test
    @DisplayName("Should return false for password no digits")
    public void getPasswordWithoutDigits() throws Exception {
        String passwd = "AbTp!fokz";

        mockMvc.perform(get(URI.concat("/"+passwd))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("isValid").value(false));
    }

    @Test
    @DisplayName("Should return false for password no lowercase letters")
    public void getPasswordWithoutLowerCase() throws Exception {
        String passwd = "ABTP!FOK1";

        mockMvc.perform(get(URI.concat("/"+passwd))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("isValid").value(false));
    }

    @Test
    @DisplayName("Should return false for password no special characters")
    public void getPasswordWithoutSpecialCharacter() throws Exception {
        String passwd = "AbTp9yfok";

        mockMvc.perform(get(URI.concat("/"+passwd))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("isValid").value(false));
    }

    @Test
    @DisplayName("Should return false for password no uppercase letters")
    public void getPasswordWithoutUpperCase() throws Exception {
        String passwd = "abtp9!fok";

        mockMvc.perform(get(URI.concat("/"+passwd))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("isValid").value(false));
    }

    @Test
    @DisplayName("Should return false for password with repeated character")
    public void getPasswordWithRepeatedCharacter() throws Exception {
        String passwd = "AbTp9!foA";

        mockMvc.perform(get(URI.concat("/"+passwd))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("isValid").value(false));
    }

    @Test
    @DisplayName("Should return false for password with insufficient number of characters")
    public void getPasswordWithInsufficientNumberCharacters() throws Exception {
        String passwd = "Tp9!foAx";

        mockMvc.perform(get(URI.concat("/"+passwd))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("isValid").value(false));
    }
}
