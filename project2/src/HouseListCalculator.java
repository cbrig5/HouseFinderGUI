import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;


public class HouseListCalculator extends Application
{

    private HouseList myHouseList;	// the main behavior for the application

    /** Main frame of the application */
    private Stage mainStage;

    // start method for this class, the main application object
    //----------------------------------------------------------
    public void start(Stage primaryStage)
    {
        System.out.println("House List Version 1.00");
        System.out.println
                ("Copyright 2004/2019 Sandeep Mitra and T M Rao");

        // Create the top-level container (main stage) and add
        // contents to it.
        MainStageContainer.setStage
                (primaryStage, "Brockport House List Version 1.00");
        mainStage = MainStageContainer.getInstance();


        // Finish setting up the stage
        // (ENABLE THE GUI TO BE CLOSED USING THE TOP RIGHT 'X' IN THE
        //  WINDOW), and show it.
        mainStage.setOnCloseRequest(new EventHandler
                <javafx.stage.WindowEvent>() {
            @Override
            public void handle(javafx.stage.WindowEvent event) {
                System.exit(0);
            }
        });

        try
        {
            myHouseList = new HouseList("houses.txt");



        }
        catch(Exception exc)
        {
            System.err.println
                    ("HouseListCalculator.HouseListCalculator - could not create " +
                            "House List!");
            exc.printStackTrace();
        }




        WindowPosition.placeCenter(mainStage);

        mainStage.show();
    }

    /**
     * The "main" entry point for the application. Carries out
     * actions to set up the application
     */
    //----------------------------------------------------------
    public static void main(String[] args)
    {
        launch(args);
    }

}
