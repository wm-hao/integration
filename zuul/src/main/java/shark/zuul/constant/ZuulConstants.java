package shark.zuul.constant;

/**
 * @author zhuhh 2019/1/16
 */
public class ZuulConstants {

    private ZuulConstants() {
    }

    public static final class FilterType {
        public static final String PRE = "pre";
        public static final String ROUTE = "route";
        public static final String POST = "post";
        public static final String ERROR = "error";
    }
}
