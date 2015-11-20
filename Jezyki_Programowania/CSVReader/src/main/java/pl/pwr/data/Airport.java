package pl.pwr.data;

/**
 * Created by SQUIER on 2015-11-19.
 */
public class Airport {

    private String code;
    private String name;

    public Airport(String code, String name) {
        setCode(code);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;

        if (!getCode().equals(airport.getCode())) return false;
        return getName().equals(airport.getName());

    }

    @Override
    public int hashCode() {
        int result = getCode().hashCode();
        result = 31 * result + getName().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return code + "," + name;
    }
}
