
class Patient {
    int id;
    int age;
    String bloodData;

    public Patient() {
        id = 0;
        age = 0;
        bloodData = "";
    }

    public Patient(int id, int age, String bloodData) {
        this.id = id;
        this.age = age;
        this.bloodData = bloodData;
    }

    int getId() {
        return id;
    }

    int getAge() {
        return age;
    }

    String getBloodData() {
        return bloodData;
    }
}

class BloodDemo {
    public static void main(String[] args) {
        // Testing the default constructor
        Patient defaultPatient = new Patient();
        System.out.println("Default Patient Info:");
        System.out.println("ID: " + defaultPatient.getId());
        System.out.println("Age: " + defaultPatient.getAge());
        
        System.out.println("Blood Type: " + defaultPatient.getBloodData());
        
        
        // Testing the overloaded constructor
        
        Patient customPatient = new Patient(12345, 30, "B+");
        System.out.println("\nCustom Patient Info:");
        System.out.println("ID: " + customPatient.getId());
        System.out.println("Age: " + customPatient.getAge());
        
        System.out.println("Blood Type: " + customPatient.getBloodData());
      
    }
}
