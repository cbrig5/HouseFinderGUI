import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.FileNotFoundException;
import java.util.Properties;

public class HouseListView extends View {

    // Model, which this View talks to
    private HouseList myModel;

    // GUI components
    private TextField minPrice;
    private TextField maxPrice;

    private TextField minArea;
    private TextField maxArea;

    private TextField minBed;
    private TextField maxBed;

    private TextArea chosen;

    private Button submitButton;
    private Button cancelButton;

    // For showing error message
    private MessageView statusLog;
    private Button tryAgainButton;

    private Boolean clicked = false;

    private int counter = 0;


    public HouseListView(HouseList houseList) // SAME PATTERN AS LoginView
    {
        super("HouseListingView");
        myModel = houseList;

        // create a container for showing the contents
        VBox container = new VBox(10);
        container.setPadding(new Insets(15, 5, 5, 5));

        // create our GUI components, add them to this panel
        container.getChildren().add(createTitle());
        container.getChildren().add(createFormContent());


        // Error message area
        container.getChildren().add(createStatusLog("  "));

        getChildren().add(container);

    }

    // Create the main form content
    //-------------------------------------------------------------
    private VBox createFormContent()
    {
        VBox vbox = new VBox(10);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 100, 25, 25));


        //---------------------------------------------------------------
        Text minPriceLabel = new Text("Minimum Price ");
        minPriceLabel.setWrappingWidth(150);
        minPriceLabel.setTextAlignment(TextAlignment.RIGHT);
        grid.add(minPriceLabel, 0, 0);

        minPrice = new TextField();
        minPrice.setPromptText("0");
        minPrice.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                processAction(e);
            }
        });
        grid.add(minPrice, 1, 0);
        //---------------------------------------------------------------
        Text maxPriceLabel = new Text("Maximum Price ");
        maxPriceLabel.setWrappingWidth(150);
        maxPriceLabel.setTextAlignment(TextAlignment.RIGHT);
        grid.add(maxPriceLabel, 0, 1);

        maxPrice = new TextField();
        maxPrice.setPromptText("0");
        maxPrice.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                processAction(e);
            }
        });
        grid.add(maxPrice, 1, 1);

        //------------------------------------------------------------------

        Text minAreaLabel = new Text("Minimum Area ");
        minAreaLabel.setWrappingWidth(150);
        minAreaLabel.setTextAlignment(TextAlignment.RIGHT);
        grid.add(minAreaLabel, 0, 2);

        minArea = new TextField();
        minArea.setPromptText("0");
        minArea.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                processAction(e);
            }
        });
        grid.add(minArea, 1, 2);
        //------------------------------------------------------

        Text maxAreaLabel = new Text("Maximum Area ");
        maxAreaLabel.setWrappingWidth(150);
        maxAreaLabel.setTextAlignment(TextAlignment.RIGHT);
        grid.add(maxAreaLabel, 0, 3);

        maxArea = new TextField();
        maxArea.setPromptText("0");
        maxArea.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                processAction(e);
            }
        });
        grid.add(maxArea, 1, 3);
        //-------------------------------------------------------

        Text minBedLabel = new Text
                ("Minimum Beds ");
        minBedLabel.setWrappingWidth(150);
        minBedLabel.setTextAlignment(TextAlignment.RIGHT);
        grid.add(minBedLabel, 0, 4);

        minBed= new TextField();
        minBed.setPromptText("0");
        grid.add(minBed, 1, 4);

        // ----------------------------------------------------------
        Text maxBedLabel = new Text("Max Beds ");
        maxBedLabel.setWrappingWidth(150);
        maxBedLabel.setTextAlignment(TextAlignment.RIGHT);
        grid.add(maxBedLabel, 0, 5);

        maxBed = new TextField();
        maxBed.setPromptText("0");
        grid.add(maxBed, 1, 5);

        //---------------------------------------------------------------------

        Text chosenLabel = new Text("Chosen Home ");
        chosenLabel.setWrappingWidth(150);
        chosenLabel.setTextAlignment(TextAlignment.RIGHT);
        grid.add(chosenLabel, 1, 6);

        chosen = new TextArea();
        chosen.setEditable(false);
        grid.add(chosen, 1, 6);
        chosen.setPrefHeight(80);
        chosen.setPrefWidth(175);


        //-------------------------------------------------------------------------

        submitButton = new Button("Find my dream house!");
        //grid.add(submitButton, 0,7);
       // submitButton.setLayoutX(100);
        //submitButton.setLayoutX(100);

            submitButton.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {

                    clearErrorMessage();
                    // do the calculation
                    processAction(e);
                }
            });


        //-------------------------------------------------------------------------

        tryAgainButton = new Button("Not my dream home - find me another!");
        if(submitButton.isDisable() == false) {
            tryAgainButton.setDisable(true);
        } else
            tryAgainButton.setDisable(false);

        tryAgainButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                clearErrorMessage();
                // do the calculation
                processAction(e);
            }
        });

        cancelButton = new Button("Reset");


        cancelButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                clearErrorMessage();
                myModel.resetView();
            }
        });

        HBox btnContainer1 = new HBox(30);
        btnContainer1.setAlignment(Pos.CENTER);

        btnContainer1.setPadding(new Insets(0,10,10,100));


        btnContainer1.getChildren().add(submitButton);
        btnContainer1.getChildren().add(tryAgainButton);

        HBox btnContainer2 = new HBox();
        btnContainer2.setAlignment(Pos.CENTER);
        btnContainer2.getChildren().add(cancelButton);


        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(grid);
        vbox.getChildren().add(btnContainer1);
        vbox.getChildren().add(btnContainer2);

        return vbox;
    }

    // Create the status log field
    //-------------------------------------------------------------
    private MessageView createStatusLog(String initialMessage)
    {
        statusLog = new MessageView(initialMessage);

        return statusLog;
    }

    // Create the title container
    //-------------------------------------------------------------
    private Node createTitle()
    {
        HBox container = new HBox();
        container.setAlignment(Pos.CENTER);

        Text titleText = new Text(" Real Estate Listing ");
        titleText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        titleText.setWrappingWidth(300);
        titleText.setTextAlignment(TextAlignment.CENTER);
        titleText.setFill(Color.DARKGREEN);
        container.getChildren().add(titleText);

        return container;
    }

    //---------------------------------------------------------
    public void updateState(String key, Object value)
    {
        String val = (String)value;
        if (key.equals("ChosenHome"))
        {

            if(value.equals("No houses found!") == false) {
                submitButton.setDisable(true);
                tryAgainButton.setDisable(false);
            } else {
                submitButton.setDisable(false);
                tryAgainButton.setDisable(true);
            }


            chosen.setText(val);
        } else if (key.equals("NoHomes")) {
            chosen.setText(val);
            tryAgainButton.setDisable(true);

        }
    }

    /**
     * Display error message
     */
    //----------------------------------------------------------
    public void displayErrorMessage(String message)
    {
        statusLog.displayErrorMessage(message);
    }

    /**
     * Clear error message
     */
    //----------------------------------------------------------
    public void clearErrorMessage()
    {
        statusLog.clearErrorMessage();
    }

    public void processAction(Event evt)
    {

        clearErrorMessage();
        // do the transfer

        String minPriceEntered = minPrice.getText();
        String maxPriceEntered = maxPrice.getText();

        String minAreaEntered = minArea.getText();
        String maxAreaEntered = maxArea.getText();

        String minBedEntered = minBed.getText();
        String maxBedEntered = maxBed.getText();


        if(minPriceEntered == null || minPriceEntered.length() == 0) {
            minPriceEntered = "0";


        }
        if(maxPriceEntered == null || maxPriceEntered.length() == 0) {
            maxPriceEntered = "0";

        }
        if(minAreaEntered == null || minAreaEntered.length() == 0) {
            minAreaEntered = "0";


        }
        if(maxAreaEntered == null || maxAreaEntered.length() == 0) {
            maxAreaEntered = "0";


        }
        if(minBedEntered == null || minBedEntered.length() == 0) {
            minBedEntered = "0";

        }
        if(maxBedEntered == null || maxBedEntered.length() == 0) {
            maxBedEntered = "0";


        }

  /*      // Here, we are doing USER DATA VALIDATION
        if ((minPriceEntered == null) ||
                (minAreaEntered.length() == 0))
        {
            displayErrorMessage
                    ("Please enter a number of shirts");
        } else if ((maxPriceEntered == null)|| (maxPriceEntered.length() == 0) ) {
            displayErrorMessage
                    ("Please enter a number of pants");

        } else if ((minAreaEntered == null)|| (minAreaEntered.length() == 0) ) {
            displayErrorMessage
                    ("Please enter a number of ties");

        } else if ((maxAreaEntered == null)|| (maxAreaEntered.length() == 0)) {
            displayErrorMessage
                    ("Please enter a number of shoes");
        } else
*/
            try
            {
                double minPrice = Double.parseDouble(minPriceEntered);
                double maxPrice = Double.parseDouble(maxPriceEntered);

                double minArea = Double.parseDouble(minAreaEntered);
                double maxArea = Double.parseDouble(maxAreaEntered);

                double minBed = Double.parseDouble(minBedEntered);
                double maxBed = Double.parseDouble(maxBedEntered);

                if (minPrice < 0 || maxPrice < 0 || minArea < 0 || maxArea < 0 || minBed < 0 || maxBed < 0)
                {
                    displayErrorMessage
                            ("Invalid amount: Please re-enter");
                }
                else
                {

                    processHouseList(minPriceEntered,
                            maxPriceEntered, minAreaEntered,maxAreaEntered,minBedEntered, maxBedEntered);
                }
            }
            catch (Exception ex)
            {
                displayErrorMessage
                        ("Error in processing listing- THIS ERROR");
            }

        }

    private void processHouseList(String minPrice, String maxPrice, String minArea,
                                  String maxArea, String minBed, String maxBed) throws FileNotFoundException {

        Properties props = new Properties();

        props.setProperty("MinimumPrice", minPrice);
        props.setProperty("MaximumPrice", maxPrice);
        props.setProperty("MinimumArea", minArea);
        props.setProperty("MaximumArea", maxArea);
        props.setProperty("MinimumBed", minBed);
        props.setProperty("MaximumBed", maxBed);


        myModel.processHouseList(props);


    }



}


