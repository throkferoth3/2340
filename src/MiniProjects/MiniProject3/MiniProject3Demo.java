package MiniProjects.MiniProject3;

public class MiniProject3Demo {
    public static void main(String[] args) {
        Employee headOfCompany = new Employee("James Borg", "CEO", "Headquarters", 220000,
                "Male", false);
        Employee jWallace = new Employee("Jennifer Wallace", "CFO", "Administration",
                172000, "Female", true);
        Employee aZelaya = new Employee("Alicia Zelaya", "Office Manager", "Administration",
                75000, "Female", false);
        Employee aJabbar = new Employee("Ahmad Jabbar", "Admin", "Administration",
                100000, "Male", false);
        Employee fWong = new Employee("Franklin Wong", "CRADO", "R&D", 160000,
                "Male", true);
        Employee jSmith = new Employee("John Smith", "Research Assistant", "R&D", 120000,
                "Male", true);
        Employee rNarayan = new Employee("Ramesh Narayan", "Data Scientist", "R&D", 152000,
                "Male", false);

        headOfCompany.addChild(jWallace);
        headOfCompany.addChild(fWong);
        jWallace.addChild(aZelaya);
        jWallace.addChild(aJabbar);
        fWong.addChild(jSmith);
        fWong.addChild(rNarayan);

        System.out.println(headOfCompany.generateReport1());
        System.out.println(headOfCompany.generateReport2());
        System.out.println(headOfCompany.generateReport3());
        System.out.println(headOfCompany.generateReport4());

        rNarayan.addChild(new Employee("Joyce English", "ML Engineer", "R&D", 140000,
                "Female", false));

        System.out.println(headOfCompany.generateReport1());
        System.out.println(headOfCompany.generateReport2());
        System.out.println(headOfCompany.generateReport3());
        System.out.println(headOfCompany.generateReport4());
    }
}
