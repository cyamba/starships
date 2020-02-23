package com.yambacode.swapi.api;

import com.yambacode.swapi.model.Starship;
import com.yambacode.swapi.service.StarshipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/starships")
@RestController
public class StarshipController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StarshipController.class);


    private StarshipService starshipService;

    @Autowired
    public StarshipController(StarshipService starshipService) {
        this.starshipService = starshipService;
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Starship> listAll() {
        List<Starship> all = starshipService.listAll();
        LOGGER.info("Executing list all starships result : {}", all);
        return all;
    }


    @RequestMapping(value = "/ordered/{count}", method = RequestMethod.GET)
    @ResponseBody
    public List<Starship> getStarshipsByCost(@PathVariable Integer count) {
        return starshipService.getStarshipsByCost(count);
    }

    @RequestMapping(value = "/ordered", method = RequestMethod.GET)
    @ResponseBody
    public List<Starship> getStarshipsByCostDefault() {
        return starshipService.getStarshipsByCost(null);
    }

    @RequestMapping(value = "/{starShipId}", method = RequestMethod.GET)
    @ResponseBody
    public Starship getStarship(
            @PathVariable String starShipId) {
        return starshipService.getStarshipById(starShipId);
    }

    @RequestMapping(value = "/{starShipId}", method = RequestMethod.PUT)
    @ResponseBody
    public Starship modifyStarhipById(
            @PathVariable("starShipId") String starShipId,
            @Valid @RequestBody Starship starship) {
        starship.setStarshipId(starShipId);
        return starshipService.save(starship);
    }

}
