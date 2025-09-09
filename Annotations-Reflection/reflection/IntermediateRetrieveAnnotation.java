package reflection;

public class IntermediateRetrieveAnnotation {
    public static void main(String[] args) {
        Class<AnnotatedClass> cls = AnnotatedClass.class;
        Author a = cls.getAnnotation(Author.class);
        if (a != null) System.out.println("Author: " + a.name());
        else System.out.println("No @Author present."); 
    }
}
