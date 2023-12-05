public class Bag {
    int red;
    int blue;
    int green;

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public Bag(int red, int green, int blue){
        this.red = red;
        this.blue = blue;
        this.green = green;
    }
}