public class AlphabetPrinter {
    public static void main(String[] args) {
        Thread alphabetThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c = 'A'; c <= 'Z'; c++) {
                    System.out.print(c + " ");
                    try {
                        Thread.sleep(100); 
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        alphabetThread.start();
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            alphabetThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}