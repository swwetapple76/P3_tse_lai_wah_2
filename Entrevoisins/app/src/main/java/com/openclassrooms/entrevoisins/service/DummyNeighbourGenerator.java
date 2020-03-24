package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyNeighbourGenerator {

    public static List<Neighbour> DUMMY_NEIGHBOURS = Arrays.asList(
            //b.	Modify the DummyNeighbourGenerator and the favorites to the list
            new Neighbour(0, "Caroline", "http://i.pravatar.cc/150?u=a042581f4e29026704d",true),
            new Neighbour(1, "Jack", "http://i.pravatar.cc/150?u=a042581f4e29026704e",false),
            new Neighbour(2, "Chloé", "http://i.pravatar.cc/150?u=a042581f4e29026704f",true),
            new Neighbour(3, "Vincent", "http://i.pravatar.cc/150?u=a042581f4e29026704a",false),
            new Neighbour(4, "Elodie", "http://i.pravatar.cc/150?u=a042581f4e29026704b",true),
            new Neighbour(5, "Sylvain", "http://i.pravatar.cc/150?u=a042581f4e29026704c",false),
            new Neighbour(6, "Laetitia", "http://i.pravatar.cc/150?u=a042581f4e29026703d",false),
            new Neighbour(7, "Dan", "http://i.pravatar.cc/150?u=a042581f4e29026703b",false),
            new Neighbour(8, "Joseph", "http://i.pravatar.cc/150?u=a042581f4e29026704d",false),
            new Neighbour(9, "Emma", "http://i.pravatar.cc/150?u=a042581f4e29026706d",false),
            new Neighbour(10, "Patrick", "http://i.pravatar.cc/150?u=a042581f4e29026702d",false),
            new Neighbour(11, "Ludovic", "http://i.pravatar.cc/150?u=a042581f3e39026702d",false)
    );

    static List<Neighbour> generateNeighbours() {
        return new ArrayList<>(DUMMY_NEIGHBOURS);

    }
    public static List<Neighbour> NEW_NEIGHBOUR = Arrays.asList(
            new Neighbour(12, "ABC", "http://i.pravatar.cc/150?u=a042581f4e29026704c",false),
            new Neighbour(13, "CDE", "http://i.pravatar.cc/150?u=a042581f4e29026703d",false)

            );
}
