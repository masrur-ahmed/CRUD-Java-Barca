package com.masrur.controller;

import com.masrur.entity.Player;
import com.masrur.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private PlayerRepository playerRepository;

    @PostMapping("/player")
    public Player savePlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @GetMapping("/player/{id}")
    public Player getPlayer(@PathVariable("id") String playerId) {
        return playerRepository.getPlayerById(playerId);
    }

    @DeleteMapping("/player/{id}")
    public String deletePlayer(@PathVariable("id") String playerId) {
        return  playerRepository.delete(playerId);
    }

    @PutMapping("/player/{id}")
    public String updatePlayer(@PathVariable("id") String playerId, @RequestBody Player player) {
        return playerRepository.update(playerId,player);
    }
}
