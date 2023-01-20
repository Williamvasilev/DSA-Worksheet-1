package com.example.worksheet1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;

public class ImageController {


    private  Stage stage;
    private  Scene scene;

    @FXML
    public ImageView imageView, imageView2, imageView3;

    @FXML
    private RadioButton redRadioButton, greenRadioButton, blueRadioButton;

    @FXML
    private ListView imageDetailsListView;


    static Image image;

    public void open(ActionEvent actionEvent) {
        FileChooser fc = new FileChooser();
        // Set the initial directory for the displayed file dialog
        fc.setInitialDirectory(new File("C:\\Users\\willi\\IdeaProjects\\worksheet1\\src\\main\\java\\com\\example\\worksheet1"));

        // Set the selected file or null if no file has been selected
        File file = fc.showOpenDialog(null); // Shows a new file open dialog.
        if (file !=null){

            // URI that represents this abstract pathname
            imageView.setImage(new Image(file.toURI().toString()));
            image = new Image(file.toURI().toString());
            imageDetails();
        } else{
            System.out.println("A file is invalid!");
        }


    }

            public void close (ActionEvent actionEvent){
                Platform.exit();
                System.exit(0);
            }



//    public WritableImage changeToGray(ActionEvent actionEvent) {
//
//        Image image = imageView.getImage();
//        imageView2.setImage(image);
//        PixelReader pixelReader = image.getPixelReader();
//
//        int width = (int) image.getWidth();
//        int height = (int) image.getHeight();
//
//        WritableImage grayImage = new WritableImage(width, height);
//
//        for (int y = 0; y < height; y++) {
//            for (int x = 0; x < width; x++) {
//                int pixel = pixelReader.getArgb(x, y);
//
//                int alpha = ((pixel >> 24) & 0xff);
//                int red = ((pixel >> 16) & 0xff);
//                int green = ((pixel >> 8) & 0xff);
//                int blue = (pixel & 0xff);
//
//                int grayLevel = (int) (0.2162 * red + 0.7152 * green + 0.0722 * blue);
//                int gray = (alpha << 24) + (grayLevel << 16) + (grayLevel << 8) + grayLevel;
//
//                grayImage.getPixelWriter().setArgb(x, y, gray);
//            }
//        } imageView2.setImage(grayImage);
//        return grayImage;
//    }

    public WritableImage changeToGray(ActionEvent actionEvent) {

        Image image = imageView.getImage();
        imageView2.setImage(image);
        PixelReader pixelReader = image.getPixelReader();

        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        WritableImage grayImage = new WritableImage(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {


                double red = pixelReader.getColor(x,y).getRed();
                double green = pixelReader.getColor(x,y).getGreen();
                double blue = pixelReader.getColor(x,y).getBlue();

                double grayLevel = (red + green + blue)/3;
                ;

                grayImage.getPixelWriter().setColor(x,y, Color.gray(grayLevel));
            }
        } imageView2.setImage(grayImage);
        return grayImage;
    }



    public WritableImage red(ActionEvent actionEvent) {
        Image image = imageView.getImage();
        imageView3.setImage(image);
        PixelReader pixelReader = image.getPixelReader();

        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        WritableImage redImage = new WritableImage(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                double red = pixelReader.getColor(x,y).getRed();

                double red2 = (red);

                redImage.getPixelWriter().setColor(x,y, Color.color(red2,0,0,1));
            }
        } imageView3.setImage(redImage);
        return redImage;
    }


    public WritableImage green(ActionEvent actionEvent) {
        Image image = imageView.getImage();
        imageView3.setImage(image);
        PixelReader pixelReader = image.getPixelReader();

        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        WritableImage greenImage = new WritableImage(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                double green = pixelReader.getColor(x,y).getGreen();

                double green2 = (green);

                greenImage.getPixelWriter().setColor(x,y, Color.color(0,green2,0,1));
            }
        } imageView3.setImage(greenImage);
        return greenImage;
    }

    public WritableImage blue(ActionEvent actionEvent) {
        Image image = imageView.getImage();
        imageView3.setImage(image);
        PixelReader pixelReader = image.getPixelReader();

        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        WritableImage blueImage = new WritableImage(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                double blue = pixelReader.getColor(x,y).getBlue();

                double blue2 = (blue);

                blueImage.getPixelWriter().setColor(x,y, Color.color(0,0,blue2,1));
            }
        } imageView3.setImage(blueImage);
        return blueImage;
    }

    public void imageDetails() {
        Image image = imageView.getImage();

        imageDetailsListView.getItems().add(image.getHeight());
        imageDetailsListView.getItems().add(image.getWidth());
        imageDetailsListView.getItems().add(image.getUrl());
    }

//    public void changeScreenButtonPushed (ActionEvent event) throws IOException
//    {
//
//}

    public void switchToRGB(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("rgb.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void change(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("rgb.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}


//theimageview.setOnMousePressed()->{
//    PixelReader pr = theimageview.getImage().getPixelReader();
//    Color col = pr.getColor(e.getX(),e.getY());
//
//    System.out.println("Hue : "+col.getHue());
//    System.out.println("Sat : "+col.getSaturation());
//    System.out.println("Bri : "+col.getBrightness());
//}