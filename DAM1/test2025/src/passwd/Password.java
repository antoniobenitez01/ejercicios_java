package passwd;
import java.io.Serializable;

/*
- PASSWORD -
Class representing a password
16-09-2025
*/
public class Password implements Serializable
{
    // ATTRIBUTES ====================================================

    public static String DEFAULT_PASSWORD = "Password";
    public static String DEFAULT_CONTEXT = "Context";
    private String password;
    private String context;

    // CONSTRUCTORS ================================================

    //COMPLETE CONSTRUCTOR
    public Password(String password, String context)
    {
        if(password.isEmpty() || password == null)
        {
            throw new IllegalArgumentException("Password field cannot be empty.");
        }
        if(context.isEmpty() || context == null)
        {
            throw new IllegalArgumentException("Context field cannot be empty.");
        }
        this.password = password;
        this.context = context;
    }

    //DEFAULT CONSTRUCTOR
    public Password()
    {
        this(DEFAULT_PASSWORD,DEFAULT_CONTEXT);
    }

    // METHODS =====================================================

    //GET - PASSWORD
    public String getPassword() { return this.password; }

    //GET - CONTEXT
    public String getContext() { return this.context; }
}
