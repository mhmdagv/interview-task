package utility;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import exception.NoSuchJsonFileException;
import model.ElementInfo;
import model.ElementInfoMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

public class JsonReadUtils {

    public static void readAllJsonElements(ElementInfoMap elementMap, String path) {
        File[] fileList = getFileList(path);
        Type elementType = new TypeToken<List<ElementInfo>>(){}.getType();
        Gson gson = new Gson();
        List<ElementInfo> elementInfoList = null;
        for (File file : fileList) {
            try {
                elementInfoList = gson
                        .fromJson(new FileReader(file), elementType);
                elementInfoList.parallelStream()
                        .forEach(elementMap::put
                        );
            } catch (FileNotFoundException e) {
                System.out.println("{} not found");
            }
        }
    }

    public static File[] getFileList(String path) {
        URL resourceUrl = JsonReadUtils.class.getClassLoader().getResource(path);
        if (resourceUrl == null) {
            throw new NoSuchJsonFileException("Your " + path + " folder is empty or does not exist inside your resources");
        }
        return new File(resourceUrl.getFile())
                .listFiles(pathname -> !pathname.isDirectory());
    }

}
