package yr2.sem2.lab05answer;

import java.util.*;

public class TestCPU {
  public static void main(String[] args) {
    CPU cpu = new CPU();

    cpu.setIp(0);

    //String[] memory = {"clear", "inc", "inc", "disp", "reset", "halt"};

    String[] memory = {"clear", "inc", "inc", "disp", "ble6 1", "halt"};

    cpu.setMemory(memory);

    System.out.println(cpu.getIp());

    for (int i = 0; i < cpu.getMemory().length; i++)
      System.out.println(cpu.getMemory()[i]);

    System.out.println();

    System.out.println(cpu.fetch(3));

    cpu.run();
  }
}