package se.comhem.test.montyhall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/monty-hall")
public class MontyHallEndpoint {

  @Autowired
 MontyHallGame montyHallGame;


  @PostMapping("/simulate")
  @ResponseBody
  public ResponseEntity<?> simulateMontyHall(
      @RequestParam("simulations")  final int simulations,
      @RequestParam("isSwitching") final boolean isSwitching) {
    if(simulations> 0 && simulations< Integer.MAX_VALUE) {
      return new ResponseEntity<>(montyHallGame.simulate(simulations, isSwitching), HttpStatus.OK);
    }else{
      return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }
  }

}
