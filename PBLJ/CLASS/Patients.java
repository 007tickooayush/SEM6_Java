package PBLJ.CLASS;

class Patient {
    String name="";
    Double weight;
    Double height;
    Patient(String name, Double weight, Double height){
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    static Double calculateBMI(Patient patient){
        Double weight = patient.weight, height = patient.height;
        return (weight/Math.pow(height,2))*703d;
    }
}

public class Patients {

    public static void main(String[] args) {
        Patient sam = new Patient("Sam",120d,180d);
        System.out.print(Patient.calculateBMI(sam));
    }
}
