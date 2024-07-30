public class Zad3 {

    public static class Park {
        private String name;
        private Attraction[] attractions;
        public Park(String name, Attraction[] attractions) {
            this.name = name;
            this.attractions = attractions;
        }
        public String getName() {
            return name;
        }
        public Attraction[] getAttractions() {
            return attractions;
        }
        public static class Attraction {
            private String name;
            private String workingHours;
            private double price;
            public Attraction(String name, String workingHours, double price) {
                this.name = name;
                this.workingHours = workingHours;
                this.price = price;
            }
            public String getName() {
                return name;
            }

            public String getWorkingHours() {
                return workingHours;
            }

            public double getPrice() {
                return price;
            }
        }
    }
    public static void main(String[] args) {
        Park.Attraction attraction1 = new Park.Attraction("Карусель", "10:00-22:00", 5.0);
        Park.Attraction attraction2 = new Park.Attraction("Американские горки", "11:00-21:00", 10.0);
        Park.Attraction attraction3 = new Park.Attraction("Колесо обозрения", "10:00-22:00", 8.0);
        Park park = new Park("Парк развлечений", new Park.Attraction[] {attraction1, attraction2, attraction3});
        System.out.println("Название парка: " + park.getName());
        System.out.println("Аттракционы:");
        for (Park.Attraction attraction : park.getAttractions()) {
            System.out.println("- " + attraction.getName() + " (" + attraction.getWorkingHours() + ", " + attraction.getPrice() + " руб.)");
        }
    }
}
