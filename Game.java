import java.util.Scanner;

public class Game {

    Scanner scan = new Scanner(System.in);

    public void start() {
        System.out.println("Macera oyununa hoşgeldiniz");
        System.out.print("İsminizi girin: ");
        String playerName = scan.nextLine();

        Player player = new Player(playerName);
        System.out.println("Hosgeldin " + player.getName());
        System.out.println("---------------------------");
        System.out.println("Karakterler");
        player.selectChar();


        Location location = null;
        while (true) {
            System.out.println("Karakter Bilgileri");
            player.printInfo();
            System.out.println();
            System.out.print("######### Bölgeler #########" +
                    "\n-> 1 Güvenli Ev" +
                    "\n-> 2 Eşya dükkanı --> Silah veya Zırh satın alabilirsin" +
                    "\n-> 3 Mağara --> ÖDÜL <Yemek>" +
                    "\n-> 4 Orman --> ÖDÜL <Odun>" +
                    "\n-> 5 Nehir --> ÖDÜL <Su>" +
                    "\n-> 0 Çıkıs yap" +
                    "\nLütfen gitmek istediğiniz bölgeyi seçin: ");
            int loc = scan.nextInt();
            switch (loc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz !");

            }

            if (location == null){
                System.out.println("Oyun Kapatılıyor...");
                break;
            }
            if (!location.onLocation()){
                System.out.println("Game Over");
                break;
            }


        }

    }
}
