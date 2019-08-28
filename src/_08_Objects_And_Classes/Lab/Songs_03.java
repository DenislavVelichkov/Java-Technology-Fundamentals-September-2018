package _08_Objects_And_Classes.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Songs_03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Song> songs = new ArrayList<>();

        int numSongs = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numSongs; i++) {
            String[] data = sc.nextLine().split("_");

            String type = data[0];
            String name = data[1];
            String time = data[2];

            Song song = new Song();

            song.setTypeList(type);
            song.setName(name);
            song.setTime(time);

            songs.add(song);
        }

        String typeList = sc.nextLine();

        if (typeList.equals("all")) {
            for (Song song1 : songs) {
                System.out.println(song1.getName());
            }
        } else {
            List<Song> filterSong = songs.stream()
                    .filter(e -> e.getTypeList()
                            .equals(typeList))
                    .collect(Collectors.toList());

            for (Song song : filterSong) {
                System.out.println(song.getName());

            }
        }
    }
}

class Song {
    private String typeList;
    private String name;
    private String time;

    String getTypeList() {
        return typeList;
    }

    void setTypeList(String typeList) {
        this.typeList = typeList;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    void setTime(String time) {
        this.time = time;
    }
}

