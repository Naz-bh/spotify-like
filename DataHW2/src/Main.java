import java.util.*;

public class Main {

    public static void main(String[] args) {
        LinkedList name = new LinkedList();
        LinkedList allNames = new LinkedList();
        LinkedList song = new LinkedList();
        LinkedList allSongs = new LinkedList();

        while (true) {

            Scanner scan = new Scanner(System.in);
            String operation = scan.next();

            switch (operation.toUpperCase()) {

                case ("C"):

                    String name_forC = scan.next().toLowerCase();

                    if (!name.contains(name_forC)) {
                        name.insert(name_forC);
                    }

                    break;

                case ("S"):

                    String name_forS = scan.next().toLowerCase();
                    String song_forS = scan.nextLine().toLowerCase();

                    allNames.insert(name_forS);
                    allSongs.insert(song_forS);

                    if (!name.contains(name_forS)) {
                        name.insert(name_forS);
                    }
                    if (!song.contains(song_forS)) {
                        song.insert(song_forS);
                    }

                    break;

                case ("E"):
                    String name_forE = scan.next().toLowerCase();
                    String song_forE = scan.nextLine().toLowerCase();
                    for (int i = 0; i < allNames.findSize(); i++) {
                        if (allNames.get(i).equals(name_forE) && allSongs.get(i).equals(song_forE)) {
                            allNames.deleteAtPosition(i);
                            allSongs.deleteAtPosition(i);

                        }
                    }
                    break;

                case ("L"):
                    String name_forL = scan.next().toLowerCase();
                    System.out.println("Songs that " + name_forL + " likes : ");
                    for (int i = 0; i < allNames.findSize(); i++) {
                        if ((allNames.get(i).equals(name_forL))) {
                            System.out.println(allSongs.get(i));
                        }
                    }
                    break;

                case ("N"):
                    System.out.println("Names: ");
                    name.printList();
                    break;

                case ("M"):
                    System.out.println("Songs: ");
                    song.printList();
                    break;

                case ("R"):
                    LinkedHashMap<String, Integer> frequencyMap = new LinkedHashMap();
                    for (int i = 0; i < allSongs.findSize(); i++) {
                        String temp = String.valueOf(allSongs.get(i));
                        int frequency = 0;
                        for (int j = 0; j < allSongs.findSize(); j++) {
                            if ((allSongs.get(j)).equals(allSongs.get(i))) {
                                frequency++;
                                frequencyMap.put(temp, frequency);
                            }
                        }
                    }
                    TreeSet<Map.Entry<String, Integer>> sorted = new TreeSet<>(new Comparator<Map.Entry<String, Integer>>() {
                        @Override
                        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                            if (o1.getValue() <= o2.getValue()) return 1;
                            else  return -1;
                        }
                    });
                    sorted.addAll(frequencyMap.entrySet());
                    System.out.println("Recommended songs: ");
                    for (int i = 0; i < 3; i++) {
                        System.out.print(i + 1 + ". ");
                        System.out.print(sorted.pollFirst());
                        System.out.print(" times listened.\n");
                    }
                    break;

                default:
                    System.exit(0);
                    break;
            }
        }
    }
}