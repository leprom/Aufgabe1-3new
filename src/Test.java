import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Test {

        public static void main(String[] args) {

            for (int k = 1; k < 4; k++) {

                Graph gr = Graph.createGraph(k);
                Timetable[] times = Timetable.initializeTimetable(k);

                TrafficPoint[] nodes = new TrafficPoint[16];
                for (int i = 0; i < 16; i++) {
                    nodes[i] = new TrafficPoint();
                }

                //-----------------------------------------------------------------------------------------------
                // reading data from database line by line (ride by ride)
                // format of data - StartStationEndStation;HH:mm

                try (Scanner s = new Scanner(new File(System.getProperty("user.dir") + "/basicdata.txt"), "UTF-8")) {
                    s.useDelimiter(";|\n");
                    while (s.hasNext()) {

                        String travel = s.next();
                        String time = s.next();

                        if (travel.charAt(0) == travel.charAt(1))
                            continue;

                        // regulating format of time

                        if (time.length() == 5) {
                            time = time.replace('\0', '0');
                            char t = time.charAt(3);
                            time = time.replace(time.charAt(3), '0');
                            time = time.replace(time.charAt(4), t);
                        } else if (time.charAt(1) == ' ') {
                            char t = time.charAt(0);
                            time = time.replace(time.charAt(0), '0');
                            time = time.replace(time.charAt(1), t);
                        }

                        // regulating start and end station and their integer values ('A' = 0, etc.)

                        int start = travel.charAt(0) - 'A';
                        int end = travel.charAt(1) - 'A';
                        nodes[start].setStationsEntry(nodes[start].getStationsEntry() + 1);
                        nodes[end].setStationsExit(nodes[end].getStationsExit() + 1);


                        // applying Dijkstra algorithm in order to store all stations that are visited in one ride
                        // including start and end station

                        List<Integer> temp = DijkstraAlgorithm.dijkstra(gr.getMatrix(), start, end);

                        for (int i = 0; i < temp.size() - 1; i++) {
                            gr.getEdge(temp.get(i), temp.get(i + 1)).setPassengers(gr.getEdge(temp.get(i), temp.get(i + 1)).getPassengers() + 1);
                        }
                        temp.clear();


                        // left to be done:
                        // connecting every ride with timetable in order to gather statistical data about number of passengers
                        // that use one line at one section at one point in time and about required capacity per line


                    }
                } catch (FileNotFoundException e) {
                    System.exit(1);
                }

                int i, j = 0;
                int max = 0;
                int[] maxStations = new int[2];
                int min = 100000;
                int[] minStations = new int[2];
                double avg = 0;


                for (i = 0; i < 16; i++) {
                    for (j = 0; j < gr.getG()[i].size(); j++) {
                        avg = avg + gr.getEdge(i, gr.getG()[i].get(j).getV().getId()).getPassengers();
                        if (gr.getEdge(i, gr.getG()[i].get(j).getV().getId()).getPassengers() > max) {
                            max = gr.getEdge(i, gr.getG()[i].get(j).getV().getId()).getPassengers();
                            maxStations[0] = i;
                            maxStations[1] = gr.getG()[i].get(j).getV().getId();
                        }
                    }
                }

                avg = avg / 16;

                for (i = 0; i < 16; i++) {
                    for (j = 0; j < gr.getG()[i].size(); j++) {
                        if (gr.getEdge(i, gr.getG()[i].get(j).getV().getId()).getPassengers() < min) {
                            min = gr.getEdge(i, gr.getG()[i].get(j).getV().getId()).getPassengers();
                            minStations[0] = i;
                            minStations[1] = gr.getG()[i].get(j).getV().getId();
                        }
                    }
                }
                System.out.println("Statistics for traffic simulation number " + k);
                System.out.println();

                System.out.println("Maximum number of passengers is " + max + " between stations " + (char) ((int) 'A' + maxStations[0]) + " and " + (char) ((int) 'A' + maxStations[1]));
                System.out.println("Minimum number of passengers is " + min + " between stations " + (char) ((int) 'A' + minStations[0]) + " and " + (char) ((int) 'A' + minStations[1]));
                System.out.println("Average number of passengers per section is " + avg);
                System.out.println();

                for (i = 0; i < 16; i++) {
                    System.out.println("Station " + (char) ((int) 'A' + i) + ": Entries = " + nodes[i].getStationsEntry() + "; Exits = " + nodes[i].getStationsExit());
                }
                System.out.println();


            }
        }
}

/*

        Cooperating and responsibilities:

        Aleksa Glamocanin, e11722602@student.tuwien.ac.at : Creating Test-Data, Data reader and Timetables
        Ana Kubat, e01651143@student.tuwien.ac.at : Creating Dijkstra Algorithm and Graph creation
        Roman Lepilov, e01529676@student.tuwien.ac.at : Creating 3 Variances and converting Graph into Matrix

*/
