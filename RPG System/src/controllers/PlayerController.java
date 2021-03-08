package controllers;

import entities.Player;
import repositories.IPlayerRepository;

public class PlayerController {
    private final IPlayerRepository repo;

    public PlayerController(IPlayerRepository repo) {
        this.repo = repo;
    }

    public String createPlayer(String name, String pclass, String weapon) {
        Player player = new Player(name, pclass, weapon);

        boolean created = repo.createPlayer(player);

        return (created ? "User was created!" : "User creation was failed!");
    }

    public String getPlayer(int id) {
        Player player = repo.getPlayer(id);

        return (player == null ? "Player was not found!" : player.toString());
    }
}