import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int num = menu();
        if (num == 1){
            System.out.println("What would you like to name your Battle Healer?");
            String name = scanner.nextLine();
            battleHealer myBattleHealer = new battleHealer(name);
            myBattleHealer.displayStats();
            
            
        }
        else if(num == 2){
            System.out.println("What would you like to name your Royal Ghost?");
            String name = scanner.nextLine();
            RoyalGhost myRoyalGhost = new RoyalGhost(name);
            
        }
        else if(num == 3){
            System.out.println("What would you like to name your Elixer Golem?");
            String name = scanner.nextLine();
            ElixerGolem myElixerGolem = new ElixerGolem(name);
            myElixerGolem.displayStats();
            
        }
        else if(num == 4)
            System.out.println("What would you like to name your Skeleton?");
            String name = scanner.nextLine();
            skelleton myskelleton = new skelleton(name);
            
        }
    }
    
    public static int menu(){
            System.out.println("Which card would you like to use:");
            System.out.println("1. Battle Healer");
            System.out.println("2. Royal Ghost");
            System.out.println("3. Elixer Golem");
            System.out.println("4. Skeleton");
            System.out.println("5. Quit");
            int choice = scanner.nextInt();
            return choice;
            
        }
        
        
    
}
