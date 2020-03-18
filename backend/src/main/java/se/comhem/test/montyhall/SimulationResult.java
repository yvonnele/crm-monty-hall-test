package se.comhem.test.montyhall;

public class SimulationResult {
  private int wins;
  private int simulations;
  private boolean isSwitching;


  public SimulationResult(Integer wins, Integer simulations, boolean isSwitching){
    this.wins = wins;
    this.simulations = simulations;
    this.isSwitching = isSwitching;

  }

  public int getWins() {
    return wins;
  }
  public void setWins(int wins) {
    this.wins = wins;
  }

  public int getSimulations() {
    return simulations;
  }

  public void setSimulations(int simulations){
    this.simulations = simulations;
  }

  public boolean getIsSwitching() {
    return isSwitching;
  }
  public void setIsSwitching(boolean isSwitching) {
    this.isSwitching = isSwitching;
  }
  public double getWinPercentage() {return (double) wins/simulations;}
  
}
