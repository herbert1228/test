package yr2.sem2.lab05answer;

import java.util.*;

public class CPU {
  private int accumulator;
  private int ip;
  private String[] memory;

  public int getAccumulator() {
    return accumulator;
  }

  public void setAccumulator(int anAccumulator) {
    accumulator = anAccumulator;
  }

  public int getIp() {
    return ip;
  }

  public void setIp(int anIp) {
    ip = anIp;
  }

  public String[] getMemory() {
    return memory;
  }

  public void setMemory(String[] aMemory) {
    memory = aMemory;
  }

  public String fetch(int index) {
    return memory[index];
  }

  public void execute(String instruction) {
    if (instruction.equals("clear"))
      accumulator = 0;
    else if (instruction.equals("inc"))
      accumulator++;
    else if (instruction.equals("reset")) {
      System.out.println("reset, ip = " + ip);
      ip = 0;
    }
    else if (instruction.equals("disp"))
      System.out.println("Accumulator = " + accumulator);
    else if (instruction.indexOf("ble6 ") >= 0) {
      if (accumulator <= 6)
        ip = Integer.parseInt(instruction.substring(instruction.indexOf(" ") + 1));
    }
    else if (instruction.equals("halt"))
      return;
  }

  public void run() {
    String instruction;
    ip = 0;
    do {
      instruction = fetch(ip);
      ip++;
      execute(instruction);
    } while (!instruction.equals("halt"));
  }

  public void step() {
    String instruction = fetch(ip);
    if (!instruction.equals("halt")) ip++;
    execute(instruction);
  }
}