

package cookbook;


public class NotAuthenticatedException extends Exception {

    public NotAuthenticatedException() {
        super("Could not authenticate!");
    }

}
