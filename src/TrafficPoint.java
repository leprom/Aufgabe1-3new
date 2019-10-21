public class TrafficPoint{
    private int id;
    private char name;
    private boolean join;
    private int stationsEntry;
    private int stationsExit;

    public TrafficPoint(){
        this.stationsEntry = 0;
        this.stationsExit = 0;
    }

    public int getStationsEntry() {
        return stationsEntry;
    }

    public void setStationsEntry(int stationsEntry) {
        this.stationsEntry = stationsEntry;
    }

    public int getStationsExit() {
        return stationsExit;
    }

    public void setStationsExit(int stationsExit) {
        this.stationsExit = stationsExit;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return ""+this.name;
    }

    public TrafficPoint(char name, boolean join) {
        this.id = name-65;
        this.name = name;
        this.join = join;
    }

}
