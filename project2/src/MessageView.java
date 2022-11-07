// system imports

import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.Font;

import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;




//==============================================================
public class MessageView extends Text
{
    // Class constructor
    //----------------------------------------------------------
    public MessageView(String initialMessage)
    {
        super(initialMessage);
        setFont(Font.font("Helvetica", FontWeight.BOLD, 16));
        setFill(Color.BLUE);
        setTextAlignment(TextAlignment.LEFT);
    }

    /**
     * Display ordinary message
     */
    //----------------------------------------------------------
    public void displayMessage(String message)
    {
        // display the passed text in blue
        setFill(Color.BLUE);
        setText(message);
    }

    /**
     * Display error message (errors are typically shown in red)
     */
    //----------------------------------------------------------
    public void displayErrorMessage(String message)
    {
        // display the passed text in red
        setFill(Color.RED);
        setText(message);
    }

    /**
     * Clear error message
     */
    //----------------------------------------------------------
    public void clearErrorMessage()
    {
        setText("                           ");
    }
}
