import java.util.Scanner;

public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println();
        System.out.println("--- Mağazaya Hoşgeldiniz ---");
        boolean showMenu = true;

        while (showMenu){
            Scanner scan = new Scanner(System.in);
            System.out.println("1 - Silahlar");
            System.out.println("2 - Zırhlar");
            System.out.println("0 - Çıkış yap");
            System.out.print("Seçiminiz: ");
            int selecetCase = scan.nextInt();

            while (selecetCase < 1 || selecetCase > 3) {
                System.out.print("Geçersiz değer, Tekrar giriniz: ");
                selecetCase = scan.nextInt();
            }
            switch (selecetCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 0:
                    System.out.println("Tekrar bekleriz");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    Scanner scan = new Scanner(System.in);

    public void printWeapon() {
        System.out.println();
        System.out.println("--- Silahlar ---");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + " - " + w.getName() + " <Para : " + w.getMoney() + " , Hasar : " + w.getDamage() + ">");
        }
        System.out.println("0 - Çıkış yap");
    }

    public void buyWeapon() {
        System.out.print("Bir silah seçiniz: ");
        int selectWeaponID = scan.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.print("Geçersiz değer, Tekrar giriniz: ");
            selectWeaponID = scan.nextInt();
        }
        if (selectWeaponID != 0){
            Weapon selectWeapon = Weapon.getWeaponObjByID(selectWeaponID);
            if (selectWeapon != null) {
                if (selectWeapon.getMoney() > getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır");
                    System.out.println();
                    System.out.println("--- Mağazaya Hoşgeldiniz ---");
                } else {
                    if(selectWeapon.getName() != getPlayer().getInventory().getWeapon().getName()){
                        System.out.println(selectWeapon.getName() + " aldınız");
                        getPlayer().setMoney(getPlayer().getMoney() - selectWeapon.getMoney());
                        getPlayer().setDamage(getPlayer().getDamage() + selectWeapon.getDamage());
                        getPlayer().getInventory().setWeapon(selectWeapon);
                        System.out.println();
                        System.out.println("--- Mağazaya Hoşgeldiniz ---");
                    }else {
                        System.out.println(selectWeapon.getName() + " silahı mevcut, tekrar alamazsınız");
                        System.out.println();
                        System.out.println("--- Mağazaya Hoşgeldiniz ---");
                    }
                }
            }
        }else {
            System.out.println();
            System.out.println();
            System.out.println("--- Mağazaya Hoşgeldiniz ---");
        }
    }

    public void printArmor() {
        System.out.println();
        System.out.println("--- Zırhlar ---");
        for (Armor a : Armor.armor()) {
            System.out.println(a.getId() + " - " + a.getName() + " <Para : " + a.getMoney() + " , Zırh : " + a.getBlock() + ">");
        }
        System.out.println("0 - Çıkış yap");
    }

    public void buyArmor(){
        System.out.print("Bir zırh seçiniz: ");
        int selectArmorID = scan.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armor().length) {
            System.out.print("Geçersiz değer, Tekrar giriniz: ");
            selectArmorID = scan.nextInt();
        }
        if (selectArmorID != 0){
            Armor selectArmor = Armor.getArmorObjByID(selectArmorID);
            if (selectArmor != null){
                if (selectArmor.getMoney() > getPlayer().getMoney()){
                    System.out.println("Yeterli paranız bulunmamaktadır");
                    System.out.println();
                    System.out.println("--- Mağazaya Hoşgeldiniz ---");
                }else {
                    if(selectArmor.getName() != getPlayer().getInventory().getArmor().getName()){
                        System.out.println(selectArmor.getName() + " zırh aldınız");
                        getPlayer().setMoney(getPlayer().getMoney() - selectArmor.getMoney());
                        getPlayer().getInventory().setArmor(selectArmor);
                        System.out.println();
                        System.out.println("--- Mağazaya Hoşgeldiniz ---");
                    }else {
                        System.out.println(selectArmor.getName() + " zırh mevcut, tekrar alamazsınız");
                        System.out.println();
                        System.out.println("--- Mağazaya Hoşgeldiniz ---");
                    }
                }
            }
        }else {
            System.out.println();
            System.out.println("--- Mağazaya Hoşgeldiniz ---");

        }
    }
}
