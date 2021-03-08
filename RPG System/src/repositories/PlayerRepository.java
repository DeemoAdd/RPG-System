package repositories;

import Database.IDB;
import entities.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerRepository implements IPlayerRepository {
    private final IDB db;

    public PlayerRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createPlayer(Player player) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO player(name, class, weapon) VALUES (?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, player.getName());
            st.setString(2, player.getPclass());
            st.setString(3, player.getWeapon());
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                con.close();
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Player getPlayer(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, class, weapon FROM player WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Player player = new Player(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("class"),
                        rs.getString("weapon"));

                return player;
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                con.close();
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
