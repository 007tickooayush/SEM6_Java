package PBLJ.LAB.EXP2;

import java.io.PrintStream;
import java.util.Scanner;

class Video {
    String title ;

    Integer rating ;
    Integer avgRating ;
    Integer rateCount ;
    Integer videos;
    static Integer capacity = 10;

    Boolean sold ;
    Boolean rated ;

    Video(String title, Integer rating, Boolean sold, Boolean rated,Integer rateCount,Integer videos) {
        this.title = title;
        this.rating = rating;
        this.sold = sold;
        this.rated = rated;
        this.rateCount = rateCount;
        this.videos = videos;
    }

    static void videoSold(Video video) {
        video.sold = true;
    }

    static void videoReturned(Video video) {
        video.sold = false;
    }

    static void rateVideo(Video video,Boolean rated,Integer rating) {
        video.rated = rated;
        video.rating = rating;

        if(video.rateCount==2){
            video.avgRating = (2*video.rating)/video.rateCount;
        }

        if(video.rateCount>2){
           video.avgRating = (video.avgRating + video.rating);
           video.avgRating/=2;
        }
    }
}

class VideoStore {
    int total = 0;
    int available = 0;

    Video[] video = new Video[Video.capacity + 1];

    void addVideo(String title) {
        int n = ++total;
        video[n-1] = new Video(title, 0, false, false,0,n);
        available=n;
    }

    void checkOut(String title) {
        for (int i = 0; i < total; i++) {
            if (video[i].title.equals(title)) {
                Video.videoSold(video[i]);
                break;
            }
        }
        available--;
    }

    void returnVideo(String title) {
        int i;
        for (i = 0; i < total; i++) {
            if (video[i].title.equals(title)) {

                break;
            }
        }
        Video.videoReturned(video[i]);
        available++;
    }

    void recieveRating(String title, Integer rating) {
        int i;
        for (i=0;i<total;i++){
            if(video[i].title.equals(title)){
                break;
            }
        }
        video[i].rateCount++;
        video[i].rated = true;
        Video.rateVideo(video[i],video[i].rated,rating);

    }

    void listInventory() {

        System.out.format("%-30s %-20s %-10s %-10s %-10s %-10s %-15s", "TITLE", "LAST RATING", "RATING", "SOLD","RATED","RATE_COUNT","CURRENT TOTAL");
        System.out.println();
        for (int i = 0; i < total; i++){
            System.out.format("%-30s %-20d %-10d %-10s %-10s %-10s %-15s", video[i].title, video[i].rating, video[i].avgRating, video[i].sold.toString(),video[i].rated,video[i].rateCount,video[i].videos);
            System.out.println();
        }
        System.out.println();
    }
}


public class VideoRentalStore {
    static final private Scanner scan = new Scanner(System.in);
    static final private PrintStream print = new PrintStream(System.out);

    public static void main(String[] args) {
        VideoStore video = new VideoStore();

        String[] films = new String[]{"The Matrix", "The GodFather", "Star Wars IV:A New Hope"};
        video.addVideo(films[0]);
        video.listInventory();
        video.addVideo(films[1]);
        video.addVideo(films[2]);

        video.recieveRating(films[0],4);
        video.recieveRating(films[0],5);
        video.recieveRating(films[0],3);
        video.recieveRating(films[0],5);
        video.recieveRating(films[0],4);
        video.recieveRating(films[0],4);
        video.recieveRating(films[0],4);


        video.recieveRating(films[1],4);
        video.recieveRating(films[1],4);
        video.recieveRating(films[1],5);
        video.recieveRating(films[1],5);
        video.recieveRating(films[1],5);

        video.recieveRating(films[2],4);
        video.recieveRating(films[2],5);
        video.recieveRating(films[2],2);
        video.recieveRating(films[2],2);
        video.recieveRating(films[2],4);

        video.checkOut(films[1]);
        video.returnVideo(films[1]);

        //show inventory
        video.listInventory();

        video.checkOut(films[0]);
        video.returnVideo(films[0]);

        video.checkOut(films[2]);
        video.returnVideo(films[2]);

        video.checkOut(films[1]);

        video.listInventory();
        scan.close();
        print.close();
    }
}
