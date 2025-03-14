class AlphabetThread extends Thread {
    public void run() {
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.print(c + " ");
        }
    }
}

class NumberThread extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
    }
}
public class AlphabetAndNumberThreads {
    public static void main(String[] args) {
        AlphabetThread alphabetThread = new AlphabetThread();
        NumberThread numberThread = new NumberThread();
        alphabetThread.start();
        numberThread.start();
    }
}