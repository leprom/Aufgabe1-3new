import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Timetable {

    private String[][] oneline;
    private int rows;
    private int columns;

    public Timetable(String firsttime, char[] stationNames, int direction) {
        this.oneline = new String[900/stationNames.length][stationNames.length];
        this.rows = 900/stationNames.length;
        this.columns = stationNames.length;

        if (direction == 1) {
            for (int i = 0; i < stationNames.length; i++) {
                this.oneline[0][i] = String.valueOf(stationNames[i]);
            }
        } else if (direction == -1) {
            for (int i = 0; i < stationNames.length; i++) {
                this.oneline[0][stationNames.length - i - 1] = String.valueOf(stationNames[i]);
            }
        }

        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime now = LocalTime.parse(firsttime);

        for (int i = 1; i < 900/stationNames.length; i++) {
            for (int j = 0; j < stationNames.length; j++){
                this.oneline[i][j] = (df.format(now.plusMinutes(1)));
                now = LocalTime.parse(this.oneline[i][j]);
            }
        }
    }

    public static String randomTime(){
        String time = "07:5";
        Random random = new Random();
        int startingMinute = random.nextInt(10 - 1 + 1) + 1;
        if (startingMinute == 10)
            time = "08:00";
        else
            time = time + startingMinute;
        return time;
    }

    public void print() {
        for (int i = 0; i < columns; i++) {
            System.out.print(this.oneline[0][i] + "     ");
        }
        System.out.println();
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(this.oneline[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static Timetable[] initializeTimetable(int trafficVariation) {
        Timetable[] tables = new Timetable[6];
        if (trafficVariation == 1) {
            char[] line1Names = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
            char[] line2Names = {'O', 'P', 'D', 'I', 'G', 'H'};
            char[] line3Names = {'I', 'B', 'J', 'K', 'L', 'M'};
            tables[0] = new Timetable(randomTime(), line1Names, 1);
            tables[1] = new Timetable(randomTime(), line1Names, -1);
            tables[2] = new Timetable(randomTime(), line2Names, 1);
            tables[3] = new Timetable(randomTime(), line2Names, -1);
            tables[4] = new Timetable(randomTime(), line3Names, 1);
            tables[5] = new Timetable(randomTime(), line3Names, -1);
        } else if (trafficVariation == 2) {
            char[] line1Names = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
            char[] line2Names = {'J', 'A', 'I', 'E', 'K', 'L'};
            char[] line3Names = {'O', 'N', 'M', 'G', 'P'};
            tables[0] = new Timetable(randomTime(), line1Names, 1);
            tables[1] = new Timetable(randomTime(), line1Names, -1);
            tables[2] = new Timetable(randomTime(), line2Names, 1);
            tables[3] = new Timetable(randomTime(), line2Names, -1);
            tables[4] = new Timetable(randomTime(), line3Names, 1);
            tables[5] = new Timetable(randomTime(), line3Names, -1);
        } else if (trafficVariation == 3) {
            char[] line1Names = {'A', 'B', 'C', 'D', 'E', 'F'};
            char[] line2Names = {'B', 'N', 'M', 'O', 'P', 'K'};
            char[] line3Names = {'G', 'H', 'I', 'J', 'K', 'L'};
            tables[0] = new Timetable(randomTime(), line1Names, 1);
            tables[1] = new Timetable(randomTime(), line1Names, -1);
            tables[2] = new Timetable(randomTime(), line2Names, 1);
            tables[3] = new Timetable(randomTime(), line2Names, -1);
            tables[4] = new Timetable(randomTime(), line3Names, 1);
            tables[5] = new Timetable(randomTime(), line3Names, -1);
        }
        return tables;
    }

    public static void main(String[] args) {

        char[] line1Names = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        Timetable line1direction1 = new Timetable(randomTime(), line1Names, 1);
        Timetable line1direction2 = new Timetable(randomTime(), line1Names, -1);

        char[] line2Names = {'O', 'P', 'D', 'I', 'G', 'H'};
        Timetable line2direction1 = new Timetable(randomTime(), line2Names, 1);

        char[] line3Names = {'I', 'B', 'J', 'K', 'L', 'M'};
        Timetable line3direction1 = new Timetable(randomTime(), line3Names,1);
        Timetable line3direction2 = new Timetable(randomTime(), line3Names,-1);


        line2direction1.print();

    }

}


