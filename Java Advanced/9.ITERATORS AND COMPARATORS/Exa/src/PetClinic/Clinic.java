package PetClinic;

public class Clinic {
    private String name;
    private Pet [] rooms;

    public Clinic(String name, int n) {
        this.name = name;
        this.rooms = new Pet[n];
    }
    public boolean add(Pet pet){
        int size =rooms.length- rooms.length/2;
        for (int i = 0; i < size; i++) {
            if (this.rooms[rooms.length/2-i]==null){
                this.rooms[rooms.length/2-i]=pet;
                return true;
            }else if (this.rooms[rooms.length/2+i]==null){
                this.rooms[rooms.length/2+i]=pet;
                return true;
            }
        }
        return false;
    }
    public boolean release(){
        int size =rooms.length-rooms.length/2;
        for (int i = size-1; i < rooms.length; i++) {
         if (this.rooms[i]!=null){
             this.rooms[i]=null;
             return true;
         }
        }
        for (int i = 0; i < size; i++) {
            if (this.rooms[i]!=null){
                this.rooms[i]=null;
                return true;
            }
        }
        return false;
    }
    public boolean hasEmptyRooms(){
        for (Pet pet:rooms
             ) {
            if (pet==null){
                return true;
            }
        }
        return false;
    }
    public void print(){
        for (Pet pet:rooms
        ) {
            if (pet==null){
                System.out.println("Room empty");
            }else {
                System.out.println(pet.toString());
            }
        }
    }
    public void print(int room){
        System.out.println(rooms[room-1].toString());
    }

}
