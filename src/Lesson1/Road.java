package Lesson1;

public class Road implements Action {
    private int length;
    private String name;

    public Road(int length, String name) {
        this.length = length;
        this.name = name;
    }

    public boolean check(Participant object) {
        return object.run(length);

    }

    @Override
    public String getName() {
        return  name;
    }
}
