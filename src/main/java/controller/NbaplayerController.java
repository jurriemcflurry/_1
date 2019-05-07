package controller;

import model.Nbaplayer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.NbaplayersService;

import java.util.List;

@RestController
@RequestMapping("/nbaplayer")
public class NbaplayerController {

    private NbaplayersService nbaplayersService;

    public NbaplayerController(NbaplayersService nbaplayersService){
        this.nbaplayersService = nbaplayersService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Nbaplayer> getAllNbaplayers(@RequestParam(required = false) boolean sorted,
                                            @RequestParam(required = false, defaultValue = "0") int minimum,
                                            @RequestParam(required = false, defaultValue = "" + Integer.MAX_VALUE) int pageSize
    ){
        return nbaplayersService.getNbaplayers(sorted, minimum, pageSize);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Nbaplayer getNbaplayerById(@PathVariable String id){
        return nbaplayersService.getNbaplayer(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addNbaplayer(@RequestBody Nbaplayer nbaplayer){
        nbaplayersService.addNbaplayer(nbaplayer);
    }

    @RequestMapping(value = "playerName/{playerName}")
    public List<Nbaplayer> getNbaplayerByName(@PathVariable String playerName){
        return nbaplayersService.getNbaplayersByName(playerName);
    }
}
