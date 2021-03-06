package model.logic;

/**
 *
 * @author skuarch
 */
public final class Constants {

    //http codes
    public static final short HTTP_OK = 200;
    public static final short HTTP_CONFLIT = 409;
    public static final int UNPROSSABLE_ENTITY = 422;
    
    //
    public static final int MAX_BYTES = 1024 * 20;
    public static final int STOP_SECONDS = 3500;
    
    //errors
    public static final String COUNTRY_ALREADY_EXITS = "country already exists";
    public static final String OPERATION_SUCCESSFULLY_COMPLETED = "operation successfully completed";

    //==========================================================================
    /**
     * this class doesn't require a public constructor.
     */
    private Constants() {
    }

}
