package PBLJ.CLASS;

abstract class GeneralBank{
    abstract double getSavingInterestRate();
    abstract double getFixedInterestRate();
}
class ICICIBank extends GeneralBank{

    @Override
    double getSavingInterestRate() {
        return 0.04;
    }

    @Override
    double getFixedInterestRate() {
        return 0.085;
    }
}
class KotMBank extends GeneralBank{

    @Override
    double getSavingInterestRate() {
        return 0.06;
    }

    @Override
    double getFixedInterestRate() {
        return 0.09;
    }
}



public class Bank {
}

//end
