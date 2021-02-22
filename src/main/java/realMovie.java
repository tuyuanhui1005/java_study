public class realMovie implements movie {

    String name;

    public realMovie(String name) {
        this.name = name;
    }

    @Override
    public void play(String name1) {
        System.out.println("您正在观看" + name);

    }
}
