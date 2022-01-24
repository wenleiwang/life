package learn.note.JSON.gsonLearn;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * @author WangWenLei
 * @DATE: 2021/6/22
 **/
public class StudentAdapter implements JsonSerializer {
    @Override
    public JsonElement serialize(Object src, Type typeOfSrc, JsonSerializationContext context) {
        return null;
    }
}
