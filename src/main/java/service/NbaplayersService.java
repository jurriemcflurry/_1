package service;

import model.Nbaplayer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class NbaplayersService {

    List<Nbaplayer> nbaplayers = new ArrayList<Nbaplayer>(
            Arrays.asList(
                    new Nbaplayer("1", "LeBron James", "LA Lakers", 2),
                    new Nbaplayer("2", "Kevin Durant", "Golden State Warriors", 1),
                    new Nbaplayer("3", "Giannis Antetokounmpo", "Milwaukee Bucks", 3)
            )
    );

    public List<Nbaplayer> getNbaplayers(boolean sorted, int minimum, int pageSize){
        Stream<Nbaplayer> nbaplayerStream = nbaplayers.stream()
                .filter(nbaplayer -> nbaplayer.getRank() >= minimum);

        if(sorted){
            nbaplayerStream = nbaplayerStream
                    .sorted(Comparator.comparingInt(Nbaplayer::getRank));
        }

        return nbaplayerStream
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    public Nbaplayer getNbaplayer(String id){
        return nbaplayers.stream()
                .filter(nbaplayer -> nbaplayer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addNbaplayer(Nbaplayer nbaplayer){
        nbaplayers.add(nbaplayer);
    }

    public List<Nbaplayer> getNbaplayersByName(String playerName){
        return nbaplayers.stream()
                .filter(nbaplayer -> nbaplayer.getPlayerName().equals(playerName))
                .collect(Collectors.toList());
    }

}
