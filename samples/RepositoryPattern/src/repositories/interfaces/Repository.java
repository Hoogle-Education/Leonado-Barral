package repositories.interfaces;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface Repository<T> {

    default T save(T newElement) throws IOException {
        File file = new File("");
        String projectPath = file.getAbsolutePath();
        String targetPath = projectPath + "\\database";
        String filePath = projectPath + newElement.getClass().getName().toLowerCase() + ".txt";
        FileAttribute<Set<PosixFilePermission>> atributes = PosixFilePermissions.asFileAttribute(
                PosixFilePermissions.fromString("rwxr-x---"));
        Files.createFile(Path.of(filePath), atributes);
        return null;
    }
//    List<T> findAll();
//    Optional<T> findById(int id);
//    T update(T origin, T destination);
//    boolean delete(T t);
//    boolean deleteById(int id);

}
