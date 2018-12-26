package test.com.rrefreshlayout.json;

import android.app.Activity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FastJson extends Activity{
//        //可以使用 JSON.toJSONString() 将 Java 对象转换换为 JSON 对象：
//    private List<Person> listOfPersons = new ArrayList<Person> ();
//
//
//    public void setUp() {
//        listOfPersons.add(new Person(15, "John Doe", new Date ()));
//        listOfPersons.add(new Person(20, "Janette Doe", new Date()));
//    }
//
//
//    public void whenJavaList_thanConvertToJsonCorrect() {
//        String jsonOutput= JSON.toJSONString(listOfPersons);
//    }
//
//    //JSON 字符串转换为 Java 对象,如何解析 JSON：
//
//    public void whenJson_thanConvertToObjectCorrect() {
//        Person person = new Person(20, "John", "Doe", new Date());
//        String jsonObject = JSON.toJSONString(person);
//        Person newPerson = JSON.parseObject(jsonObject, Person.class);
//
//        assertEquals(newPerson.getAge(), 0); // 如果我们设置系列化为 false
//        assertEquals(newPerson.getFullName(), listOfPersons.get(0).getFullName());
//    }
//json字符串-简单对象型
    private static final String JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";
    //json字符串-数组类型
    private static final String JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";
    //复杂格式json字符串
    private static final String COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

    /**
     * json字符串-简单对象型与JSONObject之间的转换
     */
    public static void testJSONStrToJSONObject() {
        List<Person> peoplelist = new ArrayList<> ();
        JSONObject jsonObject = JSON.parseObject (JSON_OBJ_STR);

      /*  Person person = new Person ();
        person.setName(jsonObject.getString ("studentName"));
        peoplelist.add (person);*/
        //JSONObject jsonObject1 = JSONObject.parseObject(JSON_OBJ_STR); //因为JSONObject继承了JSON，所以这样也是可以的

        System.out.println (jsonObject.getString ("studentName") + ":" + jsonObject.getInteger ("studentAge"));

    }

    /**
     * json字符串-数组类型与JSONArray之间的转换
     */
    public static void testJSONStrToJSONArray() {

        JSONArray jsonArray = JSON.parseArray (JSON_ARRAY_STR);
        //JSONArray jsonArray1 = JSONArray.parseArray(JSON_ARRAY_STR);//因为JSONArray继承了JSON，所以这样也是可以的
//        List<Person> list = new ArrayList<> ();

        //遍历方式1
        int size = jsonArray.size ();
        for (int i = 0; i < size; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject (i);
          /*  Person a = new Person ();
            a.setAge (jsonObject.getString ("age"));
            //
            list.add (a);*/
            System.out.println (jsonObject.getString ("studentName") + ":" + jsonObject.getInteger (" "));
        }

        //遍历方式2
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println (jsonObject.getString ("studentName") + ":" + jsonObject.getInteger ("studentAge"));
        }
    }

    /**
     * 复杂json格式字符串与JSONObject之间的转换
     */
    public static void testComplexJSONStrToJSONObject() {

        JSONObject jsonObject = JSON.parseObject (COMPLEX_JSON_STR);
        //JSONObject jsonObject1 = JSONObject.parseObject(COMPLEX_JSON_STR);//因为JSONObject继承了JSON，所以这样也是可以的

        String teacherName = jsonObject.getString ("teacherName");
        Integer teacherAge = jsonObject.getInteger ("teacherAge");
        JSONObject course = jsonObject.getJSONObject ("course");
        JSONArray students = jsonObject.getJSONArray ("students");

    }

    /**
     * json字符串-简单对象与JavaBean_obj之间的转换
     */
    public static void testJSONStrToJavaBeanObj() {

        Student student = JSON.parseObject (JSON_OBJ_STR, new TypeReference<Student> () {
        });
        //Student student1 = JSONObject.parseObject(JSON_OBJ_STR, new TypeReference<Student>() {});//因为JSONObject继承了JSON，所以这样也是可以的

        System.out.println (student.getStudentName () + ":" + student.getStudentAge ());

    }

    /**
     * json字符串-数组类型与JavaBean_List之间的转换
     */
    public static void testJSONStrToJavaBeanList() {

        ArrayList<Student> students = JSON.parseObject (JSON_ARRAY_STR, new TypeReference<ArrayList<Student>> () {
        });
        //ArrayList<Student> students1 = JSONArray.parseObject(JSON_ARRAY_STR, new TypeReference<ArrayList<Student>>() {});//因为JSONArray继承了JSON，所以这样也是可以的

        for (Student student : students) {
            System.out.println (student.getStudentName () + ":" + student.getStudentAge ());
        }
    }

    /**
     * 复杂json格式字符串与JavaBean_obj之间的转换
     */
    public static void testComplexJSONStrToJavaBean() {

        Teacher teacher = JSON.parseObject (COMPLEX_JSON_STR, new TypeReference<Teacher> () {
        });
        //Teacher teacher1 = JSON.parseObject(COMPLEX_JSON_STR, new TypeReference<Teacher>() {});//因为JSONObject继承了JSON，所以这样也是可以的
        String teacherName = teacher.getTeacherName ();
        Integer teacherAge = teacher.getTeacherAge ();
        Course course = teacher.getCourse ();
        List<Student> students = teacher.getStudents ();
    }
}
