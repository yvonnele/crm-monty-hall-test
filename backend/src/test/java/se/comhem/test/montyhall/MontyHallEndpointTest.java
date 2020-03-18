package se.comhem.test.montyhall;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class MontyHallEndpointTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private MontyHallGame montyHallGame;

  @Test
  public void testSuccessCase() throws Exception {

    given(montyHallGame.simulate(100, true)).willReturn(new SimulationResult(60,100, true));

    this.mockMvc.perform(post("/monty-hall/simulate?simulations=200&isSwitching=true"))
        .andExpect(status().isOk());
  }

  @Test
  public void testNegativeSimulations() throws Exception {

    given(montyHallGame.simulate(100, true)).willReturn(new SimulationResult(60,100, true));

    this.mockMvc.perform(post("/monty-hall/simulate?simulations=-100&isSwitching=true"))
        .andExpect(status().isBadRequest());
  }


}