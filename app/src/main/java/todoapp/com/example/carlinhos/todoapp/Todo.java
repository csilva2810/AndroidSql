package todoapp.com.example.carlinhos.todoapp;

/**
 * Created by carlinhos on 11/14/16.
 */

public class Todo {

    private int id;
    private String title;
    private String desc;

    public Todo(int id, String title, String desc) {
        this.id = id;
        this.title = title;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String toString() {
        return this.desc;
    }

}
