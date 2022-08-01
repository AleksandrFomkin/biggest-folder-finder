import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {

//        MyThread thread1 = new MyThread(1);
//        MyThread thread2 = new MyThread(2);
//        thread1.start();
//        thread2.start(); // пример работы многопоточности

        String folderPath = "C:\\Users\\Aleksandr.DESKTOP-ETBP0DQ\\Desktop\\Программы";
        File file = new File(folderPath);

        FolderSizeCalculator calculator = new FolderSizeCalculator(file);
        ForkJoinPool pool = new ForkJoinPool();
        long size = pool.invoke(calculator);
        System.out.println(size);
    }
    public static long getFolderSize(File folder){
        if(folder.isFile()){
            return folder.length();
        }
        long sum = 0;
        File[] files = folder.listFiles();
        for(File file : files){
            sum += getFolderSize(file);
        }
        return sum;
    }
}
