import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonExample {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            Person person = new Person("Alice", "Williams");

            String jsonString = mapper.writeValueAsString(person);
            System.out.println("Serialized JSON: " + jsonString);

            Person parsed = mapper.readValue(jsonString, Person.class);
            System.out.println("Deserialized: " + parsed);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Person {
    private String firstName;
    private String lastName;

    public Person() {} // Needed by Jackson
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
