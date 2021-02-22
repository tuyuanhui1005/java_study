public class Cinema implements movie {


    realMovie movie;

    public Cinema(realMovie movie) {
        this.movie = movie;
    }

    @Override
    public void play(String name) {
        guanggao(true);
        play(name);
        guanggao(false);


    }

    public void guanggao(boolean isStart) {
        if (isStart) {
            System.out.println("电影马上开始了，爆米花、可乐、口香糖9.8折，快来买啊！");
        } else {
            System.out.println("电影马上结束了，爆米花、可乐、口香糖9.8折，买回家吃吧！");
        }
    }

}
