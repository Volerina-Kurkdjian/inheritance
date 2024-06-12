package inheritance;

    public interface Swimming {
        String DEFAULT = "Diving!";
        abstract int breath();
        private  void stroke() {
            if(breath()==1) {
                System.out.print("Go!");
            } else {
                System.out.print(dive());
            }
        }
        static String dive() {
            return DEFAULT;
        }
    }


