package msa.study.springbootmicroservices.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import msa.study.springbootmicroservices.domain.Multiplication;
import msa.study.springbootmicroservices.domain.MultiplicationResultAttempt;
import msa.study.springbootmicroservices.domain.User;
import msa.study.springbootmicroservices.service.MultiplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MultiplicationResultAttemptController.class)
public class MultiplicationResultAttemptControllerTest {

    @MockBean
    private MultiplicationService multiplicationService;

    @Autowired
    private MockMvc mvc;

    private JacksonTester<MultiplicationResultAttempt> jsonResult;
    private JacksonTester<MultiplicationResultAttemptController.ResultResponse> jsonResponse;

    @BeforeEach
    public void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    public void postResultReturnCorrect() throws Exception {
        genericParameterizedTest(true);
    }

    @Test
    public void postResultReturnNotCollect() throws Exception {
        genericParameterizedTest(false);
    }

    void genericParameterizedTest(final boolean correct) throws Exception {
        given(multiplicationService
        .checkAttempt(any(MultiplicationResultAttempt.class)))
        .willReturn(correct);

        User user = User.builder().alias("kiyeon_kim").build();

        Multiplication multiplication = Multiplication.builder()
                .factorA(50)
                .factorB(70)
                .result(3500)
                .build();

        MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3500);

        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.post("/results")
        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonResult.write(attempt).getJson()))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonResponse.write(new MultiplicationResultAttemptController.ResultResponse(correct)).getJson());


    }

}
