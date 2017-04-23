package yr2.sem2.lab05;

import java.util.Arrays;

public class CPU {

    private int ip, accumulator;

    private String[] memory;

    public void setIp(int ip) {
        this.ip = ip;
    }

    public void setAccumulator(int accumulator) {
        this.accumulator = accumulator;
    }

    public void setMemory(String[] memory) {
        this.memory = memory;
    }

    public int getIp() {

        return ip;
    }

    public int getAccumulator() {
        return accumulator;
    }

    public String[] getMemory() {
        return memory;
    }

//    public CPU(){
//
//    }

    public String fetch(int index){
        try{
            return memory[index];
        }
        catch (Exception ex){
//            System.out.println("memory out of range");
            System.exit(0);
            return "-1";
        }
    }

    public void execute(String instruction){
        switch (instruction){
            case "clear" :
                accumulator = 0; break;
            case "inc" :
                accumulator += 1; break;
            case "reset" :
                ip = 0; break;
            case "disp" :
                System.out.println(accumulator); break;
            case "halt" :
                return;
            case "-1" : break;
            default:
                if(instruction.substring(0,4).equals("ble6")) {
                    if (accumulator <= 6) {
                        ip = Integer.parseInt(
                                instruction.substring(
                                        instruction.indexOf(" ") + 1, instruction.length()));
                    } else
                        setIp(getIp() + 1);
                }
                break;
        }
    }

    public void run(){
        setIp(0);
        int commandToResetIP = Arrays.asList(getMemory()).indexOf("reset");
        for (String s:getMemory()
                ) {
            if (s.matches("ble6 [0-9]+")) {
                commandToResetIP = Arrays.asList(getMemory()).indexOf(s);
            }
        }
        while (true){
//            System.out.println("******"+fetch(getIp())+"******");
//            System.out.println("******"+getIp()+"******");
            int originIP = getIp();
            execute(fetch(getIp()));
            if(originIP != commandToResetIP) setIp(getIp() + 1);
        }
    }

    public static void main(String[] args) {
        CPU cpu = new CPU();
        cpu.setIp(0);
        cpu.setAccumulator(0);
        cpu.setMemory(new String[]{"clear", "inc", "inc", "disp", "ble6 1", "halt"});

        cpu.run();
    }
}
