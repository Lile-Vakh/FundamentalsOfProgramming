import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Files.*;
import static java.util.stream.DoubleStream.concat;


public class ConCat {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("usage: concat in1 in2 out");
            return;
        }

        Path in1 = Paths.get(args[0]);
        Path in2 = Paths.get(args[1]);

        if (!Files.isRegularFile(in1) || !Files.isRegularFile(in2)) {
            System.out.println("File is not regular!");
            return;
        }

        Path out = Paths.get(args[2]);
        if (Files.exists(out)) {
            System.out.println("Output file already exists!");
            return;
        }

        try {
            out = createFile(out);
        } catch (IOException e) {
            System.out.println("File could not be created!");
        }

        try {
            Files.write(out, (Stream.concat(lines(in1), lines(in2))).collect(Collectors.toList()));
        } catch (IOException e) {
            System.out.println("Could not be concatenated!");
        }
    }
}
