package astonaqa.lesson4;

public class Park {
    public class Attractions {
        String name_attr;
        int stoimost;
        String timetowork;
        public Attractions(String name_attr,int stoimost,String timetowork){
            this.name_attr=name_attr;
            this.stoimost=stoimost;
            this.timetowork=timetowork;
        }
        public void Info(){
            System.out.println("Nazvanie attrakciona-"+name_attr);
            System.out.println("Stoimost-"+stoimost+"r.");
            System.out.println("Vremya raboti-"+timetowork);
        }

    }


}
