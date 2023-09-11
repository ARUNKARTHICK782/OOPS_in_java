package ThisvsSuper;

class ClassLeader extends Student {
    ClassLeader(String name) {
        super(name);
    }

    void getResponsibiites() {
        super.getResponsibiites();
        System.out.println("Monitoring");
    }
}
