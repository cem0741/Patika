import java.util.Scanner;

public class Game {
    private Scanner input =new Scanner(System.in);

    public void start(){
        System.out.println("Macera oyununa hoşgeldiniz !");
        System.out.print("Lütfen bir isim giriniz : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);

        System.out.println(player.getName()+ "  Hoşgeldiniz !");
        System.out.println("Lütfen bir karakter seçiniz ! ");
        player.selectChar();
        Location location=null;
        while(true){
            player.printInfo();
            System.out.println();
            System.out.println("############ Bölgeler ############");
            System.out.println();
            System.out.println("1- Güvenli Ev ---> Burası sizin için güvenli bir ev, düşman yoktur! ");
            System.out.println("2- Eşya Dükkanı --> Silah veya Zırh satın alabilirsiniz ! ");
            System.out.println("3- Mağara -->  Ödül <Yemek> , Dikkatli ol **Zombi** çıkabilir! ");
            System.out.println("4- Orman  -->  Ödül <Odun>  , Dikkatli ol **Vampir** çıkabilir!");
            System.out.println("5- Nehir  -->  Ödül <Su>    , Dikkatli ol **Ayı** çıkabilir!");
            System.out.println("0 - Çıkış yap -->> Oyunu Sonlandır. ! ");

            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selectLoc= input.nextInt();

            switch (selectLoc){
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
                    location= new Cave(player);
                    break;
                case 4:
                    location= new Forest(player);
                    break;
                case 5:
                location= new River(player);
                break;
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz");

            }
            if (location==null){
                System.out.println("Oyun sonlandırıldı...");
                break;
            }

            if (!location.onLocation()) {
                System.out.println("Game Over !");
                break;
            }

        }


    }
}
