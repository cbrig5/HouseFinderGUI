// system imports

import javafx.scene.Group;

// project imports

//==============================================================
public abstract class View extends Group
{
    private String myClassName;

    // Class constructor
    //----------------------------------------------------------
    public View(String classname)
    {

        myClassName = classname;
    }

    public abstract void updateState(String key, Object value);
}
