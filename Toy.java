public class Toy {
    String name;
    int weight;
    int id;
    int quantity;

    public Toy(String name, int id, int weight, int quantity){
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.quantity = quantity;
    }

    public String getName (){
        return this.name;
    }
    public int getWeight (){
        return this.weight;
    }
    public void setWeight (int weight){
        this.weight = weight;
    }
    public void setQuantity (int quantity){
        this.quantity = quantity;
    }
    @Override
    public String toString(){
        return ("id "+ id+" название "+ name+ " вес "+ weight+" количество "+ quantity);
    }


    
}
