
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class ApplicationRunner extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

        HBox main = new HBox(); //main hbox 

        VBox vbox1 = new VBox();   // first vbox
        main.getChildren().add(vbox1); //insert vbox into main hbox for lighting and heating

        VBox lighting = new VBox();               //lighting vbox
        lighting.setPadding(new Insets(5));       //padding
        VBox heating = new VBox();                //heating vbox
        heating.setPadding(new Insets(5));
        VBox cctv = new VBox();                   //cctv vbox
        cctv.setPadding(new Insets(5));
        cctv.setSpacing(20);

        HBox space = new HBox();                 //small horizontal space between the boxes
        space.setPadding(new Insets(3));
        main.getChildren().add(space);
        main.getChildren().add(cctv);            //inserting cctv vbox into main hbox

        vbox1.getChildren().add(lighting);
        VBox vspace = new VBox();                //small vertical space between lighting and heating box
        vspace.setPadding(new Insets(2));
        vbox1.getChildren().add(vspace);
        vbox1.getChildren().add(heating);

        String boxstyle = "-fx-border-color: grey;\n"     //css
                + "-fx-border-radius: 3px;\n"
                + "-fx-border-insets: 2;\n"
                + "-fx-border-width: 2;\n";

        lighting.setStyle(boxstyle);               //applying css
        heating.setStyle(boxstyle);
        cctv.setStyle(boxstyle);

        Label heading1 = new Label("Lighting");               //labels
        lighting.getChildren().add(heading1);

        Label heading2 = new Label("Central Heating");
        heating.getChildren().add(heading2);

        Label heading3 = new Label("CCTV");
        cctv.getChildren().add(heading3);

        //making the fonts bold
        heading1.setFont(Font.font("Arial", FontWeight.BOLD, 13));
        heading2.setFont(Font.font("Arial", FontWeight.BOLD, 13));
        heading3.setFont(Font.font("Arial", FontWeight.BOLD, 13));

        HBox hbox1 = new HBox();                            //making hboxes to align elements
        hbox1.setPadding(new Insets(4));
        hbox1.setAlignment(Pos.CENTER_RIGHT);
        HBox hbox2 = new HBox();
        hbox2.setPadding(new Insets(4));
        hbox2.setAlignment(Pos.CENTER_RIGHT);
        HBox hbox3 = new HBox();
        hbox3.setPadding(new Insets(4));
        hbox3.setAlignment(Pos.CENTER_RIGHT);
        HBox hbox4 = new HBox();
        hbox4.setPadding(new Insets(4));
        hbox4.setAlignment(Pos.CENTER_RIGHT);
        HBox hbox5 = new HBox();
        hbox5.setPadding(new Insets(4));
        hbox5.setAlignment(Pos.CENTER_RIGHT);
        HBox hbox6 = new HBox();
        hbox6.setPadding(new Insets(4));
        hbox6.setAlignment(Pos.CENTER_RIGHT);
        HBox hbox7 = new HBox();
        hbox7.setPadding(new Insets(4));
        hbox7.setAlignment(Pos.CENTER_RIGHT);

        lighting.getChildren().add(hbox1);
        lighting.getChildren().add(hbox2);
        lighting.getChildren().add(hbox3);
        lighting.getChildren().add(hbox4);
        lighting.getChildren().add(hbox5);
        lighting.getChildren().add(hbox6);
        lighting.getChildren().add(hbox7);

        Text hall = new Text("Hall: ");                 //text for sliders
        Text kitchen = new Text("Kitchen: ");
        Text dining = new Text("Dining room: ");
        Text living = new Text("Living room: ");
        Text landing = new Text("Landing: ");
        Text bed1 = new Text("Bedroom 1: ");
        Text bed2 = new Text("Bedroom 2: ");

        Slider slider1 = new Slider(0, 255, 1);      //sliders for lighting 
        slider1.setValue(127.5);                     //initial default value to half
        Slider slider2 = new Slider(0, 255, 1);
        slider2.setValue(127.5);
        Slider slider3 = new Slider(0, 255, 1);
        slider3.setValue(127.5);
        Slider slider4 = new Slider(0, 255, 1);
        slider4.setValue(127.5);
        Slider slider5 = new Slider(0, 255, 1);
        slider5.setValue(127.5);
        Slider slider6 = new Slider(0, 255, 1);
        slider6.setValue(127.5);
        Slider slider7 = new Slider(0, 255, 1);
        slider7.setValue(127.5);

        Circle circle1 = new Circle(17.0f, 17.0f, 9.f);               //Coloured circles
        Circle circle2 = new Circle(17.0f, 17.0f, 9.f);
        Circle circle3 = new Circle(17.0f, 17.0f, 9.f);
        Circle circle4 = new Circle(17.0f, 17.0f, 9.f);
        Circle circle5 = new Circle(17.0f, 17.0f, 9.f);
        Circle circle6 = new Circle(17.0f, 17.0f, 9.f);
        Circle circle7 = new Circle(17.0f, 17.0f, 9.f);

        slider1.valueProperty().addListener((ObservableValue<? extends Number> obs, Number oldval, Number newval) -> {           //updating the rgb values as the slider changes 
            circle1.setFill(Color.rgb((int) slider1.getValue(), ((int) slider1.getValue()), 0));
        });
        slider2.valueProperty().addListener((ObservableValue<? extends Number> obs, Number oldval, Number newval) -> {
            circle2.setFill(Color.rgb((int) slider2.getValue(), ((int) slider2.getValue()), 0));
        });
        slider3.valueProperty().addListener((ObservableValue<? extends Number> obs, Number oldval, Number newval) -> {
            circle3.setFill(Color.rgb((int) slider3.getValue(), ((int) slider3.getValue()), 0));
        });
        slider4.valueProperty().addListener((ObservableValue<? extends Number> obs, Number oldval, Number newval) -> {
            circle4.setFill(Color.rgb((int) slider4.getValue(), ((int) slider4.getValue()), 0));
        });
        slider5.valueProperty().addListener((ObservableValue<? extends Number> obs, Number oldval, Number newval) -> {
            circle5.setFill(Color.rgb((int) slider5.getValue(), ((int) slider5.getValue()), 0));
        });
        slider6.valueProperty().addListener((ObservableValue<? extends Number> obs, Number oldval, Number newval) -> {
            circle6.setFill(Color.rgb((int) slider6.getValue(), ((int) slider6.getValue()), 0));
        });
        slider7.valueProperty().addListener((ObservableValue<? extends Number> obs, Number oldval, Number newval) -> {
            circle7.setFill(Color.rgb((int) slider7.getValue(), ((int) slider7.getValue()), 0));
        });

        circle1.setFill(Color.rgb((int) slider1.getValue(), ((int) slider1.getValue()), 0));      //setting the initial values of the rgb to the inital value of the sliders
        circle1.setStroke(Color.BLACK);                                                           //outlining the circles with black
        circle2.setFill(Color.rgb((int) slider2.getValue(), ((int) slider2.getValue()), 0));
        circle2.setStroke(Color.BLACK);
        circle3.setFill(Color.rgb((int) slider3.getValue(), ((int) slider3.getValue()), 0));
        circle3.setStroke(Color.BLACK);
        circle4.setFill(Color.rgb((int) slider4.getValue(), ((int) slider4.getValue()), 0));
        circle4.setStroke(Color.BLACK);
        circle5.setFill(Color.rgb((int) slider5.getValue(), ((int) slider5.getValue()), 0));
        circle5.setStroke(Color.BLACK);
        circle6.setFill(Color.rgb((int) slider6.getValue(), ((int) slider6.getValue()), 0));
        circle6.setStroke(Color.BLACK);
        circle7.setFill(Color.rgb((int) slider7.getValue(), ((int) slider7.getValue()), 0));
        circle7.setStroke(Color.BLACK);

        hbox1.getChildren().add(hall);             //adding the elements
        hbox1.getChildren().add(slider1);
        hbox1.getChildren().add(circle1);

        hbox2.getChildren().add(kitchen);
        hbox2.getChildren().add(slider2);
        hbox2.getChildren().add(circle2);

        hbox3.getChildren().add(dining);
        hbox3.getChildren().add(slider3);
        hbox3.getChildren().add(circle3);

        hbox4.getChildren().add(living);
        hbox4.getChildren().add(slider4);
        hbox4.getChildren().add(circle4);

        hbox5.getChildren().add(landing);
        hbox5.getChildren().add(slider5);
        hbox5.getChildren().add(circle5);

        hbox6.getChildren().add(bed1);
        hbox6.getChildren().add(slider6);
        hbox6.getChildren().add(circle6);

        hbox7.getChildren().add(bed2);
        hbox7.getChildren().add(slider7);
        hbox7.getChildren().add(circle7);

        //CCTV box
        FlowPane images = new FlowPane();
        images.setVgap(2);
        images.setHgap(2);
        images.setPrefWrapLength(406);
        cctv.getChildren().add(images);

        Image front = new Image(new FileInputStream("images/front.jpg"));          //links to images
        Image rear = new Image(new FileInputStream("images/back.jpg"));
        Image side = new Image(new FileInputStream("images/side.jpg"));
        Image drive = new Image(new FileInputStream("images/drive.jpg"));
        Image mute = new Image(new FileInputStream("images/mute-screen.gif"));
        ImageView f = new ImageView(front);
        ImageView r = new ImageView(rear);
        ImageView s = new ImageView(side);
        ImageView d = new ImageView(drive);
        HBox image1 = new HBox();
        HBox image2 = new HBox();
        HBox image3 = new HBox();
        HBox image4 = new HBox();
        image1.getChildren().add(f);
        image2.getChildren().add(r);
        image3.getChildren().add(s);
        image4.getChildren().add(d);
        String style = "-fx-border-color: black;"
                + "-fx-border-width: 1;";
        image1.setStyle(style);
        image2.setStyle(style);
        image3.setStyle(style);
        image4.setStyle(style);
        images.getChildren().add(image1);
        images.getChildren().add(image2);
        images.getChildren().add(image3);
        images.getChildren().add(image4);

        HBox buttons = new HBox();
        buttons.setSpacing(10);
        buttons.setAlignment(Pos.CENTER); //aligning the buttons to center
        cctv.getChildren().add(buttons);

        ToggleButton frontbt = new ToggleButton("Front");        //Togglebuttons 
        ToggleButton rearbt = new ToggleButton("Rear");
        ToggleButton sidebt = new ToggleButton("Side");
        ToggleButton drivebt = new ToggleButton("Drive");

        buttons.getChildren().add(frontbt);
        buttons.getChildren().add(rearbt);
        buttons.getChildren().add(sidebt);
        buttons.getChildren().add(drivebt);

        frontbt.selectedProperty().addListener(((obs, oldVal, newVal) -> {         //listener to update images to mute when buttons are clicked
            if (frontbt.isSelected()) {
                f.setImage(mute);
            } else {
                f.setImage(front);
            }
        }));

        rearbt.selectedProperty().addListener(((obs, oldVal, newVal) -> {
            if (rearbt.isSelected()) {
                r.setImage(mute);
            } else {
                r.setImage(rear);
            }
        }));

        sidebt.selectedProperty().addListener(((obs, oldVal, newVal) -> {
            if (sidebt.isSelected()) {
                s.setImage(mute);
            } else {
                s.setImage(side);
            }
        }));

        drivebt.selectedProperty().addListener(((obs, oldVal, newVal) -> {
            if (drivebt.isSelected()) {
                d.setImage(mute);
            } else {
                d.setImage(drive);
            }
        }));

        //heating box
        HBox heatingbox = new HBox();
        heatingbox.setSpacing(20);
        heating.getChildren().add(heatingbox);
        VBox options = new VBox();
        options.setPadding(new Insets(5));
        options.setSpacing(21);
        heatingbox.getChildren().add(options);

        RadioButton off = new RadioButton("Off");     //radio buttons
        RadioButton auto = new RadioButton("Auto");
        RadioButton once = new RadioButton("Once");
        RadioButton cont = new RadioButton("Cont");
        ToggleGroup group = new ToggleGroup();      //group to make sure only one can be selected at a time
        off.setToggleGroup(group);
        auto.setToggleGroup(group);
        once.setToggleGroup(group);
        cont.setToggleGroup(group);
        options.getChildren().add(off);
        options.getChildren().add(auto);
        options.getChildren().add(once);
        options.getChildren().add(cont);
        auto.setSelected(true);

        Slider temp = new Slider(0, 30, 20);  //temperature slider
        temp.setOrientation(Orientation.VERTICAL);
        temp.setShowTickMarks(true);
        temp.setShowTickLabels(true);
        temp.setMajorTickUnit(5);
        temp.setMinorTickCount(1);
        temp.setBlockIncrement(5);
        temp.setSnapToTicks(true);

        off.selectedProperty().addListener(((obs, oldVal, newVal) -> {            //listener to update the slider when radio buttons are clicked
            if (off.isSelected()) {
                temp.setValue(0);
            }
        }));

        auto.selectedProperty().addListener(((obs, oldVal, newVal) -> {
            if (auto.isSelected()) {
                temp.setValue(20);
            }
        }));

        once.selectedProperty().addListener(((obs, oldVal, newVal) -> {
            if (once.isSelected()) {
                temp.setValue(25);
            }
        }));

        temp.valueProperty().addListener((ObservableValue<? extends Number> obs, Number oldval, Number newval) -> {        //Whenever the slider value is changed manually the radio button choice becomes Cont
            if ((temp.getValue() != 0) && (temp.getValue() != 20) && (temp.getValue() != 25)) {
                cont.setSelected(true);
            }
        });

        //changing the slider labels to degree celsius
        temp.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double n) {
                if (n == 0) {
                    return "0.0 °C";
                }
                if (n == 5) {
                    return "5.0 °C";
                }
                if (n == 10) {
                    return "10.0 °C";
                }
                if (n == 15) {
                    return "15.0 °C";
                }
                if (n == 20) {
                    return "20.0 °C";
                }
                if (n == 25) {
                    return "25.0 °C";
                }
                return "30.0 °C";
            }

            @Override
            public Double fromString(String s) {
                switch (s) {
                    default:
                        return null;
                }
            }
        });

        HBox layout = new HBox(temp);
        layout.setPadding(new Insets(30));

        primaryStage.setScene(new Scene(layout));
        primaryStage.show();

        heatingbox.getChildren().add(temp);

        VBox display = new VBox();
        display.setAlignment(Pos.CENTER);
        heatingbox.getChildren().add(display);
        TextField text = new TextField();
        text.setFont(Font.font("Arial", FontWeight.BOLD, 18));    //making text bigger and bold
        DecimalFormat form = new DecimalFormat("00.0");           //displaying to 3 decimal place
        temp.valueProperty().addListener((ObservableValue<? extends Number> obs, Number oldval, Number newval) -> {
            text.setText(String.valueOf(form.format(temp.getValue())));    //the textbox value updates as the slider value changes
        });
        text.setText(Double.toString(temp.getValue()));    //setting text to the value of the slider
        text.setPrefWidth(65);
        text.setPrefHeight(40);
        display.getChildren().add(text);

        Scene scene = new Scene(main);               //Scene
        primaryStage.setTitle("SmartPad App");       //Scene title
        primaryStage.setScene(scene);                //showing the scene
        primaryStage.show();                         //displaying the stage

    }

    //main method
    public static void main(String[] args) {
        launch(args);
    }

}
