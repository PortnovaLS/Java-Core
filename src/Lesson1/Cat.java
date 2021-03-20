package Lesson1;

public class Cat implements Participant {
    private int maxRun;
    private int maxJump;
    private String name;

    public Cat (int maxRun, int maxJump, String name){
        this.maxRun = maxRun;
        this.maxJump = maxJump;
        this.name = name;
    }


    @Override
    public boolean jump(int height) {
        return height <= maxJump;
    }

    @Override
    public boolean run(int length) {
        return length <= maxRun;
    }

    @Override
    public String getName() {
        return name;
    }
}
