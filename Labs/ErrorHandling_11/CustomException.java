package ErrorHandling_11;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 2/22/2025, Saturday
 **/

public class CustomException extends RuntimeException {
    public CustomException() {
        super();
    }
    public CustomException(String s) {
        super(s);
    }
    public static void main(String[] args) throws CustomException {
        throw new CustomException("Get me out of here!");
    }
}
