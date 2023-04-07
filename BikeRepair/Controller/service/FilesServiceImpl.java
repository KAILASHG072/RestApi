package BikeRepair.Controller.service;

import BikeRepair.Controller.repository.FileRepo;
import BikeRepair.Controller.entity.FileDB;
import BikeRepair.Controller.entity.UserData;
import BikeRepair.Controller.repository.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.stream.Stream;

@Service
public class FilesServiceImpl implements FileService {
    Logger log = LoggerFactory.getLogger(FilesServiceImpl.class);

    @Autowired
    private FileRepo repo;

    @Autowired
    RegistrationRepo registrationRepo;





    public FileDB store(MultipartFile file) throws IOException {
        log.info("StorageService:Storing file , Uploading Started");
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
        log.debug("StorageService:Storing file parameter", FileDB);
        return repo.save(FileDB);
    }

    public FileDB getFile(String id) {
        log.info("StorageService:downloading Started ");
        return  repo.findById(id).get();

    }

    public Stream<FileDB> getAllFiles() {
        return repo.findAll().stream();
    }

    @Override
    public FileDB DpToUser(String id ,String username) {
        UserData userData=null;
        FileDB file = repo.findById(id).get();
        UserData user= registrationRepo.findById(username).get();
        file.setUser(user);
        return repo.save(file);
    }

}
