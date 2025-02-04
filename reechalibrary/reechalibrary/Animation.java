 /**
  *   >> Al-Reacha .~
  *   << BY : Asem Al-Mekhlafi >>
  */

package reechalibrary;

/**
 * @Coder Asem Al-Mekhlafi
 * @author PC
 */
public class Animation {
    
    /**
     * stop screen for some time.
     * @param millis the time to sleep in milli second.
     */
    public static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {}
    }
    
    
    
    /**
     * <B> this will print text as animation.<B>
     * @param text is text that will by animated.
     */
    public static void animationTyping(String text){
        animationTyping(text,3);
    }
    
    /**
     * <B> this will print text as animation.<B>
     * @param text is text that will by animated.
     * @param gear you can select speed by gear.
     * the gear is between 1-10, that is 10 is fastest.
     */
    public static void animationTyping(String text,int gear){
        if(gear > 10 || gear <= 0 ) gear = 3;
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            sleep((1000/gear));
        }
    }
    
    
    private static boolean timeDone; // is for stop looping of loading.
    /**
     * this will create an loading animation.
     * @param millis is milli second that is do loading for.
     */
    public static void loading(int millis){
        loading(millis,"loading");
    }
    public static void loading(int millis,String text){
        timeDone = false;
        new Thread(() -> {
            sleep(millis);
            timeDone = true;
        }).start();
        while(true){
            System.out.print(text+" ");
            animationTyping("...", 4);
            System.out.print("\r");
            if(timeDone) break;
        }
        System.out.print("\r");
    }
    
    
}
