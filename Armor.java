public class Armor {
    private int id;
    private String name;
    private int block;
    private int money;

    public Armor(String name, int id, int block, int money) {
        this.id = id;
        this.name = name;
        this.block = block;
        this.money = money;
    }

    public static Armor[] armor() {
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor("Hafif", 1, 1, 15);
        armorList[1] = new Armor("Orta ", 2, 3, 25);
        armorList[2] = new Armor("Ağır", 3, 5, 40);
        return armorList;
    }

    public static Armor getArmorObjByID(int id){
        for (Armor a : Armor.armor()){
            if (a.getId() == id){
                return a;
            }
        }
        return null;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
