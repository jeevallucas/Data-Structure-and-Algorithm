package praktikum_12_72210512;

import javafx.scene.control.Alert;

public class Stack {
    private int[] data;
    private int top;
    
    public Stack(int byk) {
        this.data = new int[byk];
        this.top = -1;
    }
    
    public void push(int bil) {
        if (this.top < this.data.length - 1)
            this.data[++this.top] = bil;
        else
            System.out.println();
    }
    
    boolean habis() {
        return this.top < 0;
    }
    
    public int pop() {
        if (!habis())
            return this.data[this.top--];
        else {
            System.out.println();
            return 0;
        }
    }
    
    public int peek() {
        if (!habis())
            return this.data[this.top];
        else {
            System.out.println();
            return 0;
        }
    }
    
    public void lihatStack() {
        String isiStack = "Isi stack:\n";
        
        if (!habis()) {
            for (int idx = this.top; idx >= 0; idx--)
                isiStack += "\t" + this.data[idx] + "\n";
            
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("ISI STACK");
            a.setHeaderText("ISI STACK.");
            a.setContentText(isiStack);
            a.showAndWait();
        } else
            System.out.println();
    }
}