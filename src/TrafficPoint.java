public class TrafficPoint{
    private int id;
    private char name;
    private boolean join;
    private int stationsEntry;
    private int stationsExit;

    // objects[0] = school; objects[1] = university; objects[2] = working area; objects[3] = hospital;
    private boolean[] objects;
    
    public TrafficPoint(){
        this.stationsEntry = 0;
        this.stationsExit = 0;
    }

    public void setSchool(boolean s) {
        this.objects[0] = s;
    }

    public void setUni(boolean s) {
        this.objects[1] = s;
    }

    public void setWork(boolean s) {
        this.objects[2] = s;
    }

    public void setHospital(boolean s) {
        this.objects[3] = s;
    }

    public boolean[] getObjects() {
        return objects;
    }


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
        this.objects = new boolean[4];
    }

}
