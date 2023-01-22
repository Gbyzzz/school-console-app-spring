package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.view;

import java.util.List;
import java.util.Map;

public interface IOData {
    void outputLine(String arg);

    void outputList(List list);

    void outputMap(Map<?, ?> map);

    String getString();

    int getIntFromRange(int start, int end);

    int getInt();

    void close();
}
