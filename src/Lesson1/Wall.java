package Lesson1;

public class Wall implements Action{

    private int height;
    private String name;

    public Wall(int height, String name) {
        this.height = height;
        this.name = name;
    }

    public boolean check(Participant object) {
        return object.jump(height);

    }

    @Override
    public String getName() {
        return name;
    }
}
