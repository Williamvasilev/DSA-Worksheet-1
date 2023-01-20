package com.example.worksheet1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RGBController implements Initializable {

    @FXML
    private ImageView redImage, greenImage, blueImage;

    private  Image picture;
    private Stage stage;
    private  Scene scene;

    public WritableImage red(ActionEvent actionEvent) {
        Image image = picture;
        redImage.setImage(picture);
        PixelReader pixelReader = image.getPixelReader();

        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        WritableImage redPic = new WritableImage(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                double red = pixelReader.getColor(x,y).getRed();

                double red2 = (red);

                redPic.getPixelWriter().setColor(x,y, Color.color(red2,0,0,1));
            }
        } redImage.setImage(redPic);
        return redPic;
    }


    public WritableImage green(ActionEvent actionEvent) {
        Image image = picture;
        greenImage.setImage(picture);
        PixelReader pixelReader = image.getPixelReader();

        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        WritableImage greenPic = new WritableImage(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                double green = pixelReader.getColor(x,y).getGreen();

                double green2 = (green);

                greenPic.getPixelWriter().setColor(x,y, Color.color(0,green2,0,1));
            }
        } greenImage.setImage(greenPic);
        return greenPic;
    }



    public WritableImage blue(ActionEvent actionEvent) {
        Image image = picture;
        blueImage.setImage(picture);
        PixelReader pixelReader = image.getPixelReader();

        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        WritableImage bluePic = new WritableImage(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                double blue = pixelReader.getColor(x,y).getBlue();

                double blue2 = (blue);

                bluePic.getPixelWriter().setColor(x,y, Color.color(0,0,blue2,1));
            }
        } blueImage.setImage(bluePic);
        return bluePic;
    }

    public void change(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ImageController.FXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        picture = ImageController.image;
   }
}
