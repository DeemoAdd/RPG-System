package repositories;

import entities.Player;
import java.util.List;

public interface IPlayerRepository {
    boolean createPlayer(Player player);

    Player getPlayer(int id);
}
