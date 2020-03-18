package se.comhem.test.montyhall;
import org.springframework.stereotype.Component;

import java.util.Random;


@Component
public class MontyHallGame {

    public SimulationResult simulate(int numberOfSimulations, boolean isSwitching){
      int wins = 0;
      for(int i = 0 ; i < numberOfSimulations; i++){
        if(play(isSwitching))wins++;
      }
      return new SimulationResult(wins, numberOfSimulations, isSwitching);
    }


    public boolean play(boolean isSwitching){
      int carPosition = getPosition();
      int doorSelectedPosition = getPosition();

      //If no switch, selected door must be the car to win
      //If switch, selected door must not be the car to win
      return !isSwitching ? doorSelectedPosition == carPosition : doorSelectedPosition != carPosition;
    }

    private int getPosition(){
  return new Random().nextInt(3);
    }


}
