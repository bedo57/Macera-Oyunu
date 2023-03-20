import java.util.Random;
import java.util.Scanner;

public abstract class BattleLoc extends Location{

    private Monster monster;
    private String award;
    private int maxMonster;

    Scanner scan = new Scanner(System.in);
    public BattleLoc(Player player, String name, Monster monster, String award, int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }
    @Override
    public boolean onLocation() {
        int monsNumber = this.randMonsterNumber();
        System.out.println("Şuan buradasınız " + this.getName());
        System.out.println("Dikkatli Ol! Burada " + monsNumber + " tane " + this.getMonster().getName() + " yaşıyor!");
        System.out.print("Savaşmak için -> S " +
                "\nKaçmak için -> K  : ");
        String selectCase = scan.nextLine().toUpperCase();
        if (selectCase.equals("S")){
            if(combat(monsNumber)){
                System.out.println("Tüm canavarları yendiniz");
                return true;
            }
        }
        if (this.getPlayer().getHealth() <= 0){
            System.out.println("Öldünüz");
            return false;
        }
        return true;
    }

    public boolean combat(int monsNumber){
        for(int i=1; i <= monsNumber; i++){
            this.getMonster().setHealth(this.getMonster().getOrijinalHealth());
            playerStats();
            monsterStats(i);
            while(this.getPlayer().getHealth() > 0  && this.getMonster().getHealth() > 0){
                System.out.print("Saldırmak için <S> " +
                        "\n Kaçmak için <K>  : ");
                String selectCombat = scan.nextLine().toUpperCase();
                if (selectCombat.equals("S")){
                    System.out.println("Siz vurdunuz!");
                    monster.setHealth(this.monster.getHealth() - this.getPlayer().getDamage());
                    afterHit();
                    if (this.getMonster().getHealth() > 0){
                        System.out.println("Canavar size vurdu!");
                        int monsterDmg = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if(monsterDmg < 0 )
                            monsterDmg = 0;
                        getPlayer().setHealth(this.getPlayer().getHealth() - monsterDmg);
                        afterHit();
                    }
                }else {
                    return false;
                }
            }
            if (this.getMonster().getHealth() < this.getPlayer().getHealth()){
                System.out.println("----------------");
                System.out.println("Düşmanı yendiniz ve " + this.getMonster().getAward() + " altın kazandınız");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
                System.out.println("Güncel paranız: " + this.getPlayer().getMoney());
            }else {
                return false;
            }
        }
        return true;
    }
    public void afterHit(){
        System.out.println("-------------");
        System.out.println("Canınız: " + this.getPlayer().getHealth());
        System.out.println(getMonster().getName() + " canı: " + this.getMonster().getHealth());
    }

    public void playerStats(){
        System.out.println();
        System.out.println("Oyuncu değerleri");
        System.out.println("-------------------");
        System.out.println("Sağlık : " + this.getPlayer().getHealth());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar : " + this.getPlayer().getDamage());
        System.out.println("Zırh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Engellenen hasar : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para : " + this.getPlayer().getMoney());
    }
    public void monsterStats(int i){
        System.out.println();
        System.out.println(i+ ". " + this.getMonster().getName() + " Bilgileri");
        System.out.println("----------------");
        System.out.println("Sağlık : " + this.getMonster().getHealth());
        System.out.println("Hasar : " + this.getMonster().getDamage());
        System.out.println("Ödül : " + this.getMonster().getAward());
    }
    public int randMonsterNumber(){
        Random rand = new Random();
        return rand.nextInt(3) + 1;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
}
