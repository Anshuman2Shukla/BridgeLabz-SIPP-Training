public class MultipleCatchBlocks {
    public static void main(String[] args) {
        int[] array = null;
        int index = 5;

        try {
            array = new int[]{10, 20, 30};
            System.out.println("Value at index " + index + ": " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}