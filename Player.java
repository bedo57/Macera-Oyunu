import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int orijinalHealth;
    private int money;
    private String name;
    private String charName;
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getOrijinalHealth() {
        return orijinalHealth;
    }

    public void setOrijinalHealth(int orijinalHealth) {
        this.orijinalHealth = orijinalHealth;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    Scanner scan = new Scanner(System.in);

    public void selectChar() {
        GameCharacter[] charList = {new Samurai(), new Archer(), new Knight()};
        for (GameCharacter gameCharacter : charList) {
            System.out.println("id: " + gameCharacter.getId() +
                    "\tKarakter: " + gameCharacter.getName() +
                    "\t Hasar: " + gameCharacter.getDamage() +
                    "\t Sağlık: " + gameCharacter.getHealth() +
                    "\t Para: " + gameCharacter.getMoney());
        }
        System.out.println("--------------------");
        System.out.print("Lütfen karakterinizi seçin: ");
        int id = scan.nextInt();
        switch (id) {
            case 1:
                editPlayer(new Samurai());
                break;
            case 2:
                editPlayer(new Archer());
                break;
            case 3:
                editPlayer(new Knight());
                break;
            default:
                System.out.println(id + " idli bir karakter yok");
                break;
        }

    }

    public void editPlayer(GameCharacter gameCharacter) {
        this.setCharName(gameCharacter.getName());
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setOrijinalHealth(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getMoney());
    }

    public void printInfo() {
        System.out.println(
                "Karakter: " + this.charName +
                        "\t Silah: " + this.getInventory().getWeapon().getName() +
                        "\t Zırh: " + this.getInventory().getArmor().getName() +
                        "\t Engellenen Hasar: " + this.getInventory().getArmor().getBlock() +
                        "\t Hasar: " + this.getDamage() +
                        "\t Sağlık: " + this.getHealth() +
                        "\t Para: " + this.getMoney());
    }

}
