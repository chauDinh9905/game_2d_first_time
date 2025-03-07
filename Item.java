package gameobject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
//note
public abstract class Item extends GameObject {

    private int value;      // Giá trị của Item
    protected double speed;      
    private BufferedImage image;
    protected boolean isActive;
    protected long spawnTime;      
    public Item(){
        
    }
    public Item(int value, int posX, int posY, int width, int height) {
        super(posX, posY, 100, 100); // Chiều dài = chiều rộng = 100 px
        this.value = value;
    }
    public int getValue() {
        return this.value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public double getSpeed() {
        return this.speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public long  getSpawnTime() {
        return this.spawnTime;
    }
    public void setSpawnTime(int spwanTime) {
        this.spawnTime = spwanTime;
    }
    public void setImage(String imagePath) {
        try {
            // Tải hình ảnh từ file
            BufferedImage bufferedImage = ImageIO.read(new File(imagePath));
            this.image = bufferedImage;
        } catch (IOException e) {
            System.err.println("Error loading image from path: " + imagePath);
        }
    }
    // Getter để truy cập hình ảnh
    public BufferedImage getImage() {
        return image;
    }
    public void randomPosition() {              // Hàm sinh vị trí ngẫu nhiên trong màn hình
        setPosX(new Random().nextInt(300, 1050));
        //setPosY(new Random().nextInt(100, 700));
        setPosY(0);
    }
 
    //public abstract void updateSpeed();
    public void falling(double speed) {
        this.posY += speed; // Tạm thời, khi có speed thì sửa lại
    };
    // @Override
    // abstract void draw();
    /*public void checkCollisionWithDinosaur (Dinosaur dinosaur) {
        if (this.isColliding(dinosaur)) {
            this.isActive = false;
        }
    }*/
    public boolean isActive() {
        return isActive;
    }
    public void setActive (boolean temp) {
        this.isActive = temp;
    }
    /*public void update (Dinosaur dinosaur) {
        checkCollisionWithDinosaur(dinosaur);
        if (this.posY >= 640-this.height) this.setActive(false);
    }*/
  
}