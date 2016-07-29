package model.util;

import model.bean.GenericMessage;
import model.logic.Constants;

/**
 *
 * @author skuarch
 */
public class GenericMessageUtil {

    //==========================================================================
    private GenericMessageUtil() {
    }

    // =========================================================================
    /**
     * return a GenericMessage setting with message of successfully.
     *
     * @param id long
     * @return GenericMessage
     */
    public static GenericMessage getSuccessfulMessage(long id) {
        return new GenericMessage(
                id,
                Constants.HTTP_OK,
                Constants.OPERATION_SUCCESSFULLY_COMPLETED
        );
    }

}
