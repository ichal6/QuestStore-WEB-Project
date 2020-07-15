package sort;

public enum TypeColumn {
    NAME, EMAIL, CITY, DATE, DESCRIPTION, VALUE, TYPE;

    public static TypeColumn returnType(String type){
        type = type.toLowerCase();
        TypeColumn typeColumn = null;
        switch(type){
            case "name":
               typeColumn = NAME;
               break;
            case "email":
                typeColumn = EMAIL;
                break;
            case "city":
                typeColumn = CITY;
                break;
            case "date":
                typeColumn = DATE;
                break;
            case "description":
                typeColumn = DESCRIPTION;
                break;
            case "value":
                typeColumn = VALUE;
                break;
            case "type":
                typeColumn = TYPE;
                break;
            default:
                throw new TypeNotPresentException(type,
                        new Throwable("That type doesn't exist in TypeColumn enum"));
        }
        return typeColumn;
    }
}
