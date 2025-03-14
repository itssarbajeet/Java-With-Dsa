
class Bank {
    public double getRateOfInterest() {
        return 0.0;
    }
}

class SBI extends Bank {
    public double getRateOfInterest() {
        return 5.0; 
    }
}

class HDFC extends Bank {
    public double getRateOfInterest() {
        return 6.0;
    }
}
 
class Axis extends Bank {
    public double getRateOfInterest() {
        return 7.0;
    }
}