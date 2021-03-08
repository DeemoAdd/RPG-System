package entities;

public class Player {
    private int id;
    private String name;
    private String pclass;
    private String weapon;

    public Player(int id, String name, String pclass, String weapon) {
        setId(id);
        setName(name);
        setPclass(pclass);
        setWeapon(weapon);
    }

    public Player(String name, String pclass, String weapon) {
        setName(name);
        setPclass(pclass);
        setWeapon(weapon);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPclass() {
        return pclass;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPclass(String pclass) {
        this.pclass = pclass;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", class='" + pclass + '\'' +
                ", weapon=" + weapon +
                '}';
    }
}
