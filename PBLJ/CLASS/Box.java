package PBLJ.CLASS;

public class Box {
    Double length;
    Double breadth;
    Double height;

    Box(){

    }

    Box(Double length,Double breadth,Double height){
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }

    Double calculateVolume(Double length,Double breadth,Double height){
        return length*breadth*height;
    }

    public static void main(String[] args) {
        Box b = new Box(90d,10d,22d);

        System.out.println(b.calculateVolume(b.length,b.breadth,b.height));
    }
}
