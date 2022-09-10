import java.io.IOException;



public class Main {
    private static boolean createSparseFile(String filePath, Long fileSize) {
        boolean success = true;
        String command = "dd if=/dev/zero of=%s bs=1 count=1 seek=%s";
        String formmatedCommand = String.format(command, filePath, fileSize);
        String s;
        Process p;
        try {
            p = Runtime.getRuntime().exec(formmatedCommand);

            p.waitFor();
            p.destroy();
        } catch (IOException | InterruptedException e) {
            return false;
        }
        return success;
    }
    public static void main(String[] args) {
        createSparseFile("long.txt", 2000000L);
        var a = 10;
    }

}