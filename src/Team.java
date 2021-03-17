import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Team {
    private ArrayList<Player> goalKeeperList;
    private ArrayList<Player> defenderList;
    private ArrayList<Player> midFieldList;
    private ArrayList<Player> forwarderList;

    public Team() {
        this.goalKeeperList = new ArrayList<>();
        this.defenderList = new ArrayList<>();
        this.midFieldList = new ArrayList<>();
        this.forwarderList = new ArrayList<>();

    }

    // Hàm buildTeam mặc định cho đội hình 442
    public ArrayList<Player> buildTeam() {
        ArrayList<Player> team = new ArrayList<>();

        ArrayList<Player> gkList = getRandomPlayer(this.goalKeeperList, 1);
        ArrayList<Player> dfList = getRandomPlayer(this.defenderList, 4);
        ArrayList<Player> mdList = getRandomPlayer(this.midFieldList, 4);
        ArrayList<Player> fwList = getRandomPlayer(this.forwarderList, 2);

        team.addAll(gkList);
        team.addAll(dfList);
        team.addAll(mdList);
        team.addAll(fwList);

        return team;
    }

    // Hàm buildTeam cho đội hình tùy chọn
    public ArrayList<Player> buildTeam(int defender, int midfielder, int forwarder) {
        ArrayList<Player> team = new ArrayList<>();

        ArrayList<Player> gkList = getRandomPlayer(this.goalKeeperList, 1);
        ArrayList<Player> dfList = getRandomPlayer(this.defenderList, defender);
        ArrayList<Player> mdList = getRandomPlayer(this.midFieldList, midfielder);
        ArrayList<Player> fwList = getRandomPlayer(this.forwarderList, forwarder);

        team.addAll(gkList);
        team.addAll(dfList);
        team.addAll(mdList);
        team.addAll(fwList);

        return team;
    }

    // Hàm chọn ngẫu nhiên cầu thủ thừ danh sách
    public ArrayList<Player> getRandomPlayer(ArrayList<Player> list, int totalPlayer) {
        Random rand = new Random();
        ArrayList<Player> newList = new ArrayList<>();

        for (int i = 0; i < totalPlayer; i++) {
            int randomIndex = rand.nextInt(list.size());
            newList.add(list.get(randomIndex));
            list.remove(randomIndex); // Cầu thủ sau khi đã chọn được loại bỏ khởi dánh sách tránh lặp lại
        }

        return newList;
    }

    public void addGK(String name, String position, int num) {
        this.goalKeeperList.add(new Player(name, position, num));
    }

    public void addDF(String name, String position, int num) {
        this.defenderList.add(new Player(name, position, num));
    }

    public void addMF(String name, String position, int num) {
        this.midFieldList.add(new Player(name, position, num));
    }

    public void addFW(String name, String position, int num) {
        this.forwarderList.add(new Player(name, position, num));
    }

    public ArrayList<Player> getGoalKeeperList() {
        return goalKeeperList;
    }

    public void setGoalKeeperList(ArrayList<Player> goalKeeperList) {
        this.goalKeeperList = goalKeeperList;
    }

    public ArrayList<Player> getDefenderList() {
        return defenderList;
    }

    public void setDefenderList(ArrayList<Player> defenderList) {
        this.defenderList = defenderList;
    }

    public ArrayList<Player> getMidFieldList() {
        return midFieldList;
    }

    public void setMidFieldList(ArrayList<Player> midFieldList) {
        this.midFieldList = midFieldList;
    }

    public ArrayList<Player> getForwarderList() {
        return forwarderList;
    }

    public void setForwarderList(ArrayList<Player> forwarderList) {
        this.forwarderList = forwarderList;
    }
}
