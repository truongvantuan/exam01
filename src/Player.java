public class Player {
    private String fullName;
    private String position;
    private int num;

    public Player(String fullName, String position, int num) {
        this.fullName = fullName;
        this.position = position;
        this.num = num;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return this.num + " - " +this.fullName + " - " + this.position;
    }
}