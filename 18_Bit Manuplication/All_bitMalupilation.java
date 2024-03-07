    import java.util.*;

public class All_bitMalupilation {
public class Bitsmanipulation{
    public static int Get(int n){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter i: ");
        int i=sc.nextInt();
        int bitMask=1<<i;
        if((n & bitMask)==0){
            return 0;
        }else{
            return 1;
        }
    }
    public static int Set(int n){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter i: ");
        int i=sc.nextInt();
        int bitMask=1<<i;
        return n|bitMask;

    }
    public static int Clear(int n){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter i: ");
        int i=sc.nextInt();
        int bitMask=~(1<<i);
        return n & bitMask;

    }
    public static int Update(int n){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter i: ");
        int i=sc.nextInt();
        System.out.println("Enter NewBit: ");
        int NewBit=sc.nextInt();
        if(NewBit==0){
            return Clear(n);
        }
        else{
            return Set(n);
        }
    }
    public static int Clearibit(int n){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter i: ");
        int i=sc.nextInt();
        int BitMask=(~0)<<i;
        return n&BitMask;
    }
    public static int ClearRange(int n){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter i and j: ");
        int i=sc.nextInt();
        int j=sc.nextInt();
        int a=((~0)<<(j+1));
        int b=(1<<i)-1;
        int BitMask=a|b;
        return n & BitMask;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n=sc.nextInt();
        System.out.print("Enter the choice: "); 
        sc.nextLine();
        String choice=sc.nextLine();
        switch(choice){
            case"Get ith bit":
            System.out.println(Get(n));
            break;
            case"Set ith bit":
            System.out.println(Set(n));
            break;
            case"Clear ith bit":
            System.out.println(Clear(n));
            break;
            case"Update ith bit":
            System.out.println(Update(n));
            break;
            case"Clear last ibits":
            System.out.println(Clearibit(n));
            break;
            case"Clear range of ibits":
            System.out.println(ClearRange(n));
            break;
            default:
            System.out.println("Invalid Choice!!");
         }
    }
}
}
