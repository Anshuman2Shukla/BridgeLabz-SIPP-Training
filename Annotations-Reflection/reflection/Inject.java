    package reflection;

    import java.lang.annotation.*;

/*
Simple @Inject marker for fields
*/
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Inject { }
